package finanzas_pro.repositories;

import finanzas_pro.models.entities.RatiosRentabilidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatiosRentabilidadRepository extends JpaRepository<RatiosRentabilidad, String> {
    RatiosRentabilidad findByCompanySymbol(String companySymbol);
}
