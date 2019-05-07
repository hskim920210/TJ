package tje.server.model;

import java.io.Serializable;

public class PortInfo implements Serializable {
	private int port;

	public PortInfo(int port) {
		super();
		this.port = port;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}