import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class QuantidadeEmails {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<String> emails = new HashSet<>();

        String nome = s.nextLine();

        while (true) {
            String email = s.next();

            if (email.equals("@")) break;

            emails.add(email);
        }


        System.out.println(emails.size());
    }
}
