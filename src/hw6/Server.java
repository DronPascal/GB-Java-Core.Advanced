package hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            System.out.println("Ожидаем подключение клиента");
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
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
