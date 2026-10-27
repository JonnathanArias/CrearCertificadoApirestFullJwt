package com.example.ApiRestfull.infrastructure.adapter.persistence;
//inyectamos los packages

import com.example.ApiRestfull.domain.model.Certificado;
import com.example.ApiRestfull.domain.port.CertificadoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CertificadoRepositoryAdapter implements  CertificadoRepositoryPort {

    private  final  CertificadoJpaRepository jpaRepository;

    public CertificadoRepositoryAdapter(CertificadoJpaRepository jpaRepository)
    {
        this.jpaRepository = jpaRepository;
    }

    // se realizara el polimorfismo de la clase, buscando por cada uno de los servicios
    @Override
    public Certificado guardar(Certificado certificado) {
        CertificadoJpaEntity entity = toEntity(certificado);
        CertificadoJpaEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Certificado> buscarPorId(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<Certificado> buscarPorCodigo(String codigo) {
        return jpaRepository.findAll().stream()
                .filter(e -> e.getCodigo().equals(codigo))
                .findFirst()
                .map(this::toDomain);
    }
    @Override
    public List<Certificado> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }
    @Override
    public void eliminar(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existePorCodigo(String codigo) {
        return jpaRepository.existsByCodigo(codigo);
    }

    //este permite comunicarse entre la APP y la BD

    private Certificado toDomain(CertificadoJpaEntity e) {
        return new Certificado(
                e.getId(), e.getCodigo(), e.getTitular(),
                e.getEstado(), e.getFechaEmision()
        );
    }
    private CertificadoJpaEntity toEntity(Certificado c) {
        CertificadoJpaEntity e = new CertificadoJpaEntity();
        e.setId(c.getId());
        e.setCodigo(c.getCodigo());
        e.setTitular(c.getTitular());
        e.setEstado(c.getEstado());
        e.setFechaEmision(c.getFechaEmision());
        return e;
    }
}



