package com.example.pokedex.client;
import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient<T> {

    protected RestTemplate restTemplate;
    protected URI resourceUri;

    public RestClient(RestTemplate restTemplate, URI resourceUri) {
        this.restTemplate = restTemplate;
        this.resourceUri = resourceUri;
    }

}
