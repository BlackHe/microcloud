package com.peony.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @NonNull
    private String id;
    @NonNull
    private String productName;
    @NonNull
    private Double stockQty = 0d;
}
