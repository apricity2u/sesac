package org.example.interfaceprac3;

public abstract class LibraryResource implements Borrowable {
// 추상 클래스여서 인터페이스를 무조건 만들지 않아도 되고, 구현하는 클래스가 만들 것.

    protected String title;
    protected int ID;
    protected boolean isBorrowed;

    public LibraryResource(String title, int ID){
        this.title = title;
        this.ID = ID;
        this.isBorrowed = false;
    }

    // 인터페이스로 빼기
//    public abstract void borrowResource();
//    public abstract void returnResource();

    public void getStatus(){
        System.out.println("title: " + title + " id: " + ID + " isBorrowed: " + isBorrowed);
    }

}
