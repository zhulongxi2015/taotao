package com.taotao.service.impl;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.FastDFSClient;
import com.taotao.service.PicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PicServiceImpl implements PicService {
    @Value("${TAOTAO_IMAGE_SERVER_URL}")
    private String TAOTAO_IMAGE_SERVER_URL;
   /* @Override
    public PictureResult uploadPic(MultipartFile picFile) {
        System.out.println("service");
        PictureResult pictureResult =new PictureResult();

        if(picFile.isEmpty()){
            pictureResult.setError(1);
            pictureResult.setMessage("图片为空");
            return pictureResult;
        }
        String originalFileName= picFile.getOriginalFilename();
        String extName=originalFileName.substring(originalFileName.indexOf(".")+1);
        FastDFSClient client= null;
        try {
            client = new FastDFSClient("classpath:properties/fastdfs.conf");
            String url = client.uploadFile(picFile.getBytes(),extName);
            url=TAOTAO_IMAGE_SERVER_URL+url;
            pictureResult.setError(0);
            pictureResult.setUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
            pictureResult.setError(1);
            pictureResult.setMessage("图片上传失败");
        }
        return pictureResult;
    }*/

    @Override
    public PictureResult upload(byte[] fileBytes, String extName, String orignalName) throws Exception {
        System.out.println("service");
        PictureResult pictureResult =new PictureResult();
        if(fileBytes==null || fileBytes.length==0){
            pictureResult.setError(1);
            pictureResult.setMessage("图片为空");
            return pictureResult;
        }
        FastDFSClient client= null;
        client = new FastDFSClient("classpath:properties/fastdfs.conf");
        String url = client.uploadFile(fileBytes,extName);
        url=TAOTAO_IMAGE_SERVER_URL+url;
        pictureResult.setError(0);
        pictureResult.setUrl(url);
        return pictureResult;
    }
}
