package com.licly.echo.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO
 *
 * @author licly
 * @date 2021/1/16
 */
public class BioServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8081);

		while (true) {
			try {
				process(serverSocket.accept());
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void process(Socket socket) throws IOException, InterruptedException {
		Thread.sleep(20);
		InputStream is = socket.getInputStream();

		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		pw.println("HTTP/1.1 200 OK");
		pw.println("Content-Type:text/html;charset=utf-8");
		pw.println();
		pw.println("hello world");

		pw.close();
		socket.close();
	}
}
