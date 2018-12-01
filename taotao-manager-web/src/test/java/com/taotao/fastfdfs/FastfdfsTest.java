package com.taotao.fastfdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.IOException;

public class FastfdfsTest {
    @Test
    public void fastTest() throws IOException, MyException {
        ClientGlobal.init("D:\\Learning\\JavaWorkSpace\\taotao\\taotao-manager-web\\src\\main\\resources\\resource\\fastdfs.conf");
        TrackerClient trackerClient =new TrackerClient();
        TrackerServer trackerServer =trackerClient.getConnection();
        StorageServer storageServer=null;
        StorageClient storageClient=new StorageClient(trackerServer,storageServer);
       String[] strs= storageClient.upload_file("E:\\工作目录\\项目需求\\故障灯实拍图片\\故障灯实拍图片\\1.jpg","jpg",null);
        for(String s:strs){
            System.out.println(s);
        }

    }
}
