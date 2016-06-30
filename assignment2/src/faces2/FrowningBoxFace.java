/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faces2;
import static faces2.AbstractFace.sg;
import java.awt.Color;
import simplegui.*;

/**
 *
 * @author test
 */
public class FrowningBoxFace extends BoxFace{

    public FrowningBoxFace(int x, int y, int size) {
        super(x, y, size);
    }
    
    @Override
    public void drawFacialExpression() {
    
// place the eyes and mouth dependign on position and facesize
        int centerX = x + size / 2;
        int centerY = y + size / 4;
        int eyeRadius = size / 10;

        // nose in center
        sg.drawFilledEllipse(centerX - eyeRadius / 2 / 4, centerY - eyeRadius / 2 / 3, eyeRadius / 4, eyeRadius / 3, Color.red, 1.0, "a");

        // eyes
        int leftEyeX = centerX - size / 7 - eyeRadius / 2;
        int rightEyeX = centerX + size / 7 - eyeRadius / 2;
        int eyeY = centerY - size / 7;
        sg.drawFilledEllipse(leftEyeX, eyeY, eyeRadius, eyeRadius, Color.red, 1.0, "a");
        sg.drawFilledEllipse(rightEyeX, eyeY, eyeRadius, eyeRadius, Color.red, 1.0, "a");

        // mouth
        int mouthY = centerY + size / 10;
        sg.drawLine(leftEyeX + eyeRadius, mouthY, rightEyeX, mouthY, Color.red, 1.0, eyeRadius / 3, "a");
        //this for left side of mouth
        sg.drawLine(leftEyeX + eyeRadius, mouthY, leftEyeX + eyeRadius -10, mouthY + 10, Color.red, 1.0, eyeRadius/3, "a");
        //this for right side of mouth
        sg.drawLine(rightEyeX, mouthY, rightEyeX + 10, mouthY  + 10, Color.red, 1.0, eyeRadius/3, "a");
    }
}
