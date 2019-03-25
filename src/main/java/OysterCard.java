import java.util.ArrayList;

public class OysterCard {
    private Double money;
    private String customerName;
    private Double MAXIMUM_LIMIT = 90.0;
    private boolean inJourney = false;
    private ArrayList<String> entryStation = new ArrayList<>();
    private ArrayList<String> exitStation = new ArrayList<>();

    public OysterCard(Double money, String customerName) {
        this.money = money;
        this.customerName = customerName;
    }

    public ArrayList<String> getExitStation() {
        return exitStation;
    }

    public ArrayList<String> getEntryStation() {
        return entryStation;
    }

    public Double getMoney() {
        return money;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void addMoneyToCard(Double amount){
        if(amount <= (Double) 0.0) {
            System.out.println(amount + " is an invalid amount");
            return;
        }
        if(this.money + amount > 90){
            System.out.println("Unable to add £" + amount + " to card as it hits the card limit of"
            + this.MAXIMUM_LIMIT);
            return;
        }
        this.money += amount;
    }

    private void deductMoneyFromCard(Double amount) {
        if(amount <= (Double) 0.0){
            System.out.println(amount + " is an invalid amount");
            return;
        }
        if(this.money - amount < 0) {
            System.out.println("Unable to deduct £" + amount + " due to not having enough in your card balance");
            return;
        }
        this.money -= amount;
    }

    public boolean touchIn() {
        if(this.inJourney){
            System.out.println("You are unable to touch in already in journey");
            return false;
        }
        if(this.money - 1.0 < 0){
            System.out.println("You are unable to travel due to not having enough balance");
            return false;
        }
        return this.inJourney = true;
    }

    public boolean touchOut(){
        if(!inJourney){
            System.out.println("You are not traveling you cant touch out");
            return true;
        }
        deductMoneyFromCard(1.0);
        return this.inJourney = false;
    }

    public boolean isInJourney() {
        return inJourney;
    }
}
