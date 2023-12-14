package src.model.pessoa.documento;

import java.time.LocalDate;

public class Passaporte extends Documento{

   private String number;
   private String nacionalidade;
   private LocalDate dataVencimento;

   public Passaporte(String nome, String nomePai, String nomeMae, LocalDate dataNascimento, String naturalidade, LocalDate dataExpedicao, String number, String nacionalidade, LocalDate dataVencimento) {
      super(nome, nomePai, nomeMae, dataNascimento, naturalidade, dataExpedicao);
      this.number = number;
      this.nacionalidade = nacionalidade;
      this.dataVencimento = dataVencimento;
   }

   public String getNacionalidade() {
      return nacionalidade;
   }

   public LocalDate getDataVencimento() {
      return dataVencimento;
   }

   @Override
   public String getNumeroDocumento() {
      return number;
   }
}
