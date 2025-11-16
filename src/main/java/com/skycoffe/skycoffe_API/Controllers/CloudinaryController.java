package com.skycoffe.skycoffe_API.Controllers;

import com.skycoffe.skycoffe_API.Services.CloudinaryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/upload")
public class CloudinaryController {
    private final CloudinaryService cloudinaryService;

    public CloudinaryController (CloudinaryService cloudinaryService){
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping
    public String uploadImage(@RequestParam("file")MultipartFile file) throws Exception{
        return cloudinaryService.uploadImage(file);
    }
}
