package finanzas_pro.repositories;

import finanzas_pro.models.entities.DistribucionAccionesYCotizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistribucionAccionesYCotizacionRepository extends JpaRepository<DistribucionAccionesYCotizacion, String> {
    DistribucionAccionesYCotizacion findByCompanySymbol(String companySymbol);
}
