package dev.esdras.guivendas.services;

import dev.esdras.guivendas.dto.SaleDTO;
import dev.esdras.guivendas.entities.Sale;
import dev.esdras.guivendas.repositories.SaleRepository;
import dev.esdras.guivendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service // Notação que registra a classe como um componente do sistema fazendo a mesma poder ser injetada em outros componentes
public class SaleService {

    @Autowired // Injeta essa dependência de forma transparente (evita o uso de instanciação direta "= new ...()")
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    /**
     * Busca de objetos do bd
     * Paginada, pois nao queremos que retorne todas as vendas
     * @return Objetos do Banco de Dados
     */
    @Transactional(readOnly = true) // Garante que todas as operações no banco sejam resolvidas durante a execução desse método | "readOnly = true": para não fazer lock no banco já que é um método apenas de leitura
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> result = repository.findAll(pageable);
        return result.map(SaleDTO::new); // Page já é uma string, não precisa do stream() nem Collectors
    }
}
