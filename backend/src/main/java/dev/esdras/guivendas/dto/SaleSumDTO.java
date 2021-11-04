package dev.esdras.guivendas.dto;

import dev.esdras.guivendas.entities.Seller;

import java.io.Serializable;

/**
 * Implementa o Serializable como uma boa prática, para garantir que o objeto DTO possa ser convertido para bytes e,
 * dessa forma, possa ser transferido via redes, salvo em arquivos, etc.
 */
public class SaleSumDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sellerName;
    private Double sum;

    public SaleSumDTO() {}

    /**
     * Deve-se agrupar por seller, não tem como agrupar apenas pelo nome
     * @param seller Vendedor que será usado para agrupar as vendas
     * @param sum Soma das vendas
     */
    public SaleSumDTO(Seller seller, Double sum) {
        sellerName = seller.getName();
        this.sum = sum;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
