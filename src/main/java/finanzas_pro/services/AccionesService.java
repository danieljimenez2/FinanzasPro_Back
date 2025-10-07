package finanzas_pro.services;


import finanzas_pro.models.entities.CrecimientosPorAccion;
import finanzas_pro.models.entities.DatosPorAccion;
import finanzas_pro.repositories.CrecimientoPorAccionRepository;
import finanzas_pro.repositories.DatosPorAccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccionesService {

    @Autowired
    CrecimientoPorAccionRepository crecimientoPorAccionRepositoryRepo;

    @Autowired
    DatosPorAccionRepository datosPorAccionRepositoryRepo;

    public DatosPorAccion datosPorAccion(String companySymbol) {
        return this.datosPorAccionRepositoryRepo.findByCompanySymbol(companySymbol);
    }

    public CrecimientosPorAccion crecimientoPorAccion(String companySymbol) {
        return this.crecimientoPorAccionRepositoryRepo.findByCompanySymbol(companySymbol);
    }
}
