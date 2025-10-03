package finanzas_pro.repositories;

import finanzas_pro.models.entities.Crecimientos_Por_Accion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrecimientoPorAccion extends JpaRepository<Crecimientos_Por_Accion, String> {
    Crecimientos_Por_Accion findByCompanySymbol(String companySymbol);
}
