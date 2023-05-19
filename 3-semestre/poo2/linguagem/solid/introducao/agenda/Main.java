package solid.introducao.agenda;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        agenda.adicionar(new Contato("joao", "123", "joao@gmail.com"));
        agenda.adicionar(new Contato("vitor", "456", "vitor@gmail.com"));
        agenda.adicionar(new Contato("gomes", "789", "gomes@gmail.com"));

        System.out.println(agenda.buscar("vitor"));
        agenda.excluir("vitor");
        System.out.println(agenda);

        agenda.atualizar(new Contato("joao", "999", "joao@gmail.com"));
        System.out.println(agenda);
    }
}
