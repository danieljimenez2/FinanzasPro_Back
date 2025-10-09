package finanzas_pro.services;


import finanzas_pro.models.entities.ValorIntrinseco;
import finanzas_pro.repositories.ValorIntrinsecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValorIntrinsecoService {

    @Autowired
    ValorIntrinsecoRepository valorIntrinsecoRepository;

    public ValorIntrinseco recogerValorIntrinseco(String companySymbol) {
        return this.valorIntrinsecoRepository.findByCompanySymbol(companySymbol);
    }
}
