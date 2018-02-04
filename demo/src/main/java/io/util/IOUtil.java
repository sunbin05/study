package io.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOUtil {
	
	public static void bioRead() throws IOException{
		FileInputStream fis = new FileInputStream(new File("f://tools/5.6sp1.zip"));
		FileOutputStream fos = new FileOutputStream(new File("f://tools/5.6sp1_bio.zip"));
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = fis.read(buffer)) != -1){
			fos.write(buffer, 0, len);
		}
		fis.close();
		fos.close();
	}
	
	public static void nioRead() throws IOException{
		FileInputStream fis = new FileInputStream(new File("f://tools/5.6sp1.zip"));
		FileOutputStream fos = new FileOutputStream(new File("f://tools/5.6sp1_nio.zip"));
		FileChannel inChannel = fis.getChannel();
		FileChannel outChannel = fos.getChannel();
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		while(inChannel.read(buffer) != -1){
			buffer.flip();
			outChannel.write(buffer);
			buffer.clear();
		}
		inChannel.close();
		outChannel.close();
		fis.close();
		fos.close();
	}
	
	public static void aidRead() throws IOException{
		Path path = Paths.get("f://tools/5.6sp1.zip");
		final AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path);
		final ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		fileChannel.read(buffer, 0, null, new CompletionHandler<Integer, Object>() {

			@Override
			public void completed(Integer readCount, Object attachment) {
				//System.out.println(attachment);
				fileChannel.write(buffer, 0, attachment, new CompletionHandler<Integer, Object>() {

					@Override
					public void completed(Integer result, Object attachment) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void failed(Throwable exc, Object attachment) {
						// TODO Auto-generated method stub
						
					}
				});
			}

			@Override
			public void failed(Throwable exc, Object attachment) {
				System.out.println("error:"+exc);
			}
		});
	}
	
	public static void main(String[] args) throws IOException {
		long bioStartTime = System.currentTimeMillis();
		bioRead();
		long bioEndTime = System.currentTimeMillis();
		long bioUseTime = bioEndTime - bioStartTime;
		System.out.println("bio��ʱ��"+String.valueOf(bioUseTime));
		
		long nioStartTime = System.currentTimeMillis();
		bioRead();
		long nioEndTime = System.currentTimeMillis();
		long nioUseTime = nioEndTime - nioStartTime;
		System.out.println("nio��ʱ��"+String.valueOf(nioUseTime));
	}

}

