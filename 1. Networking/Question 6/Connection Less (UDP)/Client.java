import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Scanner;

public class Client {

    public static void main(String args[]) {

        int SENDER_PORT = 3333;
        int RECEIVER_PORT = 3334;
        Scanner sc = new Scanner(System.in);

        // Numbers you want to send.
        int length = 10;

        try {

            DatagramSocket ds = new DatagramSocket(SENDER_PORT);

            byte[] rd = new byte[1024];
            byte[] sd = new byte[1024];

            InetAddress address = InetAddress.getByName("localhost");

            // Take 10 numbers from the client and send to the server.  
            int arr[] = new int[length];
            System.out.println("Enter 10 numbers : ");
            for (int i = 0; i < length; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("\nInput Array : " + Arrays.toString(arr));

            // Converting int array to byte array.
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(arr);

            sd = bos.toByteArray();
            // Creating the packet and send to server.
            DatagramPacket dp = new DatagramPacket(sd, sd.length, address, RECEIVER_PORT);
            ds.send(dp);

            // Getting the sorted numbers from the server.
            DatagramPacket dp_ouput = new DatagramPacket(rd, rd.length);
            ds.receive(dp_ouput);

            // Converting byte array to int array.
            ByteArrayInputStream bis = new ByteArrayInputStream(dp_ouput.getData());
            ObjectInputStream ois = new ObjectInputStream(bis);
            arr = (int[]) ois.readObject();

            System.out.println("Sorted Array : " + Arrays.toString(arr));

            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}