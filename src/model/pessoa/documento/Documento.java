package src.model.pessoa.documento;

import java.time.LocalDate;

public abstract class Documento {

    protected String nome;
    protected String nomePai;
    protected String nomeMae;
    protected LocalDate dataNascimento;
    protected String naturalidade;
    protected LocalDate dataExpedicao;

    public Documento(String nome, String nomePai, String nomeMae, LocalDate dataNascimento, String naturalidade, LocalDate dataExpedicao) {
        this.nome = nome;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.dataNascimento = dataNascimento;
        this.naturalidade = naturalidade;
        this.dataExpedicao = dataExpedicao;
    }

    public String getNome() {
        return nome;
    }

    public String getNomePai() {
        return nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public LocalDate getDataExpedicao() {
        return dataExpedicao;
    }

    public abstract String getNumeroDocumento();

}