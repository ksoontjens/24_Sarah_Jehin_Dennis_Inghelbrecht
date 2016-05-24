package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
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
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;
import org.havi.ui.event.HRcEvent;


public class ShuffleXlet implements Xlet , UserEventListener, HActionListener{
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
  
  //timer
  boolean running;
  long startTime;
  int timer;
  HStaticText timerText;
  int default_time = 25;
  
  //level
  int levelnr;
  HStaticText levelText;
  
  HStaticText instructions1;
  HStaticText instructions2;
  HStaticText madeBy;
  
  HTextButton nextLevel;
  HTextButton tryAgain;
  HelloTVXlet applicationManager=null;
  
    public ShuffleXlet(HelloTVXlet a, int level, int timerTime) {
        applicationManager=a;
        levelnr = level;
        timer = timerTime;
    }

    public void initXlet(XletContext context) {
       scene=HSceneFactory.getInstance().getDefaultHScene();

       scene.setBackground(new DVBColor(36, 86, 142, 255));
       scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
      running = true;
      
     
    }

    public void startXlet() {
    System.out.println("STARTXLET!!!!!!!");
    
    //System.out.println(levelnr);
    //timer = 10;
    System.out.println("level " + applicationManager.level);
    System.out.println("completepeople " + applicationManager.completePeople);
    
    
    levelText = new HStaticText("Level: " +applicationManager.level, 720/2-60, 15, 100, 141);
    scene.add(levelText);
    
    instructions1 = new HStaticText("Press 'space'", 0, 510-120, 160, 141);
    instructions2 = new HStaticText("to lock image", 0, 510-90, 160, 141);
    
    scene.add(instructions1);
    scene.add(instructions2);
    
    
    madeBy = new HStaticText("(c) Made by Dejitaru", 10, 510-40, 200, 141);
    scene.add(madeBy);
    
    
            Thread myt=new Thread(new StartGameThread(this));
       myt.start();
      
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
            System.out.println("Removing scene");
            scene.add(new HStaticText("Hallo",100,100,100,100));
            scene.repaint();
            scene.dispose();
            HSceneFactory.getInstance().dispose(scene);
            
    }

    public void userEventReceived(UserEvent e) {
        
        
        if (e.getCode()==HRcEvent.VK_SPACE && e.getType()==KeyEvent.KEY_RELEASED && running) {
            //als zowel het hoofd, het lichaam en de benen op dezelfde afbeelding staan
                if(huidigeHoofdAfbeelding == huidigeLichaamAfbeelding && huidigeLichaamAfbeelding == huidigeBenenAfbeelding) {
                    System.out.println("Gewonnen");
                    
                        //checken ofdat het aantal keer gewonnen kleiner is dan het levelnr, indien ja --> restart
                        if(applicationManager.completePeople >= levelnr) {
                            //timer stoppen
                            running = false;

                            //nextLevel button showen
                            nextLevel = new HTextButton("Gewonnen", 720/2-100, 450, 200, 100);
                            nextLevel.setBackground(new DVBColor(0, 255, 0, 127));
                            nextLevel.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            nextLevel.setActionCommand("nextLevelClick");
                            nextLevel.addHActionListener(this); //voeg HActionListener toe bij implements (boven)

                            applicationManager.timerTime = default_time;
                            timer = default_time;
                            
                            scene.add(nextLevel);
                            scene.repaint();


                            nextLevel.requestFocus();
                        }
                        else {
                            applicationManager.completePeople++;
                            System.out.println("kom ik hier 2x in??????");
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            try {
                                applicationManager.timerTime = timer;
                                applicationManager.restart();
                            } catch (XletStateChangeException ex) {
                                ex.printStackTrace();
                            }
                        }
                    
                    
                    
                }
        }
        
        
        if(timer != 0 && running) {
                
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

                scene.repaint();
            }
        }
    }

    public void actionPerformed(ActionEvent event) {
        
        
        if(event.getActionCommand().equals("tryAgainClick")) {
            tryAgain.setBackground(Color.GREEN);
            tryAgain.setBackgroundMode(HVisible.BACKGROUND_FILL);
            scene.repaint();
            scene.removeAll();
            timer = default_time;
            try {
                applicationManager.timerTime = default_time;
                applicationManager.restart();
            } catch (XletStateChangeException ex) {
                ex.printStackTrace();
            }
        }
        
        if(event.getActionCommand().equals("nextLevelClick")) {
            System.out.println("next level !!");
            applicationManager.level++;
            applicationManager.completePeople = 0;
            try {
                applicationManager.timerTime = default_time;
                applicationManager.restart();
            } catch (XletStateChangeException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
    //eigen functies
    public void startGame() {
        //
        //random startwaarden
      Random rnd = new Random();
      int randomSeed = rnd.nextInt(123456789-2222)+2222;
      rnd.setSeed(randomSeed);
       
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
      
      
      //timer
      startTime = System.currentTimeMillis();
      //running = true;
      //timer = 10;
      timerText = new HStaticText("Timer: " + timer, 720/2-60, 50, 100, 141);
      
      scene.add(timerText);
      
      
      
      
      System.out.println(running);
      
      
      scene.validate();
      scene.setVisible(true);
      UserEventRepository rep =new UserEventRepository("naam");
      rep.addAllArrowKeys();
      rep.addKey(HRcEvent.VK_SPACE);
      EventManager man=EventManager.getInstance();
      man.addUserEventListener(this, rep);
      
      while(running) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
          if(startTime + 1000 < System.currentTimeMillis()) {
            timer--;
            System.out.println(timer);
            timerText.setTextContent("Timer: " + timer, timerText.NORMAL_STATE);
            startTime = System.currentTimeMillis();
            
        }
        if(timer == 0) {
            timerText.setTextContent("Gameover!", timerText.NORMAL_STATE);
            
            tryAgain = new HTextButton("Try again", 720/2-100, 450, 200, 100);
            tryAgain.setBackground(new DVBColor(255, 0, 0, 127));
            tryAgain.setBackgroundMode(HVisible.BACKGROUND_FILL);
            tryAgain.setActionCommand("tryAgainClick");
            tryAgain.addHActionListener(this); //voeg HActionListener toe bij implements (boven)
            
            scene.add(tryAgain);
            
            scene.repaint();
            
            tryAgain.requestFocus();
            
            System.out.println("gameover");
            running = false;
        }
      }
      System.out.println("EINDE startgame()");
    }
    
    
}
