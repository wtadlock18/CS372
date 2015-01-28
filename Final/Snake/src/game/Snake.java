package game;

import static game.Board.TileHeight;
import static game.Board.TileWidth;
import static game.Board.XOffset;
import static game.Board.YOffset;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;


enum DIRECTION {

    UP, DOWN, LEFT, RIGHT;
}

public class Snake {

    private List<Body> mBody;
    private DIRECTION mDirection;
    private int l;

    public Snake(int length) {
        l = length;
        mBody = new ArrayList<Body>();
        reset(l);
    }

    public void reset(int l) {
        mBody.clear();
        for (; l > 0; l--) {
            mBody.add(new Body(7, l));
            //mBody.add(new Body(7,3));
            //mBody.add(new Body(7,2));
            //mBody.add(new Body(7,1));
        }
        mDirection = DIRECTION.RIGHT;
    }

    public void changeDirection(DIRECTION d) {
        switch (d) {
            case UP:
                if (mDirection == DIRECTION.DOWN) {
                    return;
                }
                
                break;
            case DOWN:
                if (mDirection == DIRECTION.UP) {
                    return;
                }
                break;
            case LEFT:
                if (mDirection == DIRECTION.RIGHT) {
                    return;
                }
                break;
            case RIGHT:
                if (mDirection == DIRECTION.LEFT) {
                    return;
                }
                break;
        }
        mDirection = d;
    }
    public DIRECTION getDir(){
        return mDirection;
    }

    public void move(Board b,Graphics g) {
        
        Body head;
        Body headold = mBody.get(0);
        
        switch (mDirection) {
            case UP:
                head = new Body(headold.row - 1, headold.col);
                break;
            case DOWN:
                head = new Body(headold.row + 1, headold.col);
                break;
            case LEFT:
                head = new Body(headold.row, headold.col - 1);
                break;
            case RIGHT:
                head = new Body(headold.row, headold.col + 1);
                break;
            default:
                head = new Body(0, 0);
                break;
        }

        Food f = b.getFood();
        if (f.row == head.row && f.col == head.col) {
            mBody.add(0, f);
            b.produceFood();
            g.setColor(Color.blue);
            g.fillRect(mBody.get(0).col * TileWidth + XOffset, mBody.get(0).row * TileHeight + YOffset, TileWidth, TileHeight);
            //b.repaint();
        } else {
            mBody.remove(mBody.size() - 1);
            mBody.add(0, head);
            g.setColor(Color.blue);
            g.fillRect(mBody.get(0).col * TileWidth + XOffset, mBody.get(0).row * TileHeight + YOffset, TileWidth, TileHeight);
            g.setColor(Color.WHITE);
            g.fillRect(mBody.get(mBody.size()- 1).col * TileWidth + XOffset, mBody.get(mBody.size() - 1).row * TileHeight + YOffset, TileWidth, TileHeight);


            
            //b.repaint();
        }
        if (checkBodyCollision() || checkBoundCollision(b)) {
            //
            
            
            //b.setWait(-1);
            b.setState(STATE.DEAD);
        }

        
    }

    public Body getBody(int index) {
        return mBody.get(index);
    }

    public int getLength() {
        return mBody.size();
    }

    public boolean checkBodyCollision() {
        Body head = getBody(0);
        for (int i = 1; i < getLength(); i++) {
            if (head.col == getBody(i).col && head.row == getBody(i).row) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoundCollision(Board b) {
        Body head = getBody(0);
        if (head.col >= b.Column || head.col < 0 || head.row >= b.Row || head.row < 0) {
            return true;
        }
        return false;
    }

}

class Body {

    public int row;
    public int col;	//col = column

    public Body(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public int getcol(){
        return col;
    }
    public int getrow(){
        return row;
    }
}
