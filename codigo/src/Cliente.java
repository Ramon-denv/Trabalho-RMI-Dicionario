import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private static IDicionarioPesquisa pesquisa;
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            pesquisa = (IDicionarioPesquisa) registry.lookup("DicionarioPesquisa");
            String opcao;

            do {
                System.out.println("\n----- Menu -----");
                System.out.println("1. Consultar palavra");
                System.out.println("2. Adicionar nova palavra");
                System.out.println("3. Remover palavra");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextLine();

                switch (opcao) {
                    case "1":
                        System.out.println("Digite a palavra que deseja consultar: ");
                        String palavra = sc.nextLine();
                        consultarPalavra(palavra);
                        break;
                    case "2":
                        System.out.println("Digite a nova palavra que deseja adicionar: ");
                        String novaPalavra = sc.nextLine();
                        System.out.println("Digite o significado dessa palavra: ");
                        String novoSignificado = sc.nextLine();
                        adicionarPalavra(novaPalavra, novoSignificado);
                        break;
                    case "3":
                        System.out.println("Digite a palavra que deseja remover: ");
                        String delPalavra = sc.nextLine();
                        removerPalavra(delPalavra);
                        break;
                    case "0":
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                        break;
                }
            } while (!opcao.equals("0"));

        } catch (AccessException e) {
            System.out.println("Erro de acesso: " + e.getMessage());
        } catch (NotBoundException e) {
            System.out.println("Erro ao procurar o objeto remoto: " + e.getMessage());
        } catch (RemoteException e) {
            System.out.println("Erro remoto: " + e.getMessage());
        }
    }

    public static void consultarPalavra(String palavra) {
        try {
            String significado = pesquisa.pesquisar(palavra);
            if (significado != null && !significado.isEmpty()) {
                System.out.println("O significado da palavra '" + palavra + "' é: " + significado);
            } else {
                System.out.println("Palavra não encontrada.");
            }
        } catch (RemoteException e) {
            System.out.println("Erro ao consultar palavra: " + e.getMessage());
        }
    }


    public static void adicionarPalavra(String palavra, String novoSignificado) {
        try {
            boolean sucesso = pesquisa.setDicionario(palavra, novoSignificado);
            if (sucesso) {
                System.out.println("Palavra adicionada com sucesso.");
            } else {
                System.out.println("Palavra já existe no dicionário.");
            }
        } catch (RemoteException e) {
            System.out.println("Erro ao adicionar palavra: " + e.getMessage());
        }
    }

    public static void removerPalavra(String palavra) {
        try {
            boolean sucesso = pesquisa.deleteDicionario(palavra);
            if (sucesso) {
                System.out.println("Palavra removida com sucesso.");
            } else {
                System.out.println("Palavra não encontrada no dicionário.");
            }
        } catch (RemoteException e) {
            System.out.println("Erro ao remover palavra: " + e.getMessage());
        }
    }
}