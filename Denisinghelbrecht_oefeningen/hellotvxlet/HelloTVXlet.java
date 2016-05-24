package hellotvxlet;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;


public class HelloTVXlet implements Xlet
{

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        Observer ob1=new Observer();
        Observer ob2=new Observer();
        Observer ob3=new Observer();
        Subject sub=new Subject();
        sub.register(ob1); sub.register(ob2); sub.register(ob3);
        sub.update_observers(23);
        
    }

    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
    }
    
    
}