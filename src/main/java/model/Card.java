package model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static model.CardStatus.*;
@Entity
@Table(name="CARDS")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name="card-seq-gen",
            sequenceName = "CARD_SEQ_GEN",
            allocationSize=500
    )
    private Integer Id;

    @Column(name="card_number",unique = true)
    private final String cardNumber;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @Column(name="created_date")
    private final Date createdDate;

    @Column(name="expiry_date")
    private final Date expiryDate;

    @Column(name="available_balance")
    private double availableBalance;

    @Column(name="actual_balance")
    private double actualBalance;

    @Column(name="activated_date")
    private Date activatedDate;

    @Column(name="primary_secondary_indicator")
    private boolean primarySecondaryIndicator;



    public Card() {
        this.cardNumber = generateCardNumber();
        this.status = INACTIVE;
        this.createdDate = new Date();
        this.expiryDate = addFiveYearsToDate(this.createdDate);
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

    public void setStatus(CardStatus status) throws Exception {
        if (this.status == CLOSED)
            throw new Exception("An closed card cannot be made active");
        if((this.status == ACTIVE) && status == INACTIVE)
            throw new Exception("An active card cannot be made inactive");
        if(status == ACTIVE)
           this.activatedDate = new Date();
        this.status = status;
    }

    public void setPrimarySecondaryIndicator(boolean primarySecondaryIndicator) {
        this.primarySecondaryIndicator = primarySecondaryIndicator;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public void setActualBalance(double actualBalance) {
        this.actualBalance = actualBalance;
    }

    public CardStatus getStatus() {
        return this.status;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public Date getExpiryDate() {
        return this.expiryDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public double getActualBalance() {
        return actualBalance;
    }

    public Date getActivatedDate() {
        return activatedDate;
    }

    public boolean getPrimarySecondaryIndicator() {
        return primarySecondaryIndicator;
    }

    public Integer getId() {
        return this.Id;
    }
}
