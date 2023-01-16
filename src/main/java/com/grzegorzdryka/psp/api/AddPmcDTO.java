package com.grzegorzdryka.psp.api;

import com.grzegorzdryka.psp.data.Mapa;
import com.grzegorzdryka.psp.data.Pmc;
import lombok.Data;

@Data
public class AddPmcDTO {

    private Mapa mapa;

    private String nombre;

    private String faccion;

    private int nivel;

    public Pmc toEntity(AddPmcDTO pmcDTO){
        Pmc pmc=new Pmc();
        pmc.setMapa(pmcDTO.getMapa());
        pmc.setNombre(pmcDTO.getNombre());
        pmc.setFaccion(pmcDTO.getFaccion());
        pmc.setNivel(pmcDTO.getNivel());
        return pmc;
    }
}
