package src.model.pessoa;

public class Endereco {

    private String estado;
    private String cidade;
    private long CEP;
    private String rua;
    private String numRua;
    private String bairro;

    public Endereco(String estado, String cidade, int CEP, String rua, String numRua, String bairro) {
        this.estado = estado;
        this.cidade = cidade;
        this.CEP = CEP;
        this.rua = rua;
        this.numRua = numRua;
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public long getCEP() {
        return CEP;
    }

    public String getRua() {
        return rua;
    }

    public String getNumRua() {
        return numRua;
    }

    public String getBairro() {
        return bairro;
    }
}
