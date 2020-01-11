package model;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Card {


    private final String cardNumber;
    private CardStatus status;
    private final Date activatedDate;
    private final Date expiryDate;
    private final double availableBalance;
    private final double actualBalance;

    public Card() {
        this.cardNumber = generateCardNumber();
        this.status = CardStatus.INACTIVE;
        this.activatedDate = new Date();
        this.expiryDate = addFiveYearsToDate(this.activatedDate);
        this.actualBalance = 0.0;
        this.availableBalance = 0.0;
    }

    private static String generateCardNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++) {
            sb.append(random.nextInt(9000)+1000);
        }
        return  sb.toString() ;
    }

    private Date addFiveYearsToDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 5);
        return calendar.getTime();
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

    public Date getExpiryDate() {
        return this.expiryDate;
    }
}
