import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.net.ServerSocket;

public class ServerDate {
    public static void main(String[] args) {
        int PORT = 3334;
        try {
            // Opening the server at port no. 3334
            ServerSocket ss = new ServerSocket(PORT);

            // Acceting the client at port no. 3334
            Socket socket = ss.accept();

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Sending the date to the Client.
            String date = LocalDateTime.now().toString();
            dos.writeUTF(date);

            socket.close();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
