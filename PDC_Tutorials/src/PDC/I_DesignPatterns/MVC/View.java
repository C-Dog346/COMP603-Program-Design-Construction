/*
 * The programs are designed for PDC paper
 */
package Task09_3;

import java.awt.Label;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class View implements Observer {

    private JTextArea myJTextArea;
    private JButton button;

    //Components initialization
    public View() {
        System.out.println("View()");
        JFrame frame = new JFrame("simple MVC");
        frame.add("North", new Label("counter"));
        myJTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(myJTextArea);
        frame.add("Center", scrollPane);
        JPanel panel = new JPanel();
        button = new JButton("PressMe");
        panel.add(button);
        frame.add("South", panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocation(100, 100);
        frame.setVisible(true);
    }

    @Override
    public void update(Observable obs, Object obj) {
//        System.out.println("||" + obs);
//        System.out.println("--" + obj);
        myJTextArea.append(obj + "\n");
    }

    //What is the reason for NOT registering controllor in the constructor? 
    public void addController(Controller controller) {
        System.out.println("View      : adding controller");
        //need a controller before adding it as a listener 
        button.addActionListener(controller);
    }

}
