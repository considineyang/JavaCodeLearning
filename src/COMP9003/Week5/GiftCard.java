package COMP9003.Week5;

public class GiftCard {
    private double amount;

    public GiftCard(double a){

        this.amount = a;

    }

    public void buyBook(double a){

        if(amount >= a){

            amount = amount -a;

            System.out.println("Books bought successfully");

        }else{

            System.out.println("Not enough money in the card");

        }

    }

    public double amountRemaining(){

        return amount;

    }
}
