package Task09_3;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class MathQuizGUI extends JFrame implements Observer {

    private JPanel userPanel = new JPanel();
    private JPanel calcPanel = new JPanel();
    private JLabel uName = new JLabel("Username: ");
    private JLabel pWord = new JLabel("Password: ");
    private JTextField unInput = new JTextField(10);
    private JTextField pwInput = new JTextField(10);
    private JLabel wrongName = new JLabel("Wrong username or password!");

    private JLabel firstNumber = new JLabel();
    private JLabel secondNumber = new JLabel();
    private JLabel additionLabel = new JLabel("+");
    private JButton nextButton = new JButton("Next");
    private JButton quitButton = new JButton("Quit");
    private JButton loginButton = new JButton("Log in");

    private JTextField calcSolution = new JTextField(10);

    public MathQuizGUI() {
        userPanel.add(uName);
        userPanel.add(unInput);
        userPanel.add(pWord);
        userPanel.add(pwInput);
        userPanel.add(loginButton);
        this.add(userPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.setLocation(100, 100);
        this.setVisible(true);
    }

    public void addController(MathQuizController controller) {
        System.out.println("View      : adding controller");
        //need a controller before adding it as a listener 
        getNextButton().addActionListener(controller);
        getQuitButton().addActionListener(controller);
        getLoginButton().addActionListener(controller);
    }

    private void startQuizGUI() {
        calcPanel.add(firstNumber);
        calcPanel.add(additionLabel);
        calcPanel.add(secondNumber);
        calcPanel.add(getCalcSolution());
        calcPanel.add(getNextButton());
        calcPanel.add(getQuitButton());
        this.getContentPane().removeAll();
        calcPanel.setVisible(true);
        this.add(calcPanel);
        this.revalidate();
        this.repaint();
    }

    public void newQuestionGUI(int num1, int num2, int answer) {
        firstNumber.setText(num1 + "");
        secondNumber.setText(num2 + "=");
        getCalcSolution().setText("");
        calcPanel.repaint();
    }

    void quitGameGUI(int score) {
        JPanel quitPanel = new JPanel();
        JLabel scoreLabel = new JLabel("Your score: " + score);
        quitPanel.add(scoreLabel);
        this.getContentPane().removeAll();
        //calcPanel.setVisible(true);
        this.add(quitPanel);
        this.revalidate();
        this.repaint();
    }

    /**
     * @return the nextButton
     */
    public JButton getNextButton() {
        return nextButton;
    }

    /**
     * @return the quitButton
     */
    public JButton getQuitButton() {
        return quitButton;
    }

    /**
     * @return the loginButton
     */
    public JButton getLoginButton() {
        return loginButton;
    }

    /**
     * @return the unInput
     */
    public JTextField getUnInput() {
        return unInput;
    }

    /**
     * @return the pwInput
     */
    public JTextField getPwInput() {
        return pwInput;
    }

    /**
     * @return the calcSolution
     */
    public JTextField getCalcSolution() {
        return calcSolution;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if (arg == "Start quiz") 
            startQuizGUI();
        else if (arg instanceof int[]) {
            int[] array = new int[3];
            System.arraycopy(arg, 0, array, 0, 3);
            newQuestionGUI(array[0], array[1], array[2]);
        }
        else if (arg == "Logged in")
            ;
        else if (arg instanceof Integer)
            quitGameGUI((int) arg);
        else
            System.out.println("??????? UPDATE ???????");
    }
}
