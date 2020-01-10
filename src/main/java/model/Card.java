package model;

public class Card {
    private CardStatus status = CardStatus.INACTIVE;

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
}
