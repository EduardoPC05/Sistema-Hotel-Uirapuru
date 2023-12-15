package src.model;

import src.model.pessoa.Endereco;
import src.model.pessoa.Funcionario;
import src.model.pessoa.Hospede;
import src.model.pessoa.documento.Documento;
import src.model.pessoa.documento.Passaporte;
import src.model.pessoa.documento.Rg;
import src.model.reserva.Acomodacao;
import src.model.reserva.Reserva;
import src.model.reserva.TipoQuarto;

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
        /*
        Acomodacao teste = new Acomodacao("12","12","ELE È BOM DMS", TipoQuarto.LUXO);
        Acomodacao teste1 = new Acomodacao("12","33","ELE È BOM DMS", TipoQuarto.LUXO);
        Acomodacao teste2 = new Acomodacao("12","44","ELE È BOM DMS", TipoQuarto.NORMAL);
        Acomodacao teste3 = new Acomodacao("12","44","ELE È BOM DMS", TipoQuarto.SUITE);

        this.acomodacoes = new ArrayList<Acomodacao>();
        acomodacoes.add(teste);
        acomodacoes.add(teste1);
        acomodacoes.add(teste2);
        acomodacoes.add(teste3);

         */
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
    private boolean addAcomodacao(Acomodacao quarto){
        return this.acomodacoes.add(quarto);
    }
    private boolean removeAcomodacao(Acomodacao quarto){
        return this.acomodacoes.remove(quarto);
    }
    private ArrayList<Acomodacao> getAcomodacoesPorTipo(TipoQuarto tipo) {
        ArrayList<Acomodacao> acomodacoesPorTipo = new ArrayList<Acomodacao>();
        for (Acomodacao acomodacao: acomodacoes) {
            if(acomodacao.getTipoQuarto() == tipo){
                acomodacoesPorTipo.add(acomodacao);
            }
        }
        return acomodacoesPorTipo;
    }


    public boolean efetuarReserva(Reserva nova){
        ArrayList<Acomodacao> acomodacoes = getAcomodacoesPorTipo(nova.getAcomodacao().getTipoQuarto());

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


    public Hospede criarHospedes(Documento doc,Endereco end,long tel,String senha, String email, Boolean principal){
       return new Hospede(doc,end,tel, senha,email, principal);
    }

    public Endereco criarEndereco(String estado,String cidade, String cep,String rua, String numRua, String bairro){
        return new Endereco(estado,cidade,cep,rua,numRua,bairro);
    };

    public Documento criarDocumento(String nome, String nomePai, String nomeMae, LocalDate dtNascimento,String naturalidade,LocalDate expedicao, String rg, String cpf){
        return new Rg(nome,nomePai,nomeMae,dtNascimento,naturalidade,expedicao,rg,cpf);
    }
    public Documento criarDocumento(String nome, String nomePai, String nomeMae, LocalDate dtnascimento,String naturalidade,LocalDate dtexpedicao, String number, String nacionalidade, LocalDate dtVencimento){
        return new Passaporte(nome,nomePai,nomeMae,dtnascimento,naturalidade,dtexpedicao,number,nacionalidade,dtVencimento);
    }

}
