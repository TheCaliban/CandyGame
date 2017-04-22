package fr.iut.zen.clickandswap;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class StupidGameView implements GameView{
	private final int xOrigin;
	private final int yOrigin;
	private final int width;
	private final int length;
	private final int squareSize;

	private StupidGameView(int xOrigin, int yOrigin, int length, int width, int squareSize) {
		this.xOrigin = xOrigin;
		this.yOrigin = yOrigin;
		this.length = length;
		this.width = width;
		this.squareSize = squareSize;
	}

	public static StupidGameView initGameGraphics(int xOrigin, int yOrigin, int length, int width, GameData data) {
		int squareSize = Math.min((int) (length * 1.0 / data.getNbLines()), 
								(int) (width * 1.0 / data.getNbColumns()));
		return new StupidGameView(xOrigin, yOrigin, length, width, squareSize);
	}

	private int indexFromReaCoord(float coord, int origin) { // attention, il manque des test de validité des coordonnées!
		return (int) ((coord - origin) / squareSize);
	}

	@Override
	public int lineFromX(float x) {
		return indexFromReaCoord(x, xOrigin);
	}
	
	@Override
	public int columnFromY(float y) {
		return indexFromReaCoord(y, yOrigin);
	}

	private float realCoordFromIndex(int index, int origin) {
		return origin + index * squareSize;
	}

	private float xFromI(int i) {
		return realCoordFromIndex(i, xOrigin);
	}

	private float yFromJ(int j) {
		return realCoordFromIndex(j, yOrigin);
	}

	private RectangularShape drawCell(int i, int j) {
		return new Rectangle2D.Float(xFromI(i) + 2, yFromJ(j) + 2, squareSize - 4, squareSize - 4);
	}

	private RectangularShape drawSelectedCell(int i, int j) {
		return new Rectangle2D.Float(xFromI(i), yFromJ(j), squareSize, squareSize);
	}
	
	@Override
	public void draw(Graphics2D graphics, GameData data) {
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fill(new Rectangle2D.Float(xOrigin, yOrigin, length, width));

		graphics.setColor(Color.BLACK);
		Coordinates c = data.getFirstSelected();
		if (c != null || (c = data.getSecondSelected()) != null) {
			graphics.fill(drawSelectedCell(c.getI(), c.getJ()));
		}

		for (int i = 0; i < data.getNbLines(); i++) {
			for (int j = 0; j < data.getNbColumns(); j++) {
				graphics.setColor(data.getCellColor(i, j));
				graphics.fill(drawCell(i, j));
			}
		}
	}
	
	@Override
	public void drawOnlyOneCell(Graphics2D graphics, GameData data, float x, float y) {
		draw(graphics, data);
	}
}
