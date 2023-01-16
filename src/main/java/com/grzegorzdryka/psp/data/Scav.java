package com.grzegorzdryka.psp.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Scav {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Integer id_scav;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "mapa_id")
    private Mapa mapa;
    @Column
    private String nombre;
}
