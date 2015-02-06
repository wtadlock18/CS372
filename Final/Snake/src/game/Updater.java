package game;

public class Updater extends Thread {

    private Board mBoard;
    private Snake mSnake;
/**
 * Connects the main snake and board to the updater
 * @param b The main board being used
 * @param s The main Snake being played
 */
    public Updater(Board b, Snake s) {
        mBoard = b;
        mSnake = s;
    }
/**
 * Checks if the game is in menu or not, then continues the game and makes the next move
 */
    public void run() {

        while (true) {
            //PT -- Explain how this works. What's getWait() supposed to return?
            //if (mBoard.isPlaying()) {
            if (mBoard.getWait() >= 0) {
                mBoard.repaint();

            //}
                try {
                    sleep(mBoard.getWait());
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
    }

}
