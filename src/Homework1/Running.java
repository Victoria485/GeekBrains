package Homework1;
public interface Running
{
    String getName();
    int getMaxRun();
    default boolean run(String name, int maxRun, int length)
    {
        if (length > maxRun)
        {
            System.out.printf("%s не может пробежать %d м\n", name, length);
            return false;
        }
        else
        {
            System.out.printf("%s пробежал %d м\n", name, length);
            return true;
        }
    }
}