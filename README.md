## Dicionário Distribuído - Java RMI
Este projeto demonstra a implementação de um sistema cliente-servidor utilizando Java RMI (Remote Method Invocation) para permitir o gerenciamento de um dicionário distribuído. Múltiplos clientes podem interagir simultaneamente com o servidor para consultar, adicionar ou remover palavras e seus significados.

## Integrantes
* Ramon Mendes Peixoto
* Rodrigo Mendes Peixoto

## Orientadores
* Cristiano de Macêdo Neto

## Estrutura do Projeto
O projeto é dividido em três partes principais:

1. Servidor
Servidor.java: Implementa a lógica principal do servidor, inicializa o registro RMI e gerencia as operações do dicionário.
Dicionario.java: Contém a implementação da interface remota e a lógica do dicionário, como adição, remoção e consulta de palavras.
IDicionario.java: Interface remota que define os métodos disponíveis para os clientes.
2. Cliente
Cliente.java: Implementa a interface gráfica e as funcionalidades para que o cliente interaja com o servidor, como consultar, adicionar ou remover palavras.
3. Interface Remota
IDicionario.java: Define os métodos remotos que podem ser invocados pelos clientes, como adicionarPalavra, removerPalavra e consultarSignificado.
Persistência de Dados
Os dados do dicionário são persistidos utilizando Java Object Serialization. O dicionário é salvo em um arquivo binário, permitindo a recuperação dos dados em execuções futuras do servidor.

Tratamento de Erros
O sistema é projetado para lidar com erros comuns, como problemas de rede e entrada/saída. Mensagens de erro são exibidas ao usuário e registradas para facilitar a análise de falhas.

Exemplo de Uso
1. Consultar o significado de uma palavra:
Insira a palavra na interface do cliente e clique em "Consultar".
2. Adicionar uma nova palavra:
Insira a palavra e o significado na interface do cliente e clique em "Adicionar".
3. Remover uma palavra:
Insira a palavra na interface do cliente e clique em "Remover".
