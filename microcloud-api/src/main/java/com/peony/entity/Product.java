package com.peony.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Product {

    @NonNull
    private String id;
    @NonNull
    private String productName;
    @NonNull
    private Double stockQty = 0d;
}
