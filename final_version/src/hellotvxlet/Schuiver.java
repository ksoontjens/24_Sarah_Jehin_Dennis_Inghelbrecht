/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import org.havi.ui.HComponent;
import org.havi.ui.HContainer;

/**
 *
 * @author student
 */
public class Schuiver extends HContainer implements LichaamsdeelObserver {

    final int breedte=137; //was oorspronkelijk 500 //hoeveel van de schuiver er zichtbaar is
    int hoogte=100;
    int offsetx=-300;
    int actievepos=000;
    
    public Schuiver (int x,int y){
        super(x,y,500,100);
        this.setSize(breedte,hoogte);
        this.setBackground(Color.BLACK);
       
        
    }
    
    public void schuif(int index)
    {
       int x=getXpos(index);
       offsetx=-x+actievepos;
       updateall();
    }
    
    
    public void voegtoe(String s)
    {
        this.add(new Lichaamsdeel(s,0,0,this));
    }
    
    public void voegtoetot(String s, int tot)
    {
        for (int i=1;i<=tot;i++)
        {
            voegtoe(s+String.valueOf(i)+".png");
        }
    }
    
    public int getXpos(int index)
    {
        int x=0;
        for (int i=0;i<index;i++)
        {  
                    x+=this.getComponent(i).getWidth();       
        }
        return x;
    }
    
    public void update(Lichaamsdeel c) {
        this.add(c);
        if (c.getHeight()>hoogte) hoogte=c.getHeight();
        this.setSize(breedte,hoogte);
        int nextX=0;
        for (int i=0;i<this.getComponentCount();i++)
        {
            if (this.getComponent(i)!=c)
            {
                    nextX+=this.getComponent(i).getWidth();
                    //System.out.println("nextX="+nextX);
            }
            else
            {
                    c.setLocation(nextX+offsetx, 0);
            }
        }
    }
    
        public void updateall() {
      
       
        this.setSize(breedte,hoogte);
        int nextX=0;
        for (int i=0;i<this.getComponentCount();i++)
        {
            HComponent c=(HComponent)this.getComponent(i);
            {
                    c.setLocation(nextX+offsetx, 0);
                    nextX+=this.getComponent(i).getWidth();
                    //System.out.println("nextX="+nextX);
            }

        }
    }
}
