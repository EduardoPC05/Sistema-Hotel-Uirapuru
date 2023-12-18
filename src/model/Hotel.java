package src.model;

import src.model.pessoa.clientes.Acompanhante;
import src.model.pessoa.clientes.Cliente;
import src.model.pessoa.clientes.Hospede;
import src.model.pessoa.documento.Documento;
import src.model.pessoa.documento.InfosBasicas;
import src.model.pessoa.endereco.Endereco;
import src.model.pessoa.funcionario.Funcionario;
import src.model.pessoa.login.TipoLogin;
import src.model.reserva.Acomodacao;
import src.model.reserva.Reserva;
import src.model.reserva.TipoQuarto;
import src.model.reserva.pagamento.TipoPagamento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private ArrayList<Reserva> reversasAtivas;

    private ArrayList<Funcionario> funcionarios;

    private ArrayList<Acomodacao> acomodacoes;


    public Hotel() {
        // DADOS MOCKADOS

        Acomodacao teste = new Acomodacao("12","12","ELE È BOM DMS", TipoQuarto.LUXO);
        Acomodacao teste1 = new Acomodacao("12","33","ELE È BOM DMS", TipoQuarto.LUXO);
        Acomodacao teste2 = new Acomodacao("12","44","ELE È BOM DMS", TipoQuarto.NORMAL);
        Acomodacao teste3 = new Acomodacao("12","44","ELE È BOM DMS", TipoQuarto.SUITE);

        this.acomodacoes = new ArrayList<Acomodacao>();
        acomodacoes.add(teste);
        acomodacoes.add(teste1);
        acomodacoes.add(teste2);
        acomodacoes.add(teste3);

    }

    public boolean criarAcomodacao(String andar, String num, String descricao, TipoQuarto tipoQ){
        Acomodacao quarto = new Acomodacao(andar,num,descricao,tipoQ);
         return addAcomodacao(quarto);
    }
    public boolean removerAcomodacao(Acomodacao quarto){
        //TODO
        //Fazer verificações referentes a debitos;
        return removeAcomodacao(quarto);
    }
    public boolean removerAcomodacao(String codigo){
        return this.acomodacoes.removeIf(i -> i.getCodigo().equals(codigo));
    }
    public Acomodacao getAcomodacaoPorTipo(TipoQuarto tipoQuarto){
        for (Acomodacao acomodacao: acomodacoes) {
            if(acomodacao.getTipoQuarto() == tipoQuarto){
                return acomodacao;
            }
        }
       return null;
    }
    private boolean addAcomodacao(Acomodacao quarto){
        return this.acomodacoes.add(quarto);
    }
    private boolean removeAcomodacao(Acomodacao quarto){
        return this.acomodacoes.remove(quarto);
    }

    public ArrayList<Acomodacao> getAcomodacoesPorTipo(TipoQuarto tipo) {
        ArrayList<Acomodacao> acomodacoesPorTipo = new ArrayList<Acomodacao>();
        for (Acomodacao acomodacao : acomodacoes) {
            if (acomodacao.getTipoQuarto() == tipo) {
                acomodacoesPorTipo.add(acomodacao);
            }
        }
        return acomodacoesPorTipo;
    }

    public Reserva criarReserva(Cliente hospedePrincipal, int qtdAcompanhantes, TipoQuarto tipoQuarto, LocalDate checkIn, LocalDate checkOut){
        return new Reserva(hospedePrincipal, qtdAcompanhantes, tipoQuarto, checkIn, checkOut);
    }

    public boolean efetuarReserva(Reserva nova){
        ArrayList<Acomodacao> acomodacoes = getAcomodacoesPorTipo(nova.getTipoQuarto());

        for(Acomodacao acomodacao: acomodacoes) {
            if(acomodacao.verificaReserva(nova)){
                acomodacao.addReserva(nova);
                return true;
            }
        }

        return false;
    }

    public boolean excluirReserva(String email){
        return removeReserva(getReservas(email).getLast());
    }

    private boolean removeReserva(Reserva excluir){
       return this.reversasAtivas.remove(excluir);
    }

    public ArrayList<Reserva> getReservas(String email){
        ArrayList<Reserva> reservasUsuario = new ArrayList<>();
        for (Acomodacao rs: acomodacoes){
            for (Reserva r: rs.getReservas()){
                if (r.getHospedePrincipal().getInfoLogin().getEmail().equals(email)){
                    reservasUsuario.add(r);
                }
            }
        }
        return reservasUsuario;
    }
    public Hospede criarHospedes(Cliente cliente,Endereco endereco, String telefone){
       return new Hospede(cliente,endereco,telefone);
    }

    public Endereco criarEndereco( String estado,String cidade,String rua,String numero,String bairro){
        return new Endereco(estado,cidade,rua,numero,bairro);
    };

    public ArrayList<Acomodacao> getTipoQuartosDisponiveis(){
        ArrayList<Acomodacao> retorno = new ArrayList<>();

        for (TipoQuarto c: TipoQuarto.values()){
            if (getAcomodacaoPorTipo(c) != null){
                retorno.add(getAcomodacaoPorTipo(c));
            }
        }

        return  retorno;
    }

    private Boolean adicionarDocumento(Reserva reserva, Documento documento){
        Documento doc = new Documento(reserva.getHospedePrincipal().getInfosBasicas(), documento.getNomePai(), documento.getNomeMae(), documento.getDataNascimento(), documento.getNacionalidade());
        reserva.getHospedePrincipal().setInfosBasicas(doc);
        if(reserva.getHospedePrincipal().hasDocumento(reserva.getHospedePrincipal().getInfosBasicas())){
            return true;
        }
        return false;
    }

    public boolean efetuarCheckIn(Reserva reserva, Endereco endereco, Documento documento,String telefone, LocalDateTime chegada){
        if(reserva.getHospedePrincipal() instanceof Hospede == false){
            if(chegada.isAfter(reserva.getCheckIn()) && chegada.isBefore(reserva.getCheckOut())){
                reserva.setHorarioChegada(chegada);
                adicionarDocumento(reserva, documento);
                Hospede hospede = new Hospede(reserva.getHospedePrincipal(), endereco, telefone);
                reserva.setHospedePrincipal(hospede);
                return true;
            }
        }
        return false;
    }

    private Acompanhante criarAcompanhante(String nome, InfosBasicas infos){
        return new Acompanhante(nome, infos);
    }

    public void cadastrarAcompanhante(Reserva reserva, String nome, InfosBasicas infos){
        reserva.addAcompanhantes(criarAcompanhante(nome, infos));
    }

    public boolean efetuarCheckOut(Reserva reserva, TipoPagamento tipoPagamento, LocalDateTime saida){
        if(reserva.getReservaAtiva()){
            Cliente cliente = new Cliente(reserva.getHospedePrincipal().getNome(),reserva.getHospedePrincipal().getInfosBasicas(), reserva.getHospedePrincipal().getInfoLogin());
            reserva.setTipoPagamento(tipoPagamento);
            reserva.setHospedePrincipal(cliente);
            reserva.setHorarioSaida(saida);
            return true;
        }
        return false;
    }

    public void efetuarPagamento(Reserva reserva, String nome, String numero, int cvv, int mesValidade, int anoValidade){
        reserva.setPagamentoCartao(nome, numero, cvv, mesValidade, anoValidade);
    }

    public void efetuarPagamento(Reserva reserva, double valor){
        LocalDate dataValidade =  reserva.getCheckOut().toLocalDate();
        dataValidade.plusDays(30);
        reserva.setPagamentoBoleto(dataValidade, valor);
    }

    public void efetuarPagamento(Reserva reserva, String nomeBeneficiario){
        reserva.setPagamentoCheque(nomeBeneficiario);
    }

    public ArrayList<Reserva> getReservasAtivas(){
        ArrayList<Reserva> retorno = new ArrayList<>();
        for(Acomodacao a : acomodacoes){
            for(Reserva r : a.getReservas()){
                if(r.getReservaAtiva()){
                    retorno.add(r);
                }
            }
        }
        return retorno;
    }

    public TipoLogin verificaLogin(String email, String senha){
        for(Acomodacao a : acomodacoes){
            for(Reserva r : a.getReservas()){
                if(r.getHospedePrincipal().getInfoLogin().getEmail().equals(email)){
                    if(r.getHospedePrincipal().getInfoLogin().getSenha().equals(senha)){
                        return r.getHospedePrincipal().getInfoLogin().getTipoLogin();
                    }
                }
            }
        }
        for(Funcionario f : funcionarios){
            if(f.getInfoLogin().getEmail().equals(email)){
                if(f.getInfoLogin().getSenha().equals(senha)){
                    return f.getInfoLogin().getTipoLogin();
                }
            }
        }
        return null;
    }


}
