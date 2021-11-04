package dev.esdras.guivendas.repositories;

import dev.esdras.guivendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe responsável por acessar os dados do Seller
 * Não possui notações, pois já herda todos os métodos CRUD necessários do Repository do JPA
 */
public interface SellerRepository extends JpaRepository<Seller, Long> {
}
