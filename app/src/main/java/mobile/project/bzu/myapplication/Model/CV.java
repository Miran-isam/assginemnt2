package mobile.project.bzu.myapplication.Model;

public class CV {
    private String Name;
    private String Email;
    private Integer Age;
    private int phone;
    private String Hobbies;
    private String Education;
    private String Work;
    private String Languge;
    private String Gender;




    public CV(String name, String email, int age, int phone, String hobbies,String education, String work, String languge,String gender) {
        Name = name;
        Email = email;
        Age = age;
        this.phone = phone;
        Hobbies = hobbies;
        Education = education;
        Work = work;
        Languge = languge;
      Gender=gender;
    }
    public CV(){

    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getHobbies() {
        return Hobbies;
    }

    public void setHobbies(String hobbies) {
        Hobbies = hobbies;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getWork() {
        return Work;
    }

    public void setWork(String work) {
        Work = work;
    }

    public String getLanguge() {
        return Languge;
    }

    public void setLanguge(String languge) {
        Languge = languge;
    }

    @Override
    public String toString() {
        return "CV{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Age=" + Age +
                ", phone=" + phone +
                ", Hobbies='" + Hobbies + '\'' +
                ", Education='" + Education + '\'' +
                ", Work='" + Work + '\'' +
                ", Languge='" + Languge + '\'' +
                '}';
    }
}
