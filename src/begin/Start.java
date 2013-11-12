package begin;

/*
 * Jacob Stanley, 2013
 * Kudos and respect must go to Trysten for his Java Roguelike tutorial which got me started on this.
 * http://trystans.blogspot.co.uk/2011/08/roguelike-tutorial-01-java-eclipse.html
 */

import javax.swing.JFrame;

public class Start {

    public static void main(String[] args) {
        Game game = new Game();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }

}
