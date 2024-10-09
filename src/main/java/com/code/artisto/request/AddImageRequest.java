package com.code.artisto.request;

import java.sql.Blob;

public class AddImageRequest {
    private Long id;
    private String fileName;
    private String fileType;
    private Blob image;
    private String filePath;
}
