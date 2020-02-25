package com.example.colonialproductordering.rest.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonRequest {

    private Long idPerson;
    private String name;
    private String role;

}
