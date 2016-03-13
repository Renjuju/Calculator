import java.io.IOException;
import java.net.Socket;

public class CalculatorClient extends Socket {
	private String hostname;
	private int port;
	Socket client;

	public CalculatorClient(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}

	public void start() {
		try {
			System.out.println("Attempting connection");
			client = new Socket(hostname, port);
			System.out.println("Connection started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
