package finanzas_pro.services;

import finanzas_pro.models.entities.EficienciaEnVentasActivos;
import finanzas_pro.repositories.EficienciaEnVentasActivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EficienciaEnVentasYActivosService {
    @Autowired
    EficienciaEnVentasActivosRepository eficienciaRepo;

    public EficienciaEnVentasActivos recogerEficiencia(String companySymbol) {
        return eficienciaRepo.findByCompanySymbol(companySymbol);
    }
}
