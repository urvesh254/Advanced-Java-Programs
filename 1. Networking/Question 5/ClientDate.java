import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientDate {

    public static void main(String args[]) {
        String HOST_NAME = "localhost";
        int PORT = 3334;
        Socket socket;

        try {
            // Connecting the socket to the server.
            socket = new Socket(HOST_NAME, PORT);

            DataInputStream dis = new DataInputStream(socket.getInputStream());

            // Getting the date from the server.
            String dateTime = dis.readUTF();

            System.out.println("Date & Time : " + dateTime);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}