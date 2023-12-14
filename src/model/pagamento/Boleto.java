package src.model.pagamento;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Boleto implements MetodosPagamento{
    private double valor;
    private LocalDate vencimento;

    private long codigo;

    public Boleto(double valor, LocalDate vencimento) {
        this.valor = valor;
        this.vencimento = vencimento;
    }
    private String gerarCodigo(){
        int valor = (int) getValor();
        LocalDate hoje = LocalDate.now();
        long day = ChronoUnit.DAYS.between(getVencimento(),hoje);

        return day + "";
    }


    public double getValor() {
        return valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public long getCodigo() {
        return codigo;
    }
}
