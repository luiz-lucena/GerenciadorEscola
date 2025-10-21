import model.*;
import service.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ListaEstudantes lista = new ListaEstudantes();
        CadastroDisciplinas cadastro = new CadastroDisciplinas();
        HistoricoNotas historico = new HistoricoNotas();

        // === Estudantes (com Pokémon) ===
        lista.adicionarEstudante(new Estudante(1, "Ana", new Pokemon("Abra", "Psychic")));
        lista.adicionarEstudante(new Estudante(2, "Bruno", new Pokemon("Kadabra", "Psychic")));
        lista.adicionarEstudante(new Estudante(3, "Carla", new Pokemon("Alakazam", "Psychic")));
        lista.adicionarEstudante(new Estudante(4, "Diego", new Pokemon("Natu", "Psychic")));
        lista.adicionarEstudante(new Estudante(5, "Elisa", new Pokemon("Xatu", "Psychic")));

        // === Disciplinas ===
        cadastro.adicionarDisciplina(new Disciplina("MAT101", "Matemática"));
        cadastro.adicionarDisciplina(new Disciplina("PRG201", "Programação"));
        cadastro.adicionarDisciplina(new Disciplina("BD301", "Banco de Dados"));
        cadastro.adicionarDisciplina(new Disciplina("EDF110", "Educação Física"));

        // === Matrículas e Notas ===
        historico.adicionarMatricula(1, "MAT101", 8.5);
        historico.adicionarMatricula(1, "PRG201", 9.0);
        historico.adicionarMatricula(2, "PRG201", 7.0);
        historico.adicionarMatricula(3, "BD301", 6.5);
        historico.adicionarMatricula(4, "PRG201", 8.0);
        historico.adicionarMatricula(5, "EDF110", 10.0);

        // === Saídas ===
        System.out.println("== Lista de Estudantes (ordem de cadastro) ==");
        lista.getEstudantes().forEach(System.out::println);

        lista.ordenarEstudantesPorNome();
        System.out.println("\n== Lista de Estudantes (ordenada) ==");
        lista.getEstudantes().forEach(e -> System.out.println(e.getNome()));

        System.out.println("\n== Disciplinas (inserção) ==");
        cadastro.obterTodasDisciplinas().forEach(System.out::println);

        System.out.println("\n== Duplicatas detectadas na importação ==");
        if (cadastro.getDuplicatas().isEmpty())
            System.out.println("(nenhuma)");
        else
            cadastro.getDuplicatas().forEach(System.out::println);

        System.out.println("\n== Matrículas ==");
        for (Estudante e : lista.getEstudantes()) {
            List<Matricula> mats = historico.obterMatriculas(e.getId());
            double media = historico.mediaDoEstudante(e.getId());
            System.out.println(e.getNome() + ": " + mats + " Média: " + media);
        }

        System.out.println("\n== Médias por Disciplina ==");
        for (Disciplina d : cadastro.obterTodasDisciplinas()) {
            System.out.println(d.getCodigo() + ": " + historico.mediaDaDisciplina(d.getCodigo()));
        }

        System.out.println("\n== Top 3 alunos por média ==");
        historico.topNEstudantesPorMedia(3).forEach(entry -> {
            Estudante e = lista.getEstudantes().stream()
                    .filter(s -> s.getId() == entry.getKey())
                    .findFirst().get();
            System.out.println(e.getNome() + " - " + entry.getValue());
        });

        System.out.println("\n== Alunos com média >= 8.0 ==");
        lista.getEstudantes().stream()
                .filter(e -> historico.mediaDoEstudante(e.getId()) >= 8.0)
                .forEach(e -> System.out.println(e.getNome()));

        System.out.println("\n== Disciplinas com média < 6.0 ==");
        cadastro.obterTodasDisciplinas().stream()
                .filter(d -> historico.mediaDaDisciplina(d.getCodigo()) < 6.0)
                .forEach(d -> System.out.println(d.getNome()));
    }
}
