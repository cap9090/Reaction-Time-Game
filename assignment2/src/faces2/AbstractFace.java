package faces2;

import java.awt.Color;
import simplegui.SimpleGUI;
 
/**
 *
 * @author rolf
 */
public abstract class AbstractFace {

    int x, y;   // position on screen
    int size;   // face's size
    int tan;    // our faces are all between blue and green...
    static SimpleGUI sg; // STATIC! all faces share the same sg!

    // Abstract methods (here, it's only one)
    public abstract void drawFaceShape(Color c);
    
    // constructor
    // YES, an abstract class can have a constructor!
    // although it cannot be instantiated, this constructor can be called
    // using "super(...)" in inherited classes!
    public AbstractFace(int x, int y, int size) {
        // sg is static, i.e. shared! We only want to instantiate it, if it wasn't
        // created before already.
        if (sg == null){
            sg = new SimpleGUI(false);
        }
        this.x = x;
        this.y = y;
        this.size = size;
        tan = (int) (Math.random() * 255);
        drawFace();
    }

    // we assume that a face will always have a head, eyes, nose and mouth.
    // We implement the calls to draw these features in a non-abstract method!
    // However, this method uses the abstract method "drawFaceShape", which will 
    // be implemented in inherited classes to define the face-shape details.
    private void drawFace() {
        // determine color
        // tan is between 0 and 255, hence the 
        // green and blue values will be between 0 and 255
        // red is 0
        Color c = new Color(0, tan, 255 - tan);

        // draw the faceshape
        // we use a method, although it would just be a sinngle line of
        // code to draw the ellipse here. The reason: we want the shape to
        // be variable, and therefore we want this part to be overwritten by
        // other classes
        drawFaceShape(c);

        // draw face features (eyes and mouth)
        // we want other programmers to change the facial expression, too,
        // so make it an overridable method call.
        drawFacialExpression();

    }

    // currently non-abstract, a default implementation.
    public void drawFacialExpression() {
        // place the eyes and mouth dependign on position and facesize
        int centerX = x + size / 2;
        int centerY = y + size / 4;
        int eyeRadius = size / 10;

        // nose in center
        sg.drawFilledEllipse(centerX - eyeRadius / 2 / 4, centerY - eyeRadius / 2 / 3, eyeRadius / 4, eyeRadius / 3, Color.red, 1.0, "");

        // eyes
        int leftEyeX = centerX - size / 7 - eyeRadius / 2;
        int rightEyeX = centerX + size / 7 - eyeRadius / 2;
        int eyeY = centerY - size / 7;
        sg.drawFilledEllipse(leftEyeX, eyeY, eyeRadius, eyeRadius, Color.red, 1.0, "");
        sg.drawFilledEllipse(rightEyeX, eyeY, eyeRadius, eyeRadius, Color.red, 1.0, "");

        // mouth
        int mouthY = centerY + size / 10;
        sg.drawLine(leftEyeX + eyeRadius, mouthY, rightEyeX, mouthY, Color.red, 1.0, eyeRadius / 3, "");
    }
}
