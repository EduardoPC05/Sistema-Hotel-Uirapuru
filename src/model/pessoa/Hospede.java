package src.model.pessoa;

import src.model.pessoa.documento.Documento;

public class Hospede extends Pessoa{

    private String email;
    private Boolean principal;

    public Hospede(Documento documento, Endereco endereco, long telefone, String senha, String email, Boolean principal) {
        super(documento, endereco, telefone, senha);
        this.email = email;
        this.principal = principal;
    }

    public String getEmail() {
        return email;
    }

    public Boolean ehPrincipal() {
        return principal;
    }
}
