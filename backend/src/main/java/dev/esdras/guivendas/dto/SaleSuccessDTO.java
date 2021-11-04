package dev.esdras.guivendas.dto;

import dev.esdras.guivendas.entities.Seller;

import java.io.Serializable;

/**
 * Implementa o Serializable como uma boa prática, para garantir que o objeto DTO possa ser convertido para bytes e,
 * dessa forma, possa ser transferido via redes, salvo em arquivos, etc.
 */
public class SaleSuccessDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sellerName;
    private Long visited;
    private Long deals;

    public SaleSuccessDTO() {}

    /**
     * Deve-se agrupar por seller, não tem como agrupar apenas pelo nome
     * @param seller Vendedor que será usado para agrupar os dados
     * @param visited Soma das visitas do vendedor
     * @param deals Negócios fechados
     */
    public SaleSuccessDTO(Seller seller, Long visited, Long deals) {
        sellerName = seller.getName();
        this.visited = visited;
        this.deals = deals;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Long getVisited() {
        return visited;
    }

    public void setVisited(Long visited) {
        this.visited = visited;
    }

    public Long getDeals() {
        return deals;
    }

    public void setDeals(Long deals) {
        this.deals = deals;
    }
}
