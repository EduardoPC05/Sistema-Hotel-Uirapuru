package src.model.reserva;

import src.model.pagamento.MetodosPagamento;
import src.model.pessoa.Hospede;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Reserva {

    private Hospede hospedePrincipal;
    private List<Hospede> acompanhantes;
    private Acomodacao acomodacao;
    private List<ItemConsumido> consumacao;
    private LocalDateTime chegada;
    private LocalDateTime saida;
    private double multa;
    private double desconto;
    private MetodosPagamento pagamento;

    public Reserva(Hospede hospedePrincipal, Acomodacao acomodacao, LocalDateTime chegada, LocalDateTime saida) {
        this.hospedePrincipal = hospedePrincipal;
        this.acomodacao = acomodacao;
        this.chegada = chegada;
        this.saida = saida;
    }

    public double calculaEstadia(LocalDateTime chegada, LocalDateTime saida){

        double preco = acomodacao.getPrecoDiaria();
        Duration duracao = Duration.between(saida, chegada);
        return preco * duracao.toDays();
    }

    public double calculaConsumacao(){
        double consumacao = 0;
        //TODO
        return consumacao;
    }

    public double calculaTotal(){
        double total = 0;
        //TODO
        return total;
    }

    public void addAcompanhantes(List<Hospede> acompanhantes) {
        //Lógica para adicionar acompanhantes
    }

    public void removeAcompanhantes(){
        //Lógica para remover acompanhantes;
    }

    public void setChegada(LocalDateTime chegada) {
        this.chegada = chegada;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public void setPagamento(MetodosPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Hospede getHospedePrincipal() {
        return hospedePrincipal;
    }

    public List<Hospede> getAcompanhantes() {
        return acompanhantes;
    }

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public List<ItemConsumido> getConsumacao() {
        return consumacao;
    }

    public LocalDateTime getChegada() {
        return chegada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public double getMulta() {
        return multa;
    }

    public double getDesconto() {
        return desconto;
    }

    public MetodosPagamento getPagamento() {
        return pagamento;
    }
}
