package ss.week7.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ChatClientHandler should receive and send messages. To receive messages, the
 * ChatClientHandler should be a Runnable and run should read lines from the stream until the
 * stream is closed.
 * Tip: use a BufferedReader to read lines. For now, you do not need to do anything yet with the
 * lines.
 */

public class ChatClientHandler implements Runnable {

    private final BufferedReader reader;
    private final PrintWriter writer;
    private final Socket socket;
    private String userName;
    private MyChatServer74 server;

    //Constructor, all this as it's for each CH on a  thread
    public ChatClientHandler(Socket socket, MyChatServer74 server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); //7.4.4 Tip: use a BufferedReader to read lines. For now, you do not need to do anything yet with the
        //lines.
        this.writer = new PrintWriter(socket.getOutputStream(), true); // System.out zorgt dat de output in de consule komt.
    }

    // 7.4.5 add and implement sendChat(String from, String message)
    // to write messages from the server to a connected client according to the described protocol
    public void sendChat(String from, String message) throws IOException {
        String serverMessage = "FROM~" + from + "~" + message;

        try {
            writer.println(serverMessage);
        } catch (Exception e) {
            close();
        }

    }

    // 7.4.4 ChatClientHandler should receive and send messages. To receive messages, the
    //ChatClientHandler should be a Runnable and run should read lines from the stream until the
    //stream is closed.
    @Override
    public void run() {
        boolean run = true;

        while (run) {
            try {
                String message = reader.readLine();
                if (message == null) { // 7.4.7 if message is null call the close method
                    run = false; // and end the thread by returning from run.
                    close();// <= Close
                    server.removeClient(this); // 7.4.15 implementation of removing THIS specific client
                } else if (userName == null) { // Only if there's no userName given, the first input will become username
                    userName = message;
                    server.addClient(this); //7.4.15 adding THIS specific client
                } else {
                    String[] messageSplit = message.split("~");
                    if (messageSplit[0].equals("SAY") && messageSplit.length == 2) {
                        server.handleChatMessage(this, messageSplit[1]);    //The user needs to be THIS, why? => because
                        // handleChatMessage type is requested and not the String Username
                    }

                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    // 7.4.6 Make a close() method
    public void close() throws IOException {
        socket.close();
    }

    public String getClientUserName() { //7.4.12 this is the required getter
        return userName;
    }
}
