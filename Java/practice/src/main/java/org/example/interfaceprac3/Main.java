package org.example.interfaceprac3;

public class Main {
    public static void main(String[] args) {

        Ebook ebook1 = new Ebook("ebook1", 1);
        Book book1 = new Book("book1", 2, "abcd");
        DVD dvd1 = new DVD("dvd1", 3, "1234");

        ebook1.borrowResource();
        book1.borrowResource();
        dvd1.borrowResource();

        ebook1.download();
        ebook1.getStatus();

        dvd1.returnResource();
        dvd1.getLocation();
        dvd1.getStatus();

    }
}
