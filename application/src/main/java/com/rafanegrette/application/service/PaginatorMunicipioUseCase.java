package com.rafanegrette.application.service;

import com.rafanegrette.application.port.in.PaginatorMunicipio;
import com.rafanegrette.application.port.out.LoadMunicipiosPort;
import com.rafanegrette.domain.Municipio;

import java.util.List;
import java.util.stream.Collectors;

public class PaginatorMunicipioUseCase implements PaginatorMunicipio {

    private final LoadMunicipiosPort municipiosPort;

    public PaginatorMunicipioUseCase(LoadMunicipiosPort municipiosPort) {
        this.municipiosPort = municipiosPort;
    }

    @Override
    public List<PageMunicipioQuery> getPageMunicipio(PageMunicipioCommand page) {
        return toPage(municipiosPort.loadMunicipios(page));
    }

    private List<PageMunicipioQuery> toPage(List<Municipio> municipios) {
        return municipios.stream().map(m -> new PageMunicipioQuery(m.getNombre(), m.getDepartamento().getName(), m.getHomicidios())).collect(Collectors.toList());
    }
}
