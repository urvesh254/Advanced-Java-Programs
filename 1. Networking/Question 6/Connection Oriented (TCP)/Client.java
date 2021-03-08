import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String HOST_NAME = "localhost";
        int PORT = 3334;
        Scanner sc = new Scanner(System.in);
        Socket socket;

        // Numbers you want to send.
        int length = 10;

        try {
            // Connecting the socket to the server.
            socket = new Socket(HOST_NAME, PORT);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Take 10 numbers from the client and send to the server.  
            System.out.println("Enter 10 numbers : ");
            dos.writeInt(length);
            for (int i = 0; i < length; i++) {
                dos.writeInt(sc.nextInt());
            }

            // Getting the sorted numbers from the server.
            System.out.println("\nSorted numbers array :");
            for (int i = 0; i < length; i++) {
                System.out.println(dis.readInt());
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
