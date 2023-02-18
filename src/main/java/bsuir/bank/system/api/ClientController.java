package bsuir.bank.system.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import bsuir.bank.system.api.model.NewClientRequest;
import bsuir.bank.system.service.ClientService;
import bsuir.bank.system.service.MetadataService;
import bsuir.bank.system.service.exception.InvalidPassportData;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ClientController {

    private final ClientService service;
    private final MetadataService metadataService;

    @GetMapping("/")
    public String redirectToMain() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("clients", service.getAll());
        return "main";
    }

    @GetMapping("/createForm")
    public String createForm(NewClientRequest newClientRequest, Model model) {
        prepareMetadataForForm(model);
        return "createForm";
    }

    @PostMapping("/createClient")
    public String createClient(@Valid NewClientRequest newClientRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            prepareMetadataForForm(model);
            return "createForm";
        }
        try {
            service.create(newClientRequest);
        }
        catch (InvalidPassportData exception) {
            result.rejectValue("pspIdNumber", "error.client", exception.getMessage());
            prepareMetadataForForm(model);
            return "createForm";
        }
        model.addAttribute("clients", service.getAll());
        return "redirect:/main";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Long id, Model model) {
        service.delete(id);
        model.addAttribute("clients", service.getAll());
        return "redirect:/main";
    }

    @GetMapping("/editForm/{id}")
    public String createEditForm( NewClientRequest newClientRequest, @PathVariable("id") Long id, Model model) {
        prepareMetadataForForm(model);
        model.addAttribute("newClientRequest", service.getClientRequestById(id));
        return "editForm";
    }

    @PostMapping("/editClient/{id}")
    public String updateClient(@Valid NewClientRequest newClientRequest,BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            prepareMetadataForForm(model);
            return "editForm";
        }
        try {
            service.update(newClientRequest, id);
        }
        catch (InvalidPassportData exception) {
            result.rejectValue("pspIdNumber", "error.client", exception.getMessage());
            prepareMetadataForForm(model);
            return "editForm";
        }
        model.addAttribute("clients", service.getAll());
        return "redirect:/main";
    }

    private void prepareMetadataForForm(Model model) {
        model.addAttribute("cities", metadataService.getAllCities());
        model.addAttribute("maritalStatuses", metadataService.getAllMaritalStatuses());
        model.addAttribute("disabilityTypes", metadataService.getAllDisabilityTypes());
        model.addAttribute("citizenships", metadataService.getAllCitizenship());
    }
}