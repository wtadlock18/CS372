package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {

    private Snake mSnake;
    private Board mBoard;
    private int l;
/**
 * Connects the main snake and board to the key handlers
 * @param b The main board being used
 * @param s The main Snake being played
 */
    public KeyHandler(Snake s, Board b) {
        mSnake = s;
        mBoard = b;
        l = s.getLength();
    }
/**
 * Takes the case for every key press
 * Moves the snake, and resets the game with all different settins
 * @param e The current key pressed
 */
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
                if(mBoard.getWait()<=0)
                mBoard.setWait(105);
                mSnake.reset(l);
                mBoard.resetTime();
                mBoard.produceFood();
                
                mBoard.setState(STATE.RUN);
                
                //mBoard.setDimensions(25,25,25,25);

                
                break;
            case KeyEvent.VK_D:
                mBoard.setWait(105);
                /*mSnake.reset(l);
                mBoard.resetTime();
                mBoard.produceFood();
                mBoard.setState(STATE.RUN);
                */
                //mBoard.setDimensions(25,25,25,25);

                
                break;
            case KeyEvent.VK_S:
                mBoard.setWait(250);
                /*mSnake.reset(l);
                mBoard.resetTime();
                mBoard.produceFood();
                mBoard.setState(STATE.RUN);
                */
                //mBoard.setDimensions(25,25,25,25);
                break;
                
            case KeyEvent.VK_F:
                mBoard.setWait(50);
                /*mSnake.reset(l);
                mBoard.resetTime();
                mBoard.produceFood();
                mBoard.setState(STATE.RUN);
                */
                //mBoard.setDimensions(25,25,25,25);
                break;
            case KeyEvent.VK_M:
                mBoard.setState(STATE.MENU);
                break;
            case KeyEvent.VK_1:
                mBoard.setDimensions(15, 15, 25, 25);
                //mBoard.setState(STATE.MENU);
                mBoard.drawDecoration();               
                mBoard.repaint();
                mBoard.produceFood();
                break;
            case KeyEvent.VK_2:
                mBoard.setDimensions(20, 20, 25, 25);
                mBoard.drawDecoration();
//mBoard.setState(STATE.DEAD);
                mBoard.repaint();
                
                mBoard.produceFood();
                break;
            case KeyEvent.VK_3:
                mBoard.setDimensions(25, 25, 25, 25);
                //mBoard.setState(STATE.DEAD);
                mBoard.drawDecoration();

                mBoard.repaint();
                mBoard.produceFood();
                break;

        }
    }
}
