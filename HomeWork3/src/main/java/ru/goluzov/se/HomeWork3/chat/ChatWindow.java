package ru.goluzov.se.HomeWork3.chat;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@Getter
public class ChatWindow extends JFrame {

    private static final Double SIZE_RATIO = 0.6;
    private static final Double WINDOW_RATIO = 0.75;
    private static final Double MIN_SIZE_RATIO = 0.2;

    private JEditorPane messagesPane;
    private JTextField textField;
    private JButton sendButton;
    private Messages messages;


    public void init(Messages messages) {
        this.messages = messages;
        initGui();
        initChatHistory();
    }

    private void initChatHistory() {
        showMessages();
    }

    private void initGui() {
        setTitle("Чат");
        setMinimumSize(calculateMinimumSize());
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                messages.saveHistory();
                e.getWindow().dispose();
            }
        });
        setBounds(calculateSizePosition());
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        messagesPane = new JEditorPane();
        messagesPane.setEditable(false);
        add(messagesPane);
        textField = new JTextField();
        JPanel sender = new JPanel();
        sender.setLayout(new BoxLayout(sender, BoxLayout.X_AXIS));
        sendButton = new JButton("Отправить");
        textField.setMaximumSize(new Dimension(
                Toolkit.getDefaultToolkit().getScreenSize().width,
                sendButton.getMinimumSize().height));
        sender.add(textField);
        sender.add(sendButton);
        add(sender);
        setVisible(true);
    }

    private static Dimension calculateMinimumSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension minimumSize = new Dimension();
        minimumSize.width = (int) (screenSize.width * MIN_SIZE_RATIO);
        minimumSize.height = (int) (minimumSize.width / WINDOW_RATIO);
        return minimumSize;
    }

    private static Rectangle calculateSizePosition() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle sizePosition = new Rectangle();
        sizePosition.height = (int) (screenSize.getHeight() * SIZE_RATIO);
        sizePosition.width = (int) (sizePosition.height * WINDOW_RATIO);
        return sizePosition;
    }

    public void addMessage() {
        messages.addMessage(getTextField().getText());
        getTextField().setText("");
        showMessages();
    }

    private JLabel getTextField() {
        return null;
    }

    private void showMessages() {
        getMessagesPane().setText(messages.getMessages());
    }

    public JEditorPane getMessagesPane() {
        return messagesPane;
    }

    public void init() {
    }
}