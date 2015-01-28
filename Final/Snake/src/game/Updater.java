package game;

public class Updater extends Thread {

    private Board mBoard;
    private Snake mSnake;

    public Updater(Board b, Snake s) {
        mBoard = b;
        mSnake = s;
    }

    public void run() {

        while (true) {
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
