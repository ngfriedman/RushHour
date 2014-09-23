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
    Piece0 piece0;
    Piece1 piece1;
    Piece2 piece2;
    Piece3 piece3;
    Piece4 piece4;
    Piece5 piece5;
    Piece6 piece6;
    Piece7 piece7;
    Piece8 piece8;
    Piece9 piece9;
    
    Pieces Selected;
    ImageBackground background;
    SpriteGroup PIECES;
    // CollisionManager crashChecker;

    //RushHourMain piecesList = new RushHourMain();
    static  ArrayList<Pieces> piecesList = new ArrayList<Pieces>();
    //Object[] piecesList = new Object[5];

    public void initResources() {
	
	piece0 = new Piece0(getImage("Student.png"), 10, 215);
	piece1 = new Piece1(getImage("RedCouch.png"), 350, 10);
	piece2 = new Piece2(getImage("OrangeSeat.png"), 220, 440);
	piece3 = new Piece3(getImage("YellowCouch.png"), 550, 110);
	piece4 = new Piece4(getImage("GreenCouch.png"), 10, 325);
	piece5 = new Piece5(getImage("BlueSeat.png"), 10, 540);
        piece6 = new Piece6(getImage("PurpleSeat.png"),390, 430);
	piece7 = new Piece7(getImage("PinkSeat.png"),330, 540);
	piece8 = new Piece8(getImage("DarkPurpleSeat.png"),390,200);
	piece9 = new Piece9(getImage("WhiteSeat.png"),10,10);
			    
	
	/*	piece1.setLocation(100, 500);
	piece2.setLocation(750, 300);
	piece3.setLocation(300, 300);
	piece4.setLocation(400, 50);
	piece5.setLocation(600, 100);
	*/
	piece1.setSpeed(0.0, 0);
	piece1.setMovementSpeed(0.3);

	background = new ImageBackground(getImage("Lego.jpg"));
	piece1.setBackground(background);

	PIECES = new SpriteGroup("Piece");
	PIECES.add(piece0);
	PIECES.add(piece1);
	PIECES.add(piece2);
	PIECES.add(piece3);
	PIECES.add(piece4);
	PIECES.add(piece5);
	PIECES.add(piece6);
	PIECES.add(piece7);
	PIECES.add(piece8);
	PIECES.add(piece9);


	piecesList.add(piece0);
	piecesList.add(piece1);
	piecesList.add(piece2);
	piecesList.add(piece3);
	piecesList.add(piece4);
	piecesList.add(piece5);
	piecesList.add(piece6);
	piecesList.add(piece7);
	piecesList.add(piece8);
	piecesList.add(piece9);

    }

	public void update(long elapsedTime) {
	    PIECES.update(elapsedTime);
	    
	    if (keyDown(KeyEvent.VK_0)){
		Selected = piece0;
	    }
	    else if (keyDown(KeyEvent.VK_1)){
		Selected = piece1;
	    }
	    else if (keyDown(KeyEvent.VK_2)){
		Selected = piece2;
	    }
	    else if(keyDown(KeyEvent.VK_3)){
		Selected = piece3;
	    }
	    else if(keyDown(KeyEvent.VK_4)){
		Selected = piece4;
	    }
	    else if(keyDown(KeyEvent.VK_5)){
		Selected = piece5;
	    }
	     else if (keyDown(KeyEvent.VK_6)){
		Selected = piece6;
	    }
	    else if (keyDown(KeyEvent.VK_7)){
		Selected = piece7;
	    }
	    else if(keyDown(KeyEvent.VK_8)){
		Selected = piece8;
	    }
	    else if(keyDown(KeyEvent.VK_9)){
		Selected = piece9;
	    }
	    else if(Selected == null){
		Selected = piece0;
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

	    for (int i = 0; i < piecesList.size(); i++) {
		try {
		    BufferedImage bimg = piecesList.get(i).getImage();	
		    // BufferedImage bimg = ImageIO.read(new File(piecesList.get(i).getImage()));
		    int width          = bimg.getWidth();
		    int height         = bimg.getHeight();
		    System.out.println(width + " " + height);

		    int j = 1;
		    while (j < (piecesList.size() - i)) {
			 BufferedImage bimg2 = piecesList.get(i+j).getImage();
			//BufferedImage bimg2 = ImageIO.read(new File(piecesList.get(i+j).getImage()));
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
        game.setup(new RushHourMain(), new Dimension(850, 650), false);
        game.start();
	    }
}


