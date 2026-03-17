package com.sofi.SofiStudio.service;


import com.sofi.SofiStudio.dto.GalleryImageDto;
import com.sofi.SofiStudio.model.GalleryImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GalleryImageService {

    List<GalleryImage> getAllImages();

    GalleryImage addImage(MultipartFile file, String category) throws Exception;

    GalleryImage updateImage(Long id, GalleryImageDto dto);

    void deleteImage(Long id);

}
