package dev.esdras.guivendas.controllers;

import dev.esdras.guivendas.dto.SaleDTO;
import dev.esdras.guivendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que esta classe é um controlador Rest
@RequestMapping(value = "/sales") // Indica qual o caminho deste recurso Web
public class SaleController {

    @Autowired
    private SaleService service;

    /**
     * Método para representar o endpoint
     */
    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list); // Retorna o Protocolo HTTP de sucesso + A lista de Sales no corpo da resposta
    }
}
