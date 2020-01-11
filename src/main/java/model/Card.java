package model;

import java.util.Random;

public class Card {
    private String cardNumber;
    private CardStatus status;

    public Card() {
        this.cardNumber = generateCardNumber();
        this.status = CardStatus.INACTIVE;
    }

    private static String generateCardNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++) {
            sb.append(random.nextInt(9000)+1000);
        }
        return  sb.toString() ;
    }

    public CardStatus getStatus() {
        return this.status;
    }

    public void setStatus(CardStatus status) {
        if (this.status == CardStatus.CLOSED)
            return;
        if((this.status == CardStatus.ACTIVE) && status == CardStatus.INACTIVE)
            return;
        this.status = status;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

}
