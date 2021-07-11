package Homework1;
public interface Jumping
{
    String getName();
    int getMaxJump();
    default boolean jump(String name, int maxJump, int length)
    {
        if (length > maxJump)
        {
            System.out.printf("%s не может прыгнуть на %d м\n", name, length);
            return false;
        }
        else
        {
            System.out.printf("%s прыгнул на %d м\n", name, length);
            return true;
        }
    }
}