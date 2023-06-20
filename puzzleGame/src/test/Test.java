package test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        //打乱数组
        Random random = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = random.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;

        }

        for (int i = 0; i < tempArr.length; i++) {
            System.out.print(tempArr[i] + " ");
        }
        System.out.println();
        //创建二维数组
        int[][] data = new int[4][4];

        //给二维数组赋值
        //method1
        for (int i = 0; i < tempArr.length; i++) {
            data[i / 4][i % 4] = tempArr[i];
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");

            }
            System.out.println();

        }

    }
}
