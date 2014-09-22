import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Added
import java.util.ArrayList;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import com.golden.gamedev.*;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.background.*;

public class RushHourMain extends Game{

    Piece1 piece1;
    Piece2 piece2;
    Piece3 piece3;
    Piece4 piece4;
    Piece5 piece5;

    ImageBackground background;
    SpriteGroup PIECES;
    // CollisionManager crashChecker;

    //RushHourMain piecesList = new RushHourMain();
    static  ArrayList<Pieces> piecesList = new ArrayList<Pieces>();
    //Object[] piecesList = new Object[5];

    public void initResources() {

	piece1 = new Piece1(getImage("piece1.png"), 100, 200);
	piece2 = new Piece2(getImage("piece2.png"), 300, 100);
	piece3 = new Piece3(getImage("pieces3.png"), 200, 200);
	piece4 = new Piece4(getImage("piece4.png"), 400, 300);
	piece5 = new Piece5(getImage("piece5.png"), 600, 500);

	piece1.setLocation(100, 500);
	piece2.setLocation(750, 300);
	piece3.setLocation(300, 300);
	piece4.setLocation(400, 50);
	piece5.setLocation(600, 100);

	piece1.setSpeed(0.0, 0);
	piece1.setMovementSpeed(0.3);

	background = new ImageBackground(getImage("Lego.jpg"));
	piece1.setBackground(background);

	PIECES = new SpriteGroup("Piece");
	PIECES.add(piece1);
	PIECES.add(piece2);
	PIECES.add(piece3);
	PIECES.add(piece4);
	PIECES.add(piece5);

	piecesList.add(piece1);
	piecesList.add(piece2);
	piecesList.add(piece3);
	piecesList.add(piece4);
	piecesList.add(piece5);

    }

	public void update(long elapsedTime) {
	    PIECES.update(elapsedTime);
	    Pieces Selected = piece1;
	    if (keyDown(KeyEvent.VK_1)){
		Selected = piece1;
	    }
	    if (keyDown(KeyEvent.VK_2)){
		Selected = piece2;
	    }
	    if(keyDown(KeyEvent.VK_3)){
		Selected = piece3;
	    }
	    if(keyDown(KeyEvent.VK_4)){
		Selected = piece4;
	    }
	    if(keyDown(KeyEvent.VK_5)){
		Selected = piece5;
	    }
	    if (Selected.getImage().getWidth() < Selected.getImage().getHeight()){
		    if (keyDown(KeyEvent.VK_DOWN)) {
			Selected.move(0, piece1.movementSpeed*elapsedTime);
		    } 
		    if (keyDown(KeyEvent.VK_UP)) {
			Selected.move(0, -piece1.movementSpeed*elapsedTime);
		    }
	    }
	
	    if(Selected.getImage().getWidth() > Selected.getImage().getHeight()){
		    if (keyDown(KeyEvent.VK_RIGHT)) {
			Selected.move(piece1.movementSpeed*elapsedTime, 0);
		    }
		    if (keyDown(KeyEvent.VK_LEFT)) {
			Selected.move(-piece1.movementSpeed*elapsedTime, 0);
		    }
	    }
	    
	}
	
	public static void overlap() {

	int i= 0;
	while ( i != selected) {
	    for (i = 0; i < piecesList.size(); i++) {
		try {
		    BufferedImage bimgI = piecesList.get(i).getImage();	
		    int widthI = bimgI.getWidth();
		    int heightI = bimgI.getHeight();

		    int xLocI = piecesList.get(i).getX;
		    int yLocI = piecesList.get(i).getY;

		    Point2D.Double ltCornerI = new Point2D.Double (xLocI, yLocI);
		    Point2D.Double rtCornerI = new Point2D.Double ((xLocI+widthI), yLocI);
		    Point2D.Double lbCornerI = new Point2D.Double (xLocI, (yLocI+heightI));
		    Point2D.Double rbCornerI = new Point2D.Double ((xLocI+widthI), (yLocI+heightI));

		    BufferedImage bimgS = piecesList.get(Selected).getImage();
		    int widthS = bimgS.getWidth();
		    int heightS = bimgS.getHeight();

		    int xLocS = piecesList.get(Selected).getX;
		    int yLocS = piecesList.get(Selected).getY;


		    Point2D.Double ltCornerS = new Point2D.Double (xLocS, yLocS);
		    Point2D.Double rtCornerS = new Point2D.Double ((xLocS+widthS), yLocS);
		    Point2D.Double lbCornerS = new Point2D.Double (xLocS, (yLocS+heightS));
		    Point2D.Double rbCornerS = new Point2D.Double ((xLocS+widthS), (yLocS+heightS));

		    if(lbCornerI <= ltCornerS <= rbCornerI || lbC <= rtCornerS <= rbCornerI) {

			piecesList.get(Selected).setSpeed(0.0, 0);
			piecesList.get(Selected).setMovementSpeed(0.0);
		    }
		}
		catch( Exception e) {
		}
	    }
	}
    }
    	
    public void render(Graphics2D g) {
    	background.render(g);
	PIECES.render(g);
    }

    public static void main(String[] args){

	GameLoader game = new GameLoader();
        game.setup(new RushHourMain(), new Dimension(1000, 1000), false);
        game.start();
	    }
}


