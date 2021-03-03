import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientString {
    public static void main(String[] args) {
        int SENDER_PORT = 3333;
        int RECEIVER_PORT = 3334;
        Scanner sc = new Scanner(System.in);

        try {
            DatagramSocket ds = new DatagramSocket(SENDER_PORT);

            byte[] rd = new byte[1024];
            byte[] sd = new byte[1024];

            // Taking the String from Sebder
            System.out.print("Enter the string : ");
            sd = sc.nextLine().getBytes();

            InetAddress address = InetAddress.getByName("localhost");

            // Creating the packet and send to receiver.
            DatagramPacket dp = new DatagramPacket(sd, sd.length, address, RECEIVER_PORT);
            ds.send(dp);

            // Receiving the uppercase string from the receiver.  
            DatagramPacket dp1 = new DatagramPacket(rd, rd.length);
            ds.receive(dp1);

            String outputString = new String(dp1.getData()).trim();

            System.out.println("\nOutput String : " + outputString);

            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
