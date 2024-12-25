package org.example;

public enum PaymentType {

    CASH {
        @Override
        public void alert() {
            System.out.println("Please insert more money.");
        }
    },
    CARD {
        @Override
        public void alert() {
            System.out.println("You don't have enough balance.");
        }
    };

    public abstract void alert();

}
