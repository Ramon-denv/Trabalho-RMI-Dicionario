import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class DicionarioPesquisa extends UnicastRemoteObject implements IDicionarioPesquisa {
    private Dicionario dicionario;
    protected DicionarioPesquisa() throws RemoteException {
        super();
        dicionario = new Dicionario();
    }

    @Override
    public String pesquisar(String palavra) throws RemoteException {
        String significado = dicionario.getSignificado(palavra);
        return significado;
    }

    @Override
    public Boolean setDicionario(String chave, String valor) throws RemoteException {
        dicionario.setDicionario(chave, valor);
        if(pesquisar(chave) != null)
            return true;
        return false;
    }

    @Override
    public Boolean deleteDicionario(String chave) throws RemoteException {
        dicionario.deleteDicionario(chave);
        if(pesquisar(chave) != null)
            return false;
        return true;
    }
}
