package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import application.repository.EditoraRepository;
import application.repository.GeneroRepository;
import application.repository.LivroRepository;

@Controller
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepo;
    @Autowired
    private GeneroRepository generoRepo;
    @Autowired
    private EditoraRepository editoraRepo;

    @RequestMapping("/insert")
    public String insert(Model ui) {
        ui.addAttribute("generos", generoRepo.findAll());
        ui.addAttribute("editoras", editoraRepo.findAll());
        return "livros/insert";
    }

    public String insert(
        @RequestParam("titulo") String titulo,
        @RequestParam("genero") long idGenero,
        @RequestParam("editora") long idEditora
    ) {

        return "redirect:/livros/list";
    }
}