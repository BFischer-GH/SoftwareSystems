package ss.week7.chat.client;

import java.net.InetAddress;

public interface ChatClient {

    void addChatListener();

    void removeChatListener(); // void added with autocorrect

    /**
     * The boolean methods should return true on success or false on failure, for example when the
     * connection is broken.
     *
     * @param address
     * @param port
     * @return
     */
    boolean connect(InetAddress address, int port);

    /**
     *
     */
    void close();

    /**
     * @param username
     * @return
     */
    boolean sendUsername(String username);

    /**
     * @param message
     * @return
     */
    boolean sendMessage(String message);
}
