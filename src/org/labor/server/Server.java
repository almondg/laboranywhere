package org.labor.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;

import org.labor.pojos.Employee;

public class Server implements Runnable {

	private static final String RC_DEMO_EMPLOYEE = "RC-DEMO_EMPLOYEE";
	private static final boolean shouldRun = true;
	private final int PORT = 8484;
	private ServerSocket serverForAndroidRequests;
	private Employee demoEmployee;
	
	public Server() throws IOException {
		serverForAndroidRequests = new ServerSocket(PORT);
	    demoEmployee = new Employee(
	    		"shaked", "shaked@gmail.com", "0547449102");

		
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
		
		String execResult = execRequest(requestLine);
		switch (execResult) {
		case RC_DEMO_EMPLOYEE:
			sendMessagesToPhone(demoEmployee, socketForCurrentSession);
			break;

		default:
			break;
		}
		reader.close();
		inputStreamForCurrentSession.close();
		socketForCurrentSession.close();
		
	}
	
	public void sendMessagesToPhone(
			Employee employee, Socket currentSessionSocket) {

	    System.out.println("Send messages to phone called");

	    ObjectOutputStream outputStream = null;

	    try {
	        outputStream = new ObjectOutputStream(
	        		currentSessionSocket.getOutputStream());
	        outputStream.flush();

	        outputStream.writeObject(employee);
	    } catch (Exception e) {
	        System.out.println("unable to create the streams");
	        e.printStackTrace();
	    }

		try {
		    outputStream.close();
	
		} catch (Exception e) {
		    System.out.println("unable to close the streams");
		    e.printStackTrace();
		}
	}

	private String execRequest(String requestLine) {
		switch (requestLine) {
		case "help":
			System.out.println("Help requested");
			return RC_DEMO_EMPLOYEE;

		default:
			System.err.println("Request: " + requestLine + " reached default handler.");
			return "";
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
