package finanzas_pro.services;

import finanzas_pro.models.entities.Dividendos;
import finanzas_pro.repositories.DividendosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DividendosService {
    @Autowired
    DividendosRepository dividendosRepo;

    public Dividendos recogerDatosDividendos(String companySymbol) {
        return dividendosRepo.findByCompanySymbol(companySymbol);
    }
}
