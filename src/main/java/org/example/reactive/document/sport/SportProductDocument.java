package org.example.reactive.document.sport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.example.reactive.data.enums.sport.SportProductCatCodeEnum;
import org.example.reactive.document.ProductDocument;
import org.springframework.data.mongodb.core.mapping.Document;

import static org.example.reactive.constant.ProjectConstants.SPORT_PRODUCT_DOCUMENT;

@Data
@ToString(callSuper=true, includeFieldNames=true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = SPORT_PRODUCT_DOCUMENT)
public class SportProductDocument extends ProductDocument {
    private SportProductCatCodeEnum sportProductCatCodeEnum;


}
