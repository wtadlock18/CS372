package game;

import java.util.Random;
/**
 * The base for the food that allows the Snake to grow
 * @author wtadlock18
 */
public class Food extends Body{
        /**
         * Creates a new Food in a random location on the board
         */
	public Food() {
		super(0,0);
		Random rdm = new Random();
		this.row = rdm.nextInt(Board.Row);
		this.col = rdm.nextInt(Board.Column);
	}

}
