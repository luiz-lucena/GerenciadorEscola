package service;

import model.Matricula;
import java.util.*;
import java.util.stream.Collectors;

public class HistoricoNotas {
    private Map<Integer, List<Matricula>> notas = new HashMap<>();

    public void adicionarMatricula(int idEstudante, String codigoDisciplina, double nota) {
        notas.computeIfAbsent(idEstudante, k -> new ArrayList<>())
                .add(new Matricula(codigoDisciplina, nota));
    }

    public List<Matricula> obterMatriculas(int idEstudante) {
        return notas.getOrDefault(idEstudante, Collections.emptyList());
    }

    public Optional<Double> obterNota(int idEstudante, String codigoDisciplina) {
        return notas.getOrDefault(idEstudante, Collections.emptyList())
                .stream()
                .filter(m -> m.getCodigoDisciplina().equalsIgnoreCase(codigoDisciplina))
                .map(Matricula::getNota)
                .findFirst();
    }

    public void removerMatricula(int idEstudante, String codigoDisciplina) {
        notas.getOrDefault(idEstudante, new ArrayList<>())
                .removeIf(m -> m.getCodigoDisciplina().equalsIgnoreCase(codigoDisciplina));
    }

    public double mediaDoEstudante(int idEstudante) {
        return obterMatriculas(idEstudante).stream()
                .mapToDouble(Matricula::getNota).average().orElse(0.0);
    }

    public double mediaDaDisciplina(String codigoDisciplina) {
        return notas.values().stream()
                .flatMap(List::stream)
                .filter(m -> m.getCodigoDisciplina().equalsIgnoreCase(codigoDisciplina))
                .mapToDouble(Matricula::getNota)
                .average().orElse(0.0);
    }

    public List<Map.Entry<Integer, Double>> topNEstudantesPorMedia(int N) {
        return notas.keySet().stream()
                .map(id -> Map.entry(id, mediaDoEstudante(id)))
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .limit(N)
                .collect(Collectors.toList());
    }
}
