package com.sofi.SofiStudio.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {

    String uploadImage(MultipartFile file) throws Exception;
    void deleteImage(String publicId) throws Exception;

}
