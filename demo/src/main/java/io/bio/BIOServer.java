package io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {

	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(6677);
		System.out.println("锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟絣ocalhost:6677锟斤拷锟斤拷锟斤拷accept()锟斤拷锟斤拷锟斤拷锟饺达拷锟酵伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷锟斤拷 ");

		Socket socket = server.accept();
		System.out.println("锟斤拷锟斤拷丝锟绞硷拷锟斤拷盏锟斤拷突锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷螅锟斤拷锟揭伙拷锟絪ocket锟斤拷锟接ｏ拷锟斤拷锟斤拷锟斤拷inputstream锟斤拷锟斤拷read()锟斤拷锟斤拷锟斤拷锟饺达拷锟斤拷锟斤拷锟斤拷锟捷★拷锟斤拷锟斤拷 ");

		BufferedReader requestDataReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		PrintWriter responseDataWriter = new PrintWriter(socket.getOutputStream());

		while (true) {
			System.out.println("锟斤拷锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷荩锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷荻锟饺★拷小锟斤拷锟斤拷锟� ");
			String requestData = requestDataReader.readLine();
			if (requestData.contains("end")) {
				System.out.println("锟酵伙拷锟斤拷锟斤拷锟斤拷乇锟絪ocket锟斤拷锟斤拷");
				responseDataWriter.println("end");
				responseDataWriter.flush();
				break;
			} else {
				System.out.println(requestData);
			}
			responseDataWriter.println("锟斤拷锟斤拷私锟斤拷盏锟斤拷牵锟�" + requestData);
			responseDataWriter.flush();
		}

		requestDataReader.close();
		responseDataWriter.close();
		socket.close();
		server.close();
	}

}
