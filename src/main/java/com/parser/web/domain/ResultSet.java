package main.java.com.parser.web.domain;

import java.util.List;

public class ResultSet {

    private List<Book> bookPage;
    private int totalBooks;

    public List<Book> getBookPage() {
        return bookPage;
    }

    public void setBookPage(List<Book> bookPage) {
        this.bookPage = bookPage;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

}
