package COMP9003.Week5;

public class TestClass {
    public static void main(String[] args) {
        GiftCard g = new GiftCard(100);
        g.buyBook(50.5);
        g.buyBook(40.5);
        g.buyBook(60);

        System.out.println("Remaining balance: "+g.amountRemaining());
    }
}
