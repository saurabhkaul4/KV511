package edu.psu.os.KV511;

public class App {
	
	public static void main(String[] args) {
		if(args[1].equalsIgnoreCase("1")) {
			System.out.println("Running type 1 client");
			AppType1.run();
		}
		if(args[1].equalsIgnoreCase("2")) {
			System.out.println("Running type 2 client");
			AppType2.run();
		}
	}
}
