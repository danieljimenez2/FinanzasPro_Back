package finanzas_pro.controllers;


import finanzas_pro.models.entities.DatosEmpresa;
import finanzas_pro.services.DatosEmpresaYCompaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class DatosEmpresaController {

    @Autowired
    private DatosEmpresaYCompaniaService datosEmpresaYCompaniaService;

    @GetMapping("/list")
    public List<DatosEmpresa> getCompanies() {
        return datosEmpresaYCompaniaService.getFirst15Companies();
    }

    @GetMapping("/search")
    public List<DatosEmpresa> searchCompanies(String q) {
        return datosEmpresaYCompaniaService.searchCompanies(q);
    }

}
