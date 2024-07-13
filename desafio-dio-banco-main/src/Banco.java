import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public Banco(String nome, List<Conta> contas) {
        this.nome = nome;
        this.contas = contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void addCliente(Conta clienteConta) {
        contas.add(clienteConta);
    }

    public void exibirListaClientes() {
        for (Conta c : contas) {
            System.out.println("Nome do Titular: " + c.getCliente().getNome() + ", Numero da Conta: " + c.getNumero() + ", Agencia: " + c.getAgencia());
        }
    }

    public void excluirConta (Conta contaASerExcluida) {
        contas.remove(contaASerExcluida);
    }
}
