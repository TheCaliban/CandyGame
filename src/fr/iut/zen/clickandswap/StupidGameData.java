package fr.iut.zen.clickandswap;

import java.awt.Color;
import java.nio.file.Path;

public class StupidGameData implements GameData{
	private final StupidGameCell[][] matrix;
	private Coordinates selected1, selected2;

	public StupidGameData(int nbLines, int nbColumns) {
		matrix = new StupidGameCell[nbLines][nbColumns];
	}

	@Override
	public int getNbLines() {
		return matrix.length;
	}

	@Override
	public int getNbColumns() {
		return matrix[0].length;
	}

	@Override
	public Color getCellColor(int i, int j) {
		return matrix[i][j].getColor();
	}
	
	@Override
	public Coordinates getFirstSelected() {
		return selected1;
	}

	@Override
	public Coordinates getSecondSelected() {
		return selected2;
	}

	@Override
	public boolean hasSelectedCells() {
		return selected1 != null;
	}

	@Override
	public void selectFirstCell(int i, int j) {
		if (selected1 != null) {
			throw new IllegalStateException("First cell already selected");
		}
		selected1 = new Coordinates(i, j);
	}

	@Override
	public void selectSecondCell(int i, int j) {
		if (selected1 == null) {
			throw new IllegalStateException("First cell not selected yet");
		}
		if (selected2 != null) {
			throw new IllegalStateException("Second cell already selected");
		}
		selected2 = new Coordinates(i, j);
		if (selected1.equals(selected2)) {
			unselect();
		}
	}

	@Override
	public void unselect() {
		selected1 = null;
		selected2 = null;
	}

	public void setRandomMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = StupidGameCell.randomGameCell();
			}
		}
	}

	private void swapCells(int i1, int j1, int i2, int j2) {
		StupidGameCell tmp = matrix[i1][j1];
		matrix[i1][j1] = matrix[i2][j2];
		matrix[i2][j2] = tmp;
	}

	public void swapSelectedCells() {
		if (selected1 == null || selected2 == null) {
			throw new IllegalStateException("Swap impossible");
		}
		swapCells(selected1.getI(), selected1.getJ(), selected2.getI(), selected2.getJ());
	}

	public void updateData() {
		// update (attention traitement different si des cases sont
		// selectionnées ou non...)
	}
}
