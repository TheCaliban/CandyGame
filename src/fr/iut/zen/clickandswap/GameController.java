package fr.iut.zen.clickandswap;

import java.awt.Color;
import java.awt.geom.Point2D;
import fr.umlv.zen5.Application;
import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;

public class GameController {

	static void stupidGame(ApplicationContext context) {
		// get the size of the screen
		ScreenInfo screenInfo = context.getScreenInfo();
		float width = screenInfo.getWidth();
		float height = screenInfo.getHeight();
		System.out.println("size of the screen (" + width + " x " + height + ")");

		StupidGameData data = new StupidGameData(10, 15);
		data.setRandomMatrix();
		StupidGameView view = StupidGameView.initGameGraphics(330, 50, 1000, 700, data);
		GameView.draw(context, data, view);

		Point2D.Float location;

		while (true) {
			Event event = context.pollOrWaitEvent(10);
			if (event == null) { // no event
				continue;
			}
			Action action = event.getAction();
			if (action == Action.KEY_PRESSED || action == Action.KEY_RELEASED) {
				System.out.println("Aaaaahh!");
				context.exit(0);
				return;
			}
			if (action != Action.POINTER_DOWN) {
				continue;
			}

			if (!data.hasSelectedCells()) { // no cell is selected
				location = event.getLocation(); // !!! attention aucune vérfifcation des coordonnées!!!
				data.selectFirstCell(view.lineFromX(location.x), view.columnFromY(location.y));
			} else {
				location = event.getLocation();
				data.selectSecondCell(view.lineFromX(location.x), view.columnFromY(location.y));

				data.swapSelectedCells();
				data.unselect();
			}
			GameView.draw(context, data, view);
		}
	}

	public static void main(String[] args) {
		// pour changer de jeu, remplacer stupidGame par le nom de la méthode de jeu (elle doit avoir extaement la mieme en-tête).
		Application.run(Color.LIGHT_GRAY, GameController::stupidGame); // attention, utilisation d'une lambda.
	}
}
