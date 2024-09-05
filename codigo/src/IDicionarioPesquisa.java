import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDicionarioPesquisa extends Remote {
    public String pesquisar(String palavra) throws RemoteException;
    public Boolean setDicionario(String chave, String valor) throws RemoteException;
    public Boolean deleteDicionario(String chave) throws RemoteException;
}