package Homework2;
public class Homework2
{
    public static boolean sumFrom10To20(int a, int b)
    {
        return a + b >= 10 && a + b <= 20;
    }
    public static void numberSign(int a)
    {
        if (a >= 0) System.out.println("Число положительное");
        else System.out.println("Число отрицательное");
    }
    public static boolean isNegative(int a)
    {
        return a < 0;
    }
    public static void printString(String s, int a)
    {
        for (int i = 0; i < a; i++)
            System.out.println(s);
    }
    public static boolean leapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
    public static void main(String[] args)
    {
        System.out.println(sumFrom10To20(1, 2));
        numberSign(3);
        System.out.println(isNegative(4));
        printString("Java", 5);
        System.out.println(leapYear(6));
    }
}