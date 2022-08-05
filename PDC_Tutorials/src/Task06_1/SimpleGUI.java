package Task06_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SimpleGUI extends JPanel {

    private final JLabel text;
    private final Image image;
    private final JTextField textField;
    private final JButton update;
    private final JPanel southPanel;

    public SimpleGUI() {
        this.southPanel = new JPanel(new GridLayout(1, 2));
        this.text = new JLabel("Text will go here", SwingConstants.CENTER);
        this.textField = new JTextField(20);
        this.image = new ImageIcon("./resources/T06_bg.jpg").getImage();
        this.update = new JButton("Update");

        this.update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(textField.getText());
            }
        });

        this.southPanel.add(this.textField);
        this.southPanel.add(this.update);
        super.setPreferredSize(new Dimension(400, 303));
        super.setLayout(new BorderLayout());
        super.add(this.text, BorderLayout.NORTH);
        super.add(this.southPanel, BorderLayout.SOUTH);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("-_-");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SimpleGUI());
        frame.pack();
        frame.setLocation(600, 200);
        frame.setVisible(true);
        frame.setSize(400, 323);
    }

}
