package Task09_3;

public class QuizMain {
    
    public static void main(String[] args) {
        MathQuizModel model = new MathQuizModel();
        MathQuizGUI view = new MathQuizGUI();
        model.addObserver(view);       
        
        MathQuizController controller = new MathQuizController();
        controller.addModel(model);
        controller.addView(view);
        controller.initModel();
        view.addController(controller);
    }
}
