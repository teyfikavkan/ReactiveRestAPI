package org.example.reactive.repository;

import org.example.reactive.document.ProductDocument;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("Standard")
public interface ProductStandardRepository  extends MongoRepository<ProductDocument, String> {
}
