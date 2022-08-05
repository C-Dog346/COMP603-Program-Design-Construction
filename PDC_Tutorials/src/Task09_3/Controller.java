/*
 * The programs are designed for PDC paper
 */

package Task09_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Controller implements ActionListener {

    Model model;
    View view;

    //invoked when a button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Controller: acting on Model");
        model.incrementValue();
    }

    public void addModel(Model m) {
        System.out.println("Controller: adding model");
        this.model = m;
    }

    public void addView(View v) {
        System.out.println("Controller: adding view");
        this.view = v;
    }

    public void initModel(int x) {
        model.setValue(x);
    }
}
