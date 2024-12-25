package org.example;

public enum PaymentType {

    CASH {
        @Override
        public void alert() {
            System.out.println("You need more money to buy it. - cash");
        }
    },
    CARD {
        @Override
        public void alert() {
            System.out.println("You don't have enough balance. - card");
        }
    };

    public abstract void alert();

}
