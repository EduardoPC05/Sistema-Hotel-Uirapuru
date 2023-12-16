package src.model.reserva;

import src.model.pagamento.MetodosPagamento;
import src.model.pessoa.clientes.Acompanhante;
import src.model.pessoa.clientes.Hospede;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reserva {

    private Hospede hospedePrincipal;
    private ArrayList<Acompanhante> acompanhantes;
    private TipoQuarto tipoQuarto;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reserva(Hospede hospedePrincipal, ArrayList<Acompanhante> acompanhantes,TipoQuarto tipoQuarto, LocalDate checkIn, LocalDate checkOut) {
        this.hospedePrincipal = hospedePrincipal;
        this.acompanhantes = acompanhantes;
        this.tipoQuarto = tipoQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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

    public Hospede getHospedePrincipal() {
        return hospedePrincipal;
    }

    public ArrayList<Acompanhante> getAcompanhantes() {
        return acompanhantes;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
}
