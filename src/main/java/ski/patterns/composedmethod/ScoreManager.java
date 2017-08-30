package ski.patterns.composedmethod;

import java.util.Arrays;
import java.util.Scanner;

public class ScoreManager {

    public static int best(String data, int size, int x) {
        Scanner sc = new Scanner(data);
        int[] scores = new int[size];
        for (int i = 0; i < size; ++i) {
            scores[i] = sc.nextInt();
        }
        Arrays.sort(scores);
        int sum = 0;
        for (int i = scores.length-x; i < scores.length; ++i) {
            sum += scores[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int sum = best("1 2 3 4 5 6 7 8 9 10", 10, 3);
        System.out.println("Best: " + sum);
    }
}
