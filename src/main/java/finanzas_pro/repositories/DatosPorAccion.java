package finanzas_pro.repositories;


import finanzas_pro.models.entities.Datos_Por_Accion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatosPorAccion extends JpaRepository<Datos_Por_Accion, String> {
    Datos_Por_Accion findByCompanySymbol(String companySymbol);

}
