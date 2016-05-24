package hellotvxlet;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;


    
    
public class HelloTVXlet implements Xlet
      
{
 ShuffleXlet gxlet;
 XletContext ctx;
 
 int level;
 //completepeople = aantal mensen dat je per level al gemaakt hebt
 int completePeople;
 
 int timerTime;
 

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {

    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        
            level=1;
            completePeople = 0;
            // Start de GameXlet
            this.ctx=ctx;
            timerTime = 25;
            gxlet=new ShuffleXlet(this, level, timerTime);
            
            gxlet.initXlet(ctx);
            gxlet.startXlet();
    }

    public void pauseXlet() {

    }

    public void startXlet() throws XletStateChangeException {
    
    }
 
    public void restart() throws XletStateChangeException
    {
        System.out.println("Restart Xlet!!!");
        gxlet.destroyXlet(true);
  
        gxlet=new ShuffleXlet(this, level, timerTime);
        gxlet.initXlet(ctx);
        gxlet.startXlet();
    }


    
}