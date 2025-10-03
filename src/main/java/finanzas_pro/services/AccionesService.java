package finanzas_pro.services;


import finanzas_pro.repositories.CrecimientoPorAccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccionesService {

    @Autowired
    CrecimientoPorAccion crecimientoPorAccionRepo;


}
