package finanzas_pro.repositories;

import finanzas_pro.models.entities.ValorIntrinseco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValorIntrinsecoRepository extends JpaRepository<ValorIntrinseco, String> {
    ValorIntrinseco findByCompanySymbol(String companySymbol);
}
