package finanzas_pro.services;


import finanzas_pro.models.entities.Analistas_Score;
import finanzas_pro.repositories.AnalistasScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalistasScoreService {

    @Autowired
    AnalistasScoreRepository analistasScoreRepository;


    public Analistas_Score getAnalistasScore(String companySymbol) {
        return this.analistasScoreRepository.findByCompanySymbol(companySymbol);
    }
}
