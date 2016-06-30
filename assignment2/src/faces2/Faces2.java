package faces2;

import simplegui.*;
import static faces2.AbstractFace.sg;
import java.awt.Color;
/**
 *
 * @author rolf
 */
public class Faces2 implements GUIListener{
    
    public Faces2(){
        sg.registerToGUI(this);
    }
    
    @Override
    public void reactToButton1(){
        
    }
    @Override
    public void reactToButton2(){
        sg.pauseProgram(3000);
        
        
    }
    @Override
    public void reactToSlider(int x){
        
    }
    @Override
    public void reactToSwitch(boolean bln){

    }
    
    private static double mainGame(){
        boolean answer = true;
        long time = System.currentTimeMillis();
        int count = 0;
        sg.labelButton2("Pause");
        do{ 
            sg.eraseAllDrawables("a");
            int a = (int) ((Math.random()) * 6);
            int b = 0;
            drawShape(a, 1); //1 is for right left side
            if ((Math.random()) < 0.077) 
            { 
                if (a%2 == 0)
                    b = a + 1;
                else 
                    b = a - 1;
            }
            else
                b = (int) ((Math.random()) * 6 );
            drawShape(b,2);
            char choice = sg.keyReadChar();
            sg.eraseAllDrawables();
            motivationalPhrase();
            sg.print("");
//            if (((a%2==0) && ((b == a) || b == a +1)) && choice == 'e'){
//                count ++;}
//            else if (((a%2==1) && ((b == a) || b == a -1)) && choice == 'e'){
//                count ++;}
//            else if (((a%2==0) && b!=a && b != a + 1) && choice == 'u'){
//                count ++;  }
//            else if (((a%2 ==1) && b != a && b!=a -1) && choice == 'u'){
//                count ++;  
//            }
            if ((((a%2==0) && ((b == a) || b == a +1)) && choice == 'e')
                    || (((a%2==1) && ((b == a) || b == a -1)) && choice == 'e') 
                    || (((a%2==0) && b!=a && b != a + 1) && choice == 'u') 
                    ||(((a%2 ==1) && b != a && b!=a -1) && choice == 'u'))
                count++;
            else
                answer = false;
            
        } while (answer && count < 10);
        sg.eraseAllDrawables();
        long totalTime = System.currentTimeMillis() - time;
        if(count == 10)
            return (double) totalTime/count;
        else
            return -1.0;
    }
    
    private static void motivationalPhrase(){
        int x = (int) ( Math.random() * 6);
        switch (x){
            case 0:
                sg.drawText("Great Job!", 200, 100);
                break;
            case 1:
                sg.drawText("Keep it up!", 200 , 100);
                break;
            case 2:
                sg.drawText("Awesome!", 200, 100);
                break;
            case 3:
                sg.drawText("Don't quit now!", 200, 100);
                break;
            case 4:
                sg.drawText("You can do it!", 200, 100);
                break;
            case 5:
                sg.drawText("Perfect!", 200, 100);
                break;
            default:
                sg.drawText("I really hope this message does not appear on the"
                        + " graphic window", 200, 100 );
        }
    }
   
    private static void drawShape(int x, int y){ //if y = 1 then its on left side of screen, if y= 2 then its on right side of screen
        switch (x){
            case 0:
                if (y==1){
                SmileyBoxFace f = new SmileyBoxFace(20, 180, 200);}
                else
                {SmileyBoxFace f = new SmileyBoxFace(300,180, 200);}
                break;
            case 1:
                if (y==1){
                SmileyEllipseFace f = new SmileyEllipseFace(20, 180, 200);}
                else
                {SmileyEllipseFace f = new SmileyEllipseFace(300,180, 200);}
                break;
            case 2:
                if (y==1){
                FrowningBoxFace f = new FrowningBoxFace(20, 180, 200);}
                else
                {FrowningBoxFace f = new FrowningBoxFace(300,180, 200);}
                break;
            case 3:
                if (y==1){
                FrowningEllipseFace f = new FrowningEllipseFace(20, 180, 200);}
                else
                {FrowningEllipseFace f = new FrowningEllipseFace(300,180, 200);}
                break;
            case 4:
                if (y==1){
                SeriousBoxFace f = new SeriousBoxFace(20, 180, 200);}
                else
                {SeriousBoxFace f = new SeriousBoxFace(300,180, 200);}
                break;
            case 5:
                if (y==1){
                SeriousEllipseFace f = new SeriousEllipseFace(20, 180, 200);}
                else
                {SeriousEllipseFace f = new SeriousEllipseFace(300,180, 200);}
                break;
            default:
                sg.drawText("I really hope this message does not appear on the"
                        + " graphic window", 200, 100 );
                
                
                    
        }
    }
    
    private static void createStartScreen(){
        sg.print("Click \"Start\" to play");
        sg.labelButton1("Start");
        sg.drawText("Welcome to the game.  When the faces appear on the screen, ", 125, 100);
        sg.drawText("click 'u' to say that the facial expressions are not the same", 125, 115);
        sg.drawText("and click 'e' to say that the facial expressions are the same.", 125, 130);
        sg.drawText("Speed matters.  Your score will be the average time it takes", 125, 145);
        sg.drawText("you to determine if two faces are equal or unequal.  But, if", 125, 160);
        sg.drawText("you answer incorrectly, the game is over.  Click start to begin.", 125, 175);
        sg.waitForButton1();
        sg.print("");
        sg.eraseAllDrawables();
    }
    
    public static void main(String[] args) {
        
        sg = new SimpleGUI();
        Faces2 f = new Faces2();
        while (true){
        createStartScreen();
        double score = mainGame();
        if ((int) score == -1)
            sg.drawText("Sorry you answered incorrectly.  Game Over.", 200, 200);
        else
            sg.drawText("Congradulations, You Won!   Your average reaction time was " + (score/1000) + " seconds", 75, 100);
        sg.labelButton1("Play Again");
        sg.print("Click the \"Play Again\" button to try again.");
        sg.waitForButton1();
        sg.eraseAllDrawables();
        }
                
    }
}
