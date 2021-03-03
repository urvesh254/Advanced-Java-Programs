import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.ServerSocket;

public class ServerSum {
    public static void main(String[] args) {
        int PORT = 3334;

        try {
            // Opening the server at port no. 3334
            ServerSocket ss = new ServerSocket(PORT);

            // Acceting the client at port no. 3334
            Socket socket = ss.accept();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Getting the two number from the client.
            int a = dis.readInt();
            int b = dis.readInt();

            // Sum the two number.
            int sum = a + b;

            // Sending the sum of two number to Client.
            dos.writeInt(sum);

            socket.close();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
