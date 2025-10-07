package finanzas_pro.controllers;

import finanzas_pro.models.entities.*;
import finanzas_pro.services.AccionesService;
import finanzas_pro.services.AnalistasScoreService;
import finanzas_pro.services.DatosEmpresaYCompañiaService;
import finanzas_pro.services.PrecioYDatosGeneralesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/compania")
public class DatosCompañiaController {

    @Autowired
    DatosEmpresaYCompañiaService datosEmpresaYCompañiaService;

    @Autowired
    AnalistasScoreService analistasScoreService;

    @Autowired
    AccionesService accionesService;

    @Autowired
    PrecioYDatosGeneralesService precioYDatosService;


    //Recoger datos de compañia
    @GetMapping("/info")
    public DatosCompañia recogerDatosCompania(
            @RequestHeader("companySymbol") String companySymbol
    ) {
        return datosEmpresaYCompañiaService.getCompany(companySymbol);
    }

    //Recoger valoracion de analistas
    @GetMapping("/score")
    public AnalistasScore recogerValoracionAnalistas(
            @RequestHeader("companySymbol") String companySymbol
    ) {
        return analistasScoreService.getAnalistasScore(companySymbol);
    }

    //Recoger crecimiento por accion
    @GetMapping("/crecimiento")
    public CrecimientosPorAccion recogerCrecimientosAccion(
            @RequestHeader("companySymbol") String companySymbol
    ) {
        return accionesService.crecimientoPorAccion(companySymbol);
    }

    //Recoger datos Por Accion
    @GetMapping("/datosAccion")
    public DatosPorAccion recogerDatosPorAccion(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return accionesService.datosPorAccion(companySymbol);
    }

    //Recoger PreciosYDatosGenerales
    @GetMapping("/precios")
    public PrecioYDatosGenerales recogerPrecioYDatosGenerales(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return precioYDatosService.recogerPreciosYDatosGenerales(companySymbol);
    }

}
