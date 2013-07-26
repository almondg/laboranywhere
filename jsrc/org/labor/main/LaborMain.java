package org.labor.main;

import java.io.IOException;

import org.labor.server.Server;

public class LaborMain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		new Thread(server).start();
	}

}
