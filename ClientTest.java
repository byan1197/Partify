import javax.swing.JFrame;

public class ClientTest{
	public static void main(String[] args){
		Client tc;
		tc = new Client("127.0.0.1");
		tc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tc.startRunning();
	}
}
