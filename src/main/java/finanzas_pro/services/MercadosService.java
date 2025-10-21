package finanzas_pro.services;

import finanzas_pro.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class MercadosService {


    @Autowired
    private DatosCompaniaRepository datosCompaniaRepository;

    @Autowired
    private DatosEmpresaRepository datosEmpresaRepository;

    @Autowired
    private PrecioYDatosGeneralesRepository precioYDatosGeneralesRepository;

    @Autowired
    private RatiosDeValoracionRepository ratiosDeValoracionRepository;

    @Autowired
    private RatiosRentabilidadRepository ratiosRentabilidadRepository;

    @Autowired
    private PosicionFinancieraRepository posicionFinancieraRepository;

    @Autowired
    private MargenesDeLaCompaniaRepository margenesDeLaCompaniaRepository;

    @Autowired
    private DividendosRepository dividendosRepository;

    public List<Map<String, Object>> recogerListaEmpresasPorSector(String sector, int pagina) {
        var empresas = datosCompaniaRepository.findBySector(sector, PageRequest.of(pagina, 10));

        List<Map<String, Object>> resultados = new ArrayList<>();

        //Por cada empresa y company symbol:
        empresas.forEach(datosCompania -> {
            String symbol = datosCompania.getCompanySymbol();
            Map<String, Object> fila = new LinkedHashMap<>();

            fila.put("companySymbol", symbol);

            var datosCompaniaPais = datosCompaniaRepository.findByCompanySymbol(symbol);
            if (datosCompaniaPais != null) {
                fila.put("pais", datosCompaniaPais.getPais());
            }

            var datosEmpresaBasicos = datosEmpresaRepository.findByCompanySymbol(symbol);
            if (datosEmpresaBasicos != null) {
                fila.put("companyName", datosEmpresaBasicos.getCompanyName());
            }

            var precioDatos = precioYDatosGeneralesRepository.findByCompanySymbol(symbol);
            if (precioDatos != null) {
                fila.put("perTtm", precioDatos.getPerTtm());
                fila.put("situacionCaja", precioDatos.getSituacionCaja());
            }

            var ratioValoracion = ratiosDeValoracionRepository.findByCompanySymbol(symbol);
            if (ratioValoracion != null) {
                fila.put("evFcf", ratioValoracion.getEvFcf());
            }

            var ratioRentabilidad = ratiosRentabilidadRepository.findByCompanySymbol(symbol);
            if (ratioRentabilidad != null) {
                fila.put("roce", ratioRentabilidad.getRoce());
            }

            var posicionFinanciera = posicionFinancieraRepository.findByCompanySymbol(symbol);
            if (posicionFinanciera != null) {
                fila.put("ratioDeuda", posicionFinanciera.getRatioDeuda());
                fila.put("liquidez", posicionFinanciera.getLiquidez());
            }

            var margenesSobreVentas = margenesDeLaCompaniaRepository.findByCompanySymbol(symbol);
            if (margenesSobreVentas != null) {
                fila.put("margenBruto", margenesSobreVentas.getMargenBruto());
                fila.put("margenNeto", margenesSobreVentas.getMargenNeto());
            }

            var dividendos = dividendosRepository.findByCompanySymbol(symbol);
            if (dividendos != null) {
                fila.put("dividendYieldTtm", dividendos.getDividendYieldTtm());
                fila.put("PayoutRatioTtm", dividendos.getPayoutRatioTtm());
            }
            resultados.add(fila);
        });
        return resultados;
    }

}
