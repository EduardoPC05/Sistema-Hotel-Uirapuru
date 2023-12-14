package src.model.pessoa;

import src.model.pessoa.documento.Documento;


public class Pessoa {

    protected Documento documento;
    protected Endereço endereço;
    protected long telefone;
    protected String senha;

    public Pessoa(Documento documento, Endereço endereço, long telefone, String senha) {
        this.documento = documento;
        this.endereço = endereço;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Documento getDocumento() {
        return documento;
    }

    public Endereço getEndereço() {
        return endereço;
    }

    public long getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }
}
