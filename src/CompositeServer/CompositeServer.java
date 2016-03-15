package CompositeServer;
import java.util.Vector;

public class CompositeServer implements Socket {

	private Vector<Socket> childSockets = new Vector<Socket>();

	@Override
	public void start() {
		for (Socket sock : childSockets) {
			sock.start();
		}
	}
}
