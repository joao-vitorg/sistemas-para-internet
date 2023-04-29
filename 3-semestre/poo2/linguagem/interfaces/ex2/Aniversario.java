package interfaces.ex2;

public class Aniversario extends CartaoWeb {
	public Aniversario(String destinatario) {
		super(destinatario);
	}

	@Override
	public void showMessage() {
		System.out.printf("%s, feliz aniversario\n", super.getDestinatario());
	}
}
