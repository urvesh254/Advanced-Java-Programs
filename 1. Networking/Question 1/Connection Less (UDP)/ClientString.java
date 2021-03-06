import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientString {

    public static void main(String args[]) {

        int SENDER_PORT = 3333;
        int RECEIVER_PORT = 3334;
        Scanner sc = new Scanner(System.in);

        try {

            DatagramSocket ds = new DatagramSocket(SENDER_PORT);

            byte[] rd = new byte[1024];
            byte[] sd = new byte[1024];

            // Taking the String from Client
            System.out.print("Enter the string : ");
            String string = sc.nextLine();
            sd = string.getBytes();

            InetAddress address = InetAddress.getByName("localhost");

            // Creating the packet and send to server.
            DatagramPacket dp = new DatagramPacket(sd, sd.length, address, RECEIVER_PORT);
            ds.send(dp);

            // Receiving the total characters from the server.  
            DatagramPacket dp_total_char = new DatagramPacket(rd, rd.length);
            ds.receive(dp_total_char);
            String totalChars = new String(dp_total_char.getData(), dp_total_char.getOffset(), dp_total_char.getLength()).trim();
            int totalCharacters = Integer.parseInt(totalChars);

            // Getting total digits of the string from server.
            DatagramPacket dp_total_digits = new DatagramPacket(rd, rd.length);
            ds.receive(dp_total_digits);
            String totalDigitString = new String(dp_total_digits.getData(), dp_total_digits.getOffset(), dp_total_digits.getLength()).trim();
            int totalDigits = Integer.parseInt(totalDigitString);

            System.out.println("\nString : " + string);
            System.out.println("Total Characters : " + totalCharacters);
            System.out.println("Total Digits : " + totalDigits);

            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
} 