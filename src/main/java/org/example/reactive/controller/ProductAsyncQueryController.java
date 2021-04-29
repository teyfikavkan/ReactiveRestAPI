package org.example.reactive.controller;

import org.example.reactive.document.ProductDocument;
import org.example.reactive.repository.ProductStandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.example.reactive.constant.EndpointConstants.*;

@RestController
@RequestMapping(ROOT_REQUEST_PATH)
@Profile("Async")
public class ProductAsyncQueryController {

    @Autowired
    private ProductStandardRepository productStandardRepository;

    @GetMapping(GET_ALL_ASYNC_PATH)
    @Async("asyncExecutor")
    public CompletableFuture<List<ProductDocument>> getAllAsAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<List<ProductDocument>> future = CompletableFuture.supplyAsync(() -> productStandardRepository.findAll());

        return CompletableFuture.completedFuture(future.get());
    }

    @GetMapping(FIND_BY_ID_ASYNC_PATH)
    @Async("asyncExecutor")
    public CompletableFuture<ProductDocument> getByIdAsAsync(@PathVariable String id) throws ExecutionException, InterruptedException {
        CompletableFuture<ProductDocument> future = CompletableFuture.supplyAsync(() -> productStandardRepository.findById(id).get());

        return CompletableFuture.completedFuture(future.get());
    }
}
