import java.util.Scanner;

class MOD {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int x = s.nextInt();
        int y = s.nextInt();

        System.out.printf("O MOD de (%d, %d) = %d\n", x, y, mod(x, y));
    }

    public static int mod(int x, int y) {
        if (x<y) return x;
        if (x>y) return mod(x-y, y);
        return 0;
    }
}
