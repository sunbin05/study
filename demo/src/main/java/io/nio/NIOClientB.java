package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class NIOClientB {
	
	private Selector selector ;
	Charset charset = Charset.forName("UTF-8");
	
	public static void main(String[] args) throws Exception {
		new NIOClientA().init();
	}
	
	public void init() throws Exception{
		selector = Selector.open();
		SocketChannel sc = SocketChannel.open(new InetSocketAddress("localhost", 6666));
		sc.configureBlocking(false);
		sc.register(selector, SelectionKey.OP_READ);
		new ClientThread().start();
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()){
			sc.write(charset.encode(scanner.nextLine()));
		}
	}
	
	private class ClientThread extends Thread{
		public void run(){
			try {
				while(selector.select() > 0){
					for(SelectionKey sk : selector.selectedKeys()){
						selector.selectedKeys().remove(sk);
						if(sk.isReadable()){
							SocketChannel sc = (SocketChannel) sk.channel();
							ByteBuffer buffer = ByteBuffer.allocate(2048);
							String content = "";
							while(sc.read(buffer) > 0){
								buffer.flip();
								content += charset.decode(buffer);
							}
							System.out.println("��������Ӧ�����ǣ�"+content);
							sk.interestOps(SelectionKey.OP_READ);
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
