package finanzas_pro.models.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "distribucion_acciones_y_cotizacion")
public class DistribucionAccionesYCotizacion {


    @Id
    @Column(name = "company_symbol", length = 50, nullable = false)
    private String companySymbol;

    @OneToOne
    @MapsId // PK compartida con DatosCompania
    @JoinColumn(name = "company_symbol")
    private DatosEmpresa datosEmpresa;

    @Column(name = "porcentaje_insiders", precision = 36, scale = 16)
    private BigDecimal porcentajeInsiders;

    @Column(name = "porcentaje_institucionales", precision = 36, scale = 16)
    private BigDecimal porcentajeInstitucionales;

    @Column(name = "variacion_acc_10y", precision = 36, scale = 16)
    private BigDecimal variacionAcc10y;

    @Column(name = "cotizacion_cagr_5y", precision = 36, scale = 16)
    private BigDecimal cotizacionCagr5y;

    @Column(name = "cotizacion_cagr_10y", precision = 36, scale = 16)
    private BigDecimal cotizacionCagr10y;

    public String getCompanySymbol() {
        return companySymbol;
    }

    public void setCompanySymbol(String companySymbol) {
        this.companySymbol = companySymbol;
    }

    public DatosEmpresa getDatosEmpresa() {
        return datosEmpresa;
    }

    public void setDatosEmpresa(DatosEmpresa datosEmpresa) {
        this.datosEmpresa = datosEmpresa;
    }

    public BigDecimal getPorcentajeInsiders() {
        return porcentajeInsiders;
    }

    public void setPorcentajeInsiders(BigDecimal porcentajeInsiders) {
        this.porcentajeInsiders = porcentajeInsiders;
    }

    public BigDecimal getPorcentajeInstitucionales() {
        return porcentajeInstitucionales;
    }

    public void setPorcentajeInstitucionales(BigDecimal porcentajeInstitucionales) {
        this.porcentajeInstitucionales = porcentajeInstitucionales;
    }

    public BigDecimal getVariacionAcc10y() {
        return variacionAcc10y;
    }

    public void setVariacionAcc10y(BigDecimal variacionAcc10y) {
        this.variacionAcc10y = variacionAcc10y;
    }

    public BigDecimal getCotizacionCagr5y() {
        return cotizacionCagr5y;
    }

    public void setCotizacionCagr5y(BigDecimal cotizacionCagr5y) {
        this.cotizacionCagr5y = cotizacionCagr5y;
    }

    public BigDecimal getCotizacionCagr10y() {
        return cotizacionCagr10y;
    }

    public void setCotizacionCagr10y(BigDecimal cotizacionCagr10y) {
        this.cotizacionCagr10y = cotizacionCagr10y;
    }
}
