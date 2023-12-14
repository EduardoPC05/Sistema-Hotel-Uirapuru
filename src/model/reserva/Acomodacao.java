package src.model.reserva;


public class Acomodacao {

    private String codigo;
    private String andar;
    private String numero;
    private String descricao;
    private TipoQuarto tipoQuarto;
    private double precoDiaria;

    public Acomodacao(String andar, String numero, String descricao, TipoQuarto tipoQuarto) {
        this.andar = andar;
        this.numero = numero;
        this.descricao = descricao;
        this.tipoQuarto = tipoQuarto;
        calculaPrecoDiaria(tipoQuarto);
        setCodigo(andar, numero);
    }

    private void calculaPrecoDiaria(TipoQuarto tipoQuarto){
        switch (tipoQuarto){
            case NORMAL:
                precoDiaria = 100.00;
                break;
            case SUITE:
                precoDiaria = 150.00;
                break;
            case LUXO:
                precoDiaria = 250.00;
                break;
        }
    }

    private void setCodigo(String andar, String numero){
        codigo = andar + numero;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getAndar() {
        return andar;
    }

    public String getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }
}
