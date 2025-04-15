package org.example.project.web;


import lombok.AllArgsConstructor;
import org.example.project.entities.Patient;
import org.example.project.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue="0")int p,
                        @RequestParam(name="size",defaultValue="4")int s,
                        @RequestParam(name="keyword",defaultValue="")String kw){
        Page<Patient> pagePatients = patientRepository.findByNomContaining(kw,PageRequest.of(p,s));

        model.addAttribute("patientList", pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentpage",p);
        model.addAttribute("keyword",kw);

        return "patients";
    }
    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page"+page+"&keyword="+keyword;
    }
}
