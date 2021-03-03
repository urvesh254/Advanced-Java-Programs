import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientNumber {

    public static void main(String args[]) {
        String HOST_NAME = "localhost";
        int PORT = 3334;
        Scanner sc = new Scanner(System.in);
        Socket socket;

        try {
            // Connecting the socket to the server.
            socket = new Socket(HOST_NAME, PORT);

            // Take String form the client.
            System.out.print("Enter two number : ");
            int a = sc.nextInt();
            int b = sc.nextInt();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Sending the two number to the server.
            dos.writeInt(a);
            dos.writeInt(b);

            // Taking responce from the server.
            int sum = dis.readInt();

            System.out.println(String.format("%d + %d = %d", a, b, sum));

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}