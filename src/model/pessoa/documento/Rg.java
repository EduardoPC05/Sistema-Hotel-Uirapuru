package src.model.pessoa.documento;

import java.time.LocalDate;

public class Rg extends Documento{

    private String rg;
    private String cpf;

    public Rg(String nome, String nomePai, String nomeMae, LocalDate dataNascimento, String naturalidade, LocalDate dataExpedicao, String rg, String cpf) {
        super(nome, nomePai, nomeMae, dataNascimento, naturalidade, dataExpedicao);
        this.rg = rg;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String getNumeroDocumento() {
        return rg;
    }
}
