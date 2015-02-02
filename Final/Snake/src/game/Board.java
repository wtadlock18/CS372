package game;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Random;
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
    private static boolean started=false;
    private static boolean obstacles=false;
    private Snake mSnake;
    private Updater mUpdater;
    private Food mFood;
    private STATE mState;

    /**
     * Creates the main board frame that initializes and creates the size of the board, the snake,
     * And starts the updater thread. Most of the things set can be changed with variables and modifiers
     * @param title Sets the main title of the Frame
     */
    
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
/**
 * Sets the state of the game and shifts the drawing accordingly
 * @param s The new state of the game, and does repainting accordingly
 */
    public void setState(STATE s) {
        //if(!isPlaying()){
        play();
        //}
        mState = s;
        if(s.equals(STATE.RUN)){
            repaint();
        }
        if(s.equals(STATE.MENU)){
            
        }
        if(s.equals(STATE.DEAD)){
            repaint();
            waitTime=-1;
        }
    }
    

    /**
     * A not quite fully functional way to continuously update the size of the game board 
     * @param r Number of rows in the new updated game board
     * @param c Number of columns in the new updated game board
     * @param w width of each tile
     * @param h height of each tile
     */
    public void setDimensions(int r,int c,int w,int h){
        Row=r;
        Column=c;
        Width=(2*XOffset)+w*TileWidth;//calculates needed width of the screen
        Height=(2*YOffset)+h*TileHeight;//calculates needed hieghts of the screen
        this.setBounds(300, 300, Width, Height);
        repaint();
        
    }
    /**
     * Tells everything that the game is being played
     */
    public void play() {
        playing = true;
    }
    /**
     * Draws a menu which consists of the word SNAKE drawn in block letters
     * Draws a brief instructions on how to play and start the game
     * Give menu options to change the box size and snake speed
     * Displays current box size and snake speed
     * @param g The graphics in which to draw the menu
     */
    public void drawMenu(Graphics g) {
        //g.setColor(Color.WHITE);
        //g.fillRect(0, 0, TileWidth * Column * 2, TileHeight * Row * 2);
        setState(STATE.MENU);
        if(!started){
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 1000, 1000);
            started=true;
        }
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
        g.drawString("Press ENTER to Begin", 250 + XOffset, (Height / 2)-10);
        g.drawString("Arrow Keys to move", 260 + XOffset, 10+Height / 2);
        g.drawString("Press S for SLOW MODE", 150 + XOffset, 40+ Height / 2);
        g.drawString("Press D for MED MODE", 150 + XOffset, 60+ Height / 2);
        g.drawString("Press F for FAST MODE", 150 + XOffset, 80+ Height / 2);
        g.drawString("Current Speed: MEDIUM", 150 + XOffset, 100+ Height / 2);
                
        switch(waitTime){
            case 250:
                g.setColor(Color.WHITE);
                g.fillRect(245, 85+Height/2, 55, 20);
                g.setColor(Color.BLUE);
                g.drawString("Current Speed: SLOW", 150 + XOffset, 100+ Height / 2);
                break;
            case 105:
                g.setColor(Color.WHITE);
                g.fillRect(245, 85+Height/2, 55, 20);
                g.setColor(Color.BLUE);
                g.drawString("Current Speed: MEDIUM", 150 + XOffset, 100+ Height / 2);
                break;
            case 50:
                g.setColor(Color.WHITE);
                g.fillRect(245, 85+Height/2, 55, 20);
                g.setColor(Color.BLUE);
                g.drawString("Current Speed: FAST", 150 + XOffset, 100+ Height / 2);   
                break;
            
        }
        g.drawString("Press 1 to set SIZE SMALL", 325 + XOffset, 40+ Height / 2);
        g.drawString("Press 2 to set SIZE MEDIUM", 325 + XOffset, 60+ Height / 2);
        g.drawString("Press 3 to set SIZE LARGE", 325 + XOffset, 80+ Height / 2);
        switch(Row){
            case 25:
                g.setColor(Color.WHITE);
                g.fillRect(409, 85+Height/2, 85, 20);
                g.setColor(Color.BLUE);
                g.drawString("Current Size: LARGE 25x25", 325 + XOffset, 100+ Height / 2);
                break;
            case 20:
                g.setColor(Color.WHITE);
                g.fillRect(409, 85+Height/2, 85, 20);
                g.setColor(Color.BLUE);
                g.drawString("Current Size: MEDIUM 20x20", 325 + XOffset, 100+ Height / 2);
                break;
            case 15:
                g.setColor(Color.WHITE);
                g.fillRect(409, 85+Height/2, 85, 20);
                g.setColor(Color.BLUE);
                g.drawString("Current Size: SMALL 15x15", 325 + XOffset, 100+ Height / 2);   
                break;
            
        }
    }

    /**
     * Resets the time when a new game starts.
     * Not important at the moment because time isn't being used
     */
    public void resetTime() {
        time = 0;
    }
    /**
     * Returns the wait time which represents how long the snake waits before the next move
     * The lower the wait returned, the faster the snake goes
     * @return How long the snake waits before moving next
     */
    public int getWait(){
        return waitTime;
    }
    /**
     * Sets the wait time which represents how long the snake waits before the next move
     * The lower the wait returned, the faster the snake goes
     * @param w The time the snake will wait before moving
     */
    public void setWait(int w){
        waitTime=w;
    }
    
    /**
     * A method which reads scores from a file and outputs a high score list onto the screen
     * Currently not implemented or working properly
     * @param g The graphics in which everything is drawn on
     */

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
    /**
     * Tell you that you dead when you're dead
     * @param g The graphics in which everything is drawn on
     */

    public void drawDeadMessage(Graphics g) {
        //playing = false;
        //if(mState.equals(State.DEAD)){
        drawMenu(g);
        
        g.setColor(Color.RED);

        //g.drawRect(XOffset, YOffset, TileWidth * Column, TileHeight * Row);
        g.drawString("Sorry, you dead!", 235+ XOffset, (Height / 2)-40);
        g.drawString("Score: "+score, 345 + XOffset, (Height / 2)-40);
        //}
        
        //readScores(g);
        //drawScore(g);
    }
    
    /**
     * The score for the game is drawn at the bottom of the board so the player can stay updated on their score
     * @param g The graphics in which everything is drawn on
     */

    public void drawScore(Graphics g) {
        
        g.setColor(Color.WHITE);
        g.fillRect(0, Height - 35, Width, 100);
        score = mSnake.getLength() - intlength;
        g.setColor(Color.RED);
        g.drawString("Your score is " + score, XOffset, Height - 13);
        //g.drawString("Time alive: " + time / 3, Width / 2, Height - 13);
    }
/**
 * The red rectangle of the board is drawn on the screen so the user can see the bounds for the Snake
 */
    public void drawDecoration() {
        Graphics g=this.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, TileWidth * Column * 2, TileHeight * Row * 2);
        
        g.setColor(Color.RED);
        g.drawRect(XOffset-1, YOffset-1, TileWidth * Column+1, TileHeight * Row+1);
        
    }
    /**
     * A currently not implemented function to draw several box obstacles within the screen
     * This method is not currently fully functional or ready to implement
     */
    public void drawObstacles(){
        Graphics g=this.getGraphics();
        Random rand=new Random();
        int w1;
        int h1;
        for(int i=0;i<5;i++){
            w1=rand.nextInt(Row);
            h1=rand.nextInt(Column);
            g.setColor(Color.black);
            g.fillRect(h1 * TileWidth + XOffset, w1 * TileHeight + YOffset, TileWidth, TileHeight);
        }
        
    }

    /**
     * The initial method of drawing the snake on the board which is not currently implemented and not used.
     * Tough it works fine, Re-implementing this method may cause unnecessary flashing
     * @param g The graphics in which everything is drawn on
     */
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

    /**
     * The method to draw the placement of the food on the board whenever the snake is still alive
     * @param g The graphics in which everything is drawn on
     */
    public void drawFood(Graphics g) {

        g.setColor(Color.RED);
        g.fillRect(XOffset + mFood.col * TileWidth, YOffset + mFood.row * TileHeight, TileWidth, TileHeight);
    }

    /**
     * Creates a new valid location for the food to be produced in
     * @return a new Food returned in a proper location
     */
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

    /**
     * Gets the current drawn food
     * @return The current food being drawn and used
     */
    public Food getFood() {
        return mFood;
    }

    /**
     * The method which draws all of the components onto the  board. 
     * Constantly being called to ensure the user only views the most recent board
     * @param g The graphics in which everything is drawn on
     */
    @Override
    public void paint(Graphics g) {
        //drawDecoration(g);
        
        switch (mState) {
            case RUN:
                if(playing){
                    drawDecoration();
                    playing=false;
                }
                mSnake.move(this, g);
                //g.setColor(Color.WHITE);
                //g.fillRect(XOffset, YOffset, TileWidth * Column, TileHeight * Row);
                //drawSnake(g);
                drawFood(g);
                //drawObstacles();

                //drawScore(g);
                break;
            case DEAD:
                //JFrame j=new JFrame();
                //g.fillRect(XOffset, YOffset, TileWidth * Column, TileHeight * Row);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, 1000, 1000);
                //drawDecoration(g);
                drawMenu(g);
                
                drawDeadMessage(g);
                drawScore(g);
                

                break;
            case MENU:
                
                drawMenu(g);
                //drawDecoration(g);

        }

    }

    /**
     * The main method which creates a new board that initializes the whole game
     * @param args 
     */           
    public static void main(String args[]) {
        Board board = new Board("Snake -- by William and Shawn");
    }

}

class windowHandler extends WindowAdapter {


    /**
     * Makes sure the game closes when it is told to close
     * @param e 
     */
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
