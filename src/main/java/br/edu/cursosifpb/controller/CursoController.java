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
        cursos.removeIf(curso -> curso.getId() == id);
    }

    @PutMapping("/editar/{id}")
    //Editar Curso
    public void editarCurso(@PathVariable long id, @RequestBody Curso cursoatualizado){
        for (Curso c : cursos){
            if(c.getId() == id){
                c.setNome(cursoatualizado.getNome());
                c.setCargaHoraria(cursoatualizado.getCargaHoraria());
                break;
            }
        }
    }
}
