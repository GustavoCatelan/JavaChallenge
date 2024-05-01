package br.com.fiap.javaChallenge.resource;

import org.springframework.http.ResponseEntity;

public interface ResourceDTO<Entity, Request, Response> {

    ResponseEntity<Response> findById(Long id);

    ResponseEntity<Response> save(Request r);

}