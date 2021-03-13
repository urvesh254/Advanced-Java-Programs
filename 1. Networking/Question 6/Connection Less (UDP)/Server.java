import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class Server {

    public static void main(String args[]) {
        int SENDER_PORT = 3333;
        int RECEIVER_PORT = 3334;
        try {
            DatagramSocket ds = new DatagramSocket(RECEIVER_PORT);

            byte[] rd = new byte[1024];
            byte[] sd = new byte[1024];

            DatagramPacket dp_input = new DatagramPacket(rd, rd.length);
            // Receive the input array from the sender.
            ds.receive(dp_input);

            // Convert byte array to input array.
            ByteArrayInputStream bis = new ByteArrayInputStream(dp_input.getData());
            ObjectInputStream ois = new ObjectInputStream(bis);
            int[] arr = (int[]) ois.readObject();

            System.out.println("\nInput Array : " + Arrays.toString(arr));

            Arrays.sort(arr);

            System.out.println("Sorted Array : " + Arrays.toString(arr));

            InetAddress address = InetAddress.getByName("localhost");

            // Convert sorted int array to byte array.
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(arr);

            sd = bos.toByteArray();

            // Sending the sorted numbers to the client.
            DatagramPacket dp_output = new DatagramPacket(sd, sd.length, address, SENDER_PORT);
            ds.send(dp_output);

            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}