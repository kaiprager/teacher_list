package teacher_management_system.exercise.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import teacher_management_system.exercise.entity.Teacher;
import teacher_management_system.exercise.service.TeacherServiceInterface;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    private TeacherServiceInterface service;

    @Autowired
    public TeacherController(TeacherServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/get")
    public String viewAll(Model model) {
        List<Teacher> teachers = service.findAll();
        model.addAttribute("teachers", teachers);

        return "index";
    }

    @GetMapping("/addteacher")
    public String addTeacher(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);



        return "createTeacher";
    }

    @PostMapping("addteacher")
    public String createNewTeacher(@Valid @ModelAttribute Teacher teacher, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "createTeacher";
        } else {
            service.update(teacher);
            return "redirect:/teachers/get";
        }
    }

    @GetMapping("/updateteacher")
    public String editTeacher(Model model, @RequestParam Integer id){
        try{
            Teacher teacher = service.findById(id);
            model.addAttribute("teacher", teacher);
        } catch(Exception e){
            System.out.println("Id not found");

        }
        return "editTeacher";
    }

    @PostMapping("/updateteacher")
    public String updateTeacher(Model model, @RequestParam Integer id, @Valid @ModelAttribute Teacher teacher, BindingResult bindingResult){
        try{
            Teacher teacher1 = service.findById(id);

            if(bindingResult.hasErrors()){
                return "editTeacher";

            }else{
                teacher1.setFirstName(teacher.getFirstName());
                teacher1.setLastName(teacher.getLastName());
                teacher1.setEmail(teacher.getEmail());
                service.update(teacher1);
            }
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
        return "redirect:/teachers/get";
    }

    @GetMapping("/delete")
    public String deleteTeacher(@RequestParam Integer id) {
        service.deleteById(id);

        return "redirect:/teachers/get";
    }

}
