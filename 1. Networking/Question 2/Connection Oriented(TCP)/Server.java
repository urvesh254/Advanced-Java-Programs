import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

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

    public static void main(String[] args) {
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

            String outputString = convertOutputString(string);

            // Sending the converted string to Client.
            dos.writeUTF(outputString);

            socket.close();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
