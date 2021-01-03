package Pirate;

public class Pirate {
    String name = "";
    int amounOfGold = 10;
    int helathPoints = 10;
    boolean isCaptain = false;
    boolean hasWoodenLeg = false;

    public Pirate(String name, boolean isCaptain, boolean hasWooodenLeg) {
        this.name = name;
        this.isCaptain = isCaptain;
        this.hasWoodenLeg = hasWooodenLeg;
    }

    public void work(){
        if (this.isCaptain){
            this.amounOfGold += 10;
            this.helathPoints -= 5;
        } else {
            this.amounOfGold += 1;
            this.helathPoints -= 1;
        }
    }

    public void party(){
        if (this.isCaptain){
            this.helathPoints += 10;
        } else {
            this.helathPoints += 1;
        }
    }

    @Override
    public String toString(){
        if (this.hasWoodenLeg){
            return "Hello, I'm " + this.name + ". I have a wooden leg and " + this.amounOfGold + " golds.";
        } else {
            return "Hello, I'm " + this.name + ". I still have my real legs and " + this.amounOfGold + " golds.";
        }
    }


}
