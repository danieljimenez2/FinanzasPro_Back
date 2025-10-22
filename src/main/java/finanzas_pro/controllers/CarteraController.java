package finanzas_pro.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartera")
public class CarteraController {

    @PutMapping("/anadir")
    public void insertarFavoritos(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {

    }

    @GetMapping("/lista")
    public void recogerListaCartera() {

    }

    @GetMapping("comprobar")
    public boolean comprobarSiEsFavorito(
            @RequestHeader("companySymbol")
            String companySymbol
    ) {
        return false;
    }
}
