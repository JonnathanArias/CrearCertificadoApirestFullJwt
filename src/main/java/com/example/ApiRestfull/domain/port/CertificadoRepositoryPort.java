package com.example.ApiRestfull.domain.port;

import com.example.ApiRestfull.domain.model.Certificado;
import java.util.List;
import java.util.Optional;

public interface CertificadoRepositoryPort
{
    Certificado guardar(Certificado certificado);
    Optional<Certificado> buscarPorId(Long id);
    Optional<Certificado> buscarPorCodigo(String codigo);
    List<Certificado> listarTodos();
    void eliminar(Long id);
    boolean existePorCodigo(String codigo);
}
