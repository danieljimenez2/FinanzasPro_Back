package finanzas_pro.repositories;

import finanzas_pro.models.entities.MargenesDeLaCompañia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MargenesDeLaCompaniaRepository extends JpaRepository<MargenesDeLaCompañia, String> {
    MargenesDeLaCompañia findByCompanySymbol(String companySymbol);
}
