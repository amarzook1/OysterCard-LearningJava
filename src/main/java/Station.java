public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public void touchIn(OysterCard oysterCard) {
        if(oysterCard.touchIn()){
            oysterCard.getEntryStation().add(this.name);
            System.out.println("Your journey begins in " + this.name);
        }
    }

    public void touchOut(OysterCard oysterCard) {
        if(!oysterCard.touchOut()){
            oysterCard.getExitStation().add(this.name);
            System.out.println("Your journey ends in " + this.name);
        }
    }

    public String getName() {
        return name;
    }
}
