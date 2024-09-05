import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    private static IDicionarioPesquisa dicionarioPesquisa;
    public static void main(String[] args) {
        try {
            dicionarioPesquisa = new DicionarioPesquisa();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("DicionarioPesquisa", dicionarioPesquisa);
            System.out.println("Servidor de pesquisa em dicionário!");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " +
                    e.toString());
            e.printStackTrace();
        }
    }
}