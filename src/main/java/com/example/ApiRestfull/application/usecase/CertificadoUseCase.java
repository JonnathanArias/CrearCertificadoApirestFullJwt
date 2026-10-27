package com.example.ApiRestfull.application.usecase;

//Aqui importaremos las capas que necesitamos
import com.example.ApiRestfull.application.dto.CertificadoRequest;
import com.example.ApiRestfull.application.dto.CertificadoResponse;
import com.example.ApiRestfull.domain.model.Certificado;
import com.example.ApiRestfull.domain.port.CertificadoRepositoryPort; //este llora por que aun no he creado el servicio de BD con su interfaz
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service // esto indica que es el triturador el que hace las cosas sucias como nos gusta jjaj
public class CertificadoUseCase {

    //este es para insertar la inyeccion de puerto que viene de infraestrucutura puerto BD
    private final CertificadoRepositoryPort repository;

    public CertificadoUseCase(CertificadoRepositoryPort repository) {
        this.repository = repository;
    }

    //aqui instamciamos el request y el response
    public CertificadoResponse crear(CertificadoRequest request) {
        // 1. Regla de negocio: no permitir códigos duplicados
        if (repository.existePorCodigo(request.getCodigo())) {
            throw new IllegalArgumentException("Ya existe un certificado con ese código");
        }

        //aqui se crea el objeto dominio los parametros que ya sabemos que llegaran
        Certificado nuevo = new Certificado(
                null, // es autoincremental id por BD
                request.getCodigo(),
                request.getTitular(),
                "ACTIVO", // Nace activo
                LocalDateTime.now()
        );

        //guardamos el dato
        Certificado guardado = repository.guardar(nuevo);

        // 4. Devolvemos el DTO Response (para no exponer el Dominio)
        return toResponse(guardado);
    } // <--- AQUÍ cierra el método crear

    public CertificadoResponse revocar(Long id) {
        // Buscamos el certificado en la BD si existe
        Certificado certificado = repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Certificado no encontrado con ID: " + id));

        // Aqui llamamos la funcion revocar que realizamos en la clase Certificado
        certificado.revocar();

        // Guardamos los cambios y devolvemos el DTO
        return toResponse(repository.guardar(certificado));
    }

    //este me enlista los certificados todos los que esten en ese estado
    public List<CertificadoResponse> listarTodos() {
        return repository.listarTodos().stream()
                .map(this::toResponse)
                .toList();
    }

    // Método auxiliar para convertir de Dominio a DTO
    private CertificadoResponse toResponse(Certificado c) {
        return new CertificadoResponse(
                c.getId(), c.getCodigo(), c.getTitular(), c.getEstado(), c.getFechaEmision()
        );
    }
}