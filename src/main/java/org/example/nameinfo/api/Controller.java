package org.example.nameinfo.api;

import org.example.nameinfo.NameInfoApplication;
import org.example.nameinfo.dto.AgeDTO;
import org.example.nameinfo.dto.GenderDTO;
import org.example.nameinfo.dto.NationalityDTO;
import org.example.nameinfo.entity.NameInfo;
import org.example.nameinfo.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }
    @GetMapping("/{name}")
    public Mono<NameInfo> getInfoFromName(@PathVariable String name) {
        return service.getAllInfoFromName(name);
    }

    @GetMapping("/{name}/slow")
    public NameInfo getInfoFromNameSlow(@PathVariable String name) {
        return service.getAllInfoFromNameSlow(name);
    }

    @GetMapping("/{name}/age")
    public Mono<AgeDTO> getAgeFromName(@PathVariable String name) {
        return service.getAgeFromName(name);
    }

    @GetMapping("/{name}/gender")
    public Mono<GenderDTO> getGenderFromName(@PathVariable String name) {
        return service.getGenderFromName(name);
    }

    @GetMapping("/{name}/nationality")
    public Mono<NationalityDTO> getNationalityFromName(@PathVariable String name) {
        return service.getNationalityFromName(name);
    }
}
