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
        return notas.getOrDefault(idEstudante, new ArrayList<>());
    }

    public Optional<Double> obterNota(int idEstudante, String codigoDisciplina) {
        return notas.getOrDefault(idEstudante, new ArrayList<>())
                .stream()
                .filter(m -> m.getCodigoDisciplina().equals(codigoDisciplina))
                .map(Matricula::getNota)
                .findFirst();
    }

    public void removerMatricula(int idEstudante, String codigoDisciplina) {
        notas.getOrDefault(idEstudante, new ArrayList<>())
                .removeIf(m -> m.getCodigoDisciplina().equals(codigoDisciplina));
    }

    public double mediaDoEstudante(int idEstudante) {
        List<Matricula> mats = notas.get(idEstudante);
        if (mats == null || mats.isEmpty()) return 0.0;
        return mats.stream().mapToDouble(Matricula::getNota).average().orElse(0.0);
    }

    public double mediaDaDisciplina(String codigoDisciplina) {
        List<Double> notasDisciplina = notas.values().stream()
                .flatMap(List::stream)
                .filter(m -> m.getCodigoDisciplina().equals(codigoDisciplina))
                .map(Matricula::getNota)
                .collect(Collectors.toList());
        if (notasDisciplina.isEmpty()) return 0.0;
        return notasDisciplina.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public List<Map.Entry<Integer, Double>> topNEstudantesPorMedia(int N) {
        return notas.keySet().stream()
                .map(id -> Map.entry(id, mediaDoEstudante(id)))
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .limit(N)
                .collect(Collectors.toList());
    }
}
