package com.taotao.service;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.pojo.TaotaoResult;

public interface PicService {
    /*public PictureResult uploadPic(MultipartFile picFile);*/
    public PictureResult upload(byte[] fileBytes,String extName,String orignalName) throws Exception;
}
