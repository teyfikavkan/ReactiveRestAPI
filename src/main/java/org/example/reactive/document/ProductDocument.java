package org.example.reactive.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class ProductDocument {

    @Id
    private String productId;

    private String productName;

    @CreatedDate
    private Date purchaseDate;
}
