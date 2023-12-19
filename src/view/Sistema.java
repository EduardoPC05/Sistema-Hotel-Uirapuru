package src.view;

import src.model.Hotel;
import src.model.pessoa.documento.TipoDocumento;
import src.model.pessoa.funcionario.Funcionario;
import src.model.pessoa.login.InfoLogin;
import src.model.pessoa.login.TipoLogin;
import src.model.reserva.Acomodacao;
import src.model.reserva.Reserva;
import src.model.reserva.TipoQuarto;
import src.model.reserva.pagamento.TipoPagamento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private Hotel hotel;
    public Sistema() {
        hotel = new Hotel();
    }

    public void initTela(){
        System.out.println("""
                 ██╗  ██╗ ██████╗ ████████╗███████╗██╗         ██╗   ██╗██╗██████╗  █████╗ ██████╗ ██╗   ██╗██████╗ ██╗   ██╗
                 ██║  ██║██╔═══██╗╚══██╔══╝██╔════╝██║         ██║   ██║██║██╔══██╗██╔══██╗██╔══██╗██║   ██║██╔══██╗██║   ██║
                 ███████║██║   ██║   ██║   █████╗  ██║         ██║   ██║██║██████╔╝███████║██████╔╝██║   ██║██████╔╝██║   ██║
                 ██╔══██║██║   ██║   ██║   ██╔══╝  ██║         ██║   ██║██║██╔══██╗██╔══██║██╔═══╝ ██║   ██║██╔══██╗██║   ██║
                 ██║  ██║╚██████╔╝   ██║   ███████╗███████╗    ╚██████╔╝██║██║  ██║██║  ██║██║     ╚██████╔╝██║  ██║╚██████╔╝
                 ╚═╝  ╚═╝ ╚═════╝    ╚═╝   ╚══════╝╚══════╝     ╚═════╝ ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝      ╚═════╝ ╚═╝  ╚═╝ ╚═════╝
                
                """);
        telaInicial();
    }

    private void telaInicial(){
        Scanner scan = new Scanner(System.in);
        int input;
        do{
            System.out.println("""
                                                _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲
                                                ┃     1- Reservar      ┃
                                                ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
                                                _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲_̲̲_̲̲_̲̲_̲̲_̲̲_̲̲_̲
                                                ┃   2- Acessar Conta   ┃
                                                ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
                                                _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲_̲̲_̲̲_̲̲_̲̲_̲̲_̲̲_̲
                                                ┃       3- Hotel       ┃
                                                ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
               
                """);
            input = scan.nextInt();
        }while (input < 0 || input > 3);

        switch (input) {
            case 1:
                telaReservar();
                break;
            case 2:
                telaAcessarConta();
                break;
            case 3:
                telaHotel();
                break;
        }

    }

    private void telaReservar() {
        Scanner scanner = new Scanner(System.in);
        String dataCheckIn;
        String dataCheckOut;
        String nome;
        String numeroDoc = null;
        String email = null;
        String senha = null;
        int diaIn = 0, mesIn = 0, anoIn = 0;
        int diaOut = 0, mesOut = 0, anoOut = 0;
        int qtdAdultos, qtdCriancas;
        int quartoEscolha;
        int docEscolha;
        int loginEscolha;
        TipoDocumento tipoDocumento = null;
        TipoQuarto quarto = null;
        InfoLogin login;
        boolean correct = false;

        do{
            System.out.print("Digite a data de check-in no formato dd/mm/aaaa: ");
            dataCheckIn = scanner.nextLine();

            String[] partes = dataCheckIn.split("/");

            if (partes.length == 3) {
                if(partes[0].length() == 2){
                    if(partes[1].length() == 2){
                        if(partes[2].length() == 4){
                            // Extrair os componentes como inteiros
                            diaIn = Integer.parseInt(partes[0]);
                            mesIn = Integer.parseInt(partes[1]);
                            anoIn = Integer.parseInt(partes[2]);

                            correct = true;
                        }
                    }
                }
            }
            if(!correct){
                System.out.println("Formato de data inválido.");
            }
        }while (!correct);
        correct = false;

        do{
            System.out.print("Digite a data de check-out no formato dd/mm/aaaa: ");
            dataCheckOut = scanner.nextLine();

            String[] partes = dataCheckOut.split("/");

            if (partes.length == 3) {
                if(partes[0].length() == 2){
                    if(partes[1].length() == 2){
                        if(partes[2].length() == 4){
                            // Extrair os componentes como inteiros
                            diaOut = Integer.parseInt(partes[0]);
                            mesOut = Integer.parseInt(partes[1]);
                            anoOut = Integer.parseInt(partes[2]);

                            correct = true;
                        }
                    }
                }
            }
            if(!correct){
                System.out.println("Formato de data inválido.");
            }
        }while (!correct);
        correct = false;

        do{
            System.out.print("Digite a quantidade de adultos: ");
            qtdAdultos = scanner.nextInt();

            System.out.print("Digite a quantidade de crianças: ");
            qtdCriancas = scanner.nextInt();

            if((qtdAdultos > 3 || qtdAdultos < 1) && (qtdCriancas > 2 || qtdCriancas < 0)){
                System.out.println("O limite dos quartos é de no máximo 3 adultos e 2 crianças");
            }
        }while ((qtdAdultos > 3 || qtdAdultos < 1) && (qtdCriancas > 2 || qtdCriancas < 0));

        int i = 1;
        for (Acomodacao c: hotel.getTipoQuartosDisponiveis()){
            System.out.print(i + "- ");
            System.out.print(c.getTipoQuarto());
            System.out.println(" - R$" + c.getPrecoDiaria());
            i++;
        }

        do{
            quartoEscolha = scanner.nextInt();
        }while (quartoEscolha < 1 || quartoEscolha > 3);

        quarto = buscarTipoQuarto(quartoEscolha);

        nome = lerNome();

        do{
            System.out.println("""
                    Escolha o tipo de documento:
                    
                    1 - RG
                    2 - CPF
                    3 - PASSAPORTE
                    
                    """);

            docEscolha = scanner.nextInt();
        }while (docEscolha < 1 || docEscolha > 3);

        switch (docEscolha) {
            case 1:
                tipoDocumento = TipoDocumento.RG;
                break;
            case 2:
                tipoDocumento = TipoDocumento.CPF;
                break;
            case 3:
                tipoDocumento = TipoDocumento.PASSAPORTE;
                break;
        }

        numeroDoc = lerDocumento();


       do{

           login = null;

           if(lerCadastreSe() == 1){
               email = lerEmail();

               senha = lerSenha();
               login = hotel.criarLogin(email, senha, TipoLogin.CLIENTE);
           }else{

               email = lerEmail();

               senha = lerSenha();
               if(hotel.verificaLogin(email, senha) != null){
                   login = hotel.criarLogin(email, senha, TipoLogin.CLIENTE);
               }

           }
           if(login == null){
               System.out.println("Login não encontrado!");
           }
       }while (login == null);


        if(hotel.efetuarReserva(hotel.criarReserva(hotel.criarCliente(nome, hotel.criarInfosBasicas(tipoDocumento, numeroDoc), login),
                qtdAdultos + qtdCriancas, quarto, LocalDate.of(anoIn, mesIn, diaIn), LocalDate.of(anoOut, mesOut, diaOut)))){
            System.out.println("""
                    █▓▒▒░░░Reserva concluida░░░▒▒▓█
                    """);
        }else{
            System.out.println("Desculpe, não possuimos quartos disponíveis para esta data. Por favor tente novamente.");
        }

        try {
                Thread.sleep(1000);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        initTela();
    }

    private TipoQuarto buscarTipoQuarto(int quartoEscolha){
        TipoQuarto quarto = null;
        switch (quartoEscolha){
            case 1:
                quarto = TipoQuarto.NORMAL;
                break;
            case 2:
                quarto = TipoQuarto.SUITE;
                break;
            case 3:
                quarto = TipoQuarto.LUXO;
                break;
        }
        return quarto;
    }

    private String lerNome(){
        System.out.println("Digite nome: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String lerDocumento(){
        System.out.println("Digite o numero do documento: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String lerEmail(){
        System.out.println("Digite seu email: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String lerSenha(){
        System.out.println("Digite uma senha: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int lerCadastreSe(){
        System.out.println("1 - Cadastre-se");
        System.out.println("2 - Login");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void telaAcessarConta(){
        Scanner scanner = new Scanner(System.in);
        String email;
        String senha;

        System.out.println("Digite seu email: ");
        email = scanner.nextLine();

        System.out.println("Digite sua senha: ");
        senha = scanner.nextLine();

        if(hotel.verificaLogin(email, senha) != null){
            int input;
            do{
                System.out.println("""
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲_̲_̲_̲_̲_̲_̲_̲
                                      ┃ 1- Consulta Reservas  ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲_̲_̲_̲_̲_̲̲_̲_̲_̲_̲
                                      ┃    2- Pagar contas    ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
               
                """);
                input = scanner.nextInt();
            }while (input < 0 || input > 2);

            switch (input) {
                case 1:
                    telaConsultarReservas(email, senha);
                    break;
                case 2:
                    telaPagarContas(email, senha);
                    break;
                default:
                    initTela();
                    break;
            }

        }else {
            System.out.println("\n***Login não encontrado***\n");
            try {
                Thread.sleep(2000);
            }
            catch (Exception e) {
                System.out.println(e);
            }
            initTela();
        }


    }

    private void telaConsultarReservas(String email, String senha){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Reserva> reservas = null;

        System.out.println("\n***Tela Consultar Reserva***\n");

        switch (hotel.verificaLogin(email,senha)){
            case CLIENTE, HOSPEDE:
                reservas = hotel.getReservas(email);
                break;
            case FUNCIONARIO:
                break;
            case ADMINISTRADOR:
                break;
            case null:
                System.out.println("Login não encontrado!");
                break;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        int i = 1;
        if(reservas != null){
            for(Reserva r : reservas){
                System.out.println("----------------------------------");
                System.out.println("Reserva "+i);
                System.out.println("Check-in -> "+ r.getCheckIn().format(formatter));
                System.out.println("Check-out -> "+ r.getCheckOut().format(formatter));
                System.out.println("Tipo do quarto -> "+r.getTipoQuarto());
                System.out.println("Preço ->"+r.getPrecoPorTipo(r.getTipoQuarto()));
                System.out.println("----------------------------------");
                i++;
            }
        }


        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        initTela();
    }

    private void telaPagarContas(String email, String senha){
        Scanner scanner = new Scanner(System.in);
        Reserva reserva;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        int confirm = 0;
        double valor = 0;
        LocalDate dataValidade = null;
        Boolean flag = false;


        reserva = hotel.getReservas(email).getFirst();

        ArrayList<Reserva> reservas = null;
        reservas = hotel.getReservas(email);

        int i = 1;
        if(reservas != null){
            for(Reserva r : reservas){
                if(r.getContasAPagar() != 0){

                    for(Acomodacao a : hotel.getAcomodacoes()){
                        for(Reserva rs: a.getReservas()){
                            if(rs.equals(r)) {

                                System.out.println("----------------------------------");
                                System.out.println("Reserva " + i);
                                System.out.println("Check-in -> " + r.getCheckIn().format(formatter));
                                System.out.println("Check-out -> " + r.getCheckOut().format(formatter));
                                System.out.println("Tipo do quarto -> " + r.getTipoQuarto());
                                System.out.println("Valor a pagar ->" + r.getPrecoEstadia(a));
                                System.out.println("----------------------------------");

                                valor = r.getPrecoEstadia(a);
                                dataValidade = r.getCheckOut().toLocalDate();
                                flag = true;
                                i++;
                            }
                        }
                    }


                }
                //i++;
            }
        }

        if(!flag){
            System.out.println("\n***Você não possui pagamentos pendentes***\n");
            initTela();
        }else{
            do{
                System.out.println("CONTINUAR COM PAGAMENTO?");
                System.out.println("1- SIM");
                System.out.println("2- NÃO");

                confirm = scanner.nextInt();
            }while (confirm < 1 || confirm > 2);

            switch (reserva.getContasAPagar()){
                case 1:
                    pagamentoCartao(email);
                    break;
                case 2:
                    pagamentoBoleto(email, valor, dataValidade);
                    break;
                case 3:
                    pagamentoCheque(email);
                    break;
            }
        }


    }

    private void telaHotel() {
        Scanner scanner = new Scanner(System.in);
        String email;
        String senha;
        ArrayList<Reserva> reservas = null;

        System.out.println("Logar como Funcionário ou ADMIN");

        System.out.println("Digite seu email: ");
        email = scanner.nextLine();

        System.out.println("Digite sua senha: ");
        senha = scanner.nextLine();

        switch (hotel.verificaLogin(email,senha)){
            case CLIENTE:
                System.out.println("Esta não é uma conta de um Funcionário");
                telaHotel();
                break;
            case HOSPEDE:
                System.out.println("Esta não é uma conta de um Funcionário");
                telaHotel();
                break;
            case FUNCIONARIO:
                System.out.println("""
                    
                    █▓▒▒░░░Logado como Funcionário!░░░▒▒▓█
                    
                    """);
                telaFuncionario();
                break;
            case ADMINISTRADOR:
                System.out.println("""
                    
                    █▓▒▒░░░Logado como Admin!░░░▒▒▓█
                    
                    """);
                telaAdmin();
                break;
            case null:
                System.out.println("Login não encontrado!");
                initTela();
                break;
        }
    }

    private void telaFuncionario(){
        Scanner scanner = new Scanner(System.in);


        int input;
        do{
            System.out.println("""
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲
                                      ┃ 1- Fazer check-in de um cliente   ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲
                                      ┃ 2- Fazer check-out de um cliente  ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲
                                      ┃         3- ver reservas           ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
               
                """);
            input = scanner.nextInt();
        }while (input < 0 || input > 3);

        switch (input) {
            case 1:
                telaCheckIn();
                break;
            case 2:
                telaCheckOut();
                break;
            case 3:
                telaVerReservas();
                break;
            case 0:
                initTela();
                break;
        }


    }

    private void telaCheckIn(){
        Scanner scanner = new Scanner(System.in);
        String email;
        String cidade;
        String estado;
        String rua;
        String numero;
        String bairro;
        String nacionalidade;
        String nomePai;
        String nomeMae;
        String dataNascimento;
        String telefone;
        String dataChegada;
        String horaChegada;
        int dia = 0, mes = 0, ano = 0;
        int dChegada = 0, mChegada = 0, aChegada = 0;
        int hChegada = 0, minChegada = 0;
        Boolean correct = false;
        Reserva reserva;

        do{
            System.out.println("Digite o email do Cliente: ");
            email = scanner.nextLine();
            reserva = hotel.getReservas(email).getFirst();
            if(reserva == null){
                System.out.println("Email não encontrado ou cliente sem reservas");
            }
        }while (reserva == null);

        System.out.println("\n***Adicionar Endereço do Hospede***\n");

        System.out.println("Cidade: ");
        cidade = scanner.nextLine();

        System.out.println("Estado: ");
        estado = scanner.nextLine();

        System.out.println("Rua: ");
        rua = scanner.nextLine();

        System.out.println("Número: ");
        numero = scanner.nextLine();

        System.out.println("Bairro: ");
        bairro = scanner.nextLine();

        System.out.println("\n***Adicionar Dados do documento do hóspede***\n");

        System.out.println("Nome do pai: ");
        nomePai = scanner.nextLine();

        System.out.println("Nome da mãe: ");
        nomeMae = scanner.nextLine();

        do{
            System.out.print("Data de nascimento no formato dd/mm/aaaa: ");
            dataNascimento = scanner.nextLine();

            String[] partes = dataNascimento.split("/");

            if (partes.length == 3) {
                if(partes[0].length() == 2){
                    if(partes[1].length() == 2){
                        if(partes[2].length() == 4){
                            // Extrair os componentes como inteiros
                            dia = Integer.parseInt(partes[0]);
                            mes = Integer.parseInt(partes[1]);
                            ano = Integer.parseInt(partes[2]);

                            correct = true;
                        }
                    }
                }
            }
            if(!correct){
                System.out.println("Formato de data inválido.");
            }
        }while (!correct);
        correct = false;

        System.out.println("Nacionalidade: ");
        nacionalidade = scanner.nextLine();

        System.out.println("Telefone");
        telefone = scanner.nextLine();

        do{
            System.out.print("Data de chegada do hóspede dd/mm/aaaa: ");
            dataChegada = scanner.nextLine();

            String[] partes = dataChegada.split("/");

            if (partes.length == 3) {
                if(partes[0].length() == 2){
                    if(partes[1].length() == 2){
                        if(partes[2].length() == 4){
                            // Extrair os componentes como inteiros
                            dChegada = Integer.parseInt(partes[0]);
                            mChegada = Integer.parseInt(partes[1]);
                            aChegada = Integer.parseInt(partes[2]);

                            correct = true;
                        }
                    }
                }
            }
            if(!correct){
                System.out.println("Formato de data inválido.");
            }
        }while (!correct);
        correct = false;

        do{
            System.out.print("Hora e minuto de chegada do hóspede hh:mm: ");
            horaChegada= scanner.nextLine();

            String[] partes = horaChegada.split(":");

            if (partes.length == 2) {
                if(partes[0].length() == 2){
                    if(partes[1].length() == 2){
                        // Extrair os componentes como inteiros
                        hChegada = Integer.parseInt(partes[0]);
                        minChegada = Integer.parseInt(partes[1]);

                        correct = true;

                    }
                }
            }
            if(!correct){
                System.out.println("Formato de hora e data inválido.");
            }
        }while (!correct);

        System.out.println("DESEJA ADICIONAR ACOMPANHANTES?");
        System.out.println("1- SIM");
        System.out.println("2- NÃO");
        int acoEscolha = scanner.nextInt();

        if(acoEscolha == 1){
            int adicionar = 1;
            int docEscolha = 0;
            String numeroDoc;
            TipoDocumento tipoDocumento = null;
            while (adicionar == 1){
                String nome = lerNome();

                do{
                    System.out.println("""
                    Escolha o tipo de documento:
                    
                    1 - RG
                    2 - CPF
                    3 - PASSAPORTE
                    
                    """);

                    docEscolha = scanner.nextInt();
                }while (docEscolha < 1 || docEscolha > 3);

                switch (docEscolha) {
                    case 1:
                        tipoDocumento = TipoDocumento.RG;
                        break;
                    case 2:
                        tipoDocumento = TipoDocumento.CPF;
                        break;
                    case 3:
                        tipoDocumento = TipoDocumento.PASSAPORTE;
                        break;
                }

                numeroDoc = lerDocumento();

                hotel.cadastrarAcompanhante(reserva, nome, hotel.criarInfosBasicas(tipoDocumento, numeroDoc));

                if(reserva.getAcompanhantes().size() < reserva.getQtdAcompanhantes() - 1){
                    System.out.println("ADICIONAR MAIS ACOMPANHANTES?");
                    System.out.println("1- SIM");
                    System.out.println("2- NÃO");
                    adicionar = scanner.nextInt();
                }else {
                    adicionar = 2;
                }
            }
        }

        if(hotel.efetuarCheckIn(reserva,hotel.criarEndereco(estado, cidade, rua, numero, bairro),
                hotel.criarDocumento(hotel.getInfosPorEmail(email), nomePai, nomeMae, LocalDate.of(ano, mes, dia),nacionalidade),
                telefone,  LocalDateTime.of(aChegada, mChegada, dChegada, hChegada, minChegada))){
            System.out.println("""
                    
                    █▓▒▒░░░Check-in confirmado!░░░▒▒▓█
                    
                    """);
        }else {
            System.out.println("\n***Check-in não confirmado***\n");
            System.out.println("TENTAR NOVAMENTE?");
            System.out.println("1- SIM");
            System.out.println("2- NÃO");
            if(scanner.nextInt() == 1){
                telaFuncionario();
            }
        }

        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        initTela();
    }

    private void telaCheckOut(){
        Scanner scanner = new Scanner(System.in);
        String email;
        Reserva reserva;
        String dataSaida;
        String horaSaida;
        int dSaida = 0, mSaida = 0, aSaida = 0;
        int hSaida = 0, minSaida = 0;
        TipoPagamento tipoPagamento = null;
        Boolean correct = false;

        System.out.println("Digite o email do hóspede: ");
        do {

            email = scanner.nextLine();
            reserva = hotel.getReservas(email).getFirst();
            if (reserva == null){
                System.out.println("Email não encontrado");
                System.out.println("Digite um email válido: ");
            }
        }while (reserva == null);


        do{
            System.out.print("Data de saíd do hóspede dd/mm/aaaa: ");
            dataSaida = scanner.nextLine();

            String[] partes = dataSaida.split("/");

            if (partes.length == 3) {
                if(partes[0].length() == 2){
                    if(partes[1].length() == 2){
                        if(partes[2].length() == 4){
                            // Extrair os componentes como inteiros
                            dSaida = Integer.parseInt(partes[0]);
                            mSaida = Integer.parseInt(partes[1]);
                            aSaida = Integer.parseInt(partes[2]);

                            correct = true;
                        }
                    }
                }
            }
            if(!correct){
                System.out.println("Formato de data inválido.");
            }
        }while (!correct);
        correct = false;

        do{
            System.out.print("Hora e minuto de saída do hóspede hh:mm: ");
            horaSaida= scanner.nextLine();

            String[] partes = horaSaida.split(":");

            if (partes.length == 2) {
                if(partes[0].length() == 2){
                    if(partes[1].length() == 2){
                        // Extrair os componentes como inteiros
                        hSaida = Integer.parseInt(partes[0]);
                        minSaida = Integer.parseInt(partes[1]);

                        correct = true;

                    }
                }
            }
            if(!correct){
                System.out.println("Formato de hora e data inválido.");
            }
        }while (!correct);

        System.out.println("\n***Selecione o tipo de pagamento do Hóspede***\n");

        int input;
        do{
            System.out.println("1- Cartão");
            System.out.println("2- Boleto");
            System.out.println("3- Cheque");
            input = scanner.nextInt();
        }while (input < 0 || input > 3);

        switch (input) {
            case 1:
                tipoPagamento = TipoPagamento.CARTAO;
                break;
            case 2:
                tipoPagamento = tipoPagamento.BOLETO;
                break;
            case 3:
                tipoPagamento = tipoPagamento.CHEQUE;
                break;
        }

        reserva.setTipoPagamento(tipoPagamento);

        hotel.efetuarCheckOut(reserva, reserva.getTipoPagamento(), LocalDateTime.of(aSaida, mSaida, dSaida, hSaida, minSaida));

        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        initTela();
    }

    private void telaAdmin(){
        Scanner scanner = new Scanner(System.in);


        int input;
        do{
            System.out.println("""
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲
                                      ┃     1- Atuar como funcionário     ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲
                                      ┃        2- Atuar como ADMIN        ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
               
                """);
            input = scanner.nextInt();
        }while (input < 0 || input > 2);

        switch (input) {
            case 1:
                telaFuncionario();
                break;
            case 2:
                telaAdminAcessar();
                break;
            case 0:
                initTela();
                break;
        }
    }

    private void telaAdminAcessar(){
        Scanner scanner = new Scanner(System.in);


        int input;
        do{
            System.out.println("""
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲
                                      ┃      1- Lista de funcionários     ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲
                                      ┃     2- Adicionar Funcionários     ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲
                                      ┃      3- Remover Funcionários      ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲
                                      ┃      4- Lista de Acomodações      ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲
                                      ┃      5- Adicionar Acomodações     ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲
                                      ┃       6- Remover Acomodações      ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾                                 
               
                """);
            input = scanner.nextInt();
        }while (input < 0 || input > 6);

        switch (input) {
            case 1:
                telaListaFuncionarios();
                break;
            case 2:
                telaAdicionarFuncionarios();
                break;
            case 3:
                telaRemoverFuncionário();
                break;
            case 4:
                telaListaAcomodacoes();
                break;
            case 5:
                telaAdicionarAcomodacoes();
                break;
            case 6:
                telaRemoverAcomodacoes();
                break;
            case 0:
                initTela();
                break;
        }
    }

    private void telaVerReservas(){
        Scanner scanner = new Scanner(System.in);


        int input;
        do{
            System.out.println("""
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲
                                      ┃   1- ver histórico de reservas    ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
                                      _̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲̲_̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲̲̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲_̲
                                      ┃      2- ver reservas ativas       ┃
                                      ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
               
                """);
            input = scanner.nextInt();
        }while (input < 0 || input > 2);

        switch (input) {
            case 1:
                telaHistoricoReservas();
                break;
            case 2:
                telaReservasAtivas();
                break;
            default:
                initTela();
                break;
        }

    }

    private void telaHistoricoReservas(){
        Reserva reserva;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        int i = 1;
        for(Acomodacao a: hotel.getAcomodacoes()) {
            for (Reserva r : a.getReservas()) {
                System.out.println("----------------------------------");
                System.out.println("Reserva " + i);
                System.out.println("Hospede principal "+ r.getHospedePrincipal().getNome()+ " / email: "+r.getHospedePrincipal().getInfoLogin().getEmail());
                System.out.println("Check-in -> " + r.getCheckIn().format(formatter));
                System.out.println("Check-out -> " + r.getCheckOut().format(formatter));
                System.out.println("Tipo do quarto -> " + r.getTipoQuarto());
                System.out.println("Preço -> R$" + r.getPrecoPorTipo(r.getTipoQuarto()));
                System.out.println("Reserva está ativa? "+ (r.getReservaAtiva()? "SIM" : "NÃO"));
                System.out.print("Possui pagamento pendente? ");
                if(r.getContasAPagar() != 0){
                    System.out.println("SIM");
                }else {
                    System.out.println("NÃO");
                }
                System.out.println("----------------------------------");
                i++;
            }
        }


        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        initTela();
    }

    private void telaReservasAtivas(){
        Reserva reserva;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        int i = 1;
        for(Acomodacao a: hotel.getAcomodacoes()) {
            for (Reserva r : a.getReservas()) {
                if(r.getReservaAtiva()) {
                    System.out.println("----------------------------------");
                    System.out.println("Reserva " + i);
                    System.out.println("Hospede principal " + r.getHospedePrincipal().getNome() + " / email: " + r.getHospedePrincipal().getInfoLogin().getEmail());
                    System.out.println("Check-in -> " + r.getCheckIn().format(formatter));
                    System.out.println("Check-out -> " + r.getCheckOut().format(formatter));
                    System.out.println("Tipo do quarto -> " + r.getTipoQuarto());
                    System.out.println("Preço -> R$" + r.getPrecoPorTipo(r.getTipoQuarto()));
                    System.out.println("----------------------------------");
                    i++;
                }
            }
        }

        if(i == 1){
            System.out.println("Não há reservas ativas");
        }


        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        initTela();
    }

    private void pagamentoCartao(String email){
        Scanner scanner = new Scanner(System.in);
        Reserva reserva;
        String nome;
        String numero;
        int cvv = 0;
        int mesValidade = 0;
        int anoValidade = 0;


        reserva = hotel.getReservas(email).getFirst();

        System.out.println("\n***Pagamento com cartão***\n");

        System.out.println("Digite o nome que está no cartão: ");
        nome = scanner.nextLine();

        System.out.println("Digite o numero do cartão: ");
        numero = scanner.nextLine();

        System.out.println("Digite o CVV do cartão: ");
        cvv = scanner.nextInt();

        System.out.println("Digite o mes de validade de cartão: ");
        mesValidade = scanner.nextInt();

        System.out.println("Digite o ano de validade de cartão: ");
        anoValidade = scanner.nextInt();

        System.out.println("""
                    
                    █▓▒▒░░░Fatura paga!░░░▒▒▓█
                    
                    """);

        hotel.efetuarPagamento(reserva, nome, numero, cvv, mesValidade, anoValidade);
        initTela();
    }

    private void pagamentoBoleto(String email, double valor, LocalDate dataValidade){
        Reserva reserva;
        ArrayList<Reserva> reservas = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        reserva = hotel.getReservas(email).getFirst();

        System.out.println("Código do boleto: "+ hotel.gerarBoleto(valor, dataValidade));
        System.out.println("Valor do boleto: R$ "+valor);
        System.out.println(dataValidade.format(formatter));

        try {
            System.out.println("Pendente...");
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("Confirmando pagamento...");
            Thread.sleep(1000);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("""
                    
                    █▓▒▒░░░Boleto pago!░░░▒▒▓█
                    
                    """);

        hotel.efetuarPagamento(reserva);
        initTela();
    }

    private  void pagamentoCheque(String email){
        Scanner scanner = new Scanner(System.in);
        String nome;
        Reserva reserva;

        reserva = hotel.getReservas(email).getFirst();
        System.out.println("Digite o nome do beneficiário: ");
        nome = scanner.nextLine();

        System.out.println("""
                    
                    █▓▒▒░░░Cheque enviado!░░░▒▒▓█
                    
                    """);

        hotel.efetuarPagamento(reserva, nome);
        initTela();
    }

    private void telaAdicionarFuncionarios(){
        Scanner scanner = new Scanner(System.in);
        String nome;
        String numeroDoc;
        String nomePai;
        String nomeMae;
        String nacionalidade;
        String dataNascimento;
        String email;
        String senha;
        int dia = 0, mes = 0, ano = 0;
        int docEscolha = 0;
        int escolhaTipoLogin = 0;
        TipoDocumento tipoDocumento = null;
        Boolean correct = false;
        TipoLogin tipoLogin = null;

        System.out.println("\n***Adicionar Funcionário***\n");

        System.out.println("Digite o nome do funcionário: ");
        nome = scanner.nextLine();

        do{
            System.out.println("""
                    Escolha o tipo de documento:
                    
                    1 - RG
                    2 - CPF
                    3 - PASSAPORTE
                    
                    """);

            docEscolha = scanner.nextInt();
        }while (docEscolha < 1 || docEscolha > 3);

        switch (docEscolha) {
            case 1:
                tipoDocumento = TipoDocumento.RG;
                break;
            case 2:
                tipoDocumento = TipoDocumento.CPF;
                break;
            case 3:
                tipoDocumento = TipoDocumento.PASSAPORTE;
                break;
        }

        System.out.println("Digite o número do documento");
        numeroDoc = scanner.nextLine();

        System.out.println("Nome do Pai: ");
        nomePai = scanner.nextLine();

        System.out.println("Nome da Mãe: ");
        nomeMae = scanner.nextLine();

        do{
            System.out.print("Data de nascimento no formato dd/mm/aaaa: ");
            dataNascimento = scanner.nextLine();

            String[] partes = dataNascimento.split("/");

            if (partes.length == 3) {
                if(partes[0].length() == 2){
                    if(partes[1].length() == 2){
                        if(partes[2].length() == 4){
                            // Extrair os componentes como inteiros
                            dia = Integer.parseInt(partes[0]);
                            mes = Integer.parseInt(partes[1]);
                            ano = Integer.parseInt(partes[2]);

                            correct = true;
                        }
                    }
                }
            }
            if(!correct){
                System.out.println("Formato de data inválido.");
            }
        }while (!correct);

        System.out.println("Nacionalidade: ");
        nacionalidade = scanner.nextLine();

        System.out.println("Email do funcionário: ");
        email = scanner.nextLine();

        System.out.println("Criar senha: ");
        senha = scanner.nextLine();

        do{
            System.out.println("Escolha o nível de acesso do funcionário: ");
            System.out.println("1- Funcionário");
            System.out.println("2- ADMIN");
            escolhaTipoLogin = scanner.nextInt();
        }while (escolhaTipoLogin < 1 || escolhaTipoLogin > 2);

        switch (escolhaTipoLogin){
            case 1:
                tipoLogin = TipoLogin.FUNCIONARIO;
                break;
            case 2:
                tipoLogin = TipoLogin.ADMINISTRADOR;
                break;
        }

        hotel.addFuncionarios(hotel.criarFuncionario(nome, hotel.criarDocumento(
                        hotel.criarInfosBasicas(tipoDocumento, numeroDoc),nomePai, nomeMae, LocalDate.of(ano, mes, dia), nacionalidade),
                hotel.criarLogin(email, senha, tipoLogin)));

        System.out.println("""
                    
                    █▓▒▒░░░Funcionario contratado!!░░░▒▒▓█
                    
                    """);

        initTela();
    }

    private void telaRemoverFuncionário(){
        Scanner scanner = new Scanner(System.in);
        int index = 0;

        System.out.println("\n***Lista de Funcionários***");

        int i = 1;
        for(Funcionario f: hotel.getFuncionarios()){
            System.out.println("---------------------------");
            System.out.println("Índice "+i);
            System.out.println("Nome: "+f.getNome()+" / Email: "+f.getInfoLogin().getEmail());
            System.out.println("Cargo: "+f.getInfoLogin().getTipoLogin());
            System.out.println(f.getInfosBasicas().getTipoDocumento()+": "+f.getInfosBasicas().getNumeroDocumento());
            System.out.println("---------------------------");
            i++;
        }

        do{
            System.out.println("Digite qual funcionário remover (por índice): ");
            index = scanner.nextInt();
            index -= 1;
            if(index < 0 || index > hotel.getFuncionarios().size() -1){
                System.out.println("Índice não existente");
            }
        }while (index < 0 || index > hotel.getFuncionarios().size() -1);

        if(hotel.removeFuncionario(index) == null){
            System.out.println("Não é possível remover ADMINs");
        }else{
            System.out.println("""
                    
                    █▓▒▒░░░Funcionario removido!!░░░▒▒▓█
                    
                    """);
        }

        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        initTela();
    }

    private void telaListaFuncionarios(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n***Lista de Funcionários***");

        int i = 1;
        for(Funcionario f: hotel.getFuncionarios()){
            System.out.println("---------------------------");
            System.out.println("Índice "+i);
            System.out.println("Nome: "+f.getNome()+" / Email: "+f.getInfoLogin().getEmail());
            System.out.println("Cargo: "+f.getInfoLogin().getTipoLogin());
            System.out.println(f.getInfosBasicas().getTipoDocumento()+": "+f.getInfosBasicas().getNumeroDocumento());
            System.out.println("---------------------------");
            i++;
        }

        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        initTela();
    }

    private void telaAdicionarAcomodacoes(){
        Scanner scanner = new Scanner(System.in);
        String andar;
        String num;
        String descricao;
        int escolhaQuarto;
        TipoQuarto tipoQuarto = null;

        System.out.println("\n***Adicionar quarto***\n");

        System.out.println("Digite o andar do quarto a ser adicionado: ");
        andar = scanner.nextLine();

        System.out.println("Digite o número do quarto a ser adicionado: ");
        num = scanner.nextLine();

        System.out.println("Digite a descrição do quarto a ser adicionado: ");
        descricao = scanner.nextLine();

        do{
            System.out.println("Escolha o tipo do quarto: ");
            System.out.println("1- NORMAL");
            System.out.println("2- SUITE");
            System.out.println("3- LUXO");

            escolhaQuarto = scanner.nextInt();
        }while (escolhaQuarto < 1 || escolhaQuarto > 3);

        switch (escolhaQuarto){
            case 1:
                tipoQuarto = TipoQuarto.NORMAL;
                break;
            case 2:
                tipoQuarto = TipoQuarto.SUITE;
                break;
            case 3:
                tipoQuarto = TipoQuarto.LUXO;
                break;
        }

        if(hotel.criarAcomodacao(andar, num, descricao, tipoQuarto)){
            System.out.println("""
                    
                    █▓▒▒░░░Acomodação criada!!░░░▒▒▓█
                    
                    """);
        }else{
            System.out.println("Não foi possível adicionar o quarto. número e andar já existente.");
            telaAdicionarAcomodacoes();
        }

        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        initTela();
    }

    private void telaListaAcomodacoes(){

        System.out.println("\n***Lista de Acomodações***\n");

        int i = 1;
        for (Acomodacao a: hotel.getAcomodacoes()){
            System.out.println("----------------------");
            System.out.println("Índice: "+i);
            System.out.println("Quarto: "+a.getCodigo());
            System.out.println("Descrição: "+a.getDescricao());
            System.out.println("Tipo: "+a.getTipoQuarto());
            System.out.println("Preço diária: R$"+a.getPrecoDiaria()+" /dia");
            System.out.println("Limite de adultos: "+a.getLimiteAdultos());
            System.out.println("Limite de crianças: "+a.getLimiteCriancas());
            System.out.println("----------------------");
            i++;
        }

        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        initTela();
    }

    private void telaRemoverAcomodacoes(){
        Scanner scanner = new Scanner(System.in);
        String codigo;
        System.out.println("Digite o número da acomodaçãoa ser removida");
        codigo = scanner.nextLine();

        if(hotel.removerAcomodacao(codigo)){
            System.out.println("""
                    
                    █▓▒▒░░░Acomodação Removida!!░░░▒▒▓█
                    
                    """);
        }else{
            System.out.println("Acomodação inexistente");
        }

        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        initTela();
    }
}
