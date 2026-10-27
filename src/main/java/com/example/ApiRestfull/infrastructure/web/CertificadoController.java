package com.example.ApiRestfull.infrastructure.web;

import com.example.ApiRestfull.application.dto.CertificadoRequest;
import com.example.ApiRestfull.application.dto.CertificadoResponse;
import com.example.ApiRestfull.application.usecase.CertificadoUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificados")
public class CertificadoController {

    private final CertificadoUseCase useCase;

    public CertificadoController(CertificadoUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<CertificadoResponse> crear(@Valid @RequestBody CertificadoRequest request) {
        CertificadoResponse creado = useCase.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<CertificadoResponse>> listar() {
        return ResponseEntity.ok(useCase.listarTodos());
    }

    @PatchMapping("/{id}/revocar")
    public ResponseEntity<CertificadoResponse> revocar(@PathVariable Long id) {
        CertificadoResponse revocado = useCase.revocar(id);
        return ResponseEntity.ok(revocado);
    }




}