package src.model;

import src.model.pessoa.clientes.Acompanhante;
import src.model.pessoa.clientes.Cliente;
import src.model.pessoa.clientes.Hospede;
import src.model.pessoa.documento.Documento;
import src.model.pessoa.documento.InfosBasicas;
import src.model.pessoa.documento.TipoDocumento;
import src.model.pessoa.endereco.Endereco;
import src.model.pessoa.funcionario.Funcionario;
import src.model.pessoa.login.InfoLogin;
import src.model.pessoa.login.TipoLogin;
import src.model.reserva.Acomodacao;
import src.model.reserva.Reserva;
import src.model.reserva.TipoQuarto;
import src.model.reserva.pagamento.TipoPagamento;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hotel {
    private ArrayList<Reserva> reversasAtivas;

    private ArrayList<Funcionario> funcionarios;

    private ArrayList<Acomodacao> acomodacoes;


    public Hotel() {
        // DADOS MOCKADOS

        Acomodacao teste = new Acomodacao("12","12","ELE È BOM DMS", TipoQuarto.LUXO);
        Acomodacao teste2 = new Acomodacao("12","44","ELE È BOM DMS", TipoQuarto.NORMAL);
        Acomodacao teste3 = new Acomodacao("12","44","ELE È BOM DMS", TipoQuarto.SUITE);

        this.acomodacoes = new ArrayList<Acomodacao>();

        acomodacoes.add(teste);
        acomodacoes.add(teste2);
        acomodacoes.add(teste3);

        Endereco endereco = new Endereco("CE","Fortaleza","123123","Rua das avenidas","123");

        InfosBasicas infos = new InfosBasicas(TipoDocumento.RG, "45678");
        Documento doc = new Documento(infos,"Eduardo", "Jucá", LocalDate.of(1999, Month.JANUARY, 1), "br");

        InfoLogin tes = new InfoLogin("@teste","123", TipoLogin.CLIENTE);

        Cliente ed = new Cliente("Ed",infos,tes);

        Reserva reserva = criarReserva(ed, 1, TipoQuarto.LUXO,LocalDate.of(2011,Month.OCTOBER,20), LocalDate.of(2011,Month.OCTOBER,30));

        efetuarReserva(reserva); // reserva efetuada

        efetuarCheckIn(reserva, endereco, doc,"98765", LocalDateTime.of(2011, Month.OCTOBER, 20, 10, 0, 0));

        this.funcionarios = new ArrayList<Funcionario>();
        
        Funcionario adm = criarFuncionario("Admin", criarDocumento(criarInfosBasicas(TipoDocumento.CPF, "123456789")
                ,"admPai", "admMae", LocalDate.of(1960, 05, 10),"BR"),
                criarLogin("@admin", "123", TipoLogin.ADMINISTRADOR));
        addFuncionarios(adm);

        Funcionario rob = criarFuncionario("roberto",doc, criarLogin("@func", "123", TipoLogin.FUNCIONARIO));
        addFuncionarios(rob);

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

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Funcionario removeFuncionario(int index){
        if(funcionarios.get(index).getInfoLogin().getTipoLogin() == TipoLogin.FUNCIONARIO){
            return funcionarios.remove(index);
        }
        return null;
    }

    public ArrayList<Acomodacao> getAcomodacoes() {
        return acomodacoes;
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

    public Cliente criarCliente(String nome, InfosBasicas infos, InfoLogin infoLogin){
        return new Cliente(nome, infos, infoLogin);
    }

    public Funcionario criarFuncionario(String nome, Documento doc, InfoLogin infoLogin){
        Funcionario func = new Funcionario(nome, doc, infoLogin);
        //addFuncionarios(func);
        return func;
    }

    public InfosBasicas criarInfosBasicas(TipoDocumento tipoDocumento, String numeroDocumento){
        return new InfosBasicas(tipoDocumento, numeroDocumento);
    }

    public LocalDate criarData(int dia, int mes, int ano){
        return LocalDate.of(ano, mes, dia);
    }

    public InfoLogin criarLogin(String email, String senha, TipoLogin tipoLogin){
//        if(verificaLogin(email, senha) != null){
//            return null;
//        }
        return new InfoLogin(email, senha, tipoLogin);
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

    public InfosBasicas getInfosPorEmail(String email){
        Reserva reserva;
        for (Acomodacao rs: acomodacoes){
            for (Reserva r: rs.getReservas()){
                if (r.getHospedePrincipal().getInfoLogin().getEmail().equals(email)){
                    return r.getHospedePrincipal().getInfosBasicas();
                }
            }
        }
        return null;
    }
    public Hospede criarHospedes(Cliente cliente,Endereco endereco, String telefone){
       return new Hospede(cliente,endereco,telefone);
    }

    public Documento criarDocumento(InfosBasicas infos, String nomePai, String nomeMae, LocalDate nascimento, String nacionalidade){
        return new Documento(infos, nomePai, nomeMae, nascimento, nacionalidade);
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

    public void addFuncionarios(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public boolean efetuarCheckOut(Reserva reserva, TipoPagamento tipoPagamento, LocalDateTime saida){
        if(reserva.getHospedePrincipal() instanceof Hospede == true) {
            if (reserva.getReservaAtiva()) {
                Cliente cliente = new Cliente(reserva.getHospedePrincipal().getNome(), reserva.getHospedePrincipal().getInfosBasicas(), reserva.getHospedePrincipal().getInfoLogin());
                reserva.setTipoPagamento(tipoPagamento);
                reserva.setHospedePrincipal(cliente);
                reserva.setHorarioSaida(saida);
                return true;
            }
        }
        return false;
    }

    public void efetuarPagamento(Reserva reserva, String nome, String numero, int cvv, int mesValidade, int anoValidade){
        reserva.setPagamentoCartao(nome, numero, cvv, mesValidade, anoValidade);
    }

    public void efetuarPagamento(Reserva reserva){
        String email = reserva.getHospedePrincipal().getInfoLogin().getEmail();
        Acomodacao acomodacao = null;
        double valor = 0;

        for(Acomodacao a : acomodacoes){
            for(Reserva r: a.getReservas()){
                if(r.getHospedePrincipal().getInfoLogin().getEmail().equals(email)){
                    acomodacao = a;
                }
            }
        }

        valor = reserva.getPrecoEstadia(acomodacao);
        LocalDate dataValidade =  reserva.getCheckOut().toLocalDate();
        dataValidade.plusDays(30);
        reserva.setPagamentoBoleto(dataValidade, valor);
    }

    public void efetuarPagamento(Reserva reserva, String nomeBeneficiario){
        reserva.setPagamentoCheque(nomeBeneficiario);
    }

    public String gerarBoleto(double valor, LocalDate dataValidade){
//        LocalDate dataBase = LocalDate.of(1997, 10,7);
//        long data = ChronoUnit.DAYS.between(dataBase, dataValidade.plusDays(30));
//        valor = valor*100;
//        String v =  valor+"";
//        String d = data+"";
//
//        for(int i = 0; i < 14 - (v.length() + d.length()); i++){
//            d += "0";
//        }
//
//        return d + v.format(".0f");

        LocalDate dataBase = LocalDate.of(1997, 10, 7);
        long dias = ChronoUnit.DAYS.between(dataBase, dataValidade) + 30;

        // Formata o valor do boleto (sem vírgula e sem centavos) para garantir 10 dígitos
        String valorFormatado = String.format("%010.0f", valor * 100); // Ajustado para garantir 10 dígitos

        // Formata os dias para garantir 14 dígitos
        String diasFormatados = String.format("%4d", dias);

        // Remove zeros à esquerda
        String codigoBoleto = (diasFormatados + valorFormatado);//.replaceFirst("^0+", "");

        // Adiciona zero no meio
        int length = codigoBoleto.length();
        codigoBoleto = codigoBoleto.substring(0, length / 2) + codigoBoleto.substring(length / 2);

        return codigoBoleto;
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

    public InfoLogin getInfoLoginExistente(String email, String senha){

            for(Acomodacao a : acomodacoes){
                for(Reserva r : a.getReservas()){
                    if(r.getHospedePrincipal().getInfoLogin().getEmail().equals(email)){
                        if(r.getHospedePrincipal().getInfoLogin().getSenha().equals(senha)){
                            return r.getHospedePrincipal().getInfoLogin();
                        }
                    }
                }
            }
            for(Funcionario f : funcionarios){
                if(f.getInfoLogin().getEmail().equals(email)){
                    if(f.getInfoLogin().getSenha().equals(senha)){
                        return f.getInfoLogin();
                    }
                }
            }
            return null;

    }


}
