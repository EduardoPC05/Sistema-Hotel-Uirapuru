package src.model.pessoa.funcionario;

import src.model.pessoa.Pessoa;
import src.model.pessoa.documento.Documento;
import src.model.pessoa.documento.InfosBasicas;
import src.model.pessoa.login.InfoLogin;
import src.model.reserva.Reserva;

public class Funcionario extends Pessoa {
    private InfoLogin infoLogin;

    public Funcionario(String nome, Documento documento, InfoLogin infoLogin) {
        super(nome, documento);
        this.infoLogin = infoLogin;
    }

    public InfoLogin getInfoLogin() {
        return infoLogin;
    }


    public Funcionario(String nome, Documento documento) {
        super(nome, documento);
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
