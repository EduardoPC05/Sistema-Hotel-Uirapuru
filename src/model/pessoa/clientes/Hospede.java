package src.model.pessoa.clientes;

import src.model.pessoa.documento.InfosBasicas;
import src.model.pessoa.endereco.Endereco;
import src.model.pessoa.documento.Documento;
import src.model.pessoa.login.InfoLogin;

public class Hospede extends Cliente {
    private Endereco endereco;
    private String telefone;

    public Hospede(Cliente cliente, Endereco endereco, String telefone) {
        super(cliente.getNome(), cliente.getInfosBasicas(), cliente.getInfoLogin());
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
    public InfosBasicas getInfosBasicas() {
        return super.getInfosBasicas();
    }
}
