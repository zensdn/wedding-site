package com.sofi.SofiStudio.repository;

import com.sofi.SofiStudio.model.GalleryImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryImageRepo extends JpaRepository<GalleryImage,Long> {

}
