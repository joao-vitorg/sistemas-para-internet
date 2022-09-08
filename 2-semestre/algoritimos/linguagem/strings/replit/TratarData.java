import java.util.Scanner;

class TratarData {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String data = s.nextLine();
        String d = data.substring(0, 2);


        System.out.printf("Estamos no dia %s do mes.\n", d);
    }
} 