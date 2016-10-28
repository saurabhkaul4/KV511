package edu.psu.os.KV511;

public class App {
	
	public static void main(String[] args) {
		if(args[0].equalsIgnoreCase("1")) {
			System.out.println("Running type 1 client");
			AppType1.run( args[1],  Integer.parseInt(args[2]));
		}
		else if(args[0].equalsIgnoreCase("2")) {
			System.out.println("Running type 2 client");
			AppType2.run( args[1],  Integer.parseInt(args[2]));
		}
		else {
			System.out.println("Please select correctly");
		}
		
	}
}
