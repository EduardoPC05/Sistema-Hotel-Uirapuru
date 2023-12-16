package src.model.pessoa.clientes;

import src.model.pessoa.Pessoa;
import src.model.pessoa.documento.Documento;
import src.model.pessoa.login.InfoLogin;

public class Cliente extends Pessoa {
    private InfoLogin infoLogin;

    public Cliente(String nome, Documento documento, InfoLogin infoLogin) {
        super(nome, documento);
        this.infoLogin = infoLogin;
    }

    public InfoLogin getInfoLogin() {
        return infoLogin;
    }
}
