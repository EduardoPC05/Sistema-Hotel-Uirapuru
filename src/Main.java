package src;

import src.model.Hotel;
import src.model.pessoa.clientes.Acompanhante;
import src.model.pessoa.clientes.Hospede;
import src.model.pessoa.documento.Documento;
import src.model.pessoa.documento.TipoDocumento;
import src.model.pessoa.endereco.Endereco;
import src.model.pessoa.login.InfoLogin;
import src.model.pessoa.login.TipoLogin;
import src.model.reserva.Reserva;
import src.model.reserva.TipoQuarto;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();

        Endereco endereco = new Endereco("CE","Fortaleza","123123","Rua das avenidas","123");
        Documento doc = new Documento("Eduardo", "Jucá", LocalDate.of(1999, Month.JANUARY, 1), "br", "123", TipoDocumento.CPF);

        InfoLogin tes = new InfoLogin("@teste","123", TipoLogin.ADMINISTRADOR);

        Hospede ed = new Hospede("Ed",doc,tes,endereco,"21243121");

        Acompanhante e1 = new Acompanhante("Au",doc);

        ArrayList<Acompanhante> a = new ArrayList<Acompanhante>();
        a.add(e1);
        Reserva reserva = new Reserva(ed,a, TipoQuarto.LUXO,LocalDate.of(2011,Month.OCTOBER,20), LocalDate.of(2011,Month.OCTOBER,30));

        Reserva reserva2 = new Reserva(ed,a, TipoQuarto.LUXO,LocalDate.of(2012,Month.OCTOBER,20), LocalDate.of(2013,Month.OCTOBER,30));
        Reserva reserva3 = new Reserva(ed,a, TipoQuarto.LUXO,LocalDate.of(2011,Month.OCTOBER,20), LocalDate.of(2011,Month.OCTOBER,30));
        Reserva reserva4 = new Reserva(ed,a, TipoQuarto.LUXO,LocalDate.of(2011,Month.OCTOBER,20), LocalDate.of(2011,Month.OCTOBER,30));

        System.out.println(hotel.efetuarReserva(reserva));
        System.out.println(hotel.efetuarReserva(reserva2));
        System.out.println(hotel.efetuarReserva(reserva3));
        System.out.println(hotel.efetuarReserva(reserva4));

        System.out.println(hotel.getAcomodacaoPorTipo(TipoQuarto.LUXO).getReservas().size());

    }
}