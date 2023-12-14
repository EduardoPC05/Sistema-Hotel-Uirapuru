package src.model.pessoa.documento;

import java.time.LocalDate;

public class Rg extends Documento{

    private String rg;
    private long cpf;

    public Rg(String nome, String nomePai, String nomeMae, LocalDate dataNascimento, String naturalidade, LocalDate dataExpedicao, String rg, long cpf) {
        super(nome, nomePai, nomeMae, dataNascimento, naturalidade, dataExpedicao);
        this.rg = rg;
        this.cpf = cpf;
    }

    public long getCpf() {
        return cpf;
    }

    @Override
    public String getNumeroDocumento() {
        return rg;
    }
}
