package finanzas_pro.services;


import finanzas_pro.models.entities.PosicionFinanciera;
import finanzas_pro.repositories.PosicionFinancieraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PosicionFinancieraService {

    @Autowired
    PosicionFinancieraRepository posicionFinancieraRepo;

    public PosicionFinanciera recogerPosicionFinanciera(String companySymbol) {
        return posicionFinancieraRepo.findByCompanySymbol(companySymbol);
    }

}
