package src.model.reserva;

import src.model.pessoa.clientes.Acompanhante;
import src.model.pessoa.clientes.Cliente;
import src.model.pessoa.clientes.Hospede;
import src.model.reserva.pagamento.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
/**
 * Representa uma reserva em um hotel, incluindo informações sobre o hóspede,
 * acompanhantes, tipo de quarto, datas de check-in e check-out, pagamento, etc.
 */
public class Reserva {

    private Cliente hospedePrincipal;
    private int qtdAcompanhantes;
    private ArrayList<Acompanhante> acompanhantes;
    private TipoQuarto tipoQuarto;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private LocalDateTime horarioChegada;
    private LocalDateTime horarioSaida;
    private double precoDiaria;
    private MetodoPagamento pagamento;
    private TipoPagamento tipoPagamento;
    private int contasAPagar;

    /**
     * Construtor da classe Reserva.
     *
     * @param hospedePrincipal O hóspede principal da reserva.
     * @param qtdAcompanhantes A quantidade de acompanhantes na reserva.
     * @param tipoQuarto O tipo de quarto da reserva.
     * @param checkIn A data de check-in da reserva.
     * @param checkOut A data de check-out da reserva.
     */
    public Reserva(Cliente hospedePrincipal, int qtdAcompanhantes,TipoQuarto tipoQuarto, LocalDate checkIn, LocalDate checkOut) {
        this.hospedePrincipal = hospedePrincipal;
        this.qtdAcompanhantes = qtdAcompanhantes;
        this.tipoQuarto = tipoQuarto;
        this.checkIn = LocalDateTime.of(checkIn,LocalTime.of(9,0,0)); // Horário minimo para dar entrada no hotel
        this.checkOut = LocalDateTime.of(checkOut,LocalTime.of(12,0,0)); // Horário maximo para sair do hotel
        this.acompanhantes = new ArrayList<>();
        this.pagamento = new MetodoPagamento();
        this.tipoPagamento = null;
        this.horarioChegada = null;
        this.horarioSaida = null;
        this.contasAPagar = 0;

    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public Cliente getHospedePrincipal() {
        return hospedePrincipal;
    }

    public int getQtdAcompanhantes() {
        return qtdAcompanhantes;
    }

    public ArrayList<Acompanhante> getAcompanhantes() {
        return acompanhantes;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setHospedePrincipal(Cliente hospedePrincipal) {
        this.hospedePrincipal = hospedePrincipal;
    }

    /**
     * Retorna se a reserva está ativa, com base no tipo do hóspede principal.
     *
     * @return True se o hóspede principal for do tipo Hospede, False caso contrário.
     */
    public boolean getReservaAtiva(){
        if (hospedePrincipal instanceof Hospede){
            return true;
        }
        return false;
    }

    /**
     * Retorna o objeto de pagamento associado à reserva.
     *
     * @return O objeto de pagamento associado à reserva.
     */
    public MetodoPagamento getPagamento() {
        return pagamento;
    }

    /**
     * Retorna o tipo de pagamento associado à reserva.
     *
     * @return O tipo de pagamento associado à reserva.
     */
    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    /**
     * Retorna o preço da diária associado a uma determinada acomodação.
     *
     * @param acomodacao A acomodação para a qual obter o preço da diária.
     * @return O preço da diária da acomodação.
     */
    public double getPrecoDiaria(Acomodacao acomodacao) {
        return acomodacao.getPrecoDiaria();
    }

    /**
     * Retorna o horário de chegada da reserva
     * caso o check-In foi efetuado.
     *
     * @return O horário de chegada da reserva.
     */
    public LocalDateTime getHorarioChegada() {
        return horarioChegada;
    }

    /**
     * Retorna o horário de saída da reserva
     * caso o check-Out foi efetuado.
     *
     * @return O horário de saída da reserva.
     */
    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    /**
     * Calcula e retorna o preço total da estadia com base na acomodação associada à reserva.
     *
     * @param acomodacao A acomodação associada à reserva.
     * @return O preço total da estadia.
     */
    public double getPrecoEstadia(Acomodacao acomodacao){
        if(getHorarioChegada() != null && getHorarioSaida() != null){
            long retorno = ChronoUnit.DAYS.between(getHorarioChegada(), getHorarioSaida());
            long periodoCorreto = ChronoUnit.DAYS.between(getCheckIn(), getCheckOut());
            double valor = 0;
            if(retorno > periodoCorreto){
                valor = retorno;
            }else {
                valor = periodoCorreto;
            }
            valor *= getPrecoDiaria(acomodacao);
            return valor;
        }
        return -1;
    }

    /**
     * Retorna o preço associado a um determinado tipo de quarto.
     *
     * @param tipoQuarto O tipo de quarto para o qual obter o preço.
     * @return O preço associado ao tipo de quarto.
     */
    public double getPrecoPorTipo(TipoQuarto tipoQuarto){
        double retorno  = 0;
        switch (tipoQuarto){
            case NORMAL:
                retorno = 100.00;
                break;
            case SUITE:
                retorno = 150.00;
                break;
            case LUXO:
                retorno = 250.00;
                break;
        }
        return retorno;
    }

    /**
     * Retorna se há contas pendentes.
     *
     * @return 0 para sem contas
     * 1 para cartão
     * 2 para boleto
     * 3 para cheque.
     */
    public int getContasAPagar() {
        return contasAPagar;
    }

    /**
     * Define o pagamento da reserva como um pagamento com cartão de crédito.
     *
     * @param nome Nome no cartão.
     * @param numero Número do cartão.
     * @param cvv Código de segurança do cartão.
     * @param mesValidade Mês de validade do cartão.
     * @param anoValidade Ano de validade do cartão.
     */
    public void setPagamentoCartao(String nome, String numero, int cvv, int mesValidade, int anoValidade) {
        this.pagamento = new Cartao(nome, numero, cvv, mesValidade, anoValidade);
        contasAPagar = 0;
    }

    /**
     * Define o pagamento da reserva como um pagamento com boleto bancário.
     *
     * @param dataValidade Data de validade do boleto.
     * @param valor Valor do boleto.
     */
    public void setPagamentoBoleto(LocalDate dataValidade, double valor) {
        this.pagamento = new Boleto(dataValidade, valor);
        contasAPagar = 0;
    }

    /**
     * Define o pagamento da reserva como um pagamento com cheque.
     *
     * @param nomeBeneficiario Nome do beneficiário do cheque.
     */
    public void setPagamentoCheque(String nomeBeneficiario) {
        this.pagamento = new Cheque(nomeBeneficiario);
        contasAPagar = 0;
    }

    /**
     * Define o tipo de pagamento.
     *
     * @param tipoPagamento O tipo de pagamento escolhido.
     */
    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
        switch (tipoPagamento){
            case CARTAO:
                contasAPagar = 1;
                break;
            case BOLETO:
                contasAPagar = 2;
                break;
            case CHEQUE:
                contasAPagar = 3;
                break;
        }
    }

    /**
     * Define o preço da diária associado à reserva.
     *
     * @param precoDiaria O preço da diária a ser definido.
     */
    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    /**
     * Define o horário de chegada da reserva.
     *
     * @param horarioChegada O horário de chegada a ser definido.
     */
    public void setHorarioChegada(LocalDateTime horarioChegada) {
        this.horarioChegada = horarioChegada;
    }

    /**
     * Define o horário de saída da reserva.
     *
     * @param horarioSaida O horário de saída a ser definido.
     */
    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    /**
     * Adiciona um acompanhante à reserva.
     *
     * @param acompanhante O acompanhante a ser adicionado.
     */
    public void addAcompanhantes(Acompanhante acompanhante) {
        acompanhantes.add(acompanhante);
    }

    /**
     * Remove um acompanhante da reserva com base no nome.
     *
     * @param nome O nome do acompanhante a ser removido.
     */
    public void removeAcompanhantes(String nome){
        if(acompanhantes != null){
            for (Acompanhante ac : acompanhantes){
                if (ac.getNome() == nome){
                    acompanhantes.remove(ac);
                }
            }
        }
    }

}
