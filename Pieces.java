import java.awt.*;
import java.awt.event.*;

// GTGE
import com.golden.gamedev.*;
import com.golden.gamedev.object.*;


public class Pieces extends Sprite{

    double movementSpeed = 0;

    public Pieces(java.awt.image.BufferedImage image, int xLocation, int yLocation) {
	super(image, xLocation, yLocation);
    }

    public void setMovementSpeed(double newSpeed) {
    	movementSpeed = newSpeed;
    }
	    
}

class Piece1 extends Pieces {

    public Piece1(java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
	super(_image, _xLocation, _yLocation);
	    
    }
}

class Piece2 extends Pieces{

    public Piece2(java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
	super(_image, _xLocation, _yLocation);
	    
    }
}
class Piece3 extends Pieces{

    double movementSpeed = 0;

    public Piece3 (java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
	super( _image, _xLocation, _yLocation);
    }
}

class Piece4 extends Pieces{

    public Piece4 (java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
	super (_image, _xLocation, _yLocation);
    }
}

class Piece5 extends Pieces {

    public Piece5 (java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
	super (_image, _xLocation, _yLocation);
    }
}

