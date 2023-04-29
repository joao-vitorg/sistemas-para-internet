package interfaces.ex2;

public class Natal extends CartaoWeb {
	public Natal(String destinatario) {
		super(destinatario);
	}

	@Override
	public void showMessage() {
		System.out.printf("%s, feliz natal\n", super.getDestinatario());
	}
}
