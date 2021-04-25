package org.example.reactive.repository;

import org.example.reactive.document.ProductDocument;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("Reactive")
public interface ProductReactiveRepository extends ReactiveMongoRepository<ProductDocument, String> {
}
