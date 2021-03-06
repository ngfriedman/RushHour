import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

// GTGE
import com.golden.gamedev.*;
import com.golden.gamedev.object.*;


public class Pieces extends Sprite{
    
    
    double movementSpeed = 0;
    java.awt.image.BufferedImage img;
    int xLoca;
    int yLoca;

    public Pieces(java.awt.image.BufferedImage image, int xLocation, int yLocation) {
	super(image, xLocation, yLocation);
	img = image;
	xLoca = xLocation;
	yLoca = yLocation;
    }

    public void setMovementSpeed(double newSpeed) {
    	movementSpeed = newSpeed;
    }
    public BufferedImage getImage(){
	return img;
    }
    public double getX(){
	return xLoca;
    }
    public double getY(){
	return yLoca;
    }
}

class Piece0 extends Pieces {

    public Piece0(java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
	super(_image, _xLocation, _yLocation);
	    
    }
}

class Piece1 extends Pieces{

    public Piece1(java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
	super(_image, _xLocation, _yLocation);
	    
    }
}
class Piece2 extends Pieces{

    public Piece2 (java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
	super( _image, _xLocation, _yLocation);
    }
}

class Piece3 extends Pieces{

    public Piece3 (java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
    
	super (_image, _xLocation, _yLocation);
    }
}

class Piece4 extends Pieces {

    public Piece4 (java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
	super (_image, _xLocation, _yLocation);
    }
}
class Piece5 extends Pieces {

    public Piece5(java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
	super(_image, _xLocation, _yLocation);
	    
    }
}

class Piece6 extends Pieces{

    public Piece6(java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
	super(_image, _xLocation, _yLocation);
	    
    }
}
class Piece7 extends Pieces{

    public Piece7 (java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
	super( _image, _xLocation, _yLocation);
    }
}

class Piece8 extends Pieces{

    public Piece8 (java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
    
	super (_image, _xLocation, _yLocation);
    }
}

class Piece9 extends Pieces {

    public Piece9 (java.awt.image.BufferedImage _image, int _xLocation, int _yLocation) {
	super (_image, _xLocation, _yLocation);
    }
}
