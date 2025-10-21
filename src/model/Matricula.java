package model;

public class Matricula {
    private String codigoDisciplina;
    private double nota;

    public Matricula(String codigoDisciplina, double nota) {
        this.codigoDisciplina = codigoDisciplina;
        this.nota = nota;
    }

    public String getCodigoDisciplina() { return codigoDisciplina; }
    public double getNota() { return nota; }

    @Override
    public String toString() {
        return codigoDisciplina + "(" + nota + ")";
    }
}
