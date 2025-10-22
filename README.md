Aluno Luiz Felipe Lucena Guimarães - 2° período
Professor Samuel

=== Descrição do Projeto ===

Este projeto foi desenvolvido para atender ao desafio da escola que deseja automatizar o controle de estudantes, disciplinas e notas.
O sistema usa as principais coleções do Java (List, Set e Map) para organizar e manipular os dados de forma eficiente.

A ArrayList foi escolhida por sua simplicidade e eficiência no armazenamento ordenado e sequencial dos estudantes.

O LinkedHashSet foi escolhido para evitar duplicações de disciplinas e preservar a ordem de cadastro, atendendo aos requisitos do sistema.

O HashMap foi escolhido pela eficiência em associar chaves (IDs dos estudantes) a listas de valores (matrículas e notas), tornando a busca e o cálculo de médias rápidos e organizados.

Como toque criativo (extra do enunciado), cada estudante também é um treinador Pokémon, com seu próprio companheiro do melhor tipo, psíquico 🌀.

O sistema permite:

● Gerenciar a lista de estudantes (incluir, remover, buscar e ordenar). 
● Controlar disciplinas únicas (evitando duplicatas). 
● Associar cada estudante às suas matrículas e notas. 
● Consultar médias de alunos, médias de disciplinas e alunos aprovados.

=== Como Executar o Programa ===
1. Certifique-se de ter o Java instalado (versão 17 ou superior).
2. Compile o projeto com:
   javac Main.java
3. Execute o programa:
   java Main
4. O arquivo de saída "output.txt" será gerado automaticamente na pasta raiz do projeto com os resultados das operações.
