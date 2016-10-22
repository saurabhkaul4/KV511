package edu.psu.os.KV511.session;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public interface Client {

	public Socket initSocket() throws UnknownHostException, IOException;
}
