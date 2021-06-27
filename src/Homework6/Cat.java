package Homework6;
public class Cat extends Animal
{
    static int counterCat;
    public Cat(String name)
    {
        super(name);
        maxRun = 200;
        maxSwim = 0;
        counterCat++;
    }
}