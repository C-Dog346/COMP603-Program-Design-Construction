package Task06_2;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;

public class BGPanel extends JPanel {

    public Image image;

    public BGPanel() {
        this.image = new ImageIcon("./resources/T06_bg.jpg").getImage();
    }

    /**
     * Draw the background of this panel.
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, null);
    }
}
