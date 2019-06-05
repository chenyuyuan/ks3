package com.yuan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ApiImageController {
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;
    @RequestMapping(value = "/img/{imgname}",method= RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public BufferedImage getImage(@PathVariable String imgname) throws IOException {
        System.out.println(imgname);
        return ImageIO.read(new FileInputStream(new File(UPLOAD_FOLDER + "/static/img/" + imgname)));
    }

}
