package com.sofi.SofiStudio.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GalleryImageDto {

    @NotBlank(message = "Image URL is Required!")
    private String imageUrl;
    
    @NotBlank(message = "Catergory is Required")
    private String category;

}
