import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String args[]) {
        try {

            String HOST_NAME = args[0];
            int PORT = Integer.parseInt(args[1]);
            Scanner sc = new Scanner(System.in);
            Socket socket;

            // Connecting the socket to the server.
            socket = new Socket(HOST_NAME, PORT);

            // Take String form the client.
            System.out.print("Enter the String : ");
            String string = sc.nextLine();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Sending the string to the server.
            dos.writeUTF(string);

            // Taking responce from the server.
            String outputString = dis.readUTF();

            System.out.println("\nInput String : " + string);
            System.out.println("Output String : " + outputString);

            socket.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("run program as -> java client localhost/IP Port");
        } catch (NumberFormatException e) {
            System.out.println("Enter port no. as digit.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}