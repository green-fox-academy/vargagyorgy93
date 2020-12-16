public class Aircraft {
private int ammunition =0;
private int baseDamage = 0;
private int maxAmmo= 0;
private int allDamage= 0;
private String type = "";

    public Aircraft(int baseDamage, int maxAmmo, String type) {
        this.baseDamage = baseDamage;
        this.maxAmmo = maxAmmo;
        this.type = type;
    }

    public Aircraft() {

    }


    public int getAllDamage() {
        return allDamage;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public int figt(){

        if (this.ammunition == 0){
            System.out.println("Cant fight before refill!");
            return 0;
        } else {
            int damage = baseDamage * ammunition;
            ammunition = 0;
//            System.out.println("Dealed damage: " + damage);
            this.allDamage += damage;
            return damage;
        }
    }

    public int refill(int number){

            if (maxAmmo - ammunition < number) {
                ammunition = maxAmmo;
//                System.out.println("Remaining refillable ammo after filling: " + (number - maxAmmo));
               return (number - maxAmmo);
            } else {
                ammunition += number;
//                System.out.println("No remaining ammos");
                return 0;
            }

    }

    public void getType(){
        System.out.println(this.type);
    }

    public String getStatus(){
        return this.getClass().getSimpleName() + ", " + "Ammo: " + this.ammunition + ", " + " Base Damage: " + this.baseDamage + ", " + "All Damage: " + allDamage;
    }

    public boolean isPriority(){
        if (this.type.equals("F35")){
//            System.out.println("True");
            return true;
        } else {
//            System.out.println("False");
            return false;
        }
    }




}
