package io;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FDUtils {
	
	private static String fileName = "./file.txt";
	
	private static String outText = "hi fd";
	
	public static void main(String[] args) throws IOException {
		
		PrintStream out = new PrintStream(new FileOutputStream(FileDescriptor.out));
		out.println(outText);
		
		 try {  
	            // �½��ļ���file.txt����Ӧ��FileOutputStream����  
	            FileOutputStream out1 = new FileOutputStream(fileName);  
	            // ��ȡ�ļ���file.txt����Ӧ�ġ��ļ���������  
	            FileDescriptor fdout = out1.getFD();  
	            // ���ݡ��ļ���������������FileOutputStream������  
	            FileOutputStream out2 = new FileOutputStream(fdout);  
	            out1.write('A');    // ͨ��out1��file.txt����д��'A'  
	            out2.write('a');    // ͨ��out2��file.txt����д��'A'  
	  
	            if (fdout!=null)  
	                System.out.printf("fdout(%s) is %s\n",fdout, fdout.valid());  
	  
	                out1.close();  
	                out2.close();  
	  
	            } catch(IOException e) {  
	            e.printStackTrace();  
	            }  
		 
		 
		 
		 try {  
	            // �½��ļ���file.txt����Ӧ��FileInputStream����  
	            FileInputStream in1 = new FileInputStream(fileName);  
	            // ��ȡ�ļ���file.txt����Ӧ�ġ��ļ���������  
	            FileDescriptor fdin = in1.getFD();  
	            // ���ݡ��ļ���������������FileInputStream������  
	            FileInputStream in2 = new FileInputStream(fdin);  
	  
	            System.out.println("in1.read():"+(char)in1.read());  
	            System.out.println("in2.read():"+(char)in2.read());  
	  
	            if (fdin!=null)  
	                System.out.printf("fdin(%s) is %s\n", fdin, fdin.valid());  
	  
	                in1.close();  
	                in2.close();  
	            } catch(IOException e) {  
	            e.printStackTrace();  
	            }  
	}

}
