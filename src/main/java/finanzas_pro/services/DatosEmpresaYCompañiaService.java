package finanzas_pro.services;


import finanzas_pro.models.entities.Datos_Compañia;
import finanzas_pro.models.entities.Datos_Empresa;
import finanzas_pro.repositories.Datos_Compañia_Repository;
import finanzas_pro.repositories.Datos_Empresa_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class DatosEmpresaYCompañiaService {
    @Autowired
    private Datos_Empresa_Repository datosEmpresaRepository;

    @Autowired
    private Datos_Compañia_Repository datosCompañiaRepository;

    public List<Datos_Empresa> getFirst15Companies() {
        return datosEmpresaRepository.findAllBy(PageRequest.of(0, 15));
    }

    public List<Datos_Empresa> searchCompanies(String query) {
        if (query == null || query.length() < 2) {
            return List.of(); // no busca menos de 2 letras
        }
        PageRequest limit = PageRequest.of(0, 5); // 5 resultados máximo
        List<Datos_Empresa> bySymbol = datosEmpresaRepository.findByCompanySymbolContainingIgnoreCase(query, limit);
        List<Datos_Empresa> byName = datosEmpresaRepository.findByCompanyNameContainingIgnoreCase(query, limit);

        // Combinar y eliminar duplicados si los hay
        return Stream.concat(bySymbol.stream(), byName.stream())
                .distinct()
                .limit(5)
                .toList();
    }

    public Datos_Compañia getCompany(String companySymbol) {
        return datosCompañiaRepository.findByCompanySymbol(companySymbol);
    }
}
