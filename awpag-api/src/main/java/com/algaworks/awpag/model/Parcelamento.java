package com.algaworks.awpag.model;

import com.algaworks.awpag.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
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

        @Valid
        @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
        @NotNull
        @ManyToOne
        private Cliente cliente;

        @NotBlank
        @Size(max = 20)
        private String descricao;

        @NotNull
        @Positive
        private BigDecimal valorTotal;

        @NotNull
        @Positive
        @Max(12)
        private Integer quantidadeParcelas;

        private LocalDateTime dataCriacao;

}