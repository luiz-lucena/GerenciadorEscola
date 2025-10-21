package model;

import java.util.Objects;

public class Disciplina implements Comparable<Disciplina> {
    private String codigo;
    private String nome;

    public Disciplina(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }

    @Override
    public String toString() {
        return codigo + " - " + nome;
    }

    // Evita duplicatas no Set
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disciplina)) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public int compareTo(Disciplina d) {
        return this.codigo.compareTo(d.codigo);
    }
}
