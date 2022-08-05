/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1.cui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author Callum
 * 
 * all files are loaded from ./resources
 */
public class IO {
    
    /**
     * load the user stats from stats.txt
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public String loadStats() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("./resources/stats.txt");
        
        String stats = "";
        int x = 0;
        while((x = fr.read()) != -1)
        {
            stats +=  (char) x;
            if ((char) x == ':')
                stats+= ' ';
        }
        
        stats += "\n\n";
        fr.close();
        
        return stats;
    }
    
    /**
     * load users from users.txt
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public HashMap<String, String> loadUsers() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("./resources/users.txt"));
        
        HashMap<String, String> userEmperor = new HashMap<String, String>();
        String line = "";
        
        while ((line = br.readLine()) != null) {
            //process the text for each line
            StringTokenizer st = new StringTokenizer(line, ",");
            userEmperor.put(st.nextToken(), st.nextToken());
        }
        br.close();
           
        return userEmperor;
    }
    
    /**
     * write the current games stats to stats.txt
     * @throws IOException 
     */
    public void writeStats() throws IOException {
        String stats  = loadStats();
        FileWriter fw = new FileWriter("./resources/stats.txt");
        
        StringTokenizer st = new StringTokenizer(stats, ":\r\n ");
        int numOfGames = 0;
        String lastGamePlayed = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        
        while (st.hasMoreTokens()) {
            for (int i = 0; i < 5;i++)
                st.nextToken();
            
            numOfGames = Integer.valueOf(st.nextToken());
            numOfGames++;
            
            lastGamePlayed = formatter.format(date);
            break;
        }
        
        fw.write("Total number of completed games:" + numOfGames);
        fw.write("\nLast game played was on:" + lastGamePlayed);
        fw.close();
    }
    
    /**
     * write the users information (name + emperor played) to users.txt
     * @param user
     * @param emperor
     * @throws IOException 
     */
    public void writeUsers(String user, String emperor) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("./resources/users.txt", true));
        HashMap<String, String> tempHM = loadUsers();
        
        for (HashMap.Entry<String, String> entry : tempHM.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();  
        }
        
        tempHM.put(user, emperor);   
        
        bw.append(user + "," + tempHM.get(user));
        bw.newLine();

        bw.close();
    }
    
    
    public int loadThisUser(String name) throws FileNotFoundException, IOException {
        HashMap<String, String> userEmperor = loadUsers();
        
        if (userEmperor.containsKey(name)) {
            switch (userEmperor.get(name)) {
                case "Brutus":
                    return 1;
                case "Greg":
                    return 2;
                case "Sha'aria":
                    return 3;
            }    
        }
        return 0;
    }
}
