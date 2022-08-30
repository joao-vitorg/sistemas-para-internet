import java.util.Scanner;

class ContarVogais {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        char[] vogais = {'a', 'e', 'i', 'o', 'u'};
        int[] countVogais = new int[5];
        int count = 0;

        String text = s.nextLine();
        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            for (int j = 0; j < 5; j++) {
                if (c == vogais[j]) {
                    countVogais[j]++;
                    count++;
                }
            }
        }

        System.out.printf("Total = %d\n", count);

        for (int i = 0; i < 5; i++) {
            System.out.printf("%c = %d\n", vogais[i], countVogais[i]);
        }
    }
}
