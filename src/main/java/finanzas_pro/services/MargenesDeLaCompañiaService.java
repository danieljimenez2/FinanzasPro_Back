package finanzas_pro.services;

import finanzas_pro.models.entities.MargenesDeLaCompañia;
import finanzas_pro.repositories.MargenesDeLaCompaniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MargenesDeLaCompañiaService {

    @Autowired
    MargenesDeLaCompaniaRepository margenesDeLaCompañiarepo;

    public MargenesDeLaCompañia recogerMargenesDeLaCompañia(String companySymbol) {
        return this.margenesDeLaCompañiarepo.findByCompanySymbol(companySymbol);
    }

}
