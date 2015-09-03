import java.awt.Rectangle;

import org.sikuli.script.*;
import org.openqa.selenium.WebDriver.*;
public class TestSikuli {

        public static void main(String[] args) {
                Screen s = new Screen();
                Rectangle r = new Rectangle(300,200);
                
                try{
                		s.capture(r);
                		//System.out.println(r.getMinX());
                        s.click("/home/andrelo/Escritorio/mozila.png", 0);
                        //s.doubleClick("/home/andrelo/Escritorio/texto.png", 0);
                        s.selectRegion("ANDRELO");                        
                        //hs.wait("/home/andrelo/Escritorio/BigBan.jpg-imput.png");
                        //s.type(null, "hello world\n", 0);
                        System.out.println("AAAAAAAAAAAAAAA");
                }
                catch(FindFailed e){
                        e.printStackTrace();
                }
        }
}