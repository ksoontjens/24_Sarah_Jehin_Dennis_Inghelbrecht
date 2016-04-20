/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HIcon;
import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class Lichaamsdeel extends HIcon {

    Image img;
    
    public Lichaamsdeel(String naam,int x, int y, LichaamsdeelObserver ob)
    {
        super();
        img=this.getToolkit().getImage(naam);
        MediaTracker mt=new MediaTracker(this);
        mt.addImage(img,1);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.setLocation(x, y);
        
        this.setSize(img.getWidth(this), img.getHeight(this));
        this.setGraphicContent(img, HVisible.NORMAL_STATE);
        ob.update(this);
    }
}
