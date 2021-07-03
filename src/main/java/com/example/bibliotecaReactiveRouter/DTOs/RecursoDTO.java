package com.example.bibliotecaReactiveRouter.DTOs;

public class RecursoDTO {

    private String idRecurso;
    private String tituloRecurso;
    private String idTipoRecurso;
    private String idAutorRecurso;
    private String idCategoriaRecurso;
    private boolean disponibleRecurso;
    private String fechaPrestamo;

    public String getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getTituloRecurso() {
        return tituloRecurso;
    }

    public void setTituloRecurso(String tituloRecurso) {
        this.tituloRecurso = tituloRecurso;
    }

    public String getIdTipoRecurso() {
        return idTipoRecurso;
    }

    public void setIdTipoRecurso(String idTipoRecurso) {
        this.idTipoRecurso = idTipoRecurso;
    }

    public String getIdAutorRecurso() {
        return idAutorRecurso;
    }

    public void setIdAutorRecurso(String idAutorRecurso) {
        this.idAutorRecurso = idAutorRecurso;
    }

    public String getIdCategoriaRecurso() {
        return idCategoriaRecurso;
    }

    public void setIdCategoriaRecurso(String idCategoriaRecurso) {
        this.idCategoriaRecurso = idCategoriaRecurso;
    }

    public boolean isDisponibleRecurso() {
        return disponibleRecurso;
    }

    public void setDisponibleRecurso(boolean disponibleRecurso) {
        this.disponibleRecurso = disponibleRecurso;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}
