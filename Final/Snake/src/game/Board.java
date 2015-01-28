package game;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class Board extends JFrame {

    public static  int Width = 650;
    public static  int Height = 700;
    public static final int TileWidth = 25;
    public static final int TileHeight = 25;
    public static  int Row = 25;
    public static  int Column = 25;
    public static final int XOffset = (Width - Column * TileWidth) / 2;
    public static final int YOffset = (Height - Row * TileHeight) / 2;
    public static final int[] menu1 = {3, 4, 5, 7, 11-1, 13-1, 14-1, 15-1, 17-1, 19-1, 21-1, 22-1, 23-1};
    public static final int[] menu2 = {3, 7, 8, 11-1, 13-1, 15-1, 17-1, 19-1, 21-1};
    public static final int[] menu3 = {3, 4, 5, 7, 9, 11-1, 13-1, 14-1, 15-1, 17-1, 18-1, 21-1, 22-1, 23-1};
    public static final int[] menu4 = {5, 7, 11-1, 13-1, 15-1, 17-1, 19-1, 21-1};
    public static final int[] menu5 = {3, 4, 5, 7, 11-1, 13-1, 15-1, 17-1, 19-1, 21-1, 22-1, 23-1};
    private static final String f = "scores.txt";
    private static final int intlength =5;//The initial length the snake will be
    private static boolean playing = false;
    private static int score;
    private static int waitTime;
    private static int time = 0;
    private Snake mSnake;
    private Updater mUpdater;
    private Food mFood;
    private STATE mState;

    public Board(String title) {
        setTitle(title);
        setBounds(300, 300, Width, Height);
        setVisible(true);

        setResizable(false);
        setState(STATE.MENU);
        playing = false;
        //setDimensions(25,25,25,25);
        resetTime();
        mSnake = new Snake(intlength);
        mFood = produceFood();
        //setWait(200);
        mUpdater = new Updater(this, mSnake);
        mUpdater.start();
        //waitTime=200;
        addWindowListener(new windowHandler());
        addKeyListener(new KeyHandler(mSnake, this));
    }

    public void setState(STATE s) {
        //if(!isPlaying()){
        play();
        //}
        mState = s;
        if(s.equals(STATE.RUN)){
            repaint();
        }
        if(s.equals(STATE.DEAD)){
            repaint();
            waitTime=-1;
        }
    }

    public boolean isPlaying() {
        return playing;
    }
    public void setDimensions(int r,int c,int w,int h){
        Row=r;
        Column=c;
        Width=w*TileWidth;
        Height=h*TileHeight;
        //setBounds(300, 300, Width, Height);
        
    }
    public void play() {
        playing = true;
    }

    public void drawMenu(Graphics g) {
        //g.setColor(Color.WHITE);
        //g.fillRect(0, 0, TileWidth * Column * 2, TileHeight * Row * 2);
        setState(STATE.MENU);

        playing = false;
        g.setColor(Color.BLUE);
        for (int i = 0; i < menu1.length; i++) {
            g.fillRect(menu1[i] * TileWidth + XOffset, 5 * TileHeight + YOffset, TileWidth, TileHeight);
        }
        for (int i = 0; i < menu2.length; i++) {
            g.fillRect(menu2[i] * TileWidth + XOffset, 6 * TileHeight + YOffset, TileWidth, TileHeight);
        }
        for (int i = 0; i < menu3.length; i++) {
            g.fillRect(menu3[i] * TileWidth + XOffset, 7 * TileHeight + YOffset, TileWidth, TileHeight);
        }
        for (int i = 0; i < menu4.length; i++) {
            g.fillRect(menu4[i] * TileWidth + XOffset, 8 * TileHeight + YOffset, TileWidth, TileHeight);
        }
        for (int i = 0; i < menu5.length; i++) {
            g.fillRect(menu5[i] * TileWidth + XOffset, 9 * TileHeight + YOffset, TileWidth, TileHeight);
        }
        g.drawString("Press ENTER to Begin", 225 + XOffset, Height / 2);
        g.drawString("Press S for SLOW MODE", 225 + XOffset, 20+ Height / 2);
        g.drawString("Press F for FAST MODE", 225 + XOffset, 40+ Height / 2);
    }

    public void resetTime() {
        time = 0;
    }
    
    public int getWait(){
        return waitTime;
    }
    public void setWait(int w){
        waitTime=w;
    }

    private void readScores(Graphics g) {
        try {
            BufferedReader rdr = new BufferedReader(new FileReader(f));
            String line;
            int h = (Height / 2) + 25;
            g.drawString("HIGH SCORES", 25 + XOffset, h);
            while ((line = rdr.readLine()) != null) {
                {
                    h += 25;
                    g.drawString(line, 25 + XOffset, h);
                }
                rdr.close();

            }
        } catch (Exception ex) {
            //Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void drawDeadMessage(Graphics g) {
        playing = false;
        drawMenu(g);

        g.setColor(Color.RED);

        //g.drawRect(XOffset, YOffset, TileWidth * Column, TileHeight * Row);
        g.drawString("Sorry, you dead!", 225 + XOffset, (Height / 2)-40);
        g.drawString("Score: "+score, 225 + XOffset, (Height / 2)-20);
        //g.dispose();
        //readScores(g);
        //drawScore(g);
    }

    public void drawScore(Graphics g) {
        
        g.setColor(Color.WHITE);
        g.fillRect(0, Height - 35, Width, 100);score = mSnake.getLength() - intlength;
        g.setColor(Color.RED);
        g.drawString("Your score is " + score, XOffset, Height - 13);
        //g.drawString("Time alive: " + time / 3, Width / 2, Height - 13);
    }

    public void drawDecoration(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, TileWidth * Column * 2, TileHeight * Row * 2);
        g.setColor(Color.RED);

        g.drawRect(XOffset-1, YOffset-1, TileWidth * Column+1, TileHeight * Row+1);
    }

    public void drawSnake(Graphics g) {
        playing = true;
        g.setColor(Color.blue);
        for (int i = 0; i < mSnake.getLength(); i++) {
            Body mBody = mSnake.getBody(i);
            g.fillRect(mBody.col * TileWidth + XOffset, mBody.row * TileHeight + YOffset, TileWidth, TileHeight);
        }
        //score = mSnake.getLength() - intlength;
        time++;
    }

    public void drawFood(Graphics g) {

        g.setColor(Color.RED);
        g.fillRect(XOffset + mFood.col * TileWidth, YOffset + mFood.row * TileHeight, TileWidth, TileHeight);
    }

    public Food produceFood() {
        boolean finished;
        Food food;
        do {
            finished = true;
            food = new Food();
            for (int i = 0; i < mSnake.getLength(); i++) {
                if (mSnake.getBody(i).col == food.col && mSnake.getBody(i).row == food.row) {
                    finished = false;
                }
            }

        } while (!finished);
        mFood = food;
        //score++;
        return food;
    }

    public Food getFood() {
        return mFood;
    }

    @Override
    public void paint(Graphics g) {
        //drawDecoration(g);
        switch (mState) {
            case RUN:
                if(playing){
                    drawDecoration(g);
                    playing=false;
                }
                mSnake.move(this, g);
                //g.setColor(Color.WHITE);
                //g.fillRect(XOffset, YOffset, TileWidth * Column, TileHeight * Row);
                //drawSnake(g);
                drawFood(g);

                drawScore(g);
                break;
            case DEAD:
                //JFrame j=new JFrame();
                //g.fillRect(XOffset, YOffset, TileWidth * Column, TileHeight * Row);
                //g.setColor(Color.WHITE);
                //g.fillRect(XOffset, YOffset, TileWidth * Column, TileHeight * Row);
                drawDecoration(g);
                drawMenu(g);
                
                drawDeadMessage(g);
                drawScore(g);
                

                break;
            case MENU:
                
                drawMenu(g);
                //drawDecoration(g);

        }

    }

    public static void main(String args[]) {
        Board board = new Board("Snake -- by William and Shawn");
    }

}

class windowHandler extends WindowAdapter {

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
