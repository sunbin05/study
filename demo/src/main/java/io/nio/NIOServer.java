package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NIOServer {
	
	private Charset charset = Charset.forName("UTF-8");
	
	public static void main(String[] args) throws IOException {
		new NIOServer().init();
	}
	
	public void init() throws IOException{
		Selector selector = Selector.open();
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);
		ssc.socket().bind(new InetSocketAddress("localhost", 6666));
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("锟斤拷锟斤拷锟阶拷锟斤拷锟缴ｏ拷锟斤拷询注锟斤拷锟斤拷却锟斤拷锟斤拷锟斤拷录锟斤拷锟斤拷锟斤拷锟斤拷录锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟� ");
		
		while(selector.select() > 0){
			System.out.println("锟斤拷锟斤拷锟铰硷拷锟斤拷锟斤拷"+selector.selectedKeys().size()+"锟斤拷锟铰硷拷");
			for(SelectionKey sk : selector.selectedKeys()){
				selector.selectedKeys().remove(sk);
				if(sk.isAcceptable()){
					System.out.println("锟斤拷锟斤拷锟铰硷拷");
					SocketChannel sc = ssc.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
					sk.interestOps(SelectionKey.OP_ACCEPT);
				}
				
				if(sk.isReadable()){
					System.out.println("锟斤拷锟斤拷锟铰硷拷");
					SocketChannel sc = (SocketChannel) sk.channel();
					ByteBuffer buffer = ByteBuffer.allocate(2048);
					String content = "";
					while(sc.read(buffer) > 0){
						buffer.flip();
						content += charset.decode(buffer);
					}
					sk.interestOps(SelectionKey.OP_READ);
					
					if(content.length() > 0){
						for(SelectionKey key : selector.keys()){
							Channel target = key.channel();
							if(target instanceof SocketChannel){
								SocketChannel des = (SocketChannel)target;
								des.write(charset.encode(content));
							}
						}
					}
				}
			}
		}
	}
}
