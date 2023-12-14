package src;

import src.model.pagamento.Boleto;
import src.model.pagamento.MetodosPagamento;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Boleto teste = new Boleto(123.90);

        System.out.println(teste.gerarCodigo());





    }
}