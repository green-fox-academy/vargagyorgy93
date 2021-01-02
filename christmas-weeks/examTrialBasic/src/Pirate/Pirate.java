package Pirate;

public class Pirate {
    String name = "";
    int amounOfGold = 10;
    int helathPoints = 10;
    boolean isCaptain = false;
    boolean hasWooodenLeg = false;

    public Pirate(String name, boolean isCaptain, boolean hasWooodenLeg) {
        this.name = name;
        this.isCaptain = isCaptain;
        this.hasWooodenLeg = hasWooodenLeg;
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

    public String toString(){
        if (this.hasWooodenLeg){
            return "Hello, I'm " + this.name + ". I have a wooden leg and " + amounOfGold + " golds.";
        } else {
            return "Hello, I'm " + this.name + ". I still have my real legs and " + amounOfGold + " golds.";
        }
    }


}
