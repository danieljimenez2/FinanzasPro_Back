package finanzas_pro.services;

import finanzas_pro.models.entities.PrecioYDatosGenerales;
import finanzas_pro.repositories.PrecioYDatosGeneralesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrecioYDatosGeneralesService {

    @Autowired
    PrecioYDatosGeneralesRepository precioYDatosGeneralesrepo;

    public PrecioYDatosGenerales recogerPreciosYDatosGenerales(String companySymbol) {
        return this.precioYDatosGeneralesrepo.findByCompanySymbol(companySymbol);
    }


}
