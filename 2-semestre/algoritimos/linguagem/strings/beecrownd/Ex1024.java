import java.util.Scanner;
import java.util.stream.IntStream;

public class Ex1024 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            char[] txt = new StringBuilder(s.nextLine())
                    .reverse()
                    .toString()
                    .toCharArray();

            IntStream.range(0, txt.length)
                    .filter(j -> Character.isAlphabetic(txt[j]))
                    .forEach(j -> txt[j] += 3);

            IntStream.range(txt.length / 2, txt.length)
                    .forEach(j -> txt[j] -= 1);

            System.out.println(txt);
        }
    }
}