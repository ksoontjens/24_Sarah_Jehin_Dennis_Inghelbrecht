package hellotvxlet;

import java.awt.event.KeyEvent;
import java.util.Random;
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
  int aantalLichamen = 8;
  int aantalBenen = 8;
  
  int huidigeHoofdAfbeelding;
  int huidigeLichaamAfbeelding;
  int huidigeBenenAfbeelding;
  
  
  //background fill voor geselecteerde schuiver
  HStaticText activeColor;
  
    public HelloTVXlet() {
    
    }

    public void initXlet(XletContext context) {
       scene=HSceneFactory.getInstance().getDefaultHScene();
       
      //random startwaarden
      Random rnd = new Random();
      rnd.setSeed(123456789);
       
      huidigeHoofdAfbeelding = rnd.nextInt(aantalHoofden);
      huidigeLichaamAfbeelding = rnd.nextInt(aantalLichamen);
      huidigeBenenAfbeelding = rnd.nextInt(aantalBenen);
      
      
      //hoofden
      hoofden=new Schuiver(720/2-68,150);
      scene.add(hoofden);
      hoofden.voegtoetot("hoofd",aantalHoofden);
      //in de schuif hieronder moet je een random waarde meegeven
      hoofden.schuif(huidigeHoofdAfbeelding);
      
      //lichamen
      lichamen = new Schuiver(720/2-68, 291);
      scene.add(lichamen);
      lichamen.voegtoetot("lichaam", aantalLichamen);
      lichamen.schuif(huidigeLichaamAfbeelding);
      
      //benen
      benen = new Schuiver(720/2-68, 371);
      scene.add(benen);
      benen.voegtoetot("benen", aantalBenen);
      benen.schuif(huidigeBenenAfbeelding);
      
      //activeBodypart staat standaard op nul voor de hoofdenschuiver geselecteerd te hebben
      activeBodypart = 0;
      
      amountOfImg = aantalHoofden;
      
      
      activeColor = new HStaticText("", 720/2-78, 150, 100, 141);
      activeColor.setBackground(new DVBColor(0, 200, 200, 127));
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
    System.out.println("STARTXLET!!!!!!!");
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
                activeColor.setLocation(720/2-78, 150);
                activeColor.setSize(100, 141);
                //activeColor = new HStaticText("", 90, 130, 150, 150);  
                //scene.repaint();
                System.out.println(activeBodypart);
            }
            else if(activeBodypart == 2) {
                activeBodypart = 1;
                amountOfImg = aantalLichamen;
                activeColor.setLocation(720/2-78, 291);
                activeColor.setSize(100, 80);
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
                activeColor.setLocation(720/2-78, 291);
                activeColor.setSize(100, 80);
                //activeColor = new HStaticText("", 200, 130, 150, 150);
                //scene.repaint();
                System.out.println(activeBodypart);
            }
            else if(activeBodypart == 1) {
                activeBodypart = 2;
                activeColor.setLocation(720/2-78, 371);
                activeColor.setSize(100, 50);
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
                //System.out.println("voor switch: " + hinx);
                hinx++;
                //System.out.println("na switch: " + hinx);
            }
            if(activeBodypart == 0) {
                huidigeHoofdAfbeelding = hinx;
                hoofden.schuif(hinx);
            }
            if(activeBodypart == 1) {
                huidigeLichaamAfbeelding = hinx;
                lichamen.schuif(hinx);
            }
            if(activeBodypart == 2) {
                huidigeBenenAfbeelding = hinx;
                benen.schuif(hinx);
            }
            
            
            //System.out.println("hoofd: " + huidigeHoofdAfbeelding + "lichaam: " + huidigeLichaamAfbeelding + "benen: " + huidigeBenenAfbeelding);
            //als zowel het hoofd, het lichaam en de benen op dezelfde afbeelding staan
            if(huidigeHoofdAfbeelding == huidigeLichaamAfbeelding && huidigeLichaamAfbeelding == huidigeBenenAfbeelding) {
                //gewonnen !!!
                System.out.println("Gewonnen");
                HStaticText result = new HStaticText("Gewonnen!", 720/2-100, 450, 200, 100);
                result.setBackground(new DVBColor(0, 200, 50, 200));
                result.setBackgroundMode(HVisible.BACKGROUND_FILL);
                scene.add(result);
                scene.popToFront(result);
                scene.repaint();
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
                huidigeHoofdAfbeelding = hinx;
                hoofden.schuif(hinx);
            }
            if(activeBodypart == 1) {
                huidigeLichaamAfbeelding = hinx;
                lichamen.schuif(hinx);
            }
            if(activeBodypart == 2) {
                huidigeBenenAfbeelding = hinx;
                benen.schuif(hinx);
            }
            
            //System.out.println("hoofd: " + huidigeHoofdAfbeelding + "lichaam: " + huidigeLichaamAfbeelding + "benen: " + huidigeBenenAfbeelding);
            //als zowel het hoofd, het lichaam en de benen op dezelfde afbeelding staan
            if(huidigeHoofdAfbeelding == huidigeLichaamAfbeelding && huidigeLichaamAfbeelding == huidigeBenenAfbeelding) {
                //gewonnen !!!
                System.out.println("Gewonnen");
                HStaticText result = new HStaticText("Gewonnen!", 720/2-100, 450, 200, 100);
                result.setBackground(new DVBColor(0, 200, 50, 200));
                result.setBackgroundMode(HVisible.BACKGROUND_FILL);
                scene.add(result);
                scene.popToFront(result);
                scene.repaint();
            }
            
            scene.repaint();
        }
    }
}
