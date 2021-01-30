package chatWindow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    ObservableList<String> messagesList;

    @FXML
    public void initialize() {
        messagesList =
                FXCollections.observableArrayList();
        chatList.setItems(messagesList);
        chatList.setEditable(false);
    }
    @FXML
    private ListView<String> chatList;

    @FXML
    private TextField messageField;

    @FXML
    private Button sendButton;

    @FXML
    void onMsgFldKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            sendMessage(messageField.getText());
        }
    }

    @FXML
    void onSendBtnClicked() {
        sendMessage(messageField.getText());
    }

    public void sendMessage(String msg) {
        if (msg.isEmpty()) return;
        String username = "username";
        Message message = new Message(username, msg);
        addMsg(message);
        messageField.clear();
    }

    public void pushFrontMsg(Message msg) {
        messagesList.add(0, msg.toString());
    }

    public void addMsg(Message msg) {
        messagesList.add(msg.toString());
    }
}