package org.example.interfaceprac3;

public class Book extends LibraryPhysicalItem{

    public Book(String title, int ID, String location) {
        super(title, ID, location);
}

    @Override
    public void borrowResource() {
        if (isBorrowed()) {
            System.out.println(title + " has already been borrowed.");
            return;
        }

        isBorrowed = true;
        System.out.println(title + " is borrowed successfully!");
    }

    @Override
    public void returnResource() {
        if (!isBorrowed()) {
            return;
        }

        isBorrowed = false;
        System.out.println(title + " is returned successfully!");
    }

    @Override
    public boolean isBorrowed() {
        return isBorrowed;
    }

}
