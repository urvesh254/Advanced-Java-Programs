import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientString {

    public static void main(String args[]) {

        String HOST_NAME = "localhost";
        int PORT = 3334;
        Scanner sc = new Scanner(System.in);
        Socket socket;

        try {
            // Connecting the socket to the server.
            socket = new Socket(HOST_NAME, PORT);

            // Take String form the client.
            System.out.print("Enter the String : ");
            String string = sc.next();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Sending the string to the server.
            dos.writeUTF(string);

            // Getting totoal characters of the string.
            int totalCharacters = dis.readInt();

            // Getting total digits in the string.
            int totalDigits = dis.readInt();

            System.out.println("\nString : " + string);
            System.out.println("Total Characters : " + totalCharacters);
            System.out.println("Total Digits : " + totalDigits);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}