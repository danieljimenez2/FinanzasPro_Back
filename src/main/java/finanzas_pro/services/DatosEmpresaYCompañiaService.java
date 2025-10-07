package finanzas_pro.services;


import finanzas_pro.models.entities.DatosCompañia;
import finanzas_pro.models.entities.DatosEmpresa;
import finanzas_pro.repositories.DatosCompaniaRepository;
import finanzas_pro.repositories.DatosEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class DatosEmpresaYCompañiaService {
    @Autowired
    private DatosEmpresaRepository datosEmpresaRepository;

    @Autowired
    private DatosCompaniaRepository datosCompañiaRepository;

    public List<DatosEmpresa> getFirst15Companies() {
        return datosEmpresaRepository.findAllBy(PageRequest.of(0, 15));
    }

    public List<DatosEmpresa> searchCompanies(String query) {
        if (query == null || query.length() < 2) {
            return List.of(); // no busca menos de 2 letras
        }
        PageRequest limit = PageRequest.of(0, 5); // 5 resultados máximo
        List<DatosEmpresa> bySymbol = datosEmpresaRepository.findByCompanySymbolContainingIgnoreCase(query, limit);
        List<DatosEmpresa> byName = datosEmpresaRepository.findByCompanyNameContainingIgnoreCase(query, limit);

        // Combinar y eliminar duplicados si los hay
        return Stream.concat(bySymbol.stream(), byName.stream())
                .distinct()
                .limit(5)
                .toList();
    }

    public DatosCompañia getCompany(String companySymbol) {
        return datosCompañiaRepository.findByCompanySymbol(companySymbol);
    }
}
