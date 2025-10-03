package finanzas_pro.models.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "margenes_de_la_compañia")
public class Margenes_De_La_Compañia {

    @Id
    @Column(name = "company_symbol", length = 50, nullable = false)
    private String companySymbol;

    @OneToOne
    @MapsId
    @JoinColumn(name = "company_symbol")
    private Datos_Empresa datosEmpresa;

    @Column(name = "Margen Bruto", precision = 36, scale = 16)
    private BigDecimal margenBruto;

    @Column(name = "Margen Operativo", precision = 36, scale = 16)
    private BigDecimal margenOperativo;

    @Column(name = "Margen EBT", precision = 36, scale = 16)
    private BigDecimal margenEBT;

    @Column(name = "Margen Neto", precision = 36, scale = 16)
    private BigDecimal margenNeto;

    @Column(name = "Tasa Impuesto", precision = 36, scale = 16)
    private BigDecimal tasaImpuesto;

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

    public BigDecimal getMargenBruto() {
        return margenBruto;
    }

    public void setMargenBruto(BigDecimal margenBruto) {
        this.margenBruto = margenBruto;
    }

    public BigDecimal getMargenOperativo() {
        return margenOperativo;
    }

    public void setMargenOperativo(BigDecimal margenOperativo) {
        this.margenOperativo = margenOperativo;
    }

    public BigDecimal getMargenEBT() {
        return margenEBT;
    }

    public void setMargenEBT(BigDecimal margenEBT) {
        this.margenEBT = margenEBT;
    }

    public BigDecimal getMargenNeto() {
        return margenNeto;
    }

    public void setMargenNeto(BigDecimal margenNeto) {
        this.margenNeto = margenNeto;
    }

    public BigDecimal getTasaImpuesto() {
        return tasaImpuesto;
    }

    public void setTasaImpuesto(BigDecimal tasaImpuesto) {
        this.tasaImpuesto = tasaImpuesto;
    }
}
