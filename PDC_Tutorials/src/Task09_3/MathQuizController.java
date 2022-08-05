/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task09_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Callum
 */
public class MathQuizController implements ActionListener {

    MathQuizModel model;
    MathQuizGUI view;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (view.getNextButton() == source) {
            model.next(view.getCalcSolution());
        }
        else if (view.getQuitButton() == source) {
            model.quit(view.getCalcSolution());
        }
        else if (view.getLoginButton() == source){
            model.login(view.getUnInput(), view.getPwInput());
        }
        else
            System.out.println("??????? ACTIONPERFORMED ???????");
        
       
    }
    
    public void addModel(MathQuizModel m) {
        System.out.println("Controller: adding model");
        this.model = m;
    }

    public void addView(MathQuizGUI v) {
        System.out.println("Controller: adding view");
        this.view = v;
    }
    
    public void initModel() {
        this.model.dbsetup();
    }
}
