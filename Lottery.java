package Comprehensive;

import java.util.Random;
import java.util.Scanner;

public class Lottery {

    public static void main(String[] args) {
        // 系统生成随机号码
        int[] arr = createNumber();
        // 用户输入彩票号码
        int[] input = inputNumber();
        // 色球统计情况
        int redCount = 0;
        int blueCount = 0;
        // 红球判断
        for (int i = 0; i < input.length - 1; i++) {
            int redNumber_1 = input[i];
            for (int x = 0; x < arr.length - 1; x++) {
                if (redNumber_1 == arr[x]) {
                    redCount++;
                    break;
                }
            }
        }
        // 蓝球判断
        if (arr[arr.length - 1] == input[input.length - 1]) {
            blueCount++;
        }
        // 统计色球总数
        System.out.println("红球有" + redCount + "个");
        System.out.println("蓝球有" + blueCount + "个");
        // 判断中奖级别
        if (redCount == 6 && blueCount == 1) {
            System.out.println("恭喜你中了一等奖！！！奖金最高10000000元！！！");
        } else if (redCount == 6 && blueCount == 0) {
            System.out.println("恭喜你中了二等奖！！！奖金最高5000000元！！！");
        } else if (redCount == 5 && blueCount == 1) {
            System.out.println("恭喜你中了三等奖！！！奖金3000元！！！");
        } else if ((redCount == 5 && blueCount == 0) || (redCount == 4 && blueCount == 1)) {
            System.out.println("恭喜你中了四等奖！！！奖金200元！！！");
        } else if ((redCount == 4 && blueCount == 0) || (redCount == 3 && blueCount == 1)) {
            System.out.println("恭喜你中了五等奖！！！奖金10元！！！");
        } else if (redCount <= 2 && blueCount == 1) {
            System.out.println("恭喜你中了六等奖！！！奖金5元！！！");
        }

    }

    // 定义一个随机号码数组
    public static int[] createNumber() {
        //定义随机号码数组
        int[] arr = new int[7];
        Random r = new Random();
        for (int i = 0; i < 6; ) {
            int redNumber = r.nextInt(33) + 1;
            if (contains(arr, redNumber)) {
                arr[i] = redNumber;
                i++;
            }
        }
        arr[arr.length - 1] = r.nextInt(16) + 1;
        return arr;
    }

    // 判断重复号码
    public static boolean contains(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return false;
            }
        }
        return true;
    }

    // 输入中奖号码
    public static int[] inputNumber() {
        // 定义需要输入的数组
        int[] arr = new int[7];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 6; ) {
            System.out.println("请输入第" + (i + 1) + "个红球号码:");
            int redNumber = s.nextInt();
            // 判断是否在范围内
            if (redNumber <= 33 && redNumber >= 1) {
                // 判断重复
                if (contains(arr, redNumber)) {
                    arr[i] = redNumber;
                    i++;
                } else {
                    System.out.println("你输入的号码重复啦！");
                }
            } else {
                System.out.println("你输入的号码有误！");
            }
        }
        // 输入蓝球号码
        for (int i = 0; i < 1; ) {
            System.out.println("请输入蓝球号码:");
            int blueNumber = s.nextInt();
            // 判断范围
            if (blueNumber <= 16 && blueNumber >= 1) {
                arr[arr.length - 1] = blueNumber;
                i++;
            } else {
                System.out.println("你输入的号码有误");
            }
        }
        return arr;
    }

}
