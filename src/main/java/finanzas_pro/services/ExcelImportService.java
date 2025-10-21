package finanzas_pro.services;

import finanzas_pro.models.entities.*;
import finanzas_pro.repositories.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class ExcelImportService {

    private final TableManagementService tableManager;
    private final DatosEmpresaRepository datosEmpresaRepo;
    private final PrecioYDatosGeneralesRepository precioRepo;
    private final DatosCompaniaRepository compañiaRepo;
    private final DatosPorAccionRepository datosPorAccionRepo;
    private final MargenesDeLaCompaniaRepository margenesDeLaCompañiaRepo;
    private final EficienciaEnVentasActivosRepository eficienciaEnVentasActivosRepo;
    private final RatiosDeValoracionRepository ratiosDeValoracionRepo;
    private final RatiosRentabilidadRepository ratiosRentabilidadRepo;
    private final PosicionFinancieraRepository posicionFinancieraRepo;
    private final DividendosRepository dividendosRepo;
    private final ValorIntrinsecoRepository valorIntrinsecoRepo;
    private final AnalistasScoreRepository analistasScoreRepo;
    private final GastosSobreVentasRepository gastosSobreVentasRepo;
    private final CrecimientoPorAccionRepository crecimientosPorAccionRepo;
    private final DistribucionAccionesYCotizacionRepository distribucionAccionesYCotizacionRepo;


    public ExcelImportService(TableManagementService tableManager,
                              DatosEmpresaRepository datosEmpresaRepo,
                              PrecioYDatosGeneralesRepository precioRepo,
                              DatosCompaniaRepository compañiaRepo,
                              DatosPorAccionRepository datosPorAccionRepo,
                              MargenesDeLaCompaniaRepository margenesDeLaCompañiaRepo,
                              EficienciaEnVentasActivosRepository eficienciaEnVentasActivosRepo,
                              RatiosDeValoracionRepository ratiosDeValoracionRepo,
                              RatiosRentabilidadRepository ratiosRentabilidadRepo,
                              PosicionFinancieraRepository posicionFinancieraRepo,
                              DividendosRepository dividendosRepo,
                              ValorIntrinsecoRepository valorIntrinsecoRepo,
                              AnalistasScoreRepository analistasScoreRepo,
                              GastosSobreVentasRepository gastosSobreVentasRepo,
                              CrecimientoPorAccionRepository crecimientosPorAccionRepo,
                              DistribucionAccionesYCotizacionRepository distribucionAccionesYCotizacionRepo) {
        this.tableManager = tableManager;
        this.datosEmpresaRepo = datosEmpresaRepo;
        this.precioRepo = precioRepo;
        this.compañiaRepo = compañiaRepo;
        this.datosPorAccionRepo = datosPorAccionRepo;
        this.margenesDeLaCompañiaRepo = margenesDeLaCompañiaRepo;
        this.eficienciaEnVentasActivosRepo = eficienciaEnVentasActivosRepo;
        this.ratiosDeValoracionRepo = ratiosDeValoracionRepo;
        this.ratiosRentabilidadRepo = ratiosRentabilidadRepo;
        this.posicionFinancieraRepo = posicionFinancieraRepo;
        this.dividendosRepo = dividendosRepo;
        this.valorIntrinsecoRepo = valorIntrinsecoRepo;
        this.analistasScoreRepo = analistasScoreRepo;
        this.gastosSobreVentasRepo = gastosSobreVentasRepo;
        this.crecimientosPorAccionRepo = crecimientosPorAccionRepo;
        this.distribucionAccionesYCotizacionRepo = distribucionAccionesYCotizacionRepo;
    }

    @Transactional
    public void importarExcel(MultipartFile file) throws Exception {
        //Borrar cada vez que se importa un excel
        tableManager.resetAllTables();

        // String ruta = "C:\\Users\\Dadic\\Desktop\\Aplicacion base de datos Serbatic\\TablasEmpresaMenor - copia.xlsx";
        // String ruta = "C:\\Users\\Dadic\\Desktop\\Aplicacion base de datos Serbatic\\Excel con todas las cifras.xlsx";
        // String ruta = "C:\\Users\\Dadic\\Desktop\\Aplicacion base de datos Serbatic\\Excel sin modificar.xlsm";

        // justo antes de abrir el Workbook:
        IOUtils.setByteArrayMaxOverride(200_000_000); // o 200 MB, por ejemplo
        //Modificar esto para obtenerlo del front
        try (InputStream inputStream = file.getInputStream();

             Workbook workbook = WorkbookFactory.create(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 3; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                // --- DATOS EMPRESA ---
                String symbol = getString(row.getCell(0));
                String companyName = getString(row.getCell(1));
                if (symbol == null || symbol.isBlank()) continue;

                DatosEmpresa empresa = datosEmpresaRepo.findById(symbol).orElseGet(() -> {
                    DatosEmpresa e = new DatosEmpresa();
                    e.setCompanySymbol(symbol);
                    e.setCompanyName(companyName);
                    return datosEmpresaRepo.save(e);
                });


                // --- PRECIO Y DATOS GENERALES ---
                PrecioYDatosGenerales precio = new PrecioYDatosGenerales();
                precio.setDatosEmpresa(empresa);
                precio.setPrecio(getDecimal(row.getCell(2)));
                precio.setMin52sMax52s(getDecimal(row.getCell(3)));
                precio.setBeta(getDecimal(row.getCell(4)));
                precio.setPerTtm(getDecimal(row.getCell(5)));

                String tamMercado = getString(row.getCell(6));
                if ("null".equalsIgnoreCase(tamMercado)) {
                    tamMercado = null;
                }
                if (tamMercado != null) {
                    tamMercado = tamMercado.trim();
                }
                List<String> allowed = List.of("BIG CAP", "MICRO CAP", "MID CAP", "SMALL CAP");
                if (tamMercado == null || !allowed.contains(tamMercado)) {
                    tamMercado = null;
                }
                precio.setTamanoMercado(tamMercado);

                //precio.setTamanoMercado(getString(row.getCell(6)));
                precio.setMarketCap(getLong(row.getCell(7)));
                precio.setValorEmpresa(getLong(row.getCell(8)));
                String situacion = getString(row.getCell(11));
                if (situacion != null && !situacion.equals("CAJA NETA") && !situacion.equals("DEUDA NETA")) {
                    situacion = null; // fuerza null si no coincide con los valores del ENUM
                }
                precio.setSituacionCaja(situacion);
                //precio.setSituacionCaja(getString(row.getCell(11)));
                precio.setUltimoDividendo(getDecimal(row.getCell(12)));
                precio.setRango52s(getString(row.getCell(13)));
                precio.setMinimo52s(getDecimal(row.getCell(14)));
                precio.setMaximo52s(getDecimal(row.getCell(15)));
                precioRepo.save(precio);

                // --- DATOS COMPAÑÍA ---
                DatosCompañia compañia = new DatosCompañia();
                compañia.setDatosEmpresa(empresa);
                compañia.setMoneda(getString(row.getCell(16)));
                compañia.setISIN(getString(row.getCell(17)));
                compañia.setBolsa(getString(row.getCell(18)));
                compañia.setSector(getString(row.getCell(19)));
                compañia.setIndustria(getString(row.getCell(20)));
                compañia.setPaís(getString(row.getCell(21)));
                compañia.setEmpleados(getInt(row.getCell(22)));
                compañia.setCEO(getString(row.getCell(23)));
                compañia.setWeb(getString(row.getCell(24)));
                compañia.setFechaIpo(getDate(row.getCell(25)));
                compañiaRepo.save(compañia);


                // --- DATOS POR ACCIÓN ---
                DatosPorAccion datosPorAccion = new DatosPorAccion();
                datosPorAccion.setDatosEmpresa(empresa);
                datosPorAccion.setEpsTtm(getDecimal(row.getCell(26)));
                datosPorAccion.setCajaPorAccion(getDecimal(row.getCell(27)));
                datosPorAccion.setValorEnLibrosPorAccion(getDecimal(row.getCell(28)));
                datosPorAccion.setFcfPorAccion(getDecimal(row.getCell(29)));
                datosPorAccionRepo.save(datosPorAccion);


                // --- MÁRGENES DE LA COMPAÑÍA ---
                MargenesDeLaCompañia margenes = new MargenesDeLaCompañia();
                margenes.setDatosEmpresa(empresa);
                margenes.setMargenBruto(getDecimal(row.getCell(30)));
                margenes.setMargenOperativo(getDecimal(row.getCell(31)));
                margenes.setMargenEBT(getDecimal(row.getCell(32)));
                margenes.setMargenNeto(getDecimal(row.getCell(33)));
                margenes.setTasaImpuesto(getDecimal(row.getCell(34)));
                margenesDeLaCompañiaRepo.save(margenes);


                // --- EFICIENCIA EN VENTAS Y ACTIVOS ---
                EficienciaEnVentasActivos eficiencia = new EficienciaEnVentasActivos();
                eficiencia.setDatosEmpresa(empresa);
                eficiencia.setDaysOfSalesOutstandingTtm(getDecimal(row.getCell(35)));
                eficiencia.setDaysOfInventoryOutstandingTtm(getDecimal(row.getCell(36)));
                eficiencia.setCicloOperativo(getDecimal(row.getCell(37)));
                eficiencia.setRotacionCuentasPorCobrar(getDecimal(row.getCell(38)));
                eficiencia.setRotacionProveedores(getDecimal(row.getCell(39)));
                eficiencia.setRotacionInventarios(getDecimal(row.getCell(40)));
                eficiencia.setRotacionActivosFijos(getDecimal(row.getCell(41)));
                eficiencia.setRotacionActivos(getDecimal(row.getCell(42)));
                eficienciaEnVentasActivosRepo.save(eficiencia);


                // --- RATIOS DE VALORACIÓN ---
                RatiosDeValoracion ratios = new RatiosDeValoracion();
                ratios.setDatosEmpresa(empresa);
                ratios.setPeTtm(getDecimal(row.getCell(43)));
                ratios.setPrecioVentas(getDecimal(row.getCell(44)));
                ratios.setPrecioFcf(getDecimal(row.getCell(45)));
                ratios.setPrecioCashFlow(getDecimal(row.getCell(46)));
                ratios.setPrecioValorLibros(getDecimal(row.getCell(47)));
                ratios.setPegRatioTtm(getDecimal(row.getCell(48)));
                ratios.setEvVentas(getDecimal(row.getCell(49)));
                ratios.setEvEbitda(getDecimal(row.getCell(50)));
                ratios.setEvCfo(getDecimal(row.getCell(51)));
                ratios.setEvFcf(getDecimal(row.getCell(52)));
                ratios.setPorcentajeBeneficio(getDecimal(row.getCell(53)));
                ratios.setPorcentajeFcf(getDecimal(row.getCell(54)));
                ratiosDeValoracionRepo.save(ratios);


                // --- RATIOS RENTABILIDAD ---
                RatiosRentabilidad rentabilidad = new RatiosRentabilidad();
                rentabilidad.setDatosEmpresa(empresa);
                rentabilidad.setRoa(getDecimal(row.getCell(55)));
                rentabilidad.setRoe(getDecimal(row.getCell(56)));
                rentabilidad.setRoce(getDecimal(row.getCell(57)));
                ratiosRentabilidadRepo.save(rentabilidad);


                // --- POSICIÓN FINANCIERA ---
                PosicionFinanciera posicion = new PosicionFinanciera();
                posicion.setDatosEmpresa(empresa);
                posicion.setDeudaEquity(getDecimal(row.getCell(59)));
                posicion.setDeudaActivos(getDecimal(row.getCell(61)));
                posicion.setDeudaNetaEbitda(getDecimal(row.getCell(62)));
                posicion.setRatioDeuda(getDecimal(row.getCell(63)));
                posicion.setDeudaLongtermCapitalizacion(getDecimal(row.getCell(64)));
                posicion.setLiquidez(getDecimal(row.getCell(65)));
                posicion.setQuickratioTtm(getDecimal(row.getCell(66)));
                posicion.setCoberturaIntereses(getDecimal(row.getCell(67)));
                posicion.setDeudaCapitalizacion(getDecimal(row.getCell(68)));
                posicion.setCalidadBeneficioNeto(getDecimal(row.getCell(69)));
                posicion.setCompanyEquityMultiplier(getDecimal(row.getCell(70)));
                posicionFinancieraRepo.save(posicion);


                // --- DIVIDENDOS ---
                Dividendos dividendos = new Dividendos();
                dividendos.setDatosEmpresa(empresa);
                dividendos.setDividendYieldTtm(getDecimal(row.getCell(71)));
                dividendos.setPayoutRatioTtm(getDecimal(row.getCell(72)));
                dividendosRepo.save(dividendos);


                // --- VALOR INTRÍNSECO ---
                ValorIntrinseco valorIntrinseco = new ValorIntrinseco();
                valorIntrinseco.setDatosEmpresa(empresa);
                valorIntrinseco.setCotizacion(getDecimal(row.getCell(73)));
                valorIntrinseco.setGrahamNumberTtm(getDecimal(row.getCell(74)));
                valorIntrinseco.setGrahamNetTtm(getDecimal(row.getCell(75)));
                valorIntrinseco.setDcf(getDecimal(row.getCell(76)));
                valorIntrinseco.setPrecioAnalistas(getDecimal(row.getCell(77)));
                valorIntrinsecoRepo.save(valorIntrinseco);


                // --- ANALISTAS SCORE ---
                AnalistasScore analistasScore = new AnalistasScore();
                analistasScore.setDatosEmpresa(empresa);
                analistasScore.setRating(getString(row.getCell(79)));
                analistasScore.setScore(getInt(row.getCell(80)));
                analistasScore.setRecomendation(getString(row.getCell(81)));
                analistasScore.setAltmanScore(getDecimal(row.getCell(82)));
                analistasScore.setPiotroskiScore(getInt(row.getCell(83)));

                analistasScoreRepo.save(analistasScore);


                // --- GASTOS SOBRE VENTAS ---
                GastosSobreVentas gastosSobreVentas = new GastosSobreVentas();
                gastosSobreVentas.setDatosEmpresa(empresa);
                gastosSobreVentas.setSvgToRevenueTtm(getDecimal(row.getCell(84)));
                gastosSobreVentas.setiMasdToRevenueTtm(getDecimal(row.getCell(85)));
                gastosSobreVentas.setCapexToCfoTtm(getDecimal(row.getCell(86)));
                gastosSobreVentas.setCapexToRevenueTtm(getDecimal(row.getCell(87)));
                gastosSobreVentas.setSbcToRevenueTtm(getDecimal(row.getCell(88)));
                gastosSobreVentas.setRevenues(getLong(row.getCell(89)));

                gastosSobreVentasRepo.save(gastosSobreVentas);


                // --- CRECIMIENTOS POR ACCIÓN ---
                CrecimientosPorAccion crecimientos = new CrecimientosPorAccion();
                crecimientos.setDatosEmpresa(empresa);
                crecimientos.setRevenuesCagr10y(getDecimal(row.getCell(90)));
                crecimientos.setRevenuesCagr5y(getDecimal(row.getCell(91)));
                crecimientos.setCashflowCagr10y(getDecimal(row.getCell(92)));
                crecimientos.setCashflowCagr5y(getDecimal(row.getCell(93)));
                crecimientos.setEpsCagr10y(getDecimal(row.getCell(94)));
                crecimientos.setEpsCagr5y(getDecimal(row.getCell(95)));
                crecimientos.setEquityCagr5y(getDecimal(row.getCell(96)));
                crecimientos.setDividendsCagr10y(getDecimal(row.getCell(97)));
                crecimientos.setDividendsCagr5y(getDecimal(row.getCell(98)));

                crecimientosPorAccionRepo.save(crecimientos);


                // --- DISTRIBUCIÓN DE ACCIONES Y COTIZACIÓN ---
                DistribucionAccionesYCotizacion distribucion = new DistribucionAccionesYCotizacion();
                distribucion.setDatosEmpresa(empresa);
                distribucion.setPorcentajeInsiders(getDecimal(row.getCell(99)));
                distribucion.setPorcentajeInstitucionales(getDecimal(row.getCell(100)));
                distribucion.setVariacionAcc10y(getDecimal(row.getCell(101)));
                distribucion.setCotizacionCagr5y(getDecimal(row.getCell(102)));
                distribucion.setCotizacionCagr10y(getDecimal(row.getCell(103)));

                distribucionAccionesYCotizacionRepo.save(distribucion);
            }


        }
    }

    // --- Métodos auxiliares ---

    private String getString(Cell cell) {
        if (cell == null) return null;
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue()); // si hay números
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula().trim();
            default:
                return null;
        }
    }

    private BigDecimal getDecimal(Cell cell) {
        try {
            if (cell == null) return null;
            if (cell.getCellType() == CellType.NUMERIC)
                return BigDecimal.valueOf(cell.getNumericCellValue());
            else if (cell.getCellType() == CellType.STRING)
                return new BigDecimal(cell.getStringCellValue().trim().replace(",", "."));
            else return null;
        } catch (Exception e) {
            return null;
        }
    }

    private Long getLong(Cell cell) {
        try {
            if (cell == null) return null;
            if (cell.getCellType() == CellType.NUMERIC)
                return (long) cell.getNumericCellValue();
            else if (cell.getCellType() == CellType.STRING)
                return Long.parseLong(cell.getStringCellValue().replaceAll("[^0-9]", ""));
            else return null;
        } catch (Exception e) {
            return null;
        }
    }

    private Integer getInt(Cell cell) {
        Long val = getLong(cell);
        return val != null ? val.intValue() : null;
    }

    //Hay que sumarle un dia porque excel cuenta desde otra fecha.
    //¿Se puede convertir a String y parsear sin mas?
    private Date getDate(Cell cell) {
        if (cell == null) return null;

        try {
            // --- Caso 1: celda como texto ---
            if (cell.getCellType() == CellType.STRING) {
                String text = cell.getStringCellValue().trim();
                if (text.isEmpty() || text.equalsIgnoreCase("null")) return null;

                java.time.LocalDate localDate = java.time.LocalDate.parse(
                        text, java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd")
                );
                localDate = localDate.plusDays(1); // sumar un día
                return java.sql.Date.valueOf(localDate);
            }

            // --- Caso 2: celda como fecha NUMERIC ---
            if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                Date date = cell.getDateCellValue();
                java.time.LocalDate localDate = date.toInstant()
                        .atZone(ZoneId.of("UTC"))
                        .toLocalDate();
                localDate = localDate.plusDays(1); // sumar un día
                return java.sql.Date.valueOf(localDate);
            }

        } catch (Exception e) {
            System.out.println("No se pudo parsear fecha: " + cell + " -> " + e.getMessage());
        }

        return null;
    }
}