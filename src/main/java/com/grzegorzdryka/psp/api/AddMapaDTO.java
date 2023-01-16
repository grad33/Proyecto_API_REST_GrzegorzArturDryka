package com.grzegorzdryka.psp.api;

import com.grzegorzdryka.psp.data.Mapa;
import lombok.Data;

@Data
public class AddMapaDTO {

    private String mapa;

    private int duracion;

    public Mapa toEntity(AddMapaDTO mapaDTO){
        Mapa mapa=new Mapa();
        mapa.setMapa(mapaDTO.getMapa());
        mapa.setDuracion(mapaDTO.getDuracion());
        return mapa;
    }
}
