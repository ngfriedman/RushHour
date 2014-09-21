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
    static  ArrayList<Image> piecesList = new ArrayList<Image>();
    //Object[] piecesList = new Object[5];

    public void initResources() {

	piece1 = new Piece1(getImage("piece1.png"), 100, 200);
	piece2 = new Piece2(getImage("piece2.png"), 300, 100);
	piece3 = new Piece3(getImage("piece1.png"), 200, 200);
	piece4 = new Piece4(getImage("piece2.png"), 400, 300);
	piece5 = new Piece5(getImage("piece1.png"), 600, 500);

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

	public static void overlap() {

	    for (int i = 0; i < piecesList.size(); i++) {
		try {
		    Object getPieces = piecesList.get(i);	
		    BufferedImage bimg = ImageIO.read(new File(piecesList.get(i)));
		    int width          = bimg.getWidth();
		    int height         = bimg.getHeight();
		    System.out.println(width + " " + height);

		    int j = 0;
		    while (j < (piecesList.size() - i)) {
			BufferedImage bimg2 = ImageIO.read(new File(piecesList.get(i+j)));
			int width2          = bimg2.getWidth();
			int height2         = bimg2.getHeight();
			System.out.println(width + " " + width2 +  " " + height + " " + height2);
			j++;
		    }
		}
		catch( Exception e) {
		}
	    }
	}






    /*	int j = pieceList.size;
	for(int i = 0; i < pieceList.size; i++) {
       	if (piece.getLocation(); == ) {
	piece1.setSpeed(0.0, 0);
	piece2.setMovementSpeed(0.0);

	} */

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

