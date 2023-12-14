package src.model.pessoa;

import src.model.pessoa.documento.Documento;


public class Pessoa {

    protected Documento documento;
    protected Endereco endereco;
    protected long telefone;
    protected String senha;

    public Pessoa(Documento documento, Endereco endereco, long telefone, String senha) {
        this.documento = documento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Documento getDocumento() {
        return documento;
    }

    public Endereco getEndereço() {
        return endereco;
    }

    public long getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }
}
