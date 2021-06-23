package Homework5;
import java.time.Year;
public class Employee
{
    private String name;
    private String post;
    private String email;
    private String telephone;
    private int salary;
    private int birthYear;
    public Employee(String name, String post, String email, String telephone, int salary, int age)
    {
        this.name = name;
        this.post =  post;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.birthYear = Year.now().getValue() - age;
    }
    public int getAge()
    {
        return Year.now().getValue() - this.birthYear;
    }
    public void printInfo()
    {
        System.out.printf("Employee: name - %s, post - %s, email - %s, telephone - %s, salary - %d, age - %d\n", this.name, this.post, this.email, this.telephone, this.salary, getAge());
    }
}