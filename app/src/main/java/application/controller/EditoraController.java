package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Editora;
import application.repository.EditoraRepository;

@Controller
@RequestMapping("/editoras")
public class EditoraController {
    @Autowired
    private EditoraRepository editoraRepo;
    
    @RequestMapping("/insert")
    public String insert() {
        return "/editoras/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("nome") String nome, @RequestParam("cidade") String cidade) {
        Editora editora = new Editora();
        editora.setNome(nome);
        editora.setCidade(cidade);

        editoraRepo.save(editora);

        return "redirect:/editoras/list";
    }

    @RequestMapping("/list")
    public String getAll(Model ui) {
        ui.addAttribute("editoras", editoraRepo.findAll());
        return "/editoras/list";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("id") long id, Model ui) {
        Optional<Editora> resultado = editoraRepo.findById(id);

        if(resultado.isPresent()) {
            ui.addAttribute("editora", resultado.get());
            return "/editoras/update";
        }

        return "redirect:/editoras/list";
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(
        @RequestParam("id") long id,
        @RequestParam("nome") String nome,
        @RequestParam("cidade") String cidade) {
        
        Optional<Editora> resultado = editoraRepo.findById(id);

        if(resultado.isPresent()) {
            resultado.get().setNome(nome);
            resultado.get().setCidade(cidade);
            editoraRepo.save(resultado.get());
        }

        return "redirect:/editoras/list";
    }
}
