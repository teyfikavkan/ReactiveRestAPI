package org.example.reactive.controller;

import org.example.reactive.document.ProductDocument;
import org.example.reactive.repository.ProductReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.example.reactive.constant.EndpointConstants.*;

@RestController
@RequestMapping(ROOT_REQUEST_PATH)
@Profile("Reactive")
public class ProductReactiveQueryController {

    @Autowired
    private ProductReactiveRepository productReactiveRepository;

    @GetMapping(GET_ALL_REACTIVE_PATH)
    public Flux<ProductDocument> getAllAsReactive() {
        return productReactiveRepository.findAll();
    }

    @GetMapping(FIND_BY_ID_REACTIVE_PATH)
    public Mono<ProductDocument> getByIdAsReactive(@PathVariable String id) {
        return productReactiveRepository.findById(id);
    }
}
