package edu.psu.os.KV511;

import edu.psu.os.KV511.session.ClientType2;

public class AppType2 {
	 
	public static void run() {
	 
		for(int i = 0; i < 10; i++) {
			new Thread(new ClientType2()).start();
		}
	}
}
