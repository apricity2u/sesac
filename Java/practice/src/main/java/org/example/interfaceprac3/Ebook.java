package org.example.interfaceprac3;

public class Ebook extends LibraryResource implements Downloadable {

    private boolean isDownloadable;

    public Ebook(String title, int resource_id) {
        super(title, resource_id);
        this.isDownloadable = false;
    }

    @Override
    public void borrowResource() {
        if (isBorrowed()) {
            System.out.println(title + " has already been borrowed.");
            return;
        }

        isBorrowed = true;
        isDownloadable = true;
        System.out.println(title + " is borrowed successfully!");
    }

    @Override
    public void returnResource() {
        if (!isBorrowed()) {
            return;
        }

        isBorrowed = false;
        isDownloadable = false;
        System.out.println(title + " is returned successfully!");
    }

    @Override
    public boolean isBorrowed() {
        return isBorrowed;
    }

    @Override
    public void download() {
        if (!isDownloadable()) {
            System.out.println("Please borrow " + title + " first.");
            return;
        }

        System.out.println("...Download " + title);
    }

    @Override
    public boolean isDownloadable() {
        return isDownloadable;
    }
}
