package Day01.Quiz02;

public class Coffee extends Beverage {
    public static int amount;

    public static int getAmount() {
        return amount;
    }

    public static void setAmount(int amount) {
        Coffee.amount = amount;
    }

    public Coffee(String name) {
        super(name);
        amount++;
    }

    @Override
    public void calcPrice() {
        switch (getName()) {
            case "Americano":
                setPrice(1500);
                break;
            case "CafeLatte":
                setPrice(2500);
                break;
            case "Cappuccino":
                setPrice(3000);
                break;
            default:
                setPrice(0);
        }
    }
}