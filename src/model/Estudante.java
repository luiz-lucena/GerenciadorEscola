package model;

import java.util.Objects;

public class Estudante {
    private int id;
    private String nome;
    private Pokemon pokemon;

    public Estudante(int id, String nome, Pokemon pokemon) {
        this.id = id;
        this.nome = nome;
        this.pokemon = pokemon;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public Pokemon getPokemon() { return pokemon; }

    @Override
    public String toString() {
        return id + " - " + nome + " (Treinador: " + pokemon + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudante)) return false;
        Estudante that = (Estudante) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
