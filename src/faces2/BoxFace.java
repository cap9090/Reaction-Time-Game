package faces2;

import java.awt.Color;
import simplegui.*;

/**
 *
 * @author rolf
 */
public class BoxFace extends AbstractFace{
    BoxFace(int x, int y, int size){
        super(x,y,size);
    }

    @Override
    public void drawFaceShape(Color c) {
        sg.drawFilledBox(x, y, size, size / 2, c, 1.0, "a");
    }
    
    
   
}
