package io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;

public class BIOClientB {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket client = new Socket(Inet4Address.getLocalHost(), 6677);

		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

		PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

		BufferedReader consoleMsgReader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			out.println("�ͻ���B�������ݣ�" + consoleMsgReader.readLine());
			out.flush();
			String responseData = in.readLine();
			if ("end".equals(responseData)) {
				System.out.println("�������Ӧ�˹ر�socket��������");
				break;
			}
			System.out.println(responseData);
		}

		consoleMsgReader.close();
		in.close();
		out.close();
		client.close();
	}

}
