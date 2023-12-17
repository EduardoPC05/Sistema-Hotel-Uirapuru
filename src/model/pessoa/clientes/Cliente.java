package src.model.pessoa.clientes;

import src.model.pessoa.Pessoa;
import src.model.pessoa.documento.Documento;
import src.model.pessoa.documento.InfosBasicas;
import src.model.pessoa.login.InfoLogin;

public class Cliente extends Pessoa {
    private InfoLogin infoLogin;

    public Cliente(String nome, InfosBasicas infosBasicas, InfoLogin infoLogin) {
        super(nome, infosBasicas);
        this.infoLogin = infoLogin;
    }

    public InfoLogin getInfoLogin() {
        return infoLogin;
    }
}
