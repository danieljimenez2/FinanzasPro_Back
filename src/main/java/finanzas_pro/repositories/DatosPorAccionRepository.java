package finanzas_pro.repositories;


import finanzas_pro.models.entities.DatosPorAccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatosPorAccionRepository extends JpaRepository<DatosPorAccion, String> {
    DatosPorAccion findByCompanySymbol(String companySymbol);

}
