package Day01.Quiz02;

public class Tea extends Beverage {
    public static int amount;

    public static int getAmount() {
        return amount;
    }

    public static void setAmount(int amount) {
        Tea.amount = amount;
    }

    public Tea(String name) {
        super(name);
        amount++;
    }

    @Override
    public void calcPrice() {
        switch (getName()) {
            case "lemonTea":
                setPrice(1500);
                break;
            case "ginsengTea":
                setPrice(2000);
                break;
            case "redginsengTea":
                setPrice(2500);
                break;
            default:
                setPrice(0);
        }
    }
}