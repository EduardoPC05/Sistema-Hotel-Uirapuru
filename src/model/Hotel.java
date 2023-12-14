package src.model;

import src.model.pessoa.Funcionario;
import src.model.pessoa.Hospede;
import src.model.reserva.Acomodacao;
import src.model.reserva.Reserva;
import src.model.reserva.TipoQuarto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Hotel {
    private ArrayList<Reserva> reversasAtivas;

    private ArrayList<Funcionario> funcionarios;

    private ArrayList<Acomodacao> acomodacoes;



    public void criarAcomodacao(String andar, String num, String descricao, TipoQuarto tipoQ){
        Acomodacao quarto = new Acomodacao(andar,num,descricao,tipoQ);
        addAcomodacao(quarto);
    }
    public void  verificaQuarto(TipoQuarto e, LocalDateTime inicio, LocalDateTime fim){

    }


    private void addAcomodacao(Acomodacao quarto){
        this.acomodacoes.add(quarto);
    }



}
