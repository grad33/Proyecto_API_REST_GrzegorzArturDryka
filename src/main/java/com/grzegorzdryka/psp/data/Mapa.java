package com.grzegorzdryka.psp.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mapa {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Integer id;
    @Column
    private String mapa;
    @Column
    private int duracion;
}
