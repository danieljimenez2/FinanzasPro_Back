package finanzas_pro.repositories;

import finanzas_pro.models.entities.GastosSobreVentas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastosSobreVentasRepository extends JpaRepository<GastosSobreVentas, String> {
    GastosSobreVentas findByCompanySymbol(String companySymbol);
}
