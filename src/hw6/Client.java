package hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket("localhost",8081)) {
                DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
                new MessageReaderThread(dataInputStream).start();
                Scanner scanner = new Scanner(System.in);
                do {
                    dataOutputStream.writeUTF(scanner.nextLine());
                } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
