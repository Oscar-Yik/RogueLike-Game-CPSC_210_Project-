package ui;

import javax.swing.*;
import java.awt.*;

import static ui.Game.GAME_WIDTH;
import static ui.Game.GAME_HEIGHT;

/*
 * Represents the panel whee images are drawn
 */
public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private Game game;

    /*
     * EFFECTS: constructs a new game panel with keyboard and mouse inputs
     */
    public GamePanel(Game game) {
        mouseInputs = new MouseInputs(this);
        this.game = game;
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        //System.out.println("Keyboard Connected");
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    /*
     * MODIFIES: this
     * EFFECTS: sets game panel to a certain size
     */
    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH,GAME_HEIGHT);
        setPreferredSize(size);
        //System.out.println("size: " + GAME_WIDTH + " : " + GAME_HEIGHT);
    }

    /*
     * EFFECTS: draws the game on the panel
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        game.render(g);
        //Lightning Image
        //g.drawImage(img0.getSubimage(0,300,250,200), 0,0, 250, 200,null);
        //g.drawImage(img0.getSubimage(360,300,250,200), 0,0, 250, 200,null);
        //g.drawImage(img0.getSubimage(720,300,250,200), 0,0, 250, 200,null);
    }

    public Game getGame() {
        return this.game;
    }
}
