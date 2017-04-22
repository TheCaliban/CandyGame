package fr.iut.zen.clickandswap;

import java.awt.Color;
import java.util.Random;

public class StupidGameCell{
	private Color color;
	private final static Color[] colors = { Color.MAGENTA, Color.YELLOW, Color.BLUE, Color.GREEN };
	private final static Random colorRandom = new Random();

	public StupidGameCell(Color color) {
		this.color = color;
	}

	public static StupidGameCell randomGameCell() {
		return new StupidGameCell(colors[colorRandom.nextInt(colors.length)]);
	}

	void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return color.toString();
	}
}
