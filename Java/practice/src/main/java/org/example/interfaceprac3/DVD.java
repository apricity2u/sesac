package org.example.interfaceprac3;

public class DVD extends LibraryPhysicalItem {

    public DVD(String title, int resource_id, String location) {
        super(title, resource_id, location);
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
