package org.example.reactive.document.electronic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.example.reactive.data.enums.electronic.ElectronicProductCatCodeEnum;
import org.example.reactive.document.ProductDocument;
import org.springframework.data.mongodb.core.mapping.Document;

import static org.example.reactive.constant.ProjectConstants.ELECTRONIC_PRODUCT_DOCUMENT;

@Data
@ToString(callSuper=true, includeFieldNames=true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document(collection = ELECTRONIC_PRODUCT_DOCUMENT)
public class ElectronicProductDocument extends ProductDocument {
    private ElectronicProductCatCodeEnum electronicProductCatCodeEnum;
}
