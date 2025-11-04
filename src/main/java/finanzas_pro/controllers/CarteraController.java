package finanzas_pro.controllers;

import finanzas_pro.models.entities.Favoritos;
import finanzas_pro.services.CarteraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartera")
public class CarteraController {

    @Autowired
    private CarteraService carteraService;

    @PutMapping("/anadir")
    public Favoritos insertarFavoritos(
            @RequestHeader("companySymbol") String companySymbol
    ) {
        return carteraService.anadirAFavoritos(companySymbol);
    }

    @DeleteMapping("/borrar")
    public void borrarFavorito(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        carteraService.borrarFavoritos(companySymbol);
    }


    @GetMapping("/comprobar")
    public boolean comprobarSiEsFavorito(
            @RequestHeader("companySymbol") String companySymbol
    ) {
        return carteraService.comprobarSiEsFavorito(companySymbol);
    }

    @GetMapping("/lista")
    public List<Favoritos> recogerListaCartera(@RequestParam(defaultValue = "0") int pagina) {
        return carteraService.obtenerFavoritosPageable(pagina);
    }

    @GetMapping("/contar")
    public ResponseEntity<Long> contarResultados() {
        long resultado = this.carteraService.contarNumeroFavoritos();
        return ResponseEntity.ok(resultado);
    }

}
