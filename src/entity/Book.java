package entity;

public class Book {
    private String bookName;//图书名
    private String authorName;//图书作者
    private double price;//价格
    private int inventory;//库存
    public Book(){}

    public Book(String bookName, String authorName, double price, int inventory) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
        this.inventory = inventory;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
