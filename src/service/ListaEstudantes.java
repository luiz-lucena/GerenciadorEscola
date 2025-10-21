package service;

import model.Estudante;
import java.util.*;

public class ListaEstudantes {
    private List<Estudante> estudantes = new ArrayList<>();

    public void adicionarEstudante(Estudante e) { estudantes.add(e); }
    public void removerEstudantePorId(int id) { estudantes.removeIf(s -> s.getId() == id); }
    public Estudante obterEstudantePorIndice(int indice) { return estudantes.get(indice); }

    public List<Estudante> buscarEstudantesPorNome(String substring) {
        List<Estudante> res = new ArrayList<>();
        for (Estudante e : estudantes) {
            if (e.getNome().toLowerCase().contains(substring.toLowerCase())) res.add(e);
        }
        return res;
    }

    public void ordenarEstudantesPorNome() {
        estudantes.sort(Comparator.comparing(Estudante::getNome, String.CASE_INSENSITIVE_ORDER));
    }

    public List<Estudante> getEstudantes() { return estudantes; }
}
