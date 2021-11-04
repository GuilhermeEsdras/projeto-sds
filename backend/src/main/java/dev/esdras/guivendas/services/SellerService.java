package dev.esdras.guivendas.services;

import dev.esdras.guivendas.dto.SellerDTO;
import dev.esdras.guivendas.entities.Seller;
import dev.esdras.guivendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // Notação que registra a classe como um componente do sistema fazendo a mesma poder ser injetada em outros componentes
public class SellerService {

    @Autowired // Injeta essa dependência de forma transparente (evita o uso de instanciação direta "= new ...()")
    private SellerRepository repository;

    /**
     * Busca todos os objetos do bd
     * @return Todos os objetos do Banco de Dados
     */
    public List<SellerDTO> findAll() {
        List<Seller> result = repository.findAll();
        return result.stream().map(SellerDTO::new).collect(Collectors.toList()); // Converte cada um dos Sellers em SellerDTO's
    }
}
