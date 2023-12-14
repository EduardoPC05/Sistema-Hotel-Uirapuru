package src.model.pessoa;

import src.model.pessoa.documento.Documento;
import src.model.reserva.Reserva;

public class Funcionario extends Pessoa {

    private final Reserva reservaResponsavel;

    public Funcionario(Documento documento, Endereco endereco, long telefone, String senha, Reserva reservaResponsavel) {
        super(documento, endereco, telefone, senha);
        this.reservaResponsavel = reservaResponsavel;
    }

    public Reserva getReservaResponsavel() {
        return reservaResponsavel;
    }

    public Boolean fazColeta(){
        //TODO
        return true;
    }

    public Boolean pedidoLavanderia(){
        //TODO
        return true;
    }

    public  Boolean pedidoRestaurante(){
        //TODO
        return true;
    }

}


