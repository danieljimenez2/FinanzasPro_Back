package finanzas_pro.modells.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "datos_por_accion")
public class Datos_Por_Accion {
    @Id
    @Column(name = "company_symbol", length = 50, nullable = false)
    private String companySymbol;

    @OneToOne
    @MapsId  // PK compartida con la entidad principal
    @JoinColumn(name = "company_symbol")
    private Datos_Empresa datosEmpresa;

    @Column(name = "eps_ttm", precision = 36, scale = 16)
    private BigDecimal epsTtm;

    @Column(name = "caja_por_accion", precision = 36, scale = 16)
    private BigDecimal cajaPorAccion;

    @Column(name = "valor_en_libros_por_accion", precision = 36, scale = 16)
    private BigDecimal valorEnLibrosPorAccion;

    @Column(name = "fcf_por_accion", precision = 36, scale = 16)
    private BigDecimal fcfPorAccion;

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

    public BigDecimal getEpsTtm() {
        return epsTtm;
    }

    public void setEpsTtm(BigDecimal epsTtm) {
        this.epsTtm = epsTtm;
    }

    public BigDecimal getCajaPorAccion() {
        return cajaPorAccion;
    }

    public void setCajaPorAccion(BigDecimal cajaPorAccion) {
        this.cajaPorAccion = cajaPorAccion;
    }

    public BigDecimal getValorEnLibrosPorAccion() {
        return valorEnLibrosPorAccion;
    }

    public void setValorEnLibrosPorAccion(BigDecimal valorEnLibrosPorAccion) {
        this.valorEnLibrosPorAccion = valorEnLibrosPorAccion;
    }

    public BigDecimal getFcfPorAccion() {
        return fcfPorAccion;
    }

    public void setFcfPorAccion(BigDecimal fcfPorAccion) {
        this.fcfPorAccion = fcfPorAccion;
    }
}
