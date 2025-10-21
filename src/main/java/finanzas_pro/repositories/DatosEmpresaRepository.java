package finanzas_pro.repositories;


import finanzas_pro.models.entities.DatosEmpresa;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatosEmpresaRepository extends JpaRepository<DatosEmpresa, String> {

    // Consulta para traer 15 primeros
    List<DatosEmpresa> findAllBy(Pageable pageable);

    List<DatosEmpresa> findAllBy();

    DatosEmpresa findByCompanySymbol(String companySymbol);

    // Esto busca por id company_symbol
    List<DatosEmpresa> findByCompanySymbolContainingIgnoreCase(String companySymbolPart, Pageable pageable);

    // Esto busca por company_name
    List<DatosEmpresa> findByCompanyNameContainingIgnoreCase(String companyNamePart, Pageable pageable);

}
