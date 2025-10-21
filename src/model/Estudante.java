package model;

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
        return id + " - " + nome + " (Treinador de " + pokemon.getNome() + ")";
    }
}
