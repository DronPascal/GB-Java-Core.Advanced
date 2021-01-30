package hw8.client;

import hw8.server.Message;

import java.io.IOException;

public interface ServerService {

    boolean isConnected();

    void openConnection();

    void closeConnection();

    String authorization(String login, String password) throws IOException;

    void sendMessage(String message);

    Message readMessages();

}
