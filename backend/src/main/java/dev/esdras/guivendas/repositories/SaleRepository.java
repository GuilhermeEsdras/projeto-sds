package dev.esdras.guivendas.repositories;

import dev.esdras.guivendas.dto.SaleSuccessDTO;
import dev.esdras.guivendas.dto.SaleSumDTO;
import dev.esdras.guivendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Classe responsável por acessar os dados do Sale
 * Não possui notações, pois já herda todos os métodos CRUD necessários do Repository do JPA
 */
public interface SaleRepository extends JpaRepository<Sale, Long> {

    /**
     * Utilizando a forma de consulta/query alternativa do JPA chamada JPQL (uma mistura de SQL com Java).
     */
    @Query("SELECT NEW dev.esdras.guivendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))" +
            " FROM Sale AS obj" +
            " GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT NEW dev.esdras.guivendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))" +
            " FROM Sale AS obj" +
            " GROUP BY obj.seller")
    List<SaleSuccessDTO> successGroupedBySeller();
}
