package fr.iut.zen.clickandswap;

import java.awt.Graphics2D;
import fr.umlv.zen5.ApplicationContext;

/**
 * The GameView class is in charge of the graphical view of a click-and-swap game.
 */
public interface GameView {
	/**
	 * Transforms a real x-coordinate into the index of the corresponding line.
	 * @param x a float x-coordinate
	 * @return the index of the corresponding line.
	 * @throws IllegalArgumentException if the float coordinate doesn't fit in the game board.
	 */
	public int lineFromX(float x);

	/**
	 * Transforms a real y-coordinate into the index of the corresponding column.
	 * @param y a float y-coordinate
	 * @return the index of the corresponding column.
	 * @throws IllegalArgumentException if the float coordinate doesn't fit in the game board.
	 */
	public int columnFromY(float y);


	/**
	 * Draws the game board from its data, using an existing Graphics2D object.
	 * @param graphics a Graphics2D object provided by the default method {@code draw(ApplicationContext, GameData)}
	 * @param data the GameData containing the game data.
	 */
	public void draw(Graphics2D graphics, GameData data);

	/**
	 * Draws the game board from its data, using an existing {@code ApplicationContext}.
	 * @param context the {@code ApplicationContext} of the game
	 * @param data the GameData containing the game data.
	 * @param view the GameView on which to draw.
	 */
	public static void draw(ApplicationContext context, GameData data, GameView view) {
		context.renderFrame(graphics -> view.draw(graphics, data));
	}
	
	/**
	 * Draws only the cell specified by the given coordinates in the game board from its data, using an existing Graphics2D object.
	 * @param graphics a Graphics2D object provided by the default method {@code draw(ApplicationContext, GameData)}
	 * @param data the GameData containing the game data.
	 * @param x the float x-coordinate of the cell.
	 * @param y the float y-coordinate of the cell.
	 */
	public void drawOnlyOneCell(Graphics2D graphics, GameData data, float x, float y);

	/**
	 * Draws only the cell specified by the given coordinates in the game board from its data, using an existing {@code ApplicationContext}.
	 * @param context the {@code ApplicationContext} of the game
	 * @param data the GameData containing the game data.
	 * @param view the GameView on which to draw.
	 * @param x the float x-coordinate of the cell.
	 * @param y the float y-coordinate of the cell.
	 */
	public static void drawOnlyOneCell(ApplicationContext context, GameData data, GameView view, float x, float y) {
		context.renderFrame(graphics -> view.drawOnlyOneCell(graphics, data, x, y));
	}
}
