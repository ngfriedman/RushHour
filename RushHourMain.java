
import javax.swing.JFrame;
import com.golden.gamedev.*;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.background.*;

public class RushHourMain extends Game{

    Pieces piece1;
    Pieces piece2;

    ImageBackground background;
    SpriteGroup PIECES;
    // CollisionManager crashChecker;

    public void initResources() {
	piece1 = new Pieces(getImage("piece1.png"), 100, 300);
	piece2 = new Pieces(getImage("piece2.png"), 300, 100);

	piece1.setLocation(50, 100);
	piece2.setLocation(200, 100);

	piece1.setSpeed(0.0, 0);
	piece1.setMovementSpeed(0.2);

	//piece2.setSpeed(0.0, 0);
	//piece2.setMovementSpeed(0.2);

	background = new ImageBackground(getImage("Lego.png"));
	piece1.setBackground(background);

	PIECES = new SpriteGroup("Player Group");
        PIECES.add(piece1);
	PIECES.add(piece2);

	//	crashChecker = new SimpleCollision();
	//	crashChecker.setCollisionGroup(PIECES);

    }

    public void update(long elapsedTime) {
	PIECES.update(elapsedTime);

 if (keyDown(KeyEvent.VK_DOWN)) {
        	piece1.move(0, piece1.movementSpeed*elapsedTime);
        } 
        if (keyDown(KeyEvent.VK_UP)) {
        	piece1.move(0, -piece1.movementSpeed*elapsedTime);
        }
        if (keyDown(KeyEvent.VK_RIGHT)) {
        	piece1.move(piece1.movementSpeed*elapsedTime, 0);
        }
        if (keyDown(KeyEvent.VK_LEFT)) {
        	piece1.move(-piece1.movementSpeed*elapsedTime, 0);
        }
    }

    public void render(Graphics2D g) {
    	background.render(g);
	PIECES.render(g);
    }

    public static void main(String[] args){

	GameLoader game = new GameLoader();
        game.setup(new RushHourMain(), new Dimension(600, 600), false);
        game.start();
	    }
}
