package Homework7;
public class Homework7
{
    public static void main(String[] args)
    {
        Cat[] cats =
                {
                        new Cat("Барсик", 10),
                        new Cat("Мурзик", 20),
                        new Cat("Пушок", 30)
                };
        Bowl bowl = new Bowl();
        bowl.putFood(40);
        System.out.printf("В миске %d грамм еды\n", bowl.getFoodAmount());
        for (int i = 0; i < cats.length; i++)
        {
            cats[i].eat(bowl);
            cats[i].isSatiety();
            System.out.printf("В миске %d грамм еды\n", bowl.getFoodAmount());
        }
    }
}