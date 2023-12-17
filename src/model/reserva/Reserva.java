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
    private int qtdAcompanhantes;
    private ArrayList<Acompanhante> acompanhantes;
    private TipoQuarto tipoQuarto;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;




    public Reserva(Cliente hospedePrincipal, int qtdAcompanhantes,TipoQuarto tipoQuarto, LocalDate checkIn, LocalDate checkOut) {
        this.hospedePrincipal = hospedePrincipal;
        this.qtdAcompanhantes = qtdAcompanhantes;
        this.tipoQuarto = tipoQuarto;
        this.checkIn = LocalDateTime.of(checkIn,LocalTime.of(9,0,0)); // Horário minimo para dar entrada no hotel
        this.checkOut = LocalDateTime.of(checkOut,LocalTime.of(12,0,0)); // Horário maximo para sair do hotel
        this.acompanhantes = null;
    }

    public void addAcompanhantes(Acompanhante acompanhante) {
        acompanhantes.add(acompanhante);
    }

    public void removeAcompanhantes(String nome){
        if(acompanhantes != null){
            for (Acompanhante ac : acompanhantes){
                if (ac.getNome() == nome){
                    acompanhantes.remove(ac);
                }
            }
        }
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

    public boolean getReservaAtiva(){
        if (hospedePrincipal instanceof Hospede){
            return true;
        }
        return false;
    }

}
