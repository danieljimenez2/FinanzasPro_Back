package finanzas_pro.repositories;

import finanzas_pro.models.entities.Analistas_Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalistasScoreRepository extends JpaRepository<Analistas_Score, String> {
    Analistas_Score findByCompanySymbol(String companySymbol);
}
