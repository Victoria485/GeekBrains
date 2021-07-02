package Homework7;
public class Bowl
{
    private int foodAmount;
    public void putFood(int amount)
    {
        this.foodAmount += amount;
    }
    public boolean decreaseFood(int amount)
    {
        if (amount <= foodAmount)
        {
            this.foodAmount -= amount;
            return true;
        }
        else
        {
            System.out.println("В миске слишком мало еды");
            return false;
        }
    }
    public int getFoodAmount()
    {
        return foodAmount;
    }
}