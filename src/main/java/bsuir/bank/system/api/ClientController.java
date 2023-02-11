package bsuir.bank.system.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import bsuir.bank.system.api.model.ClientRequest;
import bsuir.bank.system.service.ClientService;
import bsuir.bank.system.service.MetadataService;
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
    public String createClient(Model model) {
        model.addAttribute("cities", metadataService.getAllCities());
        model.addAttribute("maritalStatuses", metadataService.getAllMaritalStatuses());
        model.addAttribute("disabilityTypes", metadataService.getAllDisabilityTypes());
        model.addAttribute("citizenships", metadataService.getAllCitizenship());

        return "createForm";
    }

    @PostMapping("/createClient")
    public String createClient(Model model, ClientRequest client) {
        service.create(client);
        return "main";
    }
}