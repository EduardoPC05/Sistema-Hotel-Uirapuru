package src.model.pessoa;

import src.model.pessoa.documento.Documento;

public abstract class Pessoa {
    private String nome;
    private Documento documento;

    public Pessoa(String nome, Documento documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public Documento getDocumento() {
        return documento;
    }
}
