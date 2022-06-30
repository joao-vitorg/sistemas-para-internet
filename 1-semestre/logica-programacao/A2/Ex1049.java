import java.util.Scanner;

public class Ex1049 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String vertebras, especie, dieta, animal;

		vertebras = s.next();
		especie = s.next();
		dieta = s.next();

		if (vertebras.equals("vertebrado")) {
			if (especie.equals("ave"))
				animal = dieta.equals("carnivoro") ? "aguia" : "pomba";
			else
				animal = dieta.equals("onivoro") ? "homem" : "vaca";
		} else {
			if (especie.equals("inseto"))
				animal = dieta.equals("hematofago") ? "pulga" : "lagarta";
			else
				animal = dieta.equals("hematofago") ? "sanguessuga" : "minhoca";
		}

		System.out.println(animal);

		s.close();
	}
}
