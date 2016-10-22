package edu.psu.os.KV511.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import edu.psu.os.KV511.model.Message;

public class MessageUtil {

	private DataOutputStream out;
	private DataInputStream in;
	
	public MessageUtil(Socket socket) throws IOException {
		out = new DataOutputStream(socket.getOutputStream());
		in = new DataInputStream(socket.getInputStream());
	}
	
	public void getRequest(long key) throws IOException {
		Message msg = new Message("GET", key, key);
		System.out.println("Put Request "+ key);
		out.writeUTF(msg.toString());
		System.out.println("Put Response " + in.readUTF());
	}
	
	public void putRequest(long key, long value) throws IOException {
		Message msg = new Message("PUT", key, key);
		System.out.println("Put Request "+ key);
		out.writeUTF(msg.toString());
		System.out.println("Put Response " + in.readUTF());
	}
	
}