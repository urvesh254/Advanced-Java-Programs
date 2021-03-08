import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiverString {

    /* 
    - Out task to reverse the string with ths swape case.
    */
    public static String convertOutputString(String string) {
        String outputString = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            char ch = string.charAt(i);
            if (Character.isUpperCase(ch)) {
                outputString += Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                outputString += Character.toUpperCase(ch);
            } else {
                outputString += ch;
            }
        }
        return outputString;
    }

    public static void main(String[] args) throws Exception {
        String HOST_NAME = "localhost";
        int RECEIVER_PORT = 3334;
        int SENDER_PORT = 3333;

        DatagramSocket ds = new DatagramSocket(RECEIVER_PORT);

        byte[] rd = new byte[1024];
        byte[] sd = new byte[1024];

        DatagramPacket dp = new DatagramPacket(rd, rd.length);
        // Receive the packet from the sender.
        ds.receive(dp);

        // Extract string from the received packet.
        String string = new String(dp.getData()).trim();

        String outputString = convertOutputString(string);

        InetAddress address = InetAddress.getByName(HOST_NAME);

        // Sending the converted string to Client.
        sd = outputString.getBytes();
        DatagramPacket dp_total_characters = new DatagramPacket(sd, sd.length, address, SENDER_PORT);
        ds.send(dp_total_characters);

        ds.close();
    }
}
