package finanzas_pro.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TableManagementService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void resetAllTables() {
        dropTables();
        createTables();
    }

    private void dropTables() {
        entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS datos_compañia").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS precio_y_datos_generales").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS datos_empresa").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS datos_por_accion").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS margenes_de_la_compañia").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS eficiencia_en_ventas_activos").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS ratios_de_valoracion").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS ratios_rentabilidad").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS posicion_financiera").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS dividendos").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS valor_intrinseco").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS analistas_score").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS gastos_sobre_ventas").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS crecimientos_por_accion").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS distribucion_acciones_y_cotizacion").executeUpdate();
        entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();
    }


    private void createTables() {
        createDatosEmpresaTable();
        createPrecioYDatosGeneralesTable();
        createDatosCompaniaTable();
        createDatosPorAccionTable();
        createMargenesDeLaCompaniaTable();
        createEficienciaEnVentasActivosTable();
        createRatiosDeValoracionTable();
        createRatiosRentabilidadTable();
        createPosicionFinancieraTable();
        createDividendosTable();
        createValorIntrinsecoTable();
        createAnalistasScoreTable();
        createGastosSobreVentasTable();
        createCrecimientosPorAccionTable();
        createDistribucionAccionesYCotizacionTable();
    }

    private void createDatosEmpresaTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE datos_empresa (
                        company_symbol VARCHAR(255) NOT NULL,
                        CompanyName VARCHAR(200),
                        PRIMARY KEY (company_symbol)
                    )
                """).executeUpdate();
    }


    private void createPrecioYDatosGeneralesTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE precio_y_datos_generales (
                        company_symbol VARCHAR(255) NOT NULL,
                        Precio DECIMAL(36,16),
                        min52s_max52s DECIMAL(36,16),
                        Beta DECIMAL(36,16),
                        per_ttm DECIMAL(36,16),
                        tamaño_mercado ENUM('BIG CAP','MICRO CAP','MID CAP','SMALL CAP') NULL,
                        market_cap BIGINT,
                        valor_empresa BIGINT,
                        situacion_caja ENUM('CAJA NETA','DEUDA NETA'),
                        ultimo_dividendo DECIMAL(36,16),
                        `Rango 52S` TEXT,
                        minimo_52s DECIMAL(36,16),
                        maximo_52s DECIMAL(36,16),
                        PRIMARY KEY (company_symbol),
                        FOREIGN KEY (company_symbol) REFERENCES datos_empresa(company_symbol)
                    )
                """).executeUpdate();
    }

    private void createDatosCompaniaTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE datos_compañia (
                        company_symbol VARCHAR(50) NOT NULL,
                        moneda VARCHAR(3),
                        ISIN TINYTEXT,
                        bolsa VARCHAR(100),
                        sector VARCHAR(100),
                        industria VARCHAR(100),
                        país VARCHAR(100),
                        empleados INT,
                        CEO VARCHAR(150),
                        web VARCHAR(200),
                        fecha_Ipo DATE,
                        PRIMARY KEY (company_symbol),
                        FOREIGN KEY (company_symbol) REFERENCES datos_empresa(company_symbol)
                    )
                """).executeUpdate();
    }

    private void createDatosPorAccionTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE datos_por_accion (
                        company_symbol VARCHAR(255) NOT NULL,
                        eps_ttm DECIMAL(36,16),
                        caja_por_accion DECIMAL(36,16),
                        valor_en_libros_por_accion DECIMAL(36,16),
                        fcf_por_accion DECIMAL(36,16),
                        PRIMARY KEY (company_symbol),
                        FOREIGN KEY (company_symbol) REFERENCES datos_empresa(company_symbol)
                    )
                """).executeUpdate();
    }

    private void createMargenesDeLaCompaniaTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE margenes_de_la_compañia (
                        company_symbol VARCHAR(255) NOT NULL,
                        margen_bruto DECIMAL(36,16),
                        margen_operativo DECIMAL(36,16),
                        margen_ebt DECIMAL(36,16),
                        margen_neto DECIMAL(36,16),
                        tasa_impuesto DECIMAL(36,16),
                        PRIMARY KEY (company_symbol),
                        FOREIGN KEY (company_symbol) REFERENCES datos_empresa(company_symbol)
                    )
                """).executeUpdate();
    }

    private void createEficienciaEnVentasActivosTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE eficiencia_en_ventas_activos (
                        company_symbol VARCHAR(255) NOT NULL,
                        days_of_sales_outstanding_ttm DECIMAL(36,16),
                        days_of_inventory_outstanding_ttm DECIMAL(36,16),
                        ciclo_operativo DECIMAL(36,16),
                        rotacion_cuentas_por_cobrar DECIMAL(36,16),
                        rotacion_proveedores DECIMAL(36,16),
                        rotacion_inventarios DECIMAL(36,16),
                        rotacion_activos_fijos DECIMAL(36,16),
                        rotacion_activos DECIMAL(36,16),
                        PRIMARY KEY (company_symbol),
                        FOREIGN KEY (company_symbol) REFERENCES datos_empresa(company_symbol)
                    )
                """).executeUpdate();
    }

    private void createRatiosDeValoracionTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE ratios_de_valoracion (
                        company_symbol VARCHAR(255) NOT NULL,
                        pe_ttm DECIMAL(36,16),
                        precio_ventas DECIMAL(36,16),
                        precio_fcf DECIMAL(36,16),
                        precio_cash_flow DECIMAL(36,16),
                        precio_valor_libros DECIMAL(36,16),
                        peg_ratio_ttm DECIMAL(36,16),
                        ev_ventas DECIMAL(36,16),
                        ev_ebitda DECIMAL(65,16),
                        ev_cfo DECIMAL(36,16),
                        ev_fcf DECIMAL(36,16),
                        porcentaje_beneficio DECIMAL(36,16),
                        porcentaje_fcf DECIMAL(36,16),
                        PRIMARY KEY (company_symbol),
                        FOREIGN KEY (company_symbol) REFERENCES datos_empresa(company_symbol)
                    )
                """).executeUpdate();
    }

    private void createRatiosRentabilidadTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE ratios_rentabilidad (
                        company_symbol VARCHAR(255) NOT NULL,
                        roa DECIMAL(36,16),
                        roe DECIMAL(36,16),
                        roce DECIMAL(36,16),
                        PRIMARY KEY (company_symbol),
                        FOREIGN KEY (company_symbol) REFERENCES datos_empresa(company_symbol)
                    )
                """).executeUpdate();
    }

    private void createPosicionFinancieraTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE posicion_financiera (
                        company_symbol VARCHAR(255) NOT NULL,
                        deuda_equity DECIMAL(36,16),
                        deuda_activos DECIMAL(36,16),
                        deuda_neta_ebitda DECIMAL(36,16),
                        ratio_deuda DECIMAL(36,16),
                        deuda_longterm_capitalizacion DECIMAL(36,16),
                        liquidez DECIMAL(36,16),
                        quickratio_ttm DECIMAL(36,16),
                        cobertura_intereses DECIMAL(36,16),
                        deuda_capitalizacion DECIMAL(36,16),
                        calidad_beneficio_neto DECIMAL(36,16),
                        company_equity_multiplier DECIMAL(36,16),
                        PRIMARY KEY (company_symbol),
                        FOREIGN KEY (company_symbol) REFERENCES datos_empresa(company_symbol)
                    )
                """).executeUpdate();
    }

    private void createDividendosTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE dividendos (
                        company_symbol VARCHAR(255) NOT NULL,
                        dividend_yield_ttm DECIMAL(36,16),
                        payoutRatioTTM DECIMAL(36,16),
                        PRIMARY KEY (company_symbol),
                        FOREIGN KEY (company_symbol) REFERENCES datos_empresa(company_symbol)
                    )
                """).executeUpdate();
    }

    private void createValorIntrinsecoTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE valor_intrinseco (
                        company_symbol VARCHAR(255) NOT NULL,
                        cotizacion DECIMAL(36,16),
                        graham_number_ttm DECIMAL(36,16),
                        graham_net_ttm DECIMAL(36,16),
                        dcf DECIMAL(36,16),
                        precio_analistas DECIMAL(36,16),
                        PRIMARY KEY (company_symbol),
                        FOREIGN KEY (company_symbol) REFERENCES datos_empresa(company_symbol)
                    )
                """).executeUpdate();
    }

    private void createAnalistasScoreTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE analistas_score (
                        company_symbol VARCHAR(20) NOT NULL,
                        rating VARCHAR(10),
                        score INT,
                        recomendation VARCHAR(255),
                        Altman_score DECIMAL(30,14),
                        piotroski_score INT,
                        PRIMARY KEY (company_symbol),
                        FOREIGN KEY (company_symbol) REFERENCES datos_empresa(company_symbol)
                    )
                """).executeUpdate();
    }

    private void createGastosSobreVentasTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE gastos_sobre_ventas (
                        company_symbol VARCHAR(50) NOT NULL,
                        svg_to_revenue_ttm DECIMAL(36,16),
                        `i+d_to_revenue_ttm` DECIMAL(36,16),
                        capex_to_cfo_ttm DECIMAL(36,16),
                        capex_to_revenue_ttm DECIMAL(36,16),
                        sbc_to_revenue_ttm DECIMAL(36,16),
                        revenues BIGINT,
                        PRIMARY KEY (company_symbol),
                        FOREIGN KEY (company_symbol) REFERENCES datos_empresa(company_symbol)
                    )
                """).executeUpdate();
    }

    private void createCrecimientosPorAccionTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE crecimientos_por_accion (
                        company_symbol VARCHAR(50) NOT NULL,
                        revenues_cagr_10y DECIMAL(36,16),
                        revenues_cagr_5y DECIMAL(36,16),
                        cashflow_cagr_10y DECIMAL(36,16),
                        cashflow_cagr_5y DECIMAL(36,16),
                        eps_cagr_10y DECIMAL(36,16),
                        eps_cagr_5y DECIMAL(36,16),
                        equity_cagr_5y DECIMAL(36,16),
                        dividends_cagr_10y DECIMAL(36,16),
                        dividends_cagr_5y DECIMAL(36,16),
                        PRIMARY KEY (company_symbol),
                        FOREIGN KEY (company_symbol) REFERENCES datos_empresa(company_symbol)
                    )
                """).executeUpdate();
    }

    private void createDistribucionAccionesYCotizacionTable() {
        entityManager.createNativeQuery("""
                    CREATE TABLE distribucion_acciones_y_cotizacion (
                        company_symbol VARCHAR(50) NOT NULL,
                        porcentaje_insiders DECIMAL(36,16),
                        porcentaje_institucionales DECIMAL(36,16),
                        variacion_acc_10y DECIMAL(36,16),
                        cotizacion_cagr_5y DECIMAL(36,16),
                        cotizacion_cagr_10y DECIMAL(36,16),
                        PRIMARY KEY (company_symbol),
                        FOREIGN KEY (company_symbol) REFERENCES datos_empresa(company_symbol)
                    )
                """).executeUpdate();
    }

}