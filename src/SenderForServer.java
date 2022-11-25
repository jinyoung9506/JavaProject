import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class SenderForServer extends Thread {
	public static ArrayList<DataOutputStream> out =  new ArrayList<DataOutputStream>();
	private String str = null;
	private String name = null;
	private Scanner sc = null;
	
	
	public SenderForServer() {
		
	}

	public void addSocket(Socket socket) {
		try {
			out.add(new DataOutputStream(socket.getOutputStream()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			System.out.print(">>");
			this.str = this.name + ":" +this.sc.nextLine();
			for (int i = 0; i < out.size(); i++) {
				try {
					if (out.get(i) != null) {
						out.get(i).writeUTF(this.str);
					} else {
						System.out.println("Null");
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}