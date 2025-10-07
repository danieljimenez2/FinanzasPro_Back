package finanzas_pro.repositories;

import finanzas_pro.models.entities.PrecioYDatosGenerales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrecioYDatosGeneralesRepository extends JpaRepository<PrecioYDatosGenerales, String> {
    PrecioYDatosGenerales findByCompanySymbol(String companySymbol);

}
