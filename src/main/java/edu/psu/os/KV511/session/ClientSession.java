package edu.psu.os.KV511.session;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadLocalRandom;

import edu.psu.os.KV511.model.Message;
import edu.psu.os.KV511.util.ClientProp;

public class ClientSession {

	private ClientProp prop;
	
	public ClientSession() {
		prop = new ClientProp();
	}
	
	public Socket initSocket() throws UnknownHostException, IOException {
		return new Socket(prop.getIP(), prop.getPort());
	}
	
	public boolean insertForTesting() throws UnknownHostException, IOException {
		Socket socket = initSocket();
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		
		for(int i = 1; i < 500; i++) {
			int key = ThreadLocalRandom.current().nextInt(1, 1000 + 1); 
			Message msg = new Message("PUT", key, key);
			out.writeUTF(msg.toString());
		}
		return true;
	}
}
