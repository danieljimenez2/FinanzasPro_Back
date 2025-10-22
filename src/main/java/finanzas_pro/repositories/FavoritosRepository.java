package finanzas_pro.repositories;

import finanzas_pro.models.entities.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritosRepository extends JpaRepository<Favoritos, String> {


    boolean findByCompanySymbol(String companySymbol);


}
