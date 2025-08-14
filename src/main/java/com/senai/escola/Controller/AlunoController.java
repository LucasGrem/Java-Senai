package com.senai.escola.Controller;

import com.senai.escola.Models.Aluno;
import com.senai.escola.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //defini que esta class vire a controladora
@RequestMapping ("/alunos") //Faz integração com a web
public class AlunoController {
    private final AlunoService alunoService; //precisa de um construtor, para que a variavel seja inicializada.

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> buscarAlunos(){
        return alunoService.buscarTodosAlunos();
    }

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno){
        return alunoService.salvarNovoAluno(aluno);
    }

    @DeleteMapping
    public void excluirAluno(Long id){ //"void" significa q é sem retorno
        alunoService.deletarAluno(id);
    }

    @GetMapping("/{id}") //"("/{id}")" é para buscar algo especifico
    public Aluno buscarAlunoPorId(@PathVariable Long id){ //O PathVariable
        return alunoService.buscarAlunoId(id);
    }

}
