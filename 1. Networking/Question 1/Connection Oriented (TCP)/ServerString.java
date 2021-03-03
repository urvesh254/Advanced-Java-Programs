import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerString {

    public static void main(String args[]) {
        int PORT = 3334;

        try {
            // Opening the server at port no. 3334
            ServerSocket ss = new ServerSocket(PORT);

            // Acceting the client at port no. 3334
            Socket socket = ss.accept();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Getting the string from the client.
            String string = dis.readUTF();

            // Find the toatl characters in string and send to the client.
            int totalCharacters = string.length();
            dos.writeInt(totalCharacters);

            // Find the toatl digits in string and send to the client.
            int totalDigits = 0;
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    totalDigits++;
                }
            }
            dos.writeInt(totalDigits);

            socket.close();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
