package hw7.client;

import hw7.server.Message;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.io.IOException;

public class MyClient extends JFrame {

    private ServerService serverService;

    public MyClient() {
        super("Чат");
        serverService = new SocketServerService();
        serverService.openConnection();
        JPanel jPanel = new JPanel();
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        jPanel.setSize(300, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 400, 500, 300);

        JTextArea mainChat = new JTextArea();
        mainChat.setSize(300, 250);

        initLoginPanel(mainChat);

        JTextField myMessage = new JTextField();

        JButton send = new JButton("Send");
        send.addActionListener(actionEvent -> sendMessage(myMessage));

        myMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage(myMessage);
                }
            }
        });

        if (serverService.isConnected()) {
            new Thread(() -> {
                while (true) {
                    printToUI(mainChat, serverService.readMessages());
                }
            }).start();
        }

        add(mainChat);
        jPanel.add(myMessage);
        jPanel.add(send);
        add(jPanel);
    }

    private void initLoginPanel(JTextArea mainChat) {
        JLabel loginLabel = new JLabel("Логин");
        JTextField login = new JTextField();
        login.setToolTipText("Логин");
        login.setMaximumSize(new Dimension(1000, 20));
        JLabel passwordLabel = new JLabel("Пароль");
        JPasswordField password = new JPasswordField();
        password.setToolTipText("Пароль");
        password.setMaximumSize(new Dimension(1000, 20));
        JButton authButton = new JButton("Авторизоваться");

        JLabel authLabel = new JLabel("Offline");
        authButton.addActionListener(actionEvent -> {
            String lgn = login.getText();
            String psw = new String(password.getPassword());
            if (lgn != null && psw != null && !lgn.isEmpty() && !psw.isEmpty()) {
                try {
                    String nick = serverService.authorization(lgn, psw);
                    authLabel.setText("Online, nick " + nick);
                    loginLabel.setVisible(false);
                    login.setVisible(false);
                    passwordLabel.setVisible(false);
                    password.setVisible(false);
                    authButton.setVisible(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                new Thread(() -> {
                    while (true) {
                        printToUI(mainChat, serverService.readMessages());
                    }
                }).start();
            }
        });

        add(loginLabel);
        add(login);
        add(passwordLabel);
        add(password);
        add(authButton);
        add(authLabel);

    }

    private void sendMessage(JTextField myMessage) {
        if (myMessage.getText().isEmpty())
            return;
        serverService.sendMessage(myMessage.getText());
        myMessage.setText("");
    }

    private void printToUI(JTextArea mainChat, Message message) {
        mainChat.append("\n");
        mainChat.append((message.getNick() != null ? message.getNick() : "Сервер") + " написал: " + message.getMessage());
    }


}
