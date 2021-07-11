package Homework1;
public class Human implements Running, Jumping
{
    private String name;
    private int maxRun;
    private int maxJump;
    Human(String name, int maxRun, int maxJump)
    {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public int getMaxRun()
    {
        return maxRun;
    }
    @Override
    public int getMaxJump()
    {
        return maxJump;
    }
}