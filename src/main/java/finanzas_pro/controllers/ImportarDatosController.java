package finanzas_pro.controllers;

import finanzas_pro.services.ExcelImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/excel")
public class ImportarDatosController {

    @Autowired
    private ExcelImportService excelImportService;

    @PostMapping("/importar")
    public ResponseEntity<String> importarExcel(@RequestParam("file") MultipartFile file) {
        try {
            excelImportService.importarExcel(file);
            return ResponseEntity.ok("Archivo importado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al importar el archivo: " + e.getMessage());
        }
    }
}