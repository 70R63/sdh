package de.hybris.sdh.core.pojos.responses;

public class ObligacionesPrediosResponse {
    private String chip;
    private String matriculaInmobiliaria;
    private String direccion;
    private String anoGravable;
    private String estadoObligacion;

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getMatriculaInmobiliaria() {
        return matriculaInmobiliaria;
    }

    public void setMatriculaInmobiliaria(String matriculaInmobiliaria) {
        this.matriculaInmobiliaria = matriculaInmobiliaria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAnoGravable() {
        return anoGravable;
    }

    public void setAnoGravable(String anoGravable) {
        this.anoGravable = anoGravable;
    }

    public String getEstadoObligacion() {
        return estadoObligacion;
    }

    public void setEstadoObligacion(String estadoObligacion) {
        this.estadoObligacion = estadoObligacion;
    }
}
