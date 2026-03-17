package com.sofi.SofiStudio.controller;

import com.sofi.SofiStudio.dto.GalleryImageDto;
import com.sofi.SofiStudio.model.GalleryImage;
import com.sofi.SofiStudio.service.GalleryImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GalleryController {

    private final GalleryImageService galleryImageService;

    @GetMapping("/gallery")
    public List<GalleryImage> getAllImages() {
        return galleryImageService.getAllImages();
    }

    @GetMapping("/admin/check")
    public ResponseEntity<String> checkAuth() {
        return ResponseEntity.ok("Authenticated");
    }

    @PostMapping("/admin/gallery")
    public GalleryImage addImage(@RequestParam("file") MultipartFile file,
                                 @RequestParam("category") String category) throws Exception {
        return galleryImageService.addImage(file, category);
    }

    @PutMapping("/admin/gallery/{id}")
    public GalleryImage updateImage(@PathVariable Long id, @Valid @RequestBody GalleryImageDto galleryImageDto) {
        return galleryImageService.updateImage(id, galleryImageDto);
    }

    @DeleteMapping("/admin/gallery/{id}")
    public void deleteImage(@PathVariable Long id) {
        galleryImageService.deleteImage(id);
    }

}
