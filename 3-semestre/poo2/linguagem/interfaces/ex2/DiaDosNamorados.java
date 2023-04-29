package interfaces.ex2;

public class DiaDosNamorados extends CartaoWeb {
	public DiaDosNamorados(String destinatario) {
		super(destinatario);
	}

	@Override
	public void showMessage() {
		System.out.printf("%s, Te amo\n", super.getDestinatario());
	}
}
