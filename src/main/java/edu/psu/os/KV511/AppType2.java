package edu.psu.os.KV511;

import edu.psu.os.KV511.session.ClientType2;

public class AppType2 {
	 
	public static void run(String ip, int port) {
	 
		for(int i = 0; i < 10; i++) {
			new Thread(new ClientType2(ip, port)).start();
		}
	}
}
