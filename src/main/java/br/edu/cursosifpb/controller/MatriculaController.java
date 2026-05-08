package br.edu.cursosifpb.controller;

import br.edu.cursosifpb.model.Aluno;
import br.edu.cursosifpb.model.Curso;
import br.edu.cursosifpb.model.Matricula;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    //Onde armazenaremos as Matriculas a principio
    private List<Matricula> matriculas = new ArrayList<Matricula>();

    //Criando os endpoints

    //Listar as Matriculas
    @GetMapping("/listar")
    public List<Matricula> listarMatriculas() {
        return matriculas;
    }

    @PostMapping("/matricular")
    //Cadastra Matriculas
    public void realizarMatricula(@RequestBody Matricula matricula) {
        //Gerando a matricula com base no ano e id_atual do aluno
        int matricula_n = (int) Year.now().getValue() + matricula.getMatricula() + 0;
        matricula.setMatricula(matricula_n);
        matriculas.add(matricula);
        return;
    }

    @DeleteMapping("/desvincular/{id}")
    //Remover Matriculas
    public void deletarMatricula(@PathVariable long id){
        /*faz uma leitura na lista de cursos e verifica se
        algum possui o mesmo id passado na URL, se possuir ele remove o curso
         */
        matriculas.removeIf(matricula -> matricula.getId() == id);
    }

    @DeleteMapping("/desvincular")
    //Remover Alunos
    public void deletarMatriculav2(@RequestParam long id){
         /*faz uma leitura na lista de matriculas e verifica se
        algum possui o mesmo id passado na URL, se possuir ele remove o curso
         */
        matriculas.removeIf(matricula -> matricula.getId() == id);
    }

    @PutMapping("/editarmatricula/{matricula}")
    //Editar Aluno
    public void editarMatricula(@PathVariable long id, @RequestBody Matricula matricula_atualizada) {
        //Faz um for na lista de alunos existentes
        for (Matricula matricula : matriculas){
            //verifica se existe algum aluno na lista com o mesmo id passado na URL(caminho)
            if(matricula.getMatricula() == matricula_atualizada.getMatricula()){
                //se existir ele atualiza os valore com base nos metódos set
                matricula.setAluno(matricula_atualizada.getAluno());
                matricula.setCurso(matricula_atualizada.getCurso());
                break;
            }
        }
    }

}
