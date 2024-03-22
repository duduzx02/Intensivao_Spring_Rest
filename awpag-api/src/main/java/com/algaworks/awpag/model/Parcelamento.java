package com.algaworks.awpag.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Parcelamento {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private Long id;

        @ManyToOne
        private Cliente cliente;

        private String descricao;

        private BigDecimal valorTotal;

        private Integer quantidadeParcelas;

        private LocalDateTime dataCriacao;

}
