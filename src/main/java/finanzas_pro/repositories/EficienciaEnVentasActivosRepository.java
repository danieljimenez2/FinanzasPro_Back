package finanzas_pro.repositories;

import finanzas_pro.models.entities.EficienciaEnVentasActivos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EficienciaEnVentasActivosRepository extends JpaRepository<EficienciaEnVentasActivos, String> {
    EficienciaEnVentasActivos findByCompanySymbol(String companySymbol);
}
