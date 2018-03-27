package com.example.demoC.zxing;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * 用zxing解析二维码
 * Created by Gabriel on 18/3/27.
 **/
public class ReadQRCode {
    public static void main(String[] args) throws IOException {

        MultiFormatReader formatReader=new MultiFormatReader();
        //要读取得二维码的路径
        File file=new File("/Users/ganguo/Desktop/img.png");
        //读取文件，识别成一个图片
        BufferedImage image= ImageIO.read(file);

        BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
        HashMap hints=new HashMap<>();
        try {
            Result result=formatReader.decode(binaryBitmap,hints);
            System.out.println("解析结果："+result.toString());
            System.out.println("二维码格式类型："+result.getBarcodeFormat());
        } catch (NotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到路径");
        }
    }


}
