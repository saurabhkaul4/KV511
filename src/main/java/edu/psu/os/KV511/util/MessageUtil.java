package edu.psu.os.KV511.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import edu.psu.os.KV511.model.Message;

public class MessageUtil {

	private BufferedOutputStream out;
	private InputStream in;
	
	public MessageUtil(Socket socket) throws IOException {
		out = new BufferedOutputStream(socket.getOutputStream());
		in = socket.getInputStream();
	}
	
	public void getRequest(long key) throws IOException {
		Message msg = new Message("GET", key, key);
		System.out.println("GET Request "+ key);
		out.write(msg.getString().getBytes());
		out.flush();
		byte[] buff = new byte[100];
		in.read(buff, 0, buff.length);
		System.out.println("GET Response " + new String(buff));
	}
	
	public void putRequest(long key, long value) throws IOException {
		Message msg = new Message("PUT", key, key); 
		System.out.println("Put Request "+ key);
		out.write(msg.toString().getBytes());
		//out.write(msg.hugeString().getBytes());
		out.flush();
		byte[] buff = new byte[100];
		in.read(buff, 0, buff.length);
		System.out.println("PUT Response " + new String(buff));
	}
	
	
	public void stop() throws IOException {
		out.write("STOP".toString().getBytes());
		out.flush();
	}
	
	public void close() throws IOException {
		in.close();
		out.close();
	}
	
}
