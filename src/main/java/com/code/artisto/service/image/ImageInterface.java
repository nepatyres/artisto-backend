package com.code.artisto.service.image;

import com.code.artisto.dto.ImageDto;
import com.code.artisto.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageInterface {
    List<ImageDto> saveImages(Long productId, List<MultipartFile> files);
    Image getImageById(Long id);
    void updateImage(MultipartFile file, Long imageId);
    void deleteImageById(Long id);
}
