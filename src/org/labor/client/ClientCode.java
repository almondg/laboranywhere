package org.labor.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import org.labor.pojos.Employee;

public class ClientCode implements Runnable {

	public ClientCode() {
	}
	
	public void getNewMessages() {

        Socket connect = null;
        ArrayList<Employee> employees = new ArrayList<>();
        ObjectInputStream input = null;
        OutputStreamWriter output = null;

        try {

        	System.out.println("Connect to server...");
            connect = new Socket("localhost", 8484);
            System.out.println("Connected!");
            //hangs here on creating the ObjectInputStream
            input = new ObjectInputStream(connect.getInputStream());
            output = new OutputStreamWriter(connect.getOutputStream());

            System.out.println("Request Employee...");
            requestEmployee(output);
            System.out.println("Employee requsted.");
            
            //client parses text input and will respond to the pw input 
            //by calling the sendMessagesToPhone(String user) method

            Object obj = null;
            while((obj = input.readObject()) != null) {
                if(obj instanceof Employee) {
                    employees.add((Employee)obj);
                }
                else {
                	System.out.println("Object is not an Employee: " + obj);
                }
            }
            
            System.out.println("Employees: ");
            for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.println(employee);
			}

        } catch(Exception e) {
        
        	try {
        		output.close();
        	} catch (Exception e1) {
        		e.printStackTrace();
        	}
        
        	try {
        		input.close();

        	} catch (Exception e1) {
        		e.printStackTrace();
            }
        }
	}

	private void requestEmployee(OutputStreamWriter output) {
		
		try {
			output.write("help\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		getNewMessages();
	}
}
