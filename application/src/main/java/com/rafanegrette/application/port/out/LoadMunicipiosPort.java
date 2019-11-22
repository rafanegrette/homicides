package com.rafanegrette.application.port.out;

import com.rafanegrette.application.port.in.PaginatorMunicipio;
import com.rafanegrette.domain.Municipio;

import java.util.List;

public interface LoadMunicipiosPort {

    List<Municipio> loadMunicipios(PaginatorMunicipio.PageMunicipioCommand page);

}
