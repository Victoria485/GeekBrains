package Homework6;
public class Homework6
{
    public static void main(String[] args)
    {
        Animal animals[] =
                {
                        new Cat("Барсик"),
                        new Dog("Бобик")
                };
        Obstacle obstacles[] =
                {
                        new Road(50),
                        new Road(100),
                        new Road(200),
                        new Lake(1),
                        new Road(500),
                        new Lake(5),
                        new Lake(10),
                };
        for (int i = 0; i < animals.length; i++)
        {
            int counter = 0;
            for (int j = 0; j < obstacles.length; j++)
            {
                if (obstacles[j] instanceof Road)
                {
                    if (!animals[i].run(obstacles[j].getLength())) break;
                    else counter++;
                }
                else
                {
                    if (!animals[i].swim(obstacles[j].getLength())) break;
                    else counter++;
                }
            }
            if (counter == obstacles.length) System.out.println(animals[i].getName() + " смог пройти все препятствия");
            else System.out.println(animals[i].getName() + " не смог пройти все препятствия");
        }
        System.out.println("Количество котов: " + Cat.counterCat);
        System.out.println("Количество собак: " + Dog.counterDog);
        System.out.println("Количество животных: " + Animal.counterAnimal);
    }
}