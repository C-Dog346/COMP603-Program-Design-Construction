package Task05_2;

public class Star implements Runnable{
    private final Image_ img;
    
    public Star(Image_ img) {
        this.img = img;
    }

    @Override
    public void run() {
        //Print stars
        for (int i = 0; i < 9; i++) {
            img.printStar(i);
        } 
    }
}
