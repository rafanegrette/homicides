package com.rafanegrette.application.service;

import com.rafanegrette.application.port.in.PaginatorMunicipio;
import com.rafanegrette.application.port.out.LoadMunicipiosPort;
import com.rafanegrette.domain.Departamento;
import com.rafanegrette.domain.Municipio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

public class PaginatorMunicipioUseCaseTest {

    private final LoadMunicipiosPort municipioPort = Mockito.mock(LoadMunicipiosPort.class);

    private final PaginatorMunicipioUseCase paginator = new PaginatorMunicipioUseCase(municipioPort);
    PaginatorMunicipio.PageMunicipioCommand page;
    List<Municipio> municipiosExpected;
    List<PaginatorMunicipio.PageMunicipioQuery> municipiosQuery;

    @Test
    void testGetPageMunicipio(){
        givenMunicipios();
        whenARequestSecondPageAndSize5();
        thenReturn5Municipios();
    }

    private void thenReturn5Municipios() {
        Assertions.assertEquals(municipiosExpected.size(), municipiosQuery.size());
    }

    private void whenARequestSecondPageAndSize5() {
        municipiosQuery = paginator.getPageMunicipio(page);
    }

    private void givenMunicipios() {
        page = new PaginatorMunicipio.PageMunicipioCommand(2,5);
        Departamento departamento = new Departamento("La Guajira", 56);
        municipiosExpected = Arrays.asList(
                new Municipio("Maicao", 23, departamento),
                new Municipio("Maicao", 23, departamento),
                new Municipio("Maicao", 23, departamento),
                new Municipio("Maicao", 23, departamento),
                new Municipio("Maicao", 23, departamento)
        );
        Mockito.when(municipioPort.loadMunicipios(page)).thenReturn(municipiosExpected);
    }
}