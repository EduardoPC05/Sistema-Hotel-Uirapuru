package src.model.pagamento;

import java.time.LocalDate;
import java.util.Random;

public class Boleto implements MetodosPagamento{
    private int valor;
    private LocalDate vencimento;

    private long codigo;

    public Boleto(int valor, LocalDate vencimento) {
        this.valor = valor;
        this.vencimento = vencimento;
    }

    public int getValor() {
        return valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public long getCodigo() {
        return codigo;
    }
}
