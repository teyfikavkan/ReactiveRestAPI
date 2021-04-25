package org.example.reactive.controller;

import org.example.reactive.document.ProductDocument;
import org.example.reactive.repository.ProductStandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.example.reactive.constant.EndpointConstants.*;

@RestController
@RequestMapping(ROOT_REQUEST_PATH)
@Profile("Standard")
public class ProductStandardQueryController {

    @Autowired
    private ProductStandardRepository productStandardRepository;

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping(GET_ALL_STANDARD_PATH)
    public List<ProductDocument> getAllAsStandard() {
        return productStandardRepository.findAll();
    }

    @GetMapping(FIND_BY_ID_STANDARD_PATH)
    public ProductDocument getByIdAsStandard(@PathVariable String id) {
        return productStandardRepository.findById(id).get();
    }
}
