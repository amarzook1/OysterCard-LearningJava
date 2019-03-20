//    In order to pay for my journey
//    As a customer
//    I need my fare deducted from my card


public class OysterCard {
    private Double money;
    private String customerName;
    private Double MAXIMUM_LIMIT = 90.0;

    public OysterCard(Double money, String customerName) {
        this.money = money;
        this.customerName = customerName;
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
            System.out.println("Unable to add " + amount + " to card as it hits the card limit of"
            + this.MAXIMUM_LIMIT);
            return;
        }
        this.money += amount;
    }

    public void deductMoneyFromCard

}
