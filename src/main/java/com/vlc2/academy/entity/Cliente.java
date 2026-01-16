package com.vlc2.academy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String cognome;

    @Column(name = "codice_fiscale", nullable = false, unique = true, length = 16)
    private String codiceFiscale;

    @Column(name = "data_nascita", nullable = false)
    private LocalDate dataNascita;

    @Column(name = "stato_nascita", length = 50)
    private String statoNascita = "Italia";

    @Column(name = "regione_nascita", length = 50)
    private String regioneNascita;

    @Column(name = "provincia_nascita", length = 2)
    private String provinciaNascita;

    @Column(name = "comune_nascita", length = 100)
    private String comuneNascita;

    @Column(name = "timestamp_inserimento", insertable = false, updatable = false)
    private LocalDateTime timestampInserimento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Fattura> fatture;
}