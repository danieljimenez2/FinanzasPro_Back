package finanzas_pro.services;

import finanzas_pro.models.entities.GastosSobreVentas;
import finanzas_pro.repositories.GastosSobreVentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GastosSobreVentasService {

    @Autowired
    GastosSobreVentasRepository gastosSobreVentasRepo;

    public GastosSobreVentas recogerGastosSobreVentas(String companySymbol) {
        return this.gastosSobreVentasRepo.findByCompanySymbol(companySymbol);
    }

}
