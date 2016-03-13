import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer extends Socket {

	private int port;

	public CalculatorServer(int port) {
		this.port = port;
	}

	@SuppressWarnings("resource")
	public void start() throws IOException {
		System.out.println("Starting socket server at port:" + port);
		ServerSocket serverSocket;
		serverSocket = new ServerSocket(port);
		System.out.println("Waiting for clients...");
		Socket client = serverSocket.accept();
	}

}
