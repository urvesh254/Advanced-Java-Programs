import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {

    public static void main(String args[]) {
        int PORT = 3334;

        try {
            // Opening the server at port no. 3334
            ServerSocket ss = new ServerSocket(PORT);

            // Acceting the client at port no. 3334
            Socket socket = ss.accept();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Taking the numbers from the client.
            int length = dis.readInt();
            int arr[] = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = dis.readInt();
            }

            // Sorting the number recived from the client.
            Arrays.sort(arr);

            // Sending the sorted numbers to the client.
            for (int i = 0; i < length; i++) {
                dos.writeInt(arr[i]);
            }

            socket.close();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
