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

    @Autowired
    PosicionFinancieraService posicionFinancieraService;

    @Autowired
    RatiosDeValoracionYRentabilidadService ratiosDeValoracionYRentabilidadService;

    @Autowired
    ValorIntrinsecoService valorIntrinsecoService;

    //1. Recoger valoracion de analistas   ANALISTAS SCORE
    @GetMapping("/score")
    public AnalistasScore recogerValoracionAnalistas(
            @RequestHeader("companySymbol") String companySymbol
    ) {
        return analistasValoracionService.getAnalistasScore(companySymbol);
    }

    //2. Recoger crecimiento por accion    CRECIMIENTOS POR ACCION
    @GetMapping("/crecimiento")
    public CrecimientosPorAccion recogerCrecimientosAccion(
            @RequestHeader("companySymbol") String companySymbol
    ) {
        return accionesService.crecimientoPorAccion(companySymbol);
    }

    //3. Recoger datos de compania DATOS COMPAÑIA
    @GetMapping("/info")
    public DatosCompañia recogerDatosCompania(
            @RequestHeader("companySymbol") String companySymbol
    ) {
        return datosEmpresaYCompaniaService.getCompany(companySymbol);
    }

    //4. Recoger datos por acción DATOS POR ACCIÓN
    @GetMapping("/datosAccion")
    public DatosPorAccion recogerDatosPorAccion(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return accionesService.datosPorAccion(companySymbol);
    }

    //5. Recoger distribución acciones y cotización
    @GetMapping("/cotizacion")
    public DistribucionAccionesYCotizacion recogerCotizacion(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return cotizacionService.recogerCotizacionAcciones(companySymbol);
    }

    //6. Recoger Dividendos
    @GetMapping("/dividendos")
    public Dividendos recogerDividendos(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return dividendosService.recogerDatosDividendos(companySymbol);
    }

    //7. Recoger Eficiencia en ventas y activos
    @GetMapping("/eficienciaVentas")
    public EficienciaEnVentasActivos recogerEficiencia
    (
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return eficienciaEnVentasService.recogerEficiencia(companySymbol);
    }

    //8. Recoger Gastos sobre ventas
    @GetMapping("/gastosYActivos")
    public GastosSobreVentas recogerGastosSobreVentas(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return gastosSobreVentasService.recogerGastosSobreVentas(companySymbol);
    }

    //9. Recoger margenes de la compañia
    @GetMapping("/margenesCompania")
    public MargenesDeLaCompañia recogerMargenesDeLaCompañia(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return this.margenesDeLaCompañiaService.recogerMargenesDeLaCompañia(companySymbol);
    }

    //10. Recoger posición financiera
    @GetMapping("/posicionFinanciera")
    public PosicionFinanciera recogerPosicionFinanciera(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return this.posicionFinancieraService.recogerPosicionFinanciera(companySymbol);
    }

    //11. Recoger PreciosYDatosGenerales
    @GetMapping("/precios")
    public PrecioYDatosGenerales recogerPrecioYDatosGenerales(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return precioYDatosService.recogerPreciosYDatosGenerales(companySymbol);
    }

    //12. Recoger Ratios de valoracion
    @GetMapping("/ratiosValoracion")
    public RatiosDeValoracion recogerRatiosDeValoracion(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return this.ratiosDeValoracionYRentabilidadService.recogerRatiosDeValoracion(companySymbol);
    }

    //13. Recoger Ratios de rentabilidad
    @GetMapping("/ratiosRentabilidad")
    public RatiosRentabilidad recogerRatiosDeRentabilidad(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return this.ratiosDeValoracionYRentabilidadService.recogerRatiosRentabilidad(companySymbol);
    }

    //14. Recoger Valor intrinseco
    public ValorIntrinseco recogerValorIntrinseco(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return this.valorIntrinsecoService.recogerValorIntrinseco(companySymbol);
    }
}
