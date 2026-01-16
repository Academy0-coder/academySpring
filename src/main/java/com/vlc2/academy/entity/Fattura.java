package com.vlc2.academy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "fattura")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fattura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fattura")
    private Integer idFattura;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal imponibile;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal iva;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totale;

    @Column(name = "data_emissione", nullable = false)
    private LocalDate dataEmissione;

    @Column(name = "timestamp_inserimento", insertable = false, updatable = false)
    private LocalDateTime timestampInserimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
}