package com.example.pokedex.client;
import java.net.URI;
import org.springframework.web.client.RestTemplate;

public class RestClient<T> {

    protected RestTemplate restTemplate;
    protected URI resourceUri;

    public RestClient(RestTemplate restTemplate, URI resourceUri) {
        this.restTemplate = restTemplate;
        this.resourceUri = resourceUri;
    }

}
