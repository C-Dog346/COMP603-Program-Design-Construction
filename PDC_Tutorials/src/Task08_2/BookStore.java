package Task08_2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookStore {

    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;

    public BookStore() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }

    public void connectBookStoreDB() {
        //use the conn, initialize database by creating BOOK Table and insert records
        try {
            statement = conn.createStatement();
            String sqlCreateTable = "CREATE  TABLE BOOK  (BOOKID  INT,   TITLE "
                    + "  VARCHAR(50),   CATEGORY   VARCHAR(20),   PRICE   FLOAT)";
            String sqlInsertValues = "INSERT INTO BOOK VALUES (1, 'Slum Dog Millionaire', 'Fiction', 19.90),\n" +
                    "(2, 'Run Mummy Run', 'Fiction', 28.00),\n" +
                    "(3, 'The Land of Painted Caves', 'Fiction', 15.40),\n" +
                    "(4, 'Cook with Jamie', 'Non-fiction', 55.20),\n" +
                    "(5, 'Far Eastern Odyssey', 'Non-fiction', 24.90),\n" +
                    "(6, 'Open', 'Non-fiction', 33.60),\n" +
                    "(7, 'Big Java', 'Textbook', 55.00),\n" +
                    "(8, 'Financial Accounting', 'Textbook', 24.80)";
            
            statement.executeUpdate(sqlCreateTable);
            statement.executeUpdate(sqlInsertValues);
        }
        catch (SQLException ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
        }
    }

    public void createPromotionTable() {
        /*You may need the following SQL statements for this method:

         * Create the table:
           CREATE TABLE PROMOTION (CATEGORY VARCHAR(20), DISCOUNT INT);

         * Insert records into the table: 
           INSERT INTO PROMOTION VALUES ('Fiction', 0),
           ('Non-fiction', 10),
           ('Textbook', 20);

         */
        try {
            statement = conn.createStatement();
            String newTable = "PROMOTION";
            
            DatabaseMetaData databaseMetadata = dbManager.getConnection().getMetaData();
            ResultSet resultSet = databaseMetadata.getTables(null, null, newTable, null);
            if (resultSet.next()) {
               System.out.println("TABLE ALREADY EXISTS");
            } 
            else {
                String sqlCreateTable = "CREATE TABLE " + newTable + " (CATEGORY VARCHAR(20), DISCOUNT INT)";
                statement.executeUpdate(sqlCreateTable);
                String sqlInsertRecords = "INSERT INTO PROMOTION VALUES ('Fiction', 0),\n" +
    "           ('Non-fiction', 10),\n" +
    "           ('Textbook', 20)";           
                statement.executeUpdate(sqlInsertRecords);
            }
            
            
        }
        catch (SQLException ex) {
            System.err.println("SQLException: "+ex.getMessage());
        }
    }

    public ResultSet getWeekSpecial() {
        /* You may need the following SQL statements for this method:

        * Query multiple tables:
        
          SELECT TITLE, PRICE, DISCOUNT FROM BOOK, PROMOTION WHERE BOOK.CATEGORY=PROMOTION.CATEGORY;

         */
        ResultSet rs = null;
        
        try {
            rs = statement.executeQuery("SELECT TITLE, PRICE, DISCOUNT FROM BOOK, PROMOTION WHERE BOOK.CATEGORY=PROMOTION.CATEGORY");
        }
        catch (SQLException ex) {
            System.err.println("SQLException: "+ex.getMessage());
        }

        return (rs);

    }

    public void createWeekSpecialTable(ResultSet rs) {
        try {
            statement = conn.createStatement();
            String newTable = "WEEK_SPECIAL";
            DatabaseMetaData databaseMetadata = dbManager.getConnection().getMetaData();
            ResultSet resultSet = databaseMetadata.getTables(null, null, newTable, null);
            if (resultSet.next()) {
               System.out.println("TABLE ALREADY EXISTS");
            } 
            else {
                try {
                    String sqlCreateTable = "CREATE TABLE " + newTable + " (TITLE VARCHAR(50), SPECIAL_PRICE INT)";
                    statement.executeUpdate(sqlCreateTable);
                }
                catch (SQLException ex) {
                    System.err.println("SQL Exception: " + ex.getMessage());
                }
            }     
        }
        catch (SQLException ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
        }

        try {
            int specialPrice = 0;       
            while (rs.next()) {
                String title = rs.getString("TITLE");
                int price = rs.getInt("PRICE");
                int discount = rs.getInt("DISCOUNT");

                specialPrice = price*(100-discount)/100;
                String sqlInsertRecords = "INSERT INTO WEEK_SPECIAL VALUES ('" + title +"', " + specialPrice + ")";
                statement.addBatch(sqlInsertRecords);
            }
            
            statement.executeBatch();
            //this.getNextException();
            rs.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(BookStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getNextException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
