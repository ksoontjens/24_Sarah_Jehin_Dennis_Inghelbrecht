package hellotvxlet;

import java.awt.event.KeyEvent;
import javax.tv.xlet.*;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.dvb.ui.DVBColor;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;
import org.havi.ui.event.HRcEvent;


public class HelloTVXlet implements Xlet , UserEventListener{
    Schuiver hoofden;
    Schuiver lichamen;
    Schuiver benen;
  HScene scene;
  int hinx=0;
  
  //activebody part is het bodypart dat je kan shufflen, je kan dit aanpassen met pijltje naar boven of beneden
  int activeBodypart;
  
  //aantal delen is het aantal delen dat dit lichaamsdeel bevat (er zijn bvb 8 hoofden, maar maar 2 lichamen, ...)
  int amountOfImg;
  
  int aantalHoofden = 8;
  int aantalLichamen = 2;
  int aantalBenen = 2;
  
  //background fill voor geselecteerde schuiver
  HStaticText activeColor;
  
    public HelloTVXlet() {
    
    }

    public void initXlet(XletContext context) {
       scene=HSceneFactory.getInstance().getDefaultHScene();
       //hoofden
      hoofden=new Schuiver(100,143);
      scene.add(hoofden);
      hoofden.voegtoetot("head",8);
      hoofden.schuif(0);
      
      //lichamen
      lichamen = new Schuiver(100, 250);
      scene.add(lichamen);
      lichamen.voegtoetot("body", 2);
      lichamen.schuif(0);
      
      //benen
      benen = new Schuiver(100, 350);
      scene.add(benen);
      benen.voegtoetot("legs", 2);
      benen.schuif(0);
      
      //activeBodypart staat standaard op nul voor de hoofdenschuiver geselecteerd te hebben
      activeBodypart = 0;
      
      amountOfImg = aantalHoofden;
      
      
      activeColor = new HStaticText("", 90, 130, 150, 150);
      activeColor.setBackground(new DVBColor(0, 0, 255, 127));
      activeColor.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      scene.add(activeColor);
      
      
      scene.validate();
      scene.setVisible(true);
      UserEventRepository rep =new UserEventRepository("naam");
      rep.addAllArrowKeys();
      EventManager man=EventManager.getInstance();
      man.addUserEventListener(this, rep);
      
      
     
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void userEventReceived(UserEvent e) {
        
        //boven en onder (up and down) voor van schuiver te verwisselen
        if (e.getCode()==HRcEvent.VK_UP && e.getType()==KeyEvent.KEY_PRESSED)
        {
            if(activeBodypart == 0) {
                //do nothing, want er is geen schuiver boven "hoofden" -> je zou eventueel wel ineens naar 2 kunnen gaan zodat je bij de voeten uitkomt
                System.out.println("Do nothing " + activeBodypart);
            }
            else if(activeBodypart == 1) {
                activeBodypart = 0;
                amountOfImg = aantalHoofden;
                activeColor.setLocation(90, 130);
                //activeColor = new HStaticText("", 90, 130, 150, 150);  
                //scene.repaint();
                System.out.println(activeBodypart);
            }
            else if(activeBodypart == 2) {
                activeBodypart = 1;
                amountOfImg = aantalLichamen;
                activeColor.setLocation(90, 250);
                //activeColor = new HStaticText("", 200, 130, 150, 150);
                //scene.repaint();
                System.out.println(activeBodypart);
            }
        }
        
        if (e.getCode()==HRcEvent.VK_DOWN && e.getType()==KeyEvent.KEY_PRESSED)
        {
            if(activeBodypart == 0) {
                activeBodypart = 1;
                amountOfImg = aantalLichamen;
                activeColor.setLocation(90, 250);
                //activeColor = new HStaticText("", 200, 130, 150, 150);
                //scene.repaint();
                System.out.println(activeBodypart);
            }
            else if(activeBodypart == 1) {
                activeBodypart = 2;
                activeColor.setLocation(90, 350);
                //activeColor = new HStaticText("", 300, 130, 150, 150);
                //scene.repaint();
                System.out.println(activeBodypart);
            }
            else if(activeBodypart == 2) {
                //do nothing, want er is geen schuiver onder "benen" -> je zou eventueel wel ineens naar 2 kunnen gaan zodat je bij de voeten uitkomt
                System.out.println(activeBodypart);
            }
        }
        
        
        
        
        
        //links en rechts (left en right) voor de geselecteerde schuiver
        
        if (e.getCode()==HRcEvent.VK_LEFT && e.getType()==KeyEvent.KEY_PRESSED)
        {
            //hieronder stond oorspronkelijk hinx > 6
            if(hinx > (amountOfImg-2)) {
                hinx = 0;
            }
            else {
                hinx++;
            }
            if(activeBodypart == 0) {
                hoofden.schuif(hinx);
            }
            if(activeBodypart == 1) {
                lichamen.schuif(hinx);
            }
            if(activeBodypart == 2) {
                benen.schuif(hinx);
            }
            
            scene.repaint();
        }
        
        if (e.getCode()==HRcEvent.VK_RIGHT && e.getType()==KeyEvent.KEY_PRESSED)
        {
                    
            if(hinx < 1){
                //hinx = 7;
                hinx = amountOfImg-1;
            }
            else {
                hinx--;
            }      
            if(activeBodypart == 0) {
                hoofden.schuif(hinx);
            }
            if(activeBodypart == 1) {
                lichamen.schuif(hinx);
            }
            if(activeBodypart == 2) {
                benen.schuif(hinx);
            }
            
            scene.repaint();
        }
    }
}
