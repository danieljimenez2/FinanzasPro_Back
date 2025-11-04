package finanzas_pro.services;

import finanzas_pro.models.entities.Favoritos;
import finanzas_pro.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteraService {

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

    @Autowired
    private FavoritosRepository favoritosRepository;


    public Favoritos anadirAFavoritos(String companySymbol) {
        Favoritos favorito = new Favoritos();
        favorito.setCompanySymbol(companySymbol);

        // Datos básicos
        var datosEmpresa = datosEmpresaRepository.findByCompanySymbol(companySymbol);
        if (datosEmpresa != null) {
            favorito.setCompanyName(datosEmpresa.getCompanyName());
        }

        // Precio y datos generales
        var precioDatos = precioYDatosGeneralesRepository.findByCompanySymbol(companySymbol);
        if (precioDatos != null) {
            favorito.setPerTtm(precioDatos.getPerTtm());
            favorito.setSituacionCaja(precioDatos.getSituacionCaja());
        }

        // Ratios de valoración
        var ratioValoracion = ratiosDeValoracionRepository.findByCompanySymbol(companySymbol);
        if (ratioValoracion != null) {
            favorito.setEvFcf(ratioValoracion.getEvFcf());
        }

        // Ratios de rentabilidad
        var ratioRentabilidad = ratiosRentabilidadRepository.findByCompanySymbol(companySymbol);
        if (ratioRentabilidad != null) {
            favorito.setRoce(ratioRentabilidad.getRoce());
        }

        // Posición financiera
        var posicionFinanciera = posicionFinancieraRepository.findByCompanySymbol(companySymbol);
        if (posicionFinanciera != null) {
            favorito.setRatioDeuda(posicionFinanciera.getRatioDeuda());
            favorito.setLiquidez(posicionFinanciera.getLiquidez());
        }

        // Márgenes
        var margenes = margenesDeLaCompaniaRepository.findByCompanySymbol(companySymbol);
        if (margenes != null) {
            favorito.setMargenBruto(margenes.getMargenBruto());
            favorito.setMargenNeto(margenes.getMargenNeto());
        }

        // Dividendos
        var dividendos = dividendosRepository.findByCompanySymbol(companySymbol);
        if (dividendos != null) {
            favorito.setDividendYieldTtm(dividendos.getDividendYieldTtm());
            favorito.setPayoutRatioTtm(dividendos.getPayoutRatioTtm());
        }
        // Guardamos o actualizamos si ya existe
        return favoritosRepository.save(favorito);
    }

    public Favoritos obtenerFavorito(String companySymbol) {
        return favoritosRepository.findByCompanySymbol(companySymbol);
    }

    public List<Favoritos> obtenerFavoritos() {
        return favoritosRepository.findAll();
    }

    /**
     * 🔹 Nuevo método pageable
     */
    public List<Favoritos> obtenerFavoritosPageable(int pagina) {
        return favoritosRepository.findAll(PageRequest.of(pagina, 10)).getContent();
    }

    @Transactional
    public void borrarFavoritos(String companySymbol) {
        favoritosRepository.deleteByCompanySymbol(companySymbol);
    }

    public boolean comprobarSiEsFavorito(String companySymbol) {
        return favoritosRepository.existsById(companySymbol);
    }

    public Long contarNumeroFavoritos() {
        return this.favoritosRepository.count();
    }
}
