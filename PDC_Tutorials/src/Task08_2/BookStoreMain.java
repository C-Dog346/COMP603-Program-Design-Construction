package Task08_2;

public class BookStoreMain {

    public static void main(String[] args) {

        BookStore bookstore = new BookStore();
        bookstore.connectBookStoreDB();
        bookstore.createPromotionTable();
        bookstore.createWeekSpecialTable(bookstore.getWeekSpecial());
    }
}
