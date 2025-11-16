package com.skycoffe.skycoffe_API.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary(Environment properties){
    return new Cloudinary(properties.getProperty("cloudinary.url"));

}
}
