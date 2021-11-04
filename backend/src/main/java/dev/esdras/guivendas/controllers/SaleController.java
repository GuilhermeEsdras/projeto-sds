package dev.esdras.guivendas.controllers;

import dev.esdras.guivendas.dto.SaleDTO;
import dev.esdras.guivendas.dto.SaleSuccessDTO;
import dev.esdras.guivendas.dto.SaleSumDTO;
import dev.esdras.guivendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Indica que esta classe é um controlador Rest
@RequestMapping(value = "/sales") // Indica qual o caminho/path deste recurso Web
public class SaleController {

    @Autowired
    private SaleService service;

    /**
     * Endpoint do SaleDTO
     * @param pageable Diz que a lista retornada é paginado
     * @return Lista de Sales
     */
    @GetMapping // Como não possui argumentos, esse é o path padrão/base, definido na notação da classe
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list); // Retorna o Protocolo HTTP de sucesso + A lista de Sales no corpo da resposta
    }

    /**
     * Endpoint do SaleSum
     * @return Lista de Soma de Vendas
     */
    @GetMapping(value = "/amount-by-seller") // Caminho deste endpoint | Fica "/sales/amount-by-seller"
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
        List<SaleSumDTO> list = service.amountGroupedBySeller();
        return ResponseEntity.ok(list); // Retorna o Protocolo HTTP de sucesso + A lista de Vendas no corpo da resposta
    }

    /**
     * Endpoint do SaleSuccess
     * @return Lista com os dados de Visitas e Negócios fechados
     */
    @GetMapping(value = "/success-by-seller") // Caminho deste endpoint | Fica "/sales/amount-by-seller"
    public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
        List<SaleSuccessDTO> list = service.successGroupedBySeller();
        return ResponseEntity.ok(list); // Retorna o Protocolo HTTP de sucesso + A lista de Dados no corpo da resposta
    }
}
