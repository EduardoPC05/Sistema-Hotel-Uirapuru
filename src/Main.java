package src;

import src.model.Hotel;
import src.model.pessoa.clientes.Acompanhante;
import src.model.pessoa.clientes.Cliente;
import src.model.pessoa.clientes.Hospede;
import src.model.pessoa.documento.Documento;
import src.model.pessoa.documento.TipoDocumento;
import src.model.pessoa.endereco.Endereco;
import src.model.pessoa.login.InfoLogin;
import src.model.pessoa.login.TipoLogin;
import src.model.reserva.Acomodacao;
import src.model.reserva.Reserva;
import src.model.reserva.TipoQuarto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

public class Main {

    public static <e> void main(String[] args) {


        Hotel hotel = new Hotel();


        Endereco endereco = new Endereco("CE","Fortaleza","123123","Rua das avenidas","123");
        Documento doc = new Documento("Eduardo", "Jucá", LocalDate.of(1999, Month.JANUARY, 1), "br", "123", TipoDocumento.CPF);

        InfoLogin tes = new InfoLogin("@teste","123", TipoLogin.ADMINISTRADOR);

        Cliente ed = new Cliente("Ed",doc,tes);

        Acompanhante e1 = new Acompanhante("Au",doc);

        ArrayList<Acompanhante> a = new ArrayList<Acompanhante>();
        a.add(e1);
        Reserva reserva = hotel.criarReserva(ed,a, TipoQuarto.LUXO,LocalDate.of(2011,Month.OCTOBER,20), LocalDate.of(2011,Month.OCTOBER,30));

        //Reserva reserva2 = hotel.criarReserva(ed,a, TipoQuarto.LUXO,LocalDate.of(2012,Month.OCTOBER,20), LocalDate.of(2013,Month.OCTOBER,30));
        //Reserva reserva3 = hotel.criarReserva(ed,a, TipoQuarto.LUXO,LocalDate.of(2011,Month.OCTOBER,20), LocalDate.of(2011,Month.OCTOBER,30));
//        Reserva reserva4 = hotel.criarReserva(ed,a, TipoQuarto.LUXO,LocalDate.of(2011,Month.OCTOBER,20), LocalDate.of(2011,Month.OCTOBER,30));
//
//        System.out.println(hotel.efetuarCheckIn(reserva, endereco, "12141124",  LocalDateTime.of(2011, Month.OCTOBER, 20,10,0,0)));
//        System.out.println(hotel.efetuarCheckIn(reserva, endereco, "12141124",  LocalDateTime.of(2011, Month.OCTOBER, 20,8,0,0)));
//
//        System.out.println(hotel.efetuarCheckOut(reserva));
//
//        for (Acomodacao c: hotel.getTipoQuartosDisponiveis()){
//            System.out.println(c.getTipoQuarto());
//        }

        System.out.println(hotel.efetuarReserva(reserva));
//        System.out.println(hotel.efetuarReserva(reserva2));
//        System.out.println(hotel.efetuarReserva(reserva3));
//        System.out.println(hotel.efetuarReserva(reserva4));

        System.out.println(hotel.verificaLogin("@teste", "123"));

        /*
           System.out.println(hotel.getAcomodacaoPorTipo(TipoQuarto.LUXO).getReservas().size());
         */


    }
}