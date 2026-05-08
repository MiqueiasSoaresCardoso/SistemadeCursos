package br.edu.cursosifpb.controller;
import br.edu.cursosifpb.model.Aluno;
import br.edu.cursosifpb.model.Curso;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/alunos")
public class AlunoController {
    //Onde armazenaremos os alunos a principio
    private List<Aluno> alunos = new ArrayList<Aluno>();

    //Criando os endpoints

    //Listar os Alunos
    @GetMapping
    public List<Aluno> listarAlunos(){
        return alunos;
    }

    @PostMapping("/cadastrar")
    //Cadastra Alunos
    public void cadastrarAluno(@RequestBody Aluno a){
        alunos.add(a);
        return;
    }

    @DeleteMapping("/remover/{id}")
    //Remover Alunos
    public void deleteAluno(@PathVariable long id){
        /*faz uma leitura na lista de cursos e verifica se
        algum possui o mesmo id passado na URL, se possuir ele remove o curso
         */
        alunos.removeIf(aluno -> aluno.getId() == id);
    }

    @DeleteMapping("/remover")
    //Remover Alunos
    public void deleteAlunoversao02(@RequestParam long id){
         /*faz uma leitura na lista de cursos e verifica se
        algum possui o mesmo id passado na URL, se possuir ele remove o curso
         */
        alunos.removeIf(aluno -> aluno.getId() == id);
    }

    @PutMapping("/editar/{id}")
    //Editar Aluno
    public void editarAluno(@PathVariable long id, @RequestBody Curso cursoatualizado){
        //Faz um for na lista de alunos existentes
        for (Aluno a : alunos){
            //verifica se existe algum aluno na lista com o mesmo id passado na URL(caminho)
            if(a.getId() == id){
                //se existir ele atualiza os valore com base nos metódos set
                a.setNome(a.getNome());
                a.setDataNascimento(a.getDataNascimento());
                a.setMatricula(a.getMatricula());
                break;
            }
        }
    }
}
