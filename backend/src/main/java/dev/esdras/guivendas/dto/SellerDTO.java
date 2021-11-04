package dev.esdras.guivendas.dto;

import dev.esdras.guivendas.entities.Seller;

import java.io.Serializable;

/**
 * DTO = Data Transfer Object
 * Possui os mesmos dados que a entidade Seller, porém, ao contrário da entidade, essa não possui nenhuma relação com o JPA ou Banco de Dados
 * É usada para ser retornada pelo Service.
 * Implementa o Serializable como uma boa prática, para garantir que o objeto DTO possa ser convertido para bytes e,
 * dessa forma, possa ser transferido via redes, salvo em arquivos, etc.
 */
public class SellerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public SellerDTO() {}

    public SellerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SellerDTO(Seller entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
