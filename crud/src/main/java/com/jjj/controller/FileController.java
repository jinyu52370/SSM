package com.jjj.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/21 22:46
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws Exception {
        ServletContext context = request.getServletContext();
        //得到要下载的文件的真实路径
        String realPath = context.getRealPath("/WEB-INF/pages/泳装索米.jpg");
        FileInputStream fis = new FileInputStream(realPath);

        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);
        fis.close();

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.set("Content-Disposition", "attachment;filename=泳装索米.jpg");

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "name", required = false) String name,
                         @RequestParam("headerImg") MultipartFile file,
                         Model model){

        System.out.println("上传文件的信息");
        System.out.println("文件的大小：" + file.getSize());
        System.out.println("文件项的name(headerImg)：" + file.getName());
        System.out.println("文件的名字：" + file.getOriginalFilename());

        try {
            file.transferTo(new File("F:/_IOFiles/upload/" + file.getOriginalFilename()));
            model.addAttribute("msg", "文件上传成功");
        } catch (Exception e) {
            model.addAttribute("msg", "文件上传失败：" + e.getMessage());
        }
        return "success";
    }
}
