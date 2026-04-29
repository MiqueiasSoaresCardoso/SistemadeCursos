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

    @DeleteMapping("/remover")
    //Remover Curso
    public void deleteCurso(@RequestBody Curso c){
        cursos.remove(c);
    }

    @PutMapping("editar")
    //Editar Curso
    public void editarCurso(@RequestBody Curso c){
        //Primeiro eu apago o curso
        cursos.remove(c);
        //Depois adiciono novamente com a alteração
        cursos.add(c);
    }
}
