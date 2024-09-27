package src;


public class Person {
    private String firstname;
    private String lastname;
    private int age;

    public Person () {

    }

    public Person(String personInfo){
            
        String[] parts = personInfo.split(" ");
        this.firstname = parts[0];
        this.lastname = parts[1];
        
        int startIndex = personInfo.indexOf('(') + 1;
        int endIndex = personInfo.indexOf(')');
        String ageString = personInfo.substring(startIndex, endIndex);
        this.age = Integer.parseInt(ageString);

    }

    public Person(String firstname, String lastname, int age){
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    //-------
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
