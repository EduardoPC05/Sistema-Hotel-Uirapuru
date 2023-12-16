package src.model.pessoa.clientes;

import src.model.pessoa.Pessoa;
import src.model.pessoa.documento.Documento;

public class Acompanhante extends Pessoa {
    public Acompanhante(String nome, Documento documento) {
        super(nome, documento);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public Documento getDocumento() {
        return super.getDocumento();
    }
}
