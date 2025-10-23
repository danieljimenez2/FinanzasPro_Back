package finanzas_pro.repositories;

import finanzas_pro.models.entities.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritosRepository extends JpaRepository<Favoritos, String> {

    boolean existsByCompanySymbol(String companySymbol);

    void deleteByCompanySymbol(String companySymbol);

    Favoritos findByCompanySymbol(String companySymbol);

}
