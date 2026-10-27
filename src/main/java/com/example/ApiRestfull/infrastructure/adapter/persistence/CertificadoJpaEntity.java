package com.example.ApiRestfull.infrastructure.adapter.persistence;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity // y este es para indicar que es una entidad
@Table(name = "certificados") //asi se llamara la tabla papi en SQL

public class CertificadoJpaEntity {

    //este es el ORM, crearemos los campos de la tabla SQL
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String titular;

    @Column(nullable = false, length = 20)
    private String estado;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDateTime fechaEmision;

    // Constructor vacío obligatorio para JPA
    public CertificadoJpaEntity() {}

    // Getters y Setters tiene los dos por que el solito realizara sus modificaciones
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
