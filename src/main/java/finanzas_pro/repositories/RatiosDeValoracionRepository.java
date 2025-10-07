package finanzas_pro.repositories;

import finanzas_pro.models.entities.RatiosDeValoracion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatiosDeValoracionRepository extends JpaRepository<RatiosDeValoracion, String> {
    RatiosDeValoracion findByCompanySymbol(String companySymbol);
}
