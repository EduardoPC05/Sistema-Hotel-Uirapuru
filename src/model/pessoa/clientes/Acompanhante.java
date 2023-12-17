package src.model.pessoa.clientes;

import src.model.pessoa.Pessoa;
import src.model.pessoa.documento.Documento;
import src.model.pessoa.documento.InfosBasicas;

public class Acompanhante extends Pessoa {
    public Acompanhante(String nome, InfosBasicas infos) {
        super(nome, infos);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public InfosBasicas getInfosBasicas() {
        return super.getInfosBasicas();
    }
}
