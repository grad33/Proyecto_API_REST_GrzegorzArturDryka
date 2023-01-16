package com.grzegorzdryka.psp.api;

import com.grzegorzdryka.psp.data.Mapa;
import com.grzegorzdryka.psp.data.Scav;
import lombok.Data;

@Data
public class AddScavDTO {

    private Mapa mapa;

    private String nombre;

    public Scav toEntity(AddScavDTO scavDTO){
        Scav scav=new Scav();
        scav.setMapa(scavDTO.getMapa());
        scav.setNombre(scavDTO.getNombre());
        return scav;
    }
}
