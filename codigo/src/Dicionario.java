import java.io.Serializable;
import java.util.Dictionary;
import java.util.Hashtable;

public class Dicionario implements Serializable {
    private Dictionary<String, String> Dicionario;

    public Dicionario(){
        Dicionario = inicializarDados();
    }
    public String getSignificado(String palavra){
           return Dicionario.get(palavra);
    }
    public void setDicionario(String chave, String valor){
        Dicionario.put(chave, valor);
        return;
    }
    public void deleteDicionario(String chave){
        Dicionario.remove(chave);
        return;
    }

    private static Dictionary<String, String> inicializarDados() {
        Dictionary<String, String> dados = new Hashtable<>();

        dados.put("resiliência", "Capacidade de se recuperar rapidamente de dificuldades.");
        dados.put("paradoxal", "Que apresenta um paradoxo, algo que é aparentemente contraditório.");
        dados.put("inovação", "Introdução de algo novo, geralmente relacionado a tecnologias ou métodos.");
        dados.put("eficácia", "Capacidade de produzir o efeito desejado ou esperado.");
        dados.put("empatia", "Capacidade de se colocar no lugar do outro e entender seus sentimentos e perspectivas.");
        dados.put("proativo", "Que toma a iniciativa de agir antes que os problemas surjam.");
        dados.put("sustentabilidade", "Capacidade de manter um equilíbrio entre recursos naturais e o desenvolvimento econômico.");
        dados.put("transparência", "Qualidade de ser claro e aberto sobre processos e decisões.");
        dados.put("resiliência", "Capacidade de se adaptar a mudanças e superar adversidades.");
        dados.put("cognitivo", "Relativo aos processos mentais de aquisição de conhecimento e compreensão.");
        dados.put("sociabilidade", "Habilidade de se relacionar bem com os outros e se integrar a grupos sociais.");
        dados.put("característica", "Atributo distintivo de uma pessoa, objeto ou conceito.");
        dados.put("vulnerabilidade", "Estado de estar exposto a possíveis danos ou ataques.");
        dados.put("adaptabilidade", "Capacidade de ajustar-se facilmente a novas condições ou mudanças.");
        dados.put("perspectiva", "Ponto de vista ou maneira de ver e interpretar algo.");

        return dados;
    }

}
