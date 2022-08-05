package Task09_3;

/*
 * The programs are designed for PDC paper
 */



public class RunMVC {

    private int start_value = 10;

    public static void main(String[] args) {
        RunMVC mainRunMVC = new RunMVC();
    }

    public RunMVC() {
        Model myModel = new Model();
        View myView = new View();
        myModel.addObserver(myView);
        
        Controller myController = new Controller();
        //pass the reference of model and view to the controllor
        myController.addModel(myModel);
        myController.addView(myView);
        myController.initModel(start_value);
        myView.addController(myController);
    }
}
