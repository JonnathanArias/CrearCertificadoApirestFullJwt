package com.example.ApiRestfull.domain.model;
import java.time.LocalDateTime; //para manejo de fechas

public class Certificado {

    //enlistaremos los atributos que tiene un certificado
    private  Long id;
    private String codigo;
    private String titular;
    private String estado; // sea activo o revocado
    private LocalDateTime fechaEmision;


    //instanciamos el objeto de Certificado
    public Certificado()
    {


    }

    // //crearemos el certificado ya cuando este instanciado en la BD
    public Certificado (Long id, String codigo, String titular, String estado, LocalDateTime fechaEmision)
    {
        this.id = id;
        this.codigo = codigo;
        this.titular = titular;
        this.estado = estado;
        this.fechaEmision = fechaEmision;

    }

    //realizaremos la validacion para revocar solo si esta activo
    public void revocar()
    {
        if(!"ACTIVO".equals(this.estado))
        {
            throw new IllegalStateException("Solo se pueden revocar certificados activos. ID: " + id);

        }
        this.estado = "REVOCADO";

    }

    // Getters y setters
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

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
    public String getEstado()
    {
        return estado;
    }
    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public LocalDateTime getFechaEmision()
    {
        return fechaEmision;
    }
    public void setFechaEmision(LocalDateTime fechaEmision)
    {
        this.fechaEmision = fechaEmision;
    }
}
