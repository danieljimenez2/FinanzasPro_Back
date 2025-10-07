package finanzas_pro.repositories;

import finanzas_pro.models.entities.CrecimientosPorAccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrecimientoPorAccionRepository extends JpaRepository<CrecimientosPorAccion, String> {
    CrecimientosPorAccion findByCompanySymbol(String companySymbol);
}
