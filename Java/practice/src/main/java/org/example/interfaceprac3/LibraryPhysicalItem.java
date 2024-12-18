package org.example.interfaceprac3;

public abstract class LibraryPhysicalItem extends LibraryResource{

    protected String location;

    public LibraryPhysicalItem(String title, int ID, String location) {
        super(title, ID);
        this.location = location;
    }

    public void getLocation() {
        System.out.println(title + " " + location);
    }
}
