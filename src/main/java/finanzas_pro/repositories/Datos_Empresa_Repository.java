package finanzas_pro.repositories;


import finanzas_pro.modells.entities.Datos_Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface Datos_Empresa_Repository extends JpaRepository<Datos_Empresa, String> {

    // Consulta para traer 15 primeros
    List<Datos_Empresa> findAllBy(Pageable pageable);
    List<Datos_Empresa> findAllBy();

    // Esto busca por id company_symbol
    List<Datos_Empresa> findByCompanySymbolContainingIgnoreCase(String companySymbolPart, Pageable pageable);

    // Esto busca por company_name
    List<Datos_Empresa> findByCompanyNameContainingIgnoreCase(String companyNamePart, Pageable pageable);
}
