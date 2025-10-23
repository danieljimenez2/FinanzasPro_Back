package finanzas_pro.services;

import finanzas_pro.models.entities.Favoritos;
import finanzas_pro.repositories.FavoritosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteraService {

    @Autowired
    private FavoritosRepository favoritosRepository;

    // Añadir a favoritos
    public Favoritos anadirAFavoritos(String companySymbol) {
        // Evita duplicados
        if (favoritosRepository.existsByCompanySymbol(companySymbol)) {
            return favoritosRepository.findByCompanySymbol(companySymbol);
        }

        Favoritos favorito = new Favoritos();
        favorito.setCompanySymbol(companySymbol);
        return favoritosRepository.save(favorito);
    }

    // Borrar favorito
    @Transactional
    public void borrarFavoritos(String companySymbol) {

        favoritosRepository.deleteByCompanySymbol(companySymbol);

    }

    // Comprobar si es favorito
    public boolean comprobarSiEsFavorito(String companySymbol) {
        return favoritosRepository.existsByCompanySymbol(companySymbol);
    }

    // Lista de todos los favoritos
    public List<Favoritos> obtenerFavoritos() {
        return favoritosRepository.findAll();
    }
}
