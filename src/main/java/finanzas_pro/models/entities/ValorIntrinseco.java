package finanzas_pro.models.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "valor_intrinseco")
public class ValorIntrinseco {


    @Id
    @Column(name = "company_symbol", length = 50, nullable = false)
    private String companySymbol;

    @OneToOne
    @MapsId
    @JoinColumn(name = "company_symbol")
    private DatosEmpresa datosEmpresa;

    @Column(name = "cotizacion", precision = 36, scale = 16)
    private BigDecimal cotizacion;

    @Column(name = "graham_number_ttm", precision = 36, scale = 16)
    private BigDecimal grahamNumberTtm;

    @Column(name = "graham_net_ttm", precision = 36, scale = 16)
    private BigDecimal grahamNetTtm;

    @Column(name = "dcf", precision = 36, scale = 16)
    private BigDecimal dcf;

    @Column(name = "precio_analistas", precision = 36, scale = 16)
    private BigDecimal precioAnalistas;

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

    public BigDecimal getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(BigDecimal cotizacion) {
        this.cotizacion = cotizacion;
    }

    public BigDecimal getGrahamNumberTtm() {
        return grahamNumberTtm;
    }

    public void setGrahamNumberTtm(BigDecimal grahamNumberTtm) {
        this.grahamNumberTtm = grahamNumberTtm;
    }

    public BigDecimal getGrahamNetTtm() {
        return grahamNetTtm;
    }

    public void setGrahamNetTtm(BigDecimal grahamNetTtm) {
        this.grahamNetTtm = grahamNetTtm;
    }

    public BigDecimal getDcf() {
        return dcf;
    }

    public void setDcf(BigDecimal dcf) {
        this.dcf = dcf;
    }

    public BigDecimal getPrecioAnalistas() {
        return precioAnalistas;
    }

    public void setPrecioAnalistas(BigDecimal precioAnalistas) {
        this.precioAnalistas = precioAnalistas;
    }
}
