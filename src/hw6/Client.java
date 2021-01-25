package hw6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;
import com.google.gson.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String id = UUID.randomUUID().toString();
        Socket socket = new Socket("localhost",8081);
        Scanner scanner = new Scanner(System.in);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        String inputString;
        do {
            inputString = scanner.nextLine();
            Message message = new Message();
            message.setMessage(inputString);
            message.setClientId(id);
            dataOutputStream.writeUTF(new Gson().toJson(message));
            dataOutputStream.flush();
        } while (!"\\finish".equals(inputString));
        socket.close();
    }
}
