package src;

import src.model.Hotel;
import src.model.pessoa.clientes.Acompanhante;
import src.model.pessoa.clientes.Cliente;
import src.model.pessoa.clientes.Hospede;
import src.model.pessoa.documento.Documento;
import src.model.pessoa.documento.InfosBasicas;
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

        InfosBasicas infos = new InfosBasicas(TipoDocumento.RG, "45678");
        Documento doc = new Documento(infos,"Eduardo", "Jucá", LocalDate.of(1999, Month.JANUARY, 1), "br");

        InfoLogin tes = new InfoLogin("@teste","123", TipoLogin.ADMINISTRADOR);

        Cliente ed = new Cliente("Ed",infos,tes);

        Reserva reserva = hotel.criarReserva(ed, 1, TipoQuarto.LUXO,LocalDate.of(2011,Month.OCTOBER,20), LocalDate.of(2011,Month.OCTOBER,30));

//
//        for (Acomodacao c: hotel.getTipoQuartosDisponiveis()){
//            System.out.println(c.getTipoQuarto());
//        }

        System.out.println(hotel.efetuarReserva(reserva));

        System.out.println(hotel.efetuarCheckIn(reserva, endereco, doc,"98765", LocalDateTime.of(2011, Month.OCTOBER, 20, 10, 0, 0)));
        System.out.println(reserva.getHospedePrincipal().hasDocumento(reserva.getHospedePrincipal().getInfosBasicas()));
//        System.out.println(hotel.verificaLogin("@teste", "123"));

//        System.out.println(hotel.getAcomodacaoPorTipo(TipoQuarto.LUXO).getReservas().size());



    }
}