package com.sofi.SofiStudio.service;

import com.sofi.SofiStudio.dto.GalleryImageDto;
import com.sofi.SofiStudio.model.GalleryImage;
import com.sofi.SofiStudio.repository.GalleryImageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GalleryImageServiceImpl implements GalleryImageService{

    private final GalleryImageRepo galleryImageRepo;
    private final CloudinaryService cloudinaryService;

    @Override
    public List<GalleryImage> getAllImages() {
        return galleryImageRepo.findAll();
    }

    @Override
    public GalleryImage addImage(MultipartFile file, String category) throws Exception {
        String imageUrl = cloudinaryService.uploadImage(file);
        GalleryImage image = new GalleryImage();
        image.setImageUrl(imageUrl);
        image.setCategory(category);
        return galleryImageRepo.save(image);
    }

    @Override
    public GalleryImage updateImage(Long id,  GalleryImageDto dto) {
        GalleryImage galleryImage = galleryImageRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Image Not Found with id: " + id));
        galleryImage.setImageUrl(dto.getImageUrl());
        galleryImage.setCategory(dto.getCategory());

        return galleryImageRepo.save(galleryImage);
    }

    @Override
    public void deleteImage(Long id) {
        galleryImageRepo.deleteById(id);
    }

}
