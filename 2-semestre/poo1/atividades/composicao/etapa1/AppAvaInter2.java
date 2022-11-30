package composicao.etapa1;

import java.util.HashMap;
import java.util.Map;

public class AppAvaInter2 {
    public static void main(String[] args) {
        Map<String, String> unidadeRemedio = new HashMap<>();
        unidadeRemedio.put("ml", "mililitro");
        unidadeRemedio.put("cp", "comprimido");
        unidadeRemedio.put("gr", "grama");
        unidadeRemedio.put("un", "unidade");

        System.out.println(unidadeRemedio);
    }
}
