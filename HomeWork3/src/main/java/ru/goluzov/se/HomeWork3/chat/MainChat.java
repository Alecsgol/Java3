package ru.goluzov.se.HomeWork3.chat;

import ru.goluzov.se.HomeWork3.net.ClientChat;

public class MainChat {
    public static void main(String[] args) {
        Messages messages = new Messages();
        ChatWindow chatWindow = new ChatWindow();
        chatWindow.init(messages);
        Sender sender = new Sender(chatWindow, messages);
        ClientChat.init();
        chatWindow.init();
    }
}