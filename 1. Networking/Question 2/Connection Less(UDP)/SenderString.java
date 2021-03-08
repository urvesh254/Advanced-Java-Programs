import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SenderString {
    // Here you must pass RECEIVER_PORT as 3334. because it is connected with ReceiverString file.
    public static void main(String[] args) throws Exception {
        try {

            String HOST_NAME = args[0];
            int RECEIVER_PORT = Integer.parseInt(args[1]);
            int SENDER_PORT = 3333;
            Scanner sc = new Scanner(System.in);

            // Initialize the UDP socket at sender side.
            DatagramSocket ds = new DatagramSocket(SENDER_PORT);

            byte[] rd = new byte[1024];
            byte[] sd = new byte[1024];

            // Take String form the client.
            System.out.print("Enter the String : ");
            String string = sc.nextLine();
            InetAddress address = InetAddress.getByName(HOST_NAME);

            // Creating the packet and send to server.
            sd = string.getBytes();
            DatagramPacket dp = new DatagramPacket(sd, sd.length, address, RECEIVER_PORT);
            ds.send(dp);

            // Receiving the total characters from the server.
            DatagramPacket dp_output = new DatagramPacket(rd, rd.length);
            ds.receive(dp_output);
            String outputString = new String(dp_output.getData()).trim();

            System.out.println("\nInput String : " + string);
            System.out.println("Output String : " + outputString);

            ds.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("run program as -> java client localhost/IP Port");
        } catch (NumberFormatException e) {
            System.out.println("Enter port no. as digit.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
