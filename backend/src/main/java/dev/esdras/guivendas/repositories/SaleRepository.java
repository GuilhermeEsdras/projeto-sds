package dev.esdras.guivendas.repositories;

import dev.esdras.guivendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe responsável por acessar os dados do Sale
 * Não possui notações, pois já herda todos os métodos CRUD necessários do Repository do JPA
 */
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
