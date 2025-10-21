package service;

import model.Estudante;
import java.util.*;
import java.util.stream.Collectors;

public class ListaEstudantes {
    private List<Estudante> estudantes = new ArrayList<>();

    public void adicionarEstudante(Estudante e) {
        estudantes.add(e);
    }

    public void removerEstudantePorId(int id) {
        estudantes.removeIf(e -> e.getId() == id);
    }

    public Estudante obterEstudantePorIndice(int indice) {
        return estudantes.get(indice);
    }

    public List<Estudante> buscarEstudantesPorNome(String substring) {
        return estudantes.stream()
                .filter(e -> e.getNome().toLowerCase().contains(substring.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void ordenarEstudantesPorNome() {
        estudantes.sort(Comparator.comparing(Estudante::getNome));
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }
}

