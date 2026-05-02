package br.edu.cursosifpb.controller;

import br.edu.cursosifpb.model.Curso;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    //Onde armazenaremos os cursos a principio
    private List<Curso> cursos = new ArrayList<Curso>();

    //Criando os endpoints

    //Listar os Cursos
    @GetMapping
    public List<Curso> listarCursos(){
        return cursos;
    }

    @PostMapping("/cadastrar")
    //Cadastra Cursos
    public void cadastrarCurso(@RequestBody Curso c){
        cursos.add(c);
        return;
    }

    @DeleteMapping("/remover/{id}")
    //Remover Curso
    public void deleteCurso(@PathVariable long id){
        /*faz uma leitura na lista de cursos e verifica se
        algum possui o mesmo id passado na URL, se possuir ele remove o curso
         */
        cursos.removeIf(curso -> curso.getId() == id);
    }

    @DeleteMapping("/remover")
    //Remover Curso
    public void deleteCursoversao02(@RequestParam long id){
         /*faz uma leitura na lista de cursos e verifica se
        algum possui o mesmo id passado na URL, se possuir ele remove o curso
         */
        cursos.removeIf(curso -> curso.getId() == id);
    }

    @PutMapping("/editar/{id}")
    //Editar Curso
    public void editarCurso(@PathVariable long id, @RequestBody Curso cursoatualizado){
        //Faz um for na lista de cursos existentes
        for (Curso c : cursos){
            //verifica se existe algum curso na lista com o mesmo id passado na URL(caminho)
            if(c.getId() == id){
                //se existir ele atualiza os valore com base nos metódos set
                c.setNome(cursoatualizado.getNome());
                c.setCargaHoraria(cursoatualizado.getCargaHoraria());
                break;
            }
        }
    }
}
