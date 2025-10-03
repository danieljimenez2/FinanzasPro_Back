package finanzas_pro.repositories;

import finanzas_pro.models.entities.Datos_Compañia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Datos_Compañia_Repository extends JpaRepository<Datos_Compañia, String> {
    Datos_Compañia findByCompanySymbol(String companySymbol);
}
