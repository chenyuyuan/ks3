package com.se.controller;

import com.mysql.cj.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


@RestController
@RequestMapping("/api/upload")
@CrossOrigin
public class UploadController {
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;
    private Logger logger = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("/singlefile")
    public Object singleFileUpload(MultipartFile file, HttpServletRequest request) {
        System.out.println("开始上传!");
        //logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        if (Objects.isNull(file) || file.isEmpty()) {
            logger.error("文件为空");
            System.out.println("文件为空!");
            return "文件为空，请重新上传";
        }
        try {
            System.out.println("开始保存文件!");
            byte[] bytes = file.getBytes();
            HttpSession session=request.getSession();
            String account = (String)session.getAttribute("account");
            session.setAttribute("fileName", file.getOriginalFilename());
            System.out.println((String)session.getAttribute("fileName"));
            System.out.println(account);
            Path path = Paths.get(UPLOAD_FOLDER + "/static/img/" + file.getOriginalFilename());
            //Path path = Paths.get(UPLOAD_FOLDER + "/files" + file.getOriginalFilename());
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            System.out.println("文件写入成功!");
            logger.debug("文件写入成功...");
            return file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }

    /*
    public Object singleFileUpload(MultipartFile[] files) {
        System.out.println("开始上传!");
        System.out.println(files.length);
        try {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                if (Objects.isNull(file) || file.isEmpty()) {
                    System.out.println("空文件为:" + i);
                    logger.error("文件为空");
                    System.out.println("文件为空!");
                    return "文件为空，请重新上传";
                }
                System.out.println("开始保存文件为:" + i);
                System.out.println("开始保存文件!");
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOAD_FOLDER + "/files" + file.getOriginalFilename());
                //如果没有files文件夹，则创建
                if (!Files.isWritable(path)) {
                    Files.createDirectories(Paths.get(UPLOAD_FOLDER));
                }
                //文件写入指定路径
                Files.write(path, bytes);
                System.out.println("文件写入成功!");
                logger.debug("文件写入成功...");
                return "文件上传成功";
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
        return "保存完成";
    }
    */
}
