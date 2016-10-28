package edu.psu.os.KV511;

import java.io.IOException;
import java.net.UnknownHostException;

import edu.psu.os.KV511.session.ClientType1;

public class AppType1 
{
    public static void run(String ip, int port) {
    	ClientType1 client = new ClientType1( ip, port);
        try {
			client.insertForTesting();
			client.doRequests();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
}
