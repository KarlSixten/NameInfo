package org.example.nameinfo.service;

import org.example.nameinfo.dto.AgeDTO;
import org.example.nameinfo.dto.GenderDTO;
import org.example.nameinfo.dto.NationalityDTO;
import org.example.nameinfo.entity.NameInfo;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@org.springframework.stereotype.Service
public class Service {

    public Mono<NameInfo> getAllInfoFromName(String name) {
        long startTime = System.currentTimeMillis();
        Mono<GenderDTO> gender = getGenderFromName(name);
        Mono<AgeDTO> age = getAgeFromName(name);
        Mono<NationalityDTO> nationality = getNationalityFromName(name);
        long endTime = System.currentTimeMillis();
        long timeSpent = endTime - startTime;

        System.out.println("Quick took " + timeSpent + "ms");

        return Mono.zip(gender, age, nationality)
                .map(tuple -> new NameInfo(tuple.getT2(), tuple.getT1(), tuple.getT3()));
    }

    public NameInfo getAllInfoFromNameSlow(String name) {
        long startTime = System.currentTimeMillis();
        GenderDTO genderDTO = getGenderFromName(name).block();
        AgeDTO ageDTO = getAgeFromName(name).block();
        NationalityDTO nationalityDTO = getNationalityFromName(name).block();
        long endTime = System.currentTimeMillis();
        long timeSpent = endTime - startTime;

        System.out.println("Slow took " + timeSpent + "ms");

        return new NameInfo(ageDTO, genderDTO, nationalityDTO);
    }

    public Mono<GenderDTO> getGenderFromName(String name) {
            WebClient client = WebClient.create();
            Mono<GenderDTO> genderDTOMono = client.get()
                    .uri("https://api.genderize.io?name="+name)
                    .retrieve()
                    .bodyToMono(GenderDTO.class);
            return genderDTOMono;
    }

    public Mono<AgeDTO> getAgeFromName(String name) {
        WebClient client = WebClient.create();
        Mono<AgeDTO> ageDTOMono = client.get()
                .uri("https://api.agify.io?name="+name)
                .retrieve()
                .bodyToMono(AgeDTO.class);
        return ageDTOMono;
    }

    public Mono<NationalityDTO> getNationalityFromName(String name) {
        WebClient client = WebClient.create();
        Mono<NationalityDTO> nationalityDTOMono = client.get()
                .uri("https://api.nationalize.io?name="+name)
                .retrieve()
                .bodyToMono(NationalityDTO.class);
        return nationalityDTOMono;
    }
}
