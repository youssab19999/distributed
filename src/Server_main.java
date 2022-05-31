package server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import debug.Debug;


public class Server_main {
	private static final boolean DEBUG = Debug.DEBUG;
	private static final int defaultPort = 4444;

	
	public static void main(String[] args) {
		int port;
		if (args.length == 2 && args[0].equals("-p")
				&& args[1].matches("\\d\\d?\\d?\\d?\\d?")) {
			port = Integer.parseInt(args[1]);
		} else {
			port = defaultPort;
		}
		try {
			runServer(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	public static void runServer(int port) throws IOException {
		if (DEBUG) {
			System.out.println("I am at runServer().");
		}
		Map<String, StringBuffer> map = new HashMap<String, StringBuffer>();
		Map<String, Integer> versions = new HashMap<String, Integer>();
		Server server = new Server(port, map, versions);
		server.serve();
	}
}
