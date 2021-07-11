package Homework1;
public class Homework1
{
    public static void main(String[] args)
    {
        Jumping jumpings[] =
                {
                        new Cat("Барсик", 200, 5),
                        new Cat("Мурзик", 100, 3),
                        new Human("Вася", 900, 20),
                        new Human("Петя", 800, 15),
                        new Robot("Робот", 500, 10),
                };
        Obstacle obstacles[] =
                {
                        new Treadmill(50),
                        new Treadmill(100),
                        new Wall(10),
                        new Treadmill(200),
                        new Wall(5),
                        new Wall(20),
                };
        for (int i = 0; i < jumpings.length; i++)
        {
            int counter = 0;
            for (int j = 0; j < obstacles.length; j++)
            {
                if (obstacles[j] instanceof Treadmill)
                {
                    if (!((Running)jumpings[i]).run(jumpings[i].getName(), ((Running)jumpings[i]).getMaxRun(), obstacles[j].getLength())) break;
                    else counter++;
                }
                else
                {
                    if (!jumpings[i].jump(jumpings[i].getName(), jumpings[i].getMaxJump(), obstacles[j].getLength())) break;
                    else counter++;
                }
            }
            if (counter == obstacles.length) System.out.println(jumpings[i].getName() + " смог пройти все препятствия");
            else System.out.println(jumpings[i].getName() + " не смог пройти все препятствия");
        }
    }
}