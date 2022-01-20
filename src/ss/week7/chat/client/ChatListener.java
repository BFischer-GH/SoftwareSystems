package ss.week7.chat.client;

public interface ChatListener {
    /**
     * @param from
     * @param message
     */
    void messageReceived(String from, String message);
}
