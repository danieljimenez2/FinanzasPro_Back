package finanzas_pro.repositories;

import finanzas_pro.models.entities.Dividendos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DividendosRepository extends JpaRepository<Dividendos, String> {
    Dividendos findByCompanySymbol(String companySymbol);
}
