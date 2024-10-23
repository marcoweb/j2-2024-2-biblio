package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import application.model.Livro;
import application.repository.EditoraRepository;
import application.repository.GeneroRepository;
import application.repository.LivroRepository;

@Controller
@RequestMapping(value = {"/livros", "/"})
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

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("titulo") String titulo,
        @RequestParam("genero") long idGenero,
        @RequestParam("editora") long idEditora
    ) {
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setGenero(generoRepo.findById(idGenero).get());
        livro.setEditora(editoraRepo.findById(idEditora).get());

        livroRepo.save(livro);
        return "redirect:/livros/list";
    }

    @RequestMapping(value = {"/list", ""})
    public String list(Model ui) {
        ui.addAttribute("livros", livroRepo.findAll());
        return "livros/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") long id, Model ui) {
    // @RequestMapping("/delete/{id}")
    // public String delete(@PathVariable long id, Model ui) {
        Optional<Livro> resultado = livroRepo.findById(id);

        if(resultado.isPresent()) {
            ui.addAttribute("livro", resultado.get());
            return "/livros/delete";
        }

        return "redirect:/livros/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        livroRepo.deleteById(id);
        return "redirect:/livros/list";
    }

    @RequestMapping("/update")
    public String update(Model ui, @RequestParam("id") long id) {
        Optional<Livro> resultado = livroRepo.findById(id);
        if(resultado.isPresent()) {
            ui.addAttribute("livro", resultado.get());
            ui.addAttribute("generos", generoRepo.findAll());
            ui.addAttribute("editoras", editoraRepo.findAll());

            return "livros/update";
        }

        return "redirect:/livros/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") long id,
        @RequestParam("titulo") String titulo,
        @RequestParam("genero") long idGenero,
        @RequestParam("editora") long idEditora
    ) {
        Optional<Livro> resultado = livroRepo.findById(id);
        if(resultado.isPresent()) {
            resultado.get().setTitulo(titulo);
            resultado.get().setGenero(generoRepo.findById(idGenero).get());
            resultado.get().setEditora(editoraRepo.findById(idEditora).get());

            livroRepo.save(resultado.get());
        }
        return "redirect:/livros/list";
    }
}