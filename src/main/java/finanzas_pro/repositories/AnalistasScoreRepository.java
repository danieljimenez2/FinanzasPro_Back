package finanzas_pro.repositories;

import finanzas_pro.models.entities.AnalistasScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalistasScoreRepository extends JpaRepository<AnalistasScore, String> {
    AnalistasScore findByCompanySymbol(String companySymbol);
}
