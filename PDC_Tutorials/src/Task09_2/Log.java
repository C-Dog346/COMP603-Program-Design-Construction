package Task09_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {

    BufferedWriter bufWriter;
    public static int instanceNumber = 0;
    private static Log log;
    
    private Log(String str) {
        try {
            this.bufWriter = new BufferedWriter(new FileWriter("./resources/T09_log.txt", true));

            System.out.println("writting log");
            bufWriter.write(str);
            bufWriter.flush();

        } catch (IOException e) {
        }
        instanceNumber++;
        System.out.println("A log instance has been created");
    }
    
    public static synchronized Log getSystemLogInstance(String str) {
        if (log == null) 
            log = new Log(str);
        
        return log;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Can only have one instance of a Log");
    }
}