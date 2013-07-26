package org.labor.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

	private static final boolean shouldRun = true;
	private final int PORT = 8484;
	private ServerSocket serverForAndroidRequests;
	
	public Server() throws IOException {
		serverForAndroidRequests = new ServerSocket(PORT);
		
	}
	
	private void listen() throws IOException {
		
		System.out.println(serverForAndroidRequests.getInetAddress());
		System.out.println(serverForAndroidRequests.getLocalPort());
		
		Socket socketForCurrentSession = serverForAndroidRequests.accept();
		
		System.out.println("Connected to: " + socketForCurrentSession.getInetAddress());
		
		InputStream inputStreamForCurrentSession = socketForCurrentSession.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStreamForCurrentSession));
		String requestLine = reader.readLine();
		
		System.out.println(requestLine);
		
		execRequest(requestLine);
		reader.close();
		inputStreamForCurrentSession.close();
		socketForCurrentSession.close();
		
	}

	private void execRequest(String requestLine) {
		switch (requestLine) {
		case "help":
			System.out.println("Help requested");
			
			break;

		default:
			System.err.println("Request: " + requestLine + " reached default handler.");
			break;
		}
	}

	@Override
	public void run() {
		while (shouldRun) {
			try {
				listen();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
