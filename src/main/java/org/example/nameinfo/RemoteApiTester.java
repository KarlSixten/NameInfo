/*
package org.example.nameinfo;

import org.example.nameinfo.dto.GenderDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class RemoteApiTester implements CommandLineRunner {

    List<String> names = Arrays.asList("lars", "peter", "sanne", "kim", "david", "maja");

    private Mono<String> callSlowEndpoint(){
        Mono<String> slowResponse = WebClient.create()
                .get()
                .uri("http://localhost:8080/random-string-slow")
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(e-> System.out.println("UUUPS : "+e.getMessage()));
        return slowResponse;
    }

    @Override
    public void run(String... args) throws Exception {

        //GenderDTO genderDTO = getGenderForName("Karl").block();
        //System.out.println(genderDTO);



getGendersBlocking();
getGendersNonBlocking();


        */
/*System.out.println(callSlowEndpoint().toString());

        callEndpointBlocking();

        callSlowEndpointNonBlocking();*//*

    }

    public void callEndpointBlocking(){
        long start = System.currentTimeMillis();
        List<String> ramdomStrings = new ArrayList<>();

        Mono<String> slowResponse = callSlowEndpoint();
        ramdomStrings.add(slowResponse.block()); //Three seconds spent

        slowResponse = callSlowEndpoint();
        ramdomStrings.add(slowResponse.block());//Three seconds spent

        slowResponse = callSlowEndpoint();
        ramdomStrings.add(slowResponse.block());//Three seconds spent
        long end = System.currentTimeMillis();
        ramdomStrings. add(0,"Time spent BLOCKING (ms): "+(end-start));

        //System.out.println(ramdomStrings.stream().collect(Collectors.joining(",")));
        System.out.println(String.join(",",ramdomStrings));
    }

    public void callSlowEndpointNonBlocking(){
        long start = System.currentTimeMillis();
        Mono<String> sr1 = callSlowEndpoint();
        Mono<String> sr2 = callSlowEndpoint();
        Mono<String> sr3 = callSlowEndpoint();

        var rs = Mono.zip(sr1,sr2,sr3).map(tuple3 -> {
            List<String> randomStrings = new ArrayList<>();
            randomStrings.add(tuple3.getT1());
            randomStrings.add(tuple3.getT2());
            randomStrings.add(tuple3.getT3());
            long end = System.currentTimeMillis();
            randomStrings.add(0,"Time spent NON-BLOCKING (ms): "+(end-start));
            return randomStrings;
        });
        List<String> randoms = rs.block(); //We only block when all the three Mono's has fulfilled
        System.out.println(randoms.stream().collect(Collectors.joining(",")));
    }


    Mono<GenderDTO> getGenderForName(String name) {
        WebClient client = WebClient.create();
        Mono<GenderDTO> genderDTOMono = client.get()
                .uri("https://api.genderize.io?name="+name)
                .retrieve()
                .bodyToMono(GenderDTO.class);
        return genderDTOMono;
    }

    public void getGendersBlocking() {
        long start = System.currentTimeMillis();
        List<GenderDTO> genders = names.stream().map(name -> getGenderForName(name).block()).toList();
        long end = System.currentTimeMillis();
        System.out.println("Time for six external requests, BLOCKING: "+ (end-start));
        System.out.println(genders);
    }

    public void getGendersNonBlocking() {
        long start = System.currentTimeMillis();
        var genders = names.stream().map(name -> getGenderForName(name)).toList();
        Flux<GenderDTO> flux = Flux.merge(Flux.concat(genders));
        List<GenderDTO> res = flux.collectList().block();
        long end = System.currentTimeMillis();
        System.out.println("Time for six external requests, NON-BLOCKING: "+ (end-start));
        System.out.println(genders);
    }


}
*/
