package finanzas_pro.repositories;

import finanzas_pro.models.entities.PosicionFinanciera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosicionFinancieraRepository extends JpaRepository<PosicionFinanciera, String> {
    PosicionFinanciera findByCompanySymbol(String companySymbol);
}
