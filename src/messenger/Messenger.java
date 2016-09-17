package messenger;


import java.util.List;

public interface Messenger {


    /**
     * Player won the game
     */
    void playerWon();

    /**
     * Gets the Messages
     * @return messages of list
     */
    List<String> getMessages();
}
