package src.model.pessoa;

import src.model.pessoa.documento.Documento;

public class Hospede extends Pessoa{

    private String email;
    private Boolean principal;

    public Hospede(Documento documento, Endereço endereço, long telefone, String senha, String email, Boolean principal) {
        super(documento, endereço, telefone, senha);
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
