package finanzas_pro.services;

import finanzas_pro.models.entities.DistribucionAccionesYCotizacion;
import finanzas_pro.repositories.DistribucionAccionesYCotizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CotizacionService {

    @Autowired
    DistribucionAccionesYCotizacionRepository distribucionAccionesYCotizacionRepo;

    public DistribucionAccionesYCotizacion recogerCotizacionAcciones(String companySymbol) {
        return this.distribucionAccionesYCotizacionRepo.findByCompanySymbol(companySymbol);
    }
}
