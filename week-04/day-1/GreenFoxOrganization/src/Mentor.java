public class Mentor extends Person {

    String level = "intermediat";

    public void getGoal (){
        System.out.println("Educate brilliant junior software developers.");
    }

    public void introduce(){
        System.out.println(commonIntroduce() + " " + level + " mentor");
    }

    public Mentor(String name, int age, String gender, String level){
        super(name, age, gender);
        this.level = level;
    }

    public Mentor(){

    }



}
