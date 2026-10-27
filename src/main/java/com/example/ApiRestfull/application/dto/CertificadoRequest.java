package com.example.ApiRestfull.application.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CertificadoRequest {
  //@NotBlank y  @Size este es para que me permita validar si estan correctos los campos
    //@notBank : este no permite nulos ni vacios papi
    @NotBlank(message = "Este campo es obligatorio")
    @Size(max = 50, message = "No debe superar los 50 caracteres")
    private String codigo;

    @NotBlank(message = "El titular es obigatorio pilas")
    @Size(max = 100, message ="El titular no debe superar los 100 Caracteres")
    private String titular;

    // este constructor lo dejamos vacio para que se pueda convertir en el viejo json
   public  CertificadoRequest()
   {

   };

   //parametros getter y setters
   public String getCodigo()
   {
       return codigo;
   }
    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }
    public String getTitular()
    {

        return titular;
    }
    public void setTitular(String titular)
    {
        this.titular = titular;
    }
}
