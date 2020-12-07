public class Student extends Person {

    String previousOrganization = "The School of Life";
    int skippedDays = 0;

    public void getGoal (){
        System.out.println("Be a junior software developer.");
    }

    public void introduce (){
        System.out.println(commonIntroduce() + " from " + previousOrganization + " who skipped " + skippedDays + " days from the course already.");
    }


    public void skipDays (int numberOfDays){
        skippedDays += numberOfDays;
    }

    public Student(String name, int age, String gender, String previousOrganization) {
        super(name, age, gender);
        this.previousOrganization = previousOrganization;

    }

    public Student (){

    }

}
