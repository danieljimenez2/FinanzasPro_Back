package finanzas_pro.repositories;

import finanzas_pro.models.entities.DatosCompañia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatosCompaniaRepository extends JpaRepository<DatosCompañia, String> {
    DatosCompañia findByCompanySymbol(String companySymbol);
}
