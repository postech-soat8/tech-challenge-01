package br.com.soat8.techchallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductImage {

    private UUID productImageId;

    private Product productId;

    private String name;

    private String bucketUrl;
}