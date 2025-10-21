package service;

import model.Disciplina;
import java.util.*;

public class CadastroDisciplinas {
    private Set<Disciplina> disciplinas = new LinkedHashSet<>();
    private Set<Disciplina> duplicatas = new HashSet<>();

    public void adicionarDisciplina(Disciplina d) {
        if (!disciplinas.add(d)) {
            duplicatas.add(d);
        }
    }

    public boolean verificarDisciplina(String codigo) {
        return disciplinas.stream().anyMatch(d -> d.getCodigo().equals(codigo));
    }

    public void removerDisciplina(String codigo) {
        disciplinas.removeIf(d -> d.getCodigo().equals(codigo));
    }

    public Set<Disciplina> obterTodasDisciplinas() {
        return disciplinas;
    }

    public Set<Disciplina> getDuplicatas() {
        return duplicatas;
    }
}
