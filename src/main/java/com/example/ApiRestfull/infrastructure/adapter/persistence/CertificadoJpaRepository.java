package com.example.ApiRestfull.infrastructure.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificadoJpaRepository extends JpaRepository<CertificadoJpaEntity, Long> {
    // Spring Data lee este nombre y crea el SQL por debajo
    boolean existsByCodigo(String codigo);
}