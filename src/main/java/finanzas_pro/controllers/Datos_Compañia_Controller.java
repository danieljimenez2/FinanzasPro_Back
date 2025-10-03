package finanzas_pro.controllers;

import finanzas_pro.models.entities.Analistas_Score;
import finanzas_pro.models.entities.Crecimientos_Por_Accion;
import finanzas_pro.models.entities.Datos_Compañia;
import finanzas_pro.services.AnalistasScoreService;
import finanzas_pro.services.DatosEmpresaYCompañiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/compañia")
public class Datos_Compañia_Controller {

    @Autowired
    DatosEmpresaYCompañiaService datosEmpresaYCompañiaService;

    @Autowired
    AnalistasScoreService analistasScoreService;

    @GetMapping("/info")
    public Datos_Compañia getCompañia(
            @RequestHeader("companySymbol") String companySymbol
    )
    {
        return datosEmpresaYCompañiaService.getCompany(companySymbol);
    }

    @GetMapping("/score")
    public Analistas_Score getAnalistasScore(
            @RequestHeader("companySymbol") String companySymbol
    )
    {
        return analistasScoreService.getAnalistasScore(companySymbol);
    }
    @GetMapping("/accion")
    public Crecimientos_Por_Accion get

}
