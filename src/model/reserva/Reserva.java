package src.model.reserva;

import src.model.pessoa.clientes.Acompanhante;
import src.model.pessoa.clientes.Cliente;
import src.model.pessoa.clientes.Hospede;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Reserva {

    private Cliente hospedePrincipal;
    private ArrayList<Acompanhante> acompanhantes;
    private TipoQuarto tipoQuarto;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;




    public Reserva(Cliente hospedePrincipal, ArrayList<Acompanhante> acompanhantes,TipoQuarto tipoQuarto, LocalDate checkIn, LocalDate checkOut) {
        this.hospedePrincipal = hospedePrincipal;
        this.acompanhantes = acompanhantes;
        this.tipoQuarto = tipoQuarto;
        this.checkIn = LocalDateTime.of(checkIn,LocalTime.of(9,0,0)); // Horário minimo para dar entrada no hotel
        this.checkOut = LocalDateTime.of(checkOut,LocalTime.of(12,0,0)); // Horário maximo para sair do hotel
    }

    public void addAcompanhantes(Acompanhante acompanhante) {
        acompanhantes.add(acompanhante);
    }

    public void removeAcompanhantes(Acompanhante acompanhante){
        acompanhantes.remove(acompanhante);
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public Cliente getHospedePrincipal() {
        return hospedePrincipal;
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
}
