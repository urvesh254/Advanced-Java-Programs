import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerString {

	public static void main(String args[]) {
		int SENDER_PORT = 3333;
		int RECEIVER_PORT = 3334;
		try {
			DatagramSocket ds = new DatagramSocket(RECEIVER_PORT);

			byte[] rd = new byte[1024];
			byte[] sd1 = new byte[1024];
			byte[] sd2 = new byte[1024];

			DatagramPacket dp = new DatagramPacket(rd, rd.length);
			// Receive the packet from the sender.
			ds.receive(dp);

			String string = new String(dp.getData()).trim();

			InetAddress address = InetAddress.getByName("localhost");

			// Find the toatl characters in string and send to the client.
			int totalCharacters = string.length();
			sd1 = String.valueOf(totalCharacters).getBytes();
			DatagramPacket dp_total_characters = new DatagramPacket(sd1, sd1.length, address, SENDER_PORT);
			ds.send(dp_total_characters);

			// Find the toatl digits in string and send to the client.
			int totalDigits = 0;
			for (int i = 0; i < string.length(); i++) {
				char ch = string.charAt(i);
				if (ch >= '0' && ch <= '9') {
					totalDigits++;
				}
			}
			sd2 = String.valueOf(totalDigits).getBytes();
			DatagramPacket dp_total_digits = new DatagramPacket(sd2, sd2.length, address, SENDER_PORT);
			ds.send(dp_total_digits);

			ds.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
