package entities;

public class Tabuleiro {
    private final Logica tabuleiro = new Logica();

    public boolean jogadaFinal() {
        System.out.println();
        System.out.println(this);

        return (vencedor() || velha());
    }

    public boolean userJoga(int x, int y) {
        return tabuleiro.jogar(x, y, 1);
    }

    public void pcJoga() {
        System.out.println("---------- PC ----------");
        tabuleiro.pcJoga();
    }

    public boolean vencedor() {
        switch (tabuleiro.verificarVencedor()) {
            case 1 -> {
                System.out.println("========== JOGADOR GANHOU ==========");
                return true;
            }
            case -1 -> {
                System.out.println("========== PC GANHOU ==========");
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public boolean velha() {
        if (tabuleiro.verificarVelha()) {
            System.out.println("========== DEU VELHA ==========");
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        int[][] pecas = new int[3][3];
        int[][] tab = tabuleiro.getTabuleiro();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pecas[i][j] = switch (tab[i][j]) {
                    case 1 -> 'X';
                    case -1 -> 'O';
                    default -> ' ';
                };
            }
        }

        return String.format("""
                        %c | %c | %c
                        %c | %c | %c
                        %c | %c | %c
                        """, pecas[0][0], pecas[0][1], pecas[0][2],
                pecas[1][0], pecas[1][1], pecas[1][2],
                pecas[2][0], pecas[2][1], pecas[2][2]);
    }
}
