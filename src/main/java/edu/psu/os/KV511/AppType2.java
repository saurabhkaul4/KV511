package edu.psu.os.KV511;

import edu.psu.os.KV511.session.ClientType2;

public class AppType2 {

	public static int[] a = new int[50];

	public static void run(String ip, int port) {

		generatePossion(a, 10);
		for (int i = 0 ; i < 5 ; i++) {
			new Thread(new ClientType2(ip, port, a)).start();
		}
	}

	public static void generatePossion(int[] a, int lambda) {

		for (int i = 0; i < 50; i++) {
			a[i] = 0;
		}
		int k = 0;
		double p = 1.0;
		double L;
		for (int i = 0; i < 100000; i++) {
			L = Math.exp(-lambda);
			p = 1.0;
			k = 0;

			do {
				k++;
				p *= Math.random();
			} while (p > L);

			a[k - 1]++;
		}

		for (int i = 0; i < 50; i++) {
			a[i] = a[i] / 10;
		}
	}

}