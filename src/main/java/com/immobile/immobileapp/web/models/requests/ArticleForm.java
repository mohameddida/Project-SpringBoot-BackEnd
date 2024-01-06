package com.immobile.immobileapp.web.models.requests;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    @NotBlank(message = "Location is required")
    private String emplacement;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01")
    private Double price;

    @NotNull(message = "Chambers is required")
    @Min(value = 1, message = "Chambers must be greater than or equal to 1")
    private Integer nbrPiece;

    private Boolean disponible;

    private String imageMain;

    private String imageOne;

    private String imageTwo;

    private String imageThree;
}
