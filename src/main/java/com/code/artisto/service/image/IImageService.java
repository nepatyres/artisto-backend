package com.code.artisto.service.image;

import com.code.artisto.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image addImage(List<MultipartFile> files, Long productId);
    Image getImageById(Long id);
    void updateImage(MultipartFile file, Long imageId);
    void deleteImage(Long id);
}
