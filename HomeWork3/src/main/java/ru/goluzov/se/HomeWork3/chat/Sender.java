package ru.goluzov.se.HomeWork3.chat;

import ru.goluzov.se.HomeWork3.chat.ChatWindow;
import ru.goluzov.se.HomeWork3.chat.Messages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sender {
    private ChatWindow chatWindow;
    private Messages messages;

    public Sender(ChatWindow chatWindow, Messages messages) {
        this.chatWindow = chatWindow;
        this.messages = messages;
    }

    private ActionListener send() {
        ActionListener _send = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chatWindow.addMessage();
            }
        };
        return _send;
    }
}