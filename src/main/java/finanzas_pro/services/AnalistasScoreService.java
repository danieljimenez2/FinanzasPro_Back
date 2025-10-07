package finanzas_pro.services;


import finanzas_pro.models.entities.AnalistasScore;
import finanzas_pro.repositories.AnalistasScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalistasScoreService {

    @Autowired
    AnalistasScoreRepository analistasScoreRepository;


    public AnalistasScore getAnalistasScore(String companySymbol) {
        return this.analistasScoreRepository.findByCompanySymbol(companySymbol);
    }
}
