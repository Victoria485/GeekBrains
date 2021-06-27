package Homework6;
public class Animal
{
    protected String name;
    protected int maxRun;
    protected int maxSwim;
    static int counterAnimal;
    public Animal(String name)
    {
        this.name = name;
        counterAnimal++;
    }
    public boolean run(int length)
    {
        if (length > maxRun)
        {
            System.out.printf("%s не может пробежать %d м\n", this.name, length);
            return false;
        }
        else
        {
            System.out.printf("%s пробежал %d м\n", this.name, length);
            return true;
        }
    }
    public boolean swim(int length)
    {
        if (length > maxSwim)
        {
            System.out.printf("%s не может проплыть %d м\n", this.name, length);
            return false;
        }
        else
        {
            System.out.printf("%s проплыл %d м\n", this.name, length);
            return true;
        }
    }
    public String getName()
    {
        return name;
    }
}