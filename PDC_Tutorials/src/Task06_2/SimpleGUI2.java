package Task06_2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SimpleGUI2 extends JPanel {

    private final JLabel text;
    private final Image image;
    private final JTextField textField;
    private final JButton update;
    private final JPanel southPanel;
    private final JPanel northPanel;
    private final JComboBox font;
    private final JComboBox fontSize;
    private final JLabel fontText;
    private final JLabel fontSizeText;

    public SimpleGUI2() {
        this.northPanel = new JPanel(new GridLayout(1, 4));
        this.southPanel = new JPanel(new GridLayout(1, 2));
        this.fontText = new JLabel("Font: ");
        this.fontSizeText = new JLabel("Font Size: ");
        String[] fonts = {"Arial", "Courier New", "Calibri"};
        Integer[] fontSizes = {1,2,4,8,12,16,20,24};
        this.font = new JComboBox(fonts);
        this.fontSize = new JComboBox(fontSizes);
        this.text = new JLabel("Text will go here", SwingConstants.CENTER);
        this.textField = new JTextField(20);
        this.image = new ImageIcon("./resources/T06_bg.jpg").getImage();
        this.update = new JButton("Update");
        
        this.font.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               text.setFont(new Font((String) font.getSelectedItem(), Font.PLAIN, (Integer) fontSize.getSelectedItem()));
           }
        });
        this.fontSize.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               text.setFont(new Font((String) font.getSelectedItem(), Font.PLAIN, (Integer) fontSize.getSelectedItem()));
           }
        });
        this.update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(textField.getText());
            }
        });
        
        this.northPanel.add(fontText);
        this.northPanel.add(font);
        this.northPanel.add(fontSizeText);
        this.northPanel.add(fontSize);
        this.southPanel.add(this.textField);
        this.southPanel.add(this.update);
        super.setPreferredSize(new Dimension(400, 303));
        super.setLayout(new BorderLayout());
        super.add(this.northPanel, BorderLayout.NORTH);
        super.add(this.text, BorderLayout.CENTER);
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
        frame.getContentPane().add(new SimpleGUI2());
        frame.pack();
        frame.setLocation(600, 200);
        frame.setVisible(true);
        frame.setSize(400, 323);
    }

}
