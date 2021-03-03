import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerString {
    public static void main(String[] args) {
        int SENDER_PORT = 3333;
        int RECEIVER_PORT = 3334;

        try {
            DatagramSocket ds = new DatagramSocket(RECEIVER_PORT);

            byte[] rd = new byte[1024];
            byte[] sd = new byte[1024];

            DatagramPacket dp = new DatagramPacket(rd, rd.length);
            // Receive the packet from the sender.
            ds.receive(dp);

            String inputString = new String(dp.getData()).trim();

            System.out.println("input string : " + inputString);

            // Converting the string to uppercase.
            String outputString = inputString.toUpperCase();

            // take output string and convert to packet and sent to sender.
            InetAddress address = InetAddress.getByName("localhost");
            sd = outputString.getBytes();
            DatagramPacket dp1 = new DatagramPacket(sd, sd.length, address, SENDER_PORT);
            ds.send(dp1);

            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
