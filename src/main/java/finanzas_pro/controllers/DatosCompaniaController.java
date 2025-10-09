package finanzas_pro.controllers;

import finanzas_pro.models.entities.*;
import finanzas_pro.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/compania")
public class DatosCompaniaController {

    @Autowired
    DatosEmpresaYCompaniaService datosEmpresaYCompaniaService;

    @Autowired
    AnalistasValoracionService analistasValoracionService;

    @Autowired
    AccionesService accionesService;

    @Autowired
    PrecioYDatosGeneralesService precioYDatosService;

    @Autowired
    CotizacionService cotizacionService;

    @Autowired
    DividendosService dividendosService;

    @Autowired
    EficienciaEnVentasYActivosService eficienciaEnVentasService;

    @Autowired
    GastosSobreVentasService gastosSobreVentasService;

    @Autowired
    MargenesDeLaCompañiaService margenesDeLaCompañiaService;

    //Recoger valoracion de analistas   ANALISTAS SCORE
    @GetMapping("/score")
    public AnalistasScore recogerValoracionAnalistas(
            @RequestHeader("companySymbol") String companySymbol
    ) {
        return analistasValoracionService.getAnalistasScore(companySymbol);
    }

    //Recoger crecimiento por accion    CRECIMIENTOS POR ACCION
    @GetMapping("/crecimiento")
    public CrecimientosPorAccion recogerCrecimientosAccion(
            @RequestHeader("companySymbol") String companySymbol
    ) {
        return accionesService.crecimientoPorAccion(companySymbol);
    }

    //Recoger datos de compania DATOS COMPAÑIA
    @GetMapping("/info")
    public DatosCompañia recogerDatosCompania(
            @RequestHeader("companySymbol") String companySymbol
    ) {
        return datosEmpresaYCompaniaService.getCompany(companySymbol);
    }

    //Recoger datos por acción DATOS POR ACCIÓN
    @GetMapping("/datosAccion")
    public DatosPorAccion recogerDatosPorAccion(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return accionesService.datosPorAccion(companySymbol);
    }

    //Nuevos:
    //Recoger distribución acciones y  cotización
    @GetMapping("/cotizacion")
    public DistribucionAccionesYCotizacion recogerCotizacion(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return cotizacionService.recogerCotizacionAcciones(companySymbol);
    }

    //Recoger Dividendos
    @GetMapping("/dividendos")
    public Dividendos recogerDividendos(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return dividendosService.recogerDatosDividendos(companySymbol);
    }

    //Recoger Eficiencia en ventas y activos
    @GetMapping("/eficienciaVentas")
    public EficienciaEnVentasActivos recogerEficiencia
    (
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return eficienciaEnVentasService.recogerEficiencia(companySymbol);
    }

    //Recoger Gastos sobre ventas
    @GetMapping("/gastosYActivos")
    public GastosSobreVentas recogerGastosSobreVentas(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return gastosSobreVentasService.recogerGastosSobreVentas(companySymbol);
    }

    //Recoger margenes de la compañia
    @GetMapping
    public MargenesDeLaCompañia recogerMargenesDeLaCompañia(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return this.margenesDeLaCompañiaService.recogerMargenesDeLaCompañia(companySymbol);
    }

    //Hasta preciosYDatosGenerales
    //Recoger PreciosYDatosGenerales
    @GetMapping("/precios")
    public PrecioYDatosGenerales recogerPrecioYDatosGenerales(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return precioYDatosService.recogerPreciosYDatosGenerales(companySymbol);
    }


}
