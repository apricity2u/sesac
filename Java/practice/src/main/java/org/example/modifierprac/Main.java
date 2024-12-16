package org.example.modifierprac;

public class Main {
    public static void main(String[] args) {

        //- Main 클래스에서 Person 객체를 생성하고 각 변수와 메서드에 접근해보시오.
        Person person1 = new Person("beemo", 18, 183.7);

        // 1.
        // private name 오류나는 코드
        // System.out.println(person1.name);
        System.out.println(person1.getName());
        person1.setName("ken");
        System.out.println(person1.getName());

        // private run
        // person1.run(); 오류나는 코드
        person1.publicRun();

        // 2.
        // public age
        System.out.println(person1.age);

        // public walk
        person1.walk();

        // 3.
        // default height
        System.out.println(person1.height);

        // default study
        person1.study();

        System.out.println();
        //

        // 계좌 생성
        BankAccount account = new BankAccount("1234"); // 생성되면 Your account is available.

        // 입금
        account.deposit(1000);
        account.deposit(5700);
        account.deposit(-800); // 음수 입력하면 Please enter more than 1won.

        // 출금
        account.withdraw(1000, "1234"); // 비밀번호 일치 + 잔액 O : 출금 가능
        account.withdraw(1700, "1234");
        account.withdraw(10000, "1234"); // 비밀번호 일치 + 잔액 X : 출금 불가 (잔액 없음 메세지)
        account.withdraw(1700, "123"); // 비밀번호 불일치 : 출금 불가 (비밀번호 불일치 메세지)
        account.withdraw(-800, "1234"); // 음수 입력하면 Please enter more than 1won.

        // 잔액 조회하기
        account.getBalance("1234"); // 비밀번호가 같으면 잔액 조회 가능
        account.getBalance("123");  // 비밀번호가 다르면 잔액 조회 불가

        // 비밀번호 유효성 검사
        String myPassword = "abc";
        if (!BankAccount.validateInitialPassword(myPassword)) {
            System.out.println("failed");
            // return;
        }else {

            // else 없이 하는게 자연스러움
            BankAccount account1 = new BankAccount(myPassword);
        }

    }
}
