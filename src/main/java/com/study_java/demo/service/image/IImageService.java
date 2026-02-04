package com.study_java.demo.service.image;

import com.study_java.demo.dto.ImageDTO;
import com.study_java.demo.models.Image;
import com.study_java.demo.models.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImage(Long id);
    List<ImageDTO> saveImages(List<MultipartFile> files, Long productId);
    void updateImage(MultipartFile file, Long imageId);
}
