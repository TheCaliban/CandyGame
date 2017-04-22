package fr.iut.zen.clickandswap;

import java.awt.Color;
import java.nio.file.Path;

/**
 * The GameData class defines the data used by a click-and-swap game.
 * This represents a matrix with possibly one or two selected cells.
 */
public interface GameData {
	/**
	 * The number of lines in the matrix contained in this GameData.
	 * @return the number of lines in the matrix.
	 */
	public int getNbLines();
	
	/**
	 * The number of columns in the matrix contained in this GameData.
	 * @return the number of columns in the matrix.
	 */
	public int getNbColumns();
	
	/**
	 * The color of the cell specified by its coordinates.
	 * @param i the first coordinate of the cell.
	 * @param j the second coordinate of the cell.
	 * @return he color of the cell specified by its coordinates
	 */
	public Color getCellColor(int i, int j);
	
	/**
	 * The coordinates of the first cell selected, if a cell is selected.
	 * @return the coordinates of the first cell selected, if a cell is selected; null otherwise.
	 */
	public Coordinates getFirstSelected();

	/**
	 * The coordinates of the second cell selected, if a cell is selected.
	 * @return the coordinates of the second cell selected, if a second cell is selected; null otherwise.
	 */
	public Coordinates getSecondSelected();

	/**
	 * Tests if at least one cell is selected.
	 * @return true if and only if at least one cell is selected; false otherwise.
	 */
	public boolean hasSelectedCells();

	/**
	 * Selects, as the first cell, the one identified by the specified coordinates.
	 * @param i the first coordinate of the cell.
	 * @param j the second coordinate of the cell.
	 * @throws IllegalStateException if a first cell is already selected.
	 */
	public void selectFirstCell(int i, int j);

	/**
	 * Selects, as the second cell, the one identified by the specified coordinates.
	 * @param i the first coordinate of the cell.
	 * @param j the second coordinate of the cell.
	 * @throws IllegalStateException if a first cell has not been selected yet or if a second cell is already selected.
	 */
	public void selectSecondCell(int i, int j);
	
	/**
	 * Unselects both the first and the second cell (whether they were selected or not).
	 */
	public void unselect();

	/**
	 * If there are two selected cells, swaps them.
	 * @throws IllegalStateException if not both cells are selected.
	 */
	public void swapSelectedCells();

	/**
	 * Updates the data contained in the GameData.
	 */
	public void updateData();
}
