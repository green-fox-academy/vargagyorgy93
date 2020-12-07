public class Sponsor extends Person{
    String company;
    int hiredStudents = 0;

    public void introduce (){
        System.out.println(commonIntroduce() + " who represents " + company + " "  + hiredStudents + " hired students");
    }

    public void hire(){
        hiredStudents++;
    }

    public void getGoal(){
        System.out.println("Hire brilliant junior software developers.");
    }

    public Sponsor(String name, int age, String gender,String company){
        super(name, age, gender);
        this.company = company;
    }

   public Sponsor(){
       new Person();
       this.company = "Google";
    }



}
