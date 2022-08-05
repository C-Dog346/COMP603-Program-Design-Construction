package Task08_3;

public class BookStoreMainEdb {

    public static void main(String[] args) {

        BookStoreEdb bookstore = new BookStoreEdb();
        bookstore.connectBookStoreDB();
        bookstore.createPromotionTable();
        bookstore.createWeekSpecialTable(bookstore.getWeekSpecial());
    }
}
