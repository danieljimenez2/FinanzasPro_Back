package finanzas_pro.services;

import finanzas_pro.models.entities.RatiosDeValoracion;
import finanzas_pro.models.entities.RatiosRentabilidad;
import finanzas_pro.repositories.RatiosDeValoracionRepository;
import finanzas_pro.repositories.RatiosRentabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatiosDeValoracionYRentabilidadService {

    @Autowired
    RatiosDeValoracionRepository ratiosDeValoracionRepository;

    @Autowired
    RatiosRentabilidadRepository ratiosRentabilidadRepository;

    public RatiosDeValoracion recogerRatiosDeValoracion(String companySymbol) {
        return this.ratiosDeValoracionRepository.findByCompanySymbol(companySymbol);
    }

    public RatiosRentabilidad recogerRatiosRentabilidad(String companySymbol) {
        return this.ratiosRentabilidadRepository.findByCompanySymbol(companySymbol);
    }


}
