package com.taotao.controller;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class PicController {
    @Autowired
    private PicService picService;
    @RequestMapping("/pic/upload")
    @ResponseBody
    public String uploadPic(MultipartFile uploadFile){
        String originalFileName= uploadFile.getOriginalFilename();
        String extName=originalFileName.substring(originalFileName.indexOf(".")+1);
        PictureResult pictureResult=new PictureResult();
        try {
            pictureResult= picService.upload(uploadFile.getBytes(),extName,originalFileName);
        } catch (Exception e) {
            e.printStackTrace();
            pictureResult.setError(1);
            pictureResult.setMessage("上传失败...");
        }
        return JsonUtils.objectToJson(pictureResult);//返回json字符串，为了兼容火狐浏览器要求返回类型为文本类型，content-type为text/plain
    }
}
