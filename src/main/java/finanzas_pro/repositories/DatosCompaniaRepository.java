package finanzas_pro.repositories;

import finanzas_pro.models.entities.DatosCompañia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatosCompaniaRepository extends JpaRepository<DatosCompañia, String> {
    DatosCompañia findByCompanySymbol(String companySymbol);

    Page<DatosCompañia> findBySector(String sector, Pageable page);

    Page<DatosCompañia> findByPais(String pais, Pageable page);

    Page<DatosCompañia> findByBolsa(String bolsa, Pageable page);
}
