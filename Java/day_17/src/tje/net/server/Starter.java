package tje.net.server;

public class Starter {
	public static void main(String[] args) {		
		int port = 7070;
		ClientCollector collector = new ClientCollector(port);
		collector.start();
	}
}
