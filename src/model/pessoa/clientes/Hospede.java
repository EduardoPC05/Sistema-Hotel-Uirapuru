package src.model.pessoa.clientes;

import src.model.pessoa.endereco.Endereco;
import src.model.pessoa.documento.Documento;
import src.model.pessoa.login.InfoLogin;

public class Hospede extends Cliente {
    private Endereco endereco;
    private String telefone;

    public Hospede(String nome, Documento documento, InfoLogin infoLogin, Endereco endereco, String telefone) {
        super(nome, documento, infoLogin);
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public InfoLogin getInfoLogin() {
        return super.getInfoLogin();
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
