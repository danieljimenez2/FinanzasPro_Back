package finanzas_pro.modells.entities;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "eficiencia_en_ventas_activos")
public class Eficiencia_En_Ventas_Activos {


    @Id
    @Column(name = "company_symbol", length = 50, nullable = false)
    private String companySymbol;

    @OneToOne
    @MapsId // comparte PK con datos_compania
    @JoinColumn(name = "company_symbol")
    private Datos_Empresa datosEmpresa;

    @Column(name = "days_of_sales_outstanding_ttm", precision = 36, scale = 16)
    private BigDecimal daysOfSalesOutstandingTtm;

    @Column(name = "days_of_inventory_outstanding_ttm", precision = 36, scale = 16)
    private BigDecimal daysOfInventoryOutstandingTtm;

    @Column(name = "ciclo_operativo", precision = 36, scale = 16)
    private BigDecimal cicloOperativo;

    @Column(name = "rotacion_cuentas_por_cobrar", precision = 36, scale = 16)
    private BigDecimal rotacionCuentasPorCobrar;

    @Column(name = "rotacion_proveedores", precision = 36, scale = 16)
    private BigDecimal rotacionProveedores;

    @Column(name = "rotacion_inventarios", precision = 36, scale = 16)
    private BigDecimal rotacionInventarios;

    @Column(name = "rotacion_activos_fijos", precision = 36, scale = 16)
    private BigDecimal rotacionActivosFijos;

    @Column(name = "rotacion_activos", precision = 36, scale = 16)
    private BigDecimal rotacionActivos;

    public String getCompanySymbol() {
        return companySymbol;
    }

    public void setCompanySymbol(String companySymbol) {
        this.companySymbol = companySymbol;
    }

    public Datos_Empresa getDatosEmpresa() {
        return datosEmpresa;
    }

    public void setDatosEmpresa(Datos_Empresa datosEmpresa) {
        this.datosEmpresa = datosEmpresa;
    }

    public BigDecimal getDaysOfSalesOutstandingTtm() {
        return daysOfSalesOutstandingTtm;
    }

    public void setDaysOfSalesOutstandingTtm(BigDecimal daysOfSalesOutstandingTtm) {
        this.daysOfSalesOutstandingTtm = daysOfSalesOutstandingTtm;
    }

    public BigDecimal getDaysOfInventoryOutstandingTtm() {
        return daysOfInventoryOutstandingTtm;
    }

    public void setDaysOfInventoryOutstandingTtm(BigDecimal daysOfInventoryOutstandingTtm) {
        this.daysOfInventoryOutstandingTtm = daysOfInventoryOutstandingTtm;
    }

    public BigDecimal getCicloOperativo() {
        return cicloOperativo;
    }

    public void setCicloOperativo(BigDecimal cicloOperativo) {
        this.cicloOperativo = cicloOperativo;
    }

    public BigDecimal getRotacionCuentasPorCobrar() {
        return rotacionCuentasPorCobrar;
    }

    public void setRotacionCuentasPorCobrar(BigDecimal rotacionCuentasPorCobrar) {
        this.rotacionCuentasPorCobrar = rotacionCuentasPorCobrar;
    }

    public BigDecimal getRotacionProveedores() {
        return rotacionProveedores;
    }

    public void setRotacionProveedores(BigDecimal rotacionProveedores) {
        this.rotacionProveedores = rotacionProveedores;
    }

    public BigDecimal getRotacionInventarios() {
        return rotacionInventarios;
    }

    public void setRotacionInventarios(BigDecimal rotacionInventarios) {
        this.rotacionInventarios = rotacionInventarios;
    }

    public BigDecimal getRotacionActivosFijos() {
        return rotacionActivosFijos;
    }

    public void setRotacionActivosFijos(BigDecimal rotacionActivosFijos) {
        this.rotacionActivosFijos = rotacionActivosFijos;
    }

    public BigDecimal getRotacionActivos() {
        return rotacionActivos;
    }

    public void setRotacionActivos(BigDecimal rotacionActivos) {
        this.rotacionActivos = rotacionActivos;
    }
}
