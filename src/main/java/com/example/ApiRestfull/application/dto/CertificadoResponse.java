package com.example.ApiRestfull.application.dto;
import java.time.LocalDateTime;

public class CertificadoResponse {

    private Long id;
    private String codigo;
    private String titular;
    private String estado;
    private LocalDateTime fechaEmision;

    //construimos el constructor

    public  CertificadoResponse(Long id, String codigo, String titular, String estado, LocalDateTime fechaEmision)
    {
        this.id = id;
        this.codigo = codigo;
        this.titular = titular;
        this.estado = estado;
        this.fechaEmision = fechaEmision;

    }

    //solo armamos getters solo sera lectura
    public Long getId()
    {
        return id;
    }
    public String getCodigo()
    {
        return codigo;
    }
    public String getTitular()
    {
        return titular;
    }
    public String getEstado()
    {
        return estado;
    }
    public LocalDateTime getFechaEmision()
    {
        return fechaEmision;
    }
}
