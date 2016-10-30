package edu.psu.os.KV511.session;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadLocalRandom;

import edu.psu.os.KV511.util.MessageUtil;

public class ClientType2 implements Client, Runnable {

	private String ip;
	private int port;
	private int[] a;

	public ClientType2(String ip, int port, int[] a) {
		this.ip = ip;
		this.port = port;
		this.a = a;
	}

	public Socket initSocket() throws UnknownHostException, IOException, Exception {
		return new Socket(ip, port);
	}

	public void run() {
		try {
			int no_of_req = 10;
			int time_quantum = (8 * 60) / 20;
			int time_to_sleep = 0;
			long key = 1;
			for (int k = 4; k < 18; k++) {
				if (a[k] < 5) {
					continue;
				} 
				time_to_sleep = time_quantum / this.a[k];
				for (int i = 0; i < this.a[k]; i++) {
					Thread.sleep(time_to_sleep);
					Socket socket = null;
					MessageUtil msg = null;
					try {
						socket = initSocket();
						if (socket != null) {
							msg = new MessageUtil(socket);

							for (int j = 0; j < no_of_req; j++) {
								int ran = ThreadLocalRandom.current().nextInt(1, 10 + 1);
								key = ThreadLocalRandom.current().nextInt(1, 500 + 1);
								if (ran % 2 == 0) {
									msg.putRequest(key, key);
								} else {
									msg.getRequest(key);
								}
							}
						}
					} catch (Exception e) {
						System.out.println(e);
					} finally {
						if (msg != null) {
							msg.stop();
							msg.close();
						}
						if (socket != null) {
							socket.close();
						}
					}
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return;
	}
}
