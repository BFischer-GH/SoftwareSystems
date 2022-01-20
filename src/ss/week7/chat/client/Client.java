package ss.week7.chat.client;

import ss.week7.chat.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements ChatClient, Runnable {
    private Socket socket = null;
    private ChatListener listener;
    private BufferedReader in;
    private PrintWriter out;
    private Thread thread;
    private boolean run = true;

    public Client() { //Empty Constructor
    }

    @Override
    public boolean connect(InetAddress address, int port) {
        try {
            this.socket = new Socket(address, port);
            System.out.println("Started connection on port");
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream())); //Deze gaat standaard worden
            this.out = new PrintWriter(socket.getOutputStream(), true); //Add true for autoflush
            this.addChatListener(); //Add new
            this.thread = new Thread(this);
            this.thread.start();
            return true;
        } catch (IOException e) {
            System.out.println("Error with connection");
            return false;
        }
    }

    @Override
    public void close() {
        try {
            this.run = false;
            this.socket.close();
            this.removeChatListener();
            this.thread.join();
            System.out.println("Socket is closed");

        } catch (IOException | InterruptedException e) {
            System.out.println("Could not close socket");

        }
    }

    @Override
    public boolean sendUsername(String username) {
        try {
            this.out.println(username);
            this.sendMessage(" joined the chat");
            return true; // Waarom?
        } catch (Exception e) { //If there is an error writing, make sure you call close() and return false.
            this.close();
            return false;
        }
    }

    @Override
    public boolean sendMessage(String message) {
        try {
            String fullMessage = "SAY~" + message;
            this.out.println(fullMessage);
            return true;
        } catch (Exception e) {
            this.close();
            return false;
        }
    }

    @Override
    public void addChatListener() {
        this.listener = new Chat();
    }

    @Override
    public void removeChatListener() {
        this.listener = null;
    }

    @Override
    public void run() { //Nalopen waarom dit zo geschreven moet worden...
        while (this.run) {
            try {
                String line = this.in.readLine();
                if (line == null) {
                    this.close();
                } else if (line.startsWith("FROM")) {
                    String[] messageSplit = line.split("~");
                    this.listener.messageReceived(messageSplit[1], messageSplit[2]);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
