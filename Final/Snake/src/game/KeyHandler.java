package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {

    private Snake mSnake;
    private Board mBoard;
    private int l;

    public KeyHandler(Snake s, Board b) {
        mSnake = s;
        mBoard = b;
        l = s.getLength();
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                
                mSnake.changeDirection(DIRECTION.UP);
                break;
            case KeyEvent.VK_DOWN:
                mSnake.changeDirection(DIRECTION.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                mSnake.changeDirection(DIRECTION.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                mSnake.changeDirection(DIRECTION.RIGHT);
                break;
            case KeyEvent.VK_F5:
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_R:
            
                mBoard.setWait(105);
                mSnake.reset(l);
                mBoard.resetTime();
                mBoard.setState(STATE.RUN);
                
                //mBoard.setDimensions(25,25,25,25);

                
                break;
            case KeyEvent.VK_D:
                mBoard.setWait(105);
                mSnake.reset(l);
                mBoard.resetTime();
                mBoard.setState(STATE.RUN);
                
                //mBoard.setDimensions(25,25,25,25);

                
                break;
            case KeyEvent.VK_S:
                mBoard.setWait(250);
                mSnake.reset(l);
                mBoard.resetTime();
                mBoard.setState(STATE.RUN);
                
                //mBoard.setDimensions(25,25,25,25);
                break;
                
            case KeyEvent.VK_F:
                mBoard.setWait(50);
                mSnake.reset(l);
                mBoard.resetTime();
                mBoard.setState(STATE.RUN);
                
                //mBoard.setDimensions(25,25,25,25);
                break;
            case KeyEvent.VK_M:
                mBoard.setState(STATE.MENU);
                break;

        }
    }
}
