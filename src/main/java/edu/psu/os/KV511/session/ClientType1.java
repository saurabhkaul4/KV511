package edu.psu.os.KV511.session;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadLocalRandom;

import edu.psu.os.KV511.util.ClientProp;
import edu.psu.os.KV511.util.MessageUtil;

/**
 * @KV511 client
 *
 */
public class ClientType1 implements Client {

	private ClientProp prop = null;
	
	public ClientType1() {
		prop = new ClientProp();
	}
	
	public Socket initSocket() throws UnknownHostException, IOException {
		return new Socket(prop.getIP(), prop.getPort());
	}
	
	public void insertForTesting() throws UnknownHostException, IOException {
		MessageUtil msg = new MessageUtil(initSocket());
		
		for(int i = 1; i < 5; i++) {
			int key = ThreadLocalRandom.current().nextInt(1, 10 + 1); 
			msg.putRequest(key, key);
		}
	}
	
	public void doRequests()  throws UnknownHostException, IOException {
		
		int no_of_req = Integer.parseInt(prop.get("type1.no_of_req"));
		int no_of_get = Integer.parseInt(prop.get("type1.no_of_get"));
		int no_of_put = Integer.parseInt(prop.get("type1.no_of_put"));
		
		for(int i = 0; i < no_of_req; i++) {
			
			MessageUtil msg = new MessageUtil(initSocket());
			
			for(int j = 0; j < no_of_put; j++) {
				int key = ThreadLocalRandom.current().nextInt(1, 10 + 1);
				msg.putRequest(key, key);
			}
			
			for(int j = 0; j < no_of_get; j++) {
				int key = ThreadLocalRandom.current().nextInt(1, 10 + 1);
				msg.getRequest(key);
			}
		}
	}
}
