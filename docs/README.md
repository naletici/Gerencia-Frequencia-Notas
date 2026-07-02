# Gerenciador de Frequencias e Notas.

 Esse projeto trata-se de um trabalho acadêmico para a matéria de POO.

 ## 1. Diagrama de Classes
 
![Diagrama de classes do Gerenciador de Frequências e Notas](diagrama.png)

## 2. Regras de Negócio
 
O sistema implementa as 17 regras de negócio abaixo (RN-01 a RN-17).
 
| RN | Regra de negócio |
|----|------------------|
| RN-01 | O aluno é **reprovado por falta** quando o total de faltas ultrapassa **25%** da carga horária da matéria (essa verificação tem prioridade sobre as notas). |
| RN-02 | A nota de um **Trabalho Prático** é calculada como `nota obtida × peso`; a de uma **Prova** é a própria nota. |
| RN-03 | O aluno é **Aprovado Direto** quando a média parcial é **≥ 7**. |
| RN-04 | O aluno vai para **Avaliação Final** quando a média parcial está entre **5 e 7** (5 ≤ média < 7) e ainda não há nota da final lançada. |
| RN-05 | Na avaliação final, o aluno é **Aprovado na Final** quando a **média de recuperação** `(média + nota final) / 2` é **≥ 5**. |
| RN-06 | Na avaliação final, o aluno é **Reprovado na Final** quando a **média de recuperação** `(média + nota final) / 2` é **< 5**. |
| RN-07 | O aluno é **Reprovado Direto** quando a média parcial é **< 5**. |
| RN-08 | Toda nota (de avaliação ou da final) deve estar no intervalo **[0, 10]**; valores fora disso são rejeitados com `NotaInvalidaException`. |
| RN-09 | O sistema gera **relatório de notas** individual (por aluno) e geral (da turma). |
| RN-10 | É possível **cadastrar uma matéria** na turma. |
| RN-11 | É possível **cadastrar um professor** na turma. |
| RN-12 | É possível **matricular (cadastrar) um aluno** na turma. |
| RN-13 | É possível **remover a matéria** da turma. |
| RN-14 | É possível **remover o professor** da turma. |
| RN-15 | É possível **remover um aluno** da turma pelo índice. |
| RN-16 | É possível **listar a matéria** da turma (com carga horária, limite de faltas e alunos matriculados). |
| RN-17 | É possível **listar o professor** da turma (e a matéria que ele leciona). |


