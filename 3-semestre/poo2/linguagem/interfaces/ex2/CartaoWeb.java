package interfaces.ex2;

public abstract class CartaoWeb {
	private String destinatario;

	public CartaoWeb(String destinatario) {
		this.destinatario = destinatario;
	}

	public abstract void showMessage();

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
}
