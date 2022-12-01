import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Emails {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<String> emails = new HashSet<>();

        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            emails.add(s.nextLine());
        }

        String dominio = s.nextLine();
        int count = (int) emails.stream().filter(e -> e.contains(dominio)).count();
        System.out.println("E-mails diferentes : " + emails.size());
        System.out.printf("E-mails do domínio (%s) : %d\n", dominio, count);
    }
}