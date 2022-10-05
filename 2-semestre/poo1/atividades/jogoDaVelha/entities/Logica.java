package jogoDaVelha.entities;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Logica {
    private final int[][] tabuleiro = new int[3][3];
    private final int[] soma_linha = new int[3];
    private final int[] soma_coluna = new int[3];
    private final int[] soma_diagonais = new int[2];
    private final Random random = new Random();
    private int jogadas = 0;

    public boolean jogar(int x, int y, int player) {
        if (tabuleiro[x][y] != 0) return false;

        tabuleiro[x][y] = player;
        somarTabuleiro(x, y);
        jogadas++;

        return true;
    }

    public void somarTabuleiro(int x, int y) {
        // Soma linha
        soma_linha[x] = Arrays.stream(tabuleiro[x]).sum();

        // soma coluna
        soma_coluna[y] = IntStream.range(0, 3).map(i -> tabuleiro[i][y]).sum();

        // Soma diagonal Principal
        if (x == y) {
            soma_diagonais[0] = IntStream.range(0, 3).map(i -> tabuleiro[i][i]).sum();
        }

        // Soma diagonal Secundaria
        if ((x + y) == 2) {
            soma_diagonais[1] = IntStream.range(0, 3).map(i -> tabuleiro[2 - i][i]).sum();
        }
    }

    public int verificarVencedor() {
        // Verifica linhas
        for (int linha : soma_linha) {
            if (linha == 3) return 1;
            else if (linha == -3) return -1;
        }

        // Verifica colunas
        for (int coluna : soma_coluna) {
            if (coluna == 3) return 1;
            else if (coluna == -3) return -1;
        }

        // Verifica diagonais
        for (int diagonais : soma_diagonais) {
            if (diagonais == 3) return 1;
            else if (diagonais == -3) return -1;
        }

        return 0;
    }

    public boolean verificarVelha() {
        return jogadas == 9;
    }

    public void pcJoga() {
        // Verifica se tem possibilidade de ganhar ou de perder na proxima rodada
        if (pcVerificaGanhaPerda()) return;

        // Verifica jogada central
        if (jogar(1, 1, -1)) return;

        // Faz uma jogada randomizada
        int x, y;
        do {
            x = random.nextInt(0, 3);
            y = random.nextInt(0, 3);
        } while (!jogar(x, y, -1));
    }

    private boolean pcVerificaGanhaPerda() {
        // Verifica se ganha (-2) ou se perde (2)
        for (int op = -2; op <= 2; op += 4) {
            // Verifica linhas
            for (int i = 0; i < 3; i++) {
                if (soma_linha[i] == op) {
                    return jogar(i, 0, -1) || jogar(i, 1, -1) || jogar(i, 2, -1);
                }
            }

            // Verifica colunas
            for (int j = 0; j < 3; j++) {
                if (soma_coluna[j] == op) {
                    return jogar(0, j, -1) || jogar(1, j, -1) || jogar(2, j, -1);
                }
            }

            // Verifica diagonal principal
            if (soma_diagonais[0] == op) {
                return jogar(0, 0, -1) || jogar(1, 1, -1) || jogar(2, 2, -1);
            }

            // Verifica diagonal secundaria
            if (soma_diagonais[1] == op) {
                return jogar(2, 0, -1) || jogar(1, 1, -1) || jogar(0, 2, -1);
            }
        }

        return false;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }
}
