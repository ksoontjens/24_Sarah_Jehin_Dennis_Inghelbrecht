/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */
public class StartGameThread implements Runnable {

    
       ShuffleXlet sx;
    public StartGameThread(ShuffleXlet callback)
    {
        sx=callback;
    }
    
    public void run() {
       sx.startGame();
    }

}
