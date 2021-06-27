package Homework6;
public class Dog extends Animal
{
    static int counterDog;
    public Dog(String name)
    {
        super(name);
        maxRun = 500;
        maxSwim = 10;
        counterDog++;
    }
}