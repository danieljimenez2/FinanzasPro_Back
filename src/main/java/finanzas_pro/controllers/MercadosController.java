package finanzas_pro.controllers;

import finanzas_pro.services.MercadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sector")
public class MercadosController {

    @Autowired
    private MercadosService mercadosService;

    @GetMapping("/individual")
    public ResponseEntity<List<Map<String, Object>>> recoger10EmpresasDeMercado(
            @RequestHeader("sector")
            String sector,
            @RequestHeader(value = "page", defaultValue = "0") int page
    ) {
        List<Map<String, Object>> resultados = mercadosService.recogerListaEmpresasPorSector(sector, page);
        return ResponseEntity.ok(resultados);
    }
}
