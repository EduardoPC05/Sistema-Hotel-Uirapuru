package src.model;

import src.model.pessoa.Pessoa;
import src.model.pessoa.clientes.Cliente;
import src.model.pessoa.clientes.Hospede;
import src.model.pessoa.documento.Documento;
import src.model.pessoa.documento.TipoDocumento;
import src.model.pessoa.endereco.Endereco;
import src.model.pessoa.funcionario.Funcionario;
import src.model.pessoa.login.InfoLogin;
import src.model.reserva.Acomodacao;
import src.model.reserva.Reserva;
import src.model.reserva.TipoQuarto;

import java.time.LocalDate;
import java.util.ArrayList;

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
    public Acomodacao getAcomodacaoPorTipo(TipoQuarto tipoQuarto){
        for (Acomodacao acomodacao: acomodacoes) {
            if(acomodacao.getTipoQuarto() == tipoQuarto){
                return acomodacao;
            }
        }
        return null;
    }
    public boolean removeAcomodacao(String codigo){
        return this.acomodacoes.removeIf(i -> i.getCodigo().equals(codigo));
    }
    private boolean addAcomodacao(Acomodacao quarto){
        return this.acomodacoes.add(quarto);
    }
    private boolean removeAcomodacao(Acomodacao quarto){
        return this.acomodacoes.remove(quarto);
    }

    public ArrayList<Acomodacao> getAcomodacoesPorTipo(TipoQuarto tipo) {
        ArrayList<Acomodacao> acomodacoesPorTipo = new ArrayList<Acomodacao>();
        for (Acomodacao acomodacao: acomodacoes) {
            if(acomodacao.getTipoQuarto() == tipo){
                acomodacoesPorTipo.add(acomodacao);
            }
        }
        return acomodacoesPorTipo;
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

    public boolean excluirReserva(Reserva excluir){
        //TODO
        /*
        * Fazer verificações sobre debitos e outros(pessoa)
        * */
        return removeReserva(excluir);
    }

    private boolean removeReserva(Reserva excluir){
       return this.reversasAtivas.remove(excluir);
    }

    public Hospede criarHospedes(String nome, Documento documento, InfoLogin infoLogin, Endereco endereco, String telefone){
       return new Hospede(nome,documento,infoLogin,endereco,telefone);
    }

    public Endereco criarEndereco( String estado,String cidade,String rua,String numero,String bairro){
        return new Endereco(estado,cidade,rua,numero,bairro);
    };

    public Documento criarDocumento(String nomePai, String nomeMae, LocalDate dtNascimento, String nacionalidade, String numeroDoc, TipoDocumento tipoDocumento){
        return new Documento(nomePai, nomeMae, dtNascimento, nacionalidade, numeroDoc, tipoDocumento);
    }

}
