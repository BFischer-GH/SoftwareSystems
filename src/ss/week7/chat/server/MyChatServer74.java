package ss.week7.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyChatServer74 implements ChatServer, Runnable {

    private int port;
    private ServerSocket serversocket;
    private Thread thread;
    private ArrayList<ChatClientHandler> client = new ArrayList<>(); // 7.4.12 create a clients field in the Server class

    public MyChatServer74(int port) { // Constructor for the port => opgeven bij de test!
        this.port = port;
    }

    public static void main(String[] args) { // om de server te starten dit was
        MyChatServer74 server = new MyChatServer74(8000);
        server.start();
    }

    @Override
    public void start() {
        try {
            this.serversocket = new ServerSocket(port);
            System.out.println("Started server at port " + this.serversocket.getLocalPort());
            this.thread = new Thread(this);
            this.thread.start();
        } catch (IOException e) {
            System.out.println("Error: couldn't start a connection at port" + this.serversocket.getLocalPort());
            e.printStackTrace();
        }

    }

    @Override
    public int getPort() {
        return this.serversocket.getLocalPort(); // Copy paste van MyCalcServer72
    }

    @Override
    public void stop() {
        try {
            serversocket.close();
            this.thread.join();
            return;
        } catch (IOException | InterruptedException e) {
            System.out.println("Terminated Server at port " + this.serversocket.getLocalPort());
        }
    }

    @Override
    public void run() {
        boolean run = true;
        int clientCounter = 0;

        while (run) {

            // Socket sock = null;
            try {
                Socket sock = serversocket.accept();
                ChatClientHandler ch = new ChatClientHandler(sock, this); // added ,this and sock is accepted?
                new Thread(ch).start();
                clientCounter++;
            } catch (IOException e) {
                System.out.println("Terminated server at port" + this.serversocket.getLocalPort());
                run = false;
            }
        }
    }

    public void handleChatMessage(ChatClientHandler from, String message) throws IOException { // 7.4.12
        String userName = from.getClientUserName(); // Van de gegeven client uit de lijst wordt de userName opgevraagd via getClientUsername()

        for (ChatClientHandler client : client) { //Doorloop de lijst per client (voeg this voor client toe als er wat fout gaat)
            client.sendChat(userName, message); // Verstuur een bericht volgens From~userName~bericht
        }

    }

    public void addClient(ChatClientHandler labelBij) {
        client.add(labelBij);
    }

    public void removeClient(ChatClientHandler labelWeg) {
        client.remove(labelWeg);
    }

}
