package Task05_2;

public class Space implements Runnable{
    private final Image_ img;
    
    public Space(Image_ img) {
        this.img = img;
    }
    
    @Override
    public void run() {
        //Print spaces
        for (int i = 9; i > 0; i--) {
            img.printSpace(i);
        } 
    }
}
