package Homework3;
import java.util.Arrays;
public class Homework3
{
    public static void main(String[] args)
    {
        arr01();
        arr100(3);
        arr62();
        arr2d();
        arr(4,5);
        arrMaxMin();
        System.out.println(arrBalance(1, 1, 11, 7, 1, 2, 3));
        arrOffset(-2, 3, 5, 6, 1);
    }
    private static void arrOffset(int n, int... arrOffset)
    {
        if (n > 0)
        {
            for (int i = 1; i < arrOffset.length; i++)
            {
                int t = arrOffset[i];
                arrOffset[i] = arrOffset[0];
                arrOffset[0] = t;
            }
        }
        if (n < 0)
        {
            for (int i = arrOffset.length - 2; i >= 0; i--)
            {
                int t = arrOffset[i];
                arrOffset[i] = arrOffset[arrOffset.length - 1];
                arrOffset[arrOffset.length - 1] = t;
            }
        }
        System.out.println(Arrays.toString(arrOffset));
    }
    private static boolean arrBalance(int... arrBalance)
    {
        int sum, sum1, sum2;
        sum = sum1 = sum2 = 0;
        for (int i = 0; i < arrBalance.length; i++)
        {
            sum += arrBalance[i];
        }
        for (int i = 0; i < arrBalance.length - 1; i++)
        {
            sum1 += arrBalance[i];
            sum2 = sum - sum1;
            if (sum1 == sum2) return true;
        }
        return false;
    }
    private static void arrMaxMin()
    {
        int[] arrMaxMin = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arrMaxMin.length; i++)
        {
            if (arrMaxMin[i] < min) min = arrMaxMin[i];
            if (arrMaxMin[i] > max) max = arrMaxMin[i];
        }
        System.out.printf("min = %d, max = %d\n", min, max);
    }
    private static void arr(int len, int initialValue)
    {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void arr2d()
    {
        int[][] arr2d = new int[5][5];
        for (int i = 0; i < arr2d.length; i++)
        {
            arr2d[i][i] = 1;
            arr2d[i][arr2d.length - i - 1] = 1;
        }
        for (int i = 0; i < arr2d.length; i++)
        {
            for (int j = 0; j < arr2d[i].length; j++)
            {
                System.out.print(arr2d[i][j] + "  ");
            }
            System.out.println();
        }
    }
    private static void arr62()
    {
        int[] arr62 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr62.length; i++)
        {
            if (arr62[i] < 6) arr62[i] *= 2;
        }
        System.out.println(Arrays.toString(arr62));
    }
    private static void arr100(int n) {
        int[] arr100 = new int[100];
        for (int i = 0; i < arr100.length; i++)
        {
            arr100[i] = (i + 1) * n;
        }
        System.out.println(Arrays.toString(arr100));
    }
    private static void arr01()
    {
        int[] arr01 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr01.length; i++)
        {
            arr01[i] = (arr01[i] - 1) * -1;
        }
        System.out.println(Arrays.toString(arr01));
    }
}