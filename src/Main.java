package src;

import src.model.Hotel;
import src.model.pagamento.Boleto;
import src.model.pagamento.MetodosPagamento;
import src.model.pessoa.Endereco;
import src.model.pessoa.Hospede;
import src.model.pessoa.documento.Documento;
import src.model.pessoa.documento.Rg;
import src.model.reserva.Acomodacao;
import src.model.reserva.Reserva;
import src.model.reserva.TipoQuarto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();

        Endereco endereco = new Endereco("CE","Fortaleza","123123","Rua das avenidas","123","Bairro");
        Documento doc = new Rg("Eduardo", "Jucá", "Maria", LocalDate.of(1999, Month.JANUARY, 1), "Fortaleza", LocalDate.of(2010, Month.JANUARY, 1), "123123123", "123123123");
        Hospede eduardo = new Hospede(doc,endereco, 1233123311, "jucas", "email@email.com", true);

        Reserva reserva = new Reserva(eduardo, hotel.getAcomodacaoPorTipo(TipoQuarto.LUXO), LocalDateTime.of(2021, Month.JANUARY, 1, 1, 1), LocalDateTime.of(2021, Month.FEBRUARY, 10, 1, 1));
        hotel.getAcomodacaoPorTipo(TipoQuarto.LUXO).addReserva(reserva);

        Reserva reserva2 = new Reserva(eduardo, hotel.getAcomodacaoPorTipo(TipoQuarto.LUXO), LocalDateTime.of(2021, Month.FEBRUARY, 11, 1, 1), LocalDateTime.of(2021, Month.FEBRUARY, 20, 1, 1));
        Reserva reserva3 = new Reserva(eduardo, hotel.getAcomodacaoPorTipo(TipoQuarto.LUXO), LocalDateTime.of(2021, Month.JANUARY, 10, 1, 1), LocalDateTime.of(2021, Month.JANUARY, 12, 1, 1));
        Reserva reserva4 = new Reserva(eduardo, hotel.getAcomodacaoPorTipo(TipoQuarto.LUXO), LocalDateTime.of(2021, Month.MARCH, 10, 1, 1), LocalDateTime.of(2021, Month.APRIL, 12, 1, 1));
        Reserva reserva5 = new Reserva(eduardo, hotel.getAcomodacaoPorTipo(TipoQuarto.LUXO), LocalDateTime.of(2021, Month.APRIL, 22, 1, 1), LocalDateTime.of(2021, Month.JULY, 12, 1, 1));
        Reserva reserva6 = new Reserva(eduardo, hotel.getAcomodacaoPorTipo(TipoQuarto.NORMAL), LocalDateTime.of(2021, Month.APRIL, 22, 1, 1), LocalDateTime.of(2021, Month.JULY, 12, 1, 1));
        Reserva reserva7 = new Reserva(eduardo, hotel.getAcomodacaoPorTipo(TipoQuarto.NORMAL), LocalDateTime.of(2021, Month.APRIL, 22, 1, 1), LocalDateTime.of(2021, Month.DECEMBER, 12, 1, 1));



        System.out.println(hotel.efetuarReserva(reserva2));
        System.out.println(hotel.efetuarReserva(reserva3));
        System.out.println(hotel.efetuarReserva(reserva4));
        System.out.println(hotel.efetuarReserva(reserva5));
        System.out.println(hotel.efetuarReserva(reserva6));
        System.out.println(hotel.efetuarReserva(reserva7));

        System.out.println(hotel.getAcomodacaoPorTipo(TipoQuarto.LUXO).getReservas().size());

    }
}