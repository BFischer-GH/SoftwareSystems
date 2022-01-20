package ss.week7.chat;

import ss.utils.TextIO;
import ss.week7.chat.client.ChatClient;
import ss.week7.chat.client.ChatListener;
import ss.week7.chat.client.Client;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Chat implements ChatListener {

    public static void main(String[] args) {
        InetAddress address = null;
        int port = 0;
        String userName = null;
        ChatClient client = new Client(); //Type ChatClient met naam client maakt object Client() aan
        String message = "";

        do {
            System.out.println(" Please give a server address (Localhost)");
            try {
                address = InetAddress.getByName(TextIO.getlnString());
            } catch (UnknownHostException e) {
                System.out.println("not a valid server address");
                continue;
            }
            System.out.println("Please give a server port (int)");
            port = TextIO.getlnInt();
            System.out.println("Please give a username (String)");
            userName = TextIO.getlnString();
        } while (!client.connect(address, port)); // nu doorloop je de loop minimaal 1 keer

        client.sendUsername(userName); //Eerste input wordt je username

        while (!(message.equals("quit"))) {
            message = TextIO.getlnString();
            client.sendMessage(message);
        }
        client.sendMessage("left the chat");
        System.out.println("Chat ended");
        client.close();
    } // End of main

    @Override
    public void messageReceived(String from, String message) {
        System.out.println(from + ": " + message);

    }
}
