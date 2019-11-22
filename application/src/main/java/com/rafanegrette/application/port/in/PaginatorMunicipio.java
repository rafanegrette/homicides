package com.rafanegrette.application.port.in;

import com.rafanegrette.common.SelfValidating;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface PaginatorMunicipio {

    List<PageMunicipioQuery> getPageMunicipio(PageMunicipioCommand pageMunicipio);

    class PageMunicipioQuery extends SelfValidating<PageMunicipioQuery> {

        @NotNull
        private final String nombre;

        @NotNull
        private final String departamento;

        @NotNull
        private final Integer asesinatos;

        public PageMunicipioQuery(String nombre, String departamento, Integer asesinatos) {
            this.nombre = nombre;
            this.departamento = departamento;
            this.asesinatos = asesinatos;
            this.validateSelf();
        }
    }

    class PageMunicipioCommand extends SelfValidating<PageMunicipioCommand>{
        private final Integer page;
        private final Integer size;

        public PageMunicipioCommand(Integer page, Integer size) {
            this.page = page;
            this.size = size;
        }

        public Integer getSize() {
            return size;
        }

        public Integer getPage() {
            return page;
        }
    }
}
