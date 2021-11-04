package dev.esdras.guivendas.controllers;

import dev.esdras.guivendas.dto.SellerDTO;
import dev.esdras.guivendas.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Indica que esta classe é um controlador Rest
@RequestMapping(value = "/sellers") // Indica qual o caminho deste recurso Web
public class SellerController {

    @Autowired // Injeta essa dependência de forma transparente (evita o uso de instanciação direta "= new ...()")
    private SellerService service;

    /**
     * Método para representar o endpoint
     */
    @GetMapping
    public ResponseEntity<List<SellerDTO>> findAll() {
        List<SellerDTO> list = service.findAll();
        return ResponseEntity.ok(list); // Retorna o Protocolo HTTP de sucesso + A lista de Sellers no corpo da resposta
    }
}
