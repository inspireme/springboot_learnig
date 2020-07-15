package jp.whisper.fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName FileUploadController
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/21 21:49
 * @Version 1.0
 */
@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String upload(@RequestPart(name = "file", required = false)MultipartFile multipartFile, HttpServletRequest request) {

        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
        //保存地址
        String format = sdf.format(new Date());
        String saveDir = request.getServletContext().getRealPath("/files" + format) ;
        File folder = new File(saveDir);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String oldName = multipartFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        try {
            multipartFile.transferTo(new File(saveDir ,newName));
            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/files" + format + newName;

            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "error";
    }

    @PostMapping("/uploads")
    public String uploads(MultipartFile[] files, HttpServletRequest request) {

        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
        //保存地址
        String format = sdf.format(new Date());
        String saveDir = request.getServletContext().getRealPath("/files" + format) ;
        File folder = new File(saveDir);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        for (MultipartFile file : files) {
            String oldName = file.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
            try {
                file.transferTo(new File(saveDir ,newName));
                String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/files" + format + newName;

                System.out.println("url>>>" + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "success";
    }

}
