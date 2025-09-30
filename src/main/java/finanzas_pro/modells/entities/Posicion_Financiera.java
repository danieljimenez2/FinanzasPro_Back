package finanzas_pro.modells.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "posicion_financiera")
public class Posicion_Financiera {

    @Id
    @Column(name = "company_symbol", length = 50, nullable = false)
    private String companySymbol;

    @OneToOne
    @MapsId
    @JoinColumn(name = "company_symbol")
    private Datos_Empresa datosEmpresa;

    @Column(name = "deuda_equity", precision = 36, scale = 16)
    private BigDecimal deudaEquity;

    @Column(name = "deuda_activos", precision = 36, scale = 16)
    private BigDecimal deudaActivos;

    @Column(name = "deuda_neta_ebitda", precision = 36, scale = 16)
    private BigDecimal deudaNetaEbitda;

    @Column(name = "ratio_deuda", precision = 36, scale = 16)
    private BigDecimal ratioDeuda;

    @Column(name = "deuda_longterm_capitalizacion", precision = 36, scale = 16)
    private BigDecimal deudaLongtermCapitalizacion;

    @Column(name = "liquidez", precision = 36, scale = 16)
    private BigDecimal liquidez;

    @Column(name = "quickratio_ttm", precision = 36, scale = 16)
    private BigDecimal quickratioTtm;

    @Column(name = "cobertura_intereses", precision = 36, scale = 16)
    private BigDecimal coberturaIntereses;

    @Column(name = "deuda_capitalizacion", precision = 36, scale = 16)
    private BigDecimal deudaCapitalizacion;

    @Column(name = "calidad_beneficio_neto", precision = 36, scale = 16)
    private BigDecimal calidadBeneficioNeto;

    @Column(name = "company_equity_multiplier", precision = 36, scale = 16)
    private BigDecimal companyEquityMultiplier;

    @Column(name = "companyEquityMultiplier", precision = 36, scale = 16)
    private BigDecimal companyEquityMultiplierCamel;

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

    public BigDecimal getDeudaEquity() {
        return deudaEquity;
    }

    public void setDeudaEquity(BigDecimal deudaEquity) {
        this.deudaEquity = deudaEquity;
    }

    public BigDecimal getDeudaActivos() {
        return deudaActivos;
    }

    public void setDeudaActivos(BigDecimal deudaActivos) {
        this.deudaActivos = deudaActivos;
    }

    public BigDecimal getDeudaNetaEbitda() {
        return deudaNetaEbitda;
    }

    public void setDeudaNetaEbitda(BigDecimal deudaNetaEbitda) {
        this.deudaNetaEbitda = deudaNetaEbitda;
    }

    public BigDecimal getRatioDeuda() {
        return ratioDeuda;
    }

    public void setRatioDeuda(BigDecimal ratioDeuda) {
        this.ratioDeuda = ratioDeuda;
    }

    public BigDecimal getDeudaLongtermCapitalizacion() {
        return deudaLongtermCapitalizacion;
    }

    public void setDeudaLongtermCapitalizacion(BigDecimal deudaLongtermCapitalizacion) {
        this.deudaLongtermCapitalizacion = deudaLongtermCapitalizacion;
    }

    public BigDecimal getLiquidez() {
        return liquidez;
    }

    public void setLiquidez(BigDecimal liquidez) {
        this.liquidez = liquidez;
    }

    public BigDecimal getQuickratioTtm() {
        return quickratioTtm;
    }

    public void setQuickratioTtm(BigDecimal quickratioTtm) {
        this.quickratioTtm = quickratioTtm;
    }

    public BigDecimal getCoberturaIntereses() {
        return coberturaIntereses;
    }

    public void setCoberturaIntereses(BigDecimal coberturaIntereses) {
        this.coberturaIntereses = coberturaIntereses;
    }

    public BigDecimal getDeudaCapitalizacion() {
        return deudaCapitalizacion;
    }

    public void setDeudaCapitalizacion(BigDecimal deudaCapitalizacion) {
        this.deudaCapitalizacion = deudaCapitalizacion;
    }

    public BigDecimal getCalidadBeneficioNeto() {
        return calidadBeneficioNeto;
    }

    public void setCalidadBeneficioNeto(BigDecimal calidadBeneficioNeto) {
        this.calidadBeneficioNeto = calidadBeneficioNeto;
    }

    public BigDecimal getCompanyEquityMultiplier() {
        return companyEquityMultiplier;
    }

    public void setCompanyEquityMultiplier(BigDecimal companyEquityMultiplier) {
        this.companyEquityMultiplier = companyEquityMultiplier;
    }

    public BigDecimal getCompanyEquityMultiplierCamel() {
        return companyEquityMultiplierCamel;
    }

    public void setCompanyEquityMultiplierCamel(BigDecimal companyEquityMultiplierCamel) {
        this.companyEquityMultiplierCamel = companyEquityMultiplierCamel;
    }
}
