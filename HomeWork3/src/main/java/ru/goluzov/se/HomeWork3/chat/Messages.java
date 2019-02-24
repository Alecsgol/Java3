package ru.goluzov.se.HomeWork3.chat;

import ru.goluzov.se.HomeWork3.chat.ChatHistory;

public class Messages {
    private String messages = "";

    public Messages() {
        messages = ChatHistory.loadHistory();
    }

    public String getMessages() {
        return messages;
    }

    public void addMessage(String message) {
        messages += message + "\n";
    }

    public void saveHistory() {
        ChatHistory.saveHistory(messages);
    }
}