package animalprotection;

public class animal {
    String ownerName = "";
    boolean isHealthy = true;
    int healCost = 0;

//    public animal(String ownerName, boolean isHealthy, int healCost) {
//        this.ownerName = ownerName;
//        this.isHealthy = isHealthy;
//        this.healCost = healCost;
//    }

    public void heal(){
        this.isHealthy = true;
    }

    public boolean isAdoptable(){
        return isHealthy;
    }

    public String toString(){
        if (this.isHealthy){
            return animal.class.getSimpleName() + " is helathy and adoptable";
        } else {
            return animal.class.getSimpleName() + " is not healthy " + healCost + "€" + ", and adoptable";
        }
    }
}
