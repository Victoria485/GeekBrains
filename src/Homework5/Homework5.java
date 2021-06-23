package Homework5;
public class Homework5
{
    public static void main(String[] args)
    {
        Employee[] employees =
        {
                new Employee("Ivanov0 Ivan0", "Engineer0", "ivivan0@mailbox.com", "892312310", 30000,20),
                new Employee("Ivanov1 Ivan1", "Engineer1", "ivivan1@mailbox.com", "892312311", 30001,30),
                new Employee("Ivanov2 Ivan2", "Engineer2", "ivivan2@mailbox.com", "892312312", 30002,40),
                new Employee("Ivanov3 Ivan3", "Engineer3", "ivivan3@mailbox.com", "892312313", 30003,50),
                new Employee("Ivanov4 Ivan4", "Engineer4", "ivivan4@mailbox.com", "892312314", 30004,60),
        };
        for (int i = 0; i < employees.length; i++)
        {
            if (employees[i].getAge() > 40)
                employees[i].printInfo();
        }
    }
}