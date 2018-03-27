package com.example.demoC.qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 用Qrcode解析二维码
 * Created by Gabriel on 18/3/27.
 **/
public class ReadQRCode {
    public static void main(String[] args) throws IOException {
        File file=new File("/Users/ganguo/Desktop/QRCode.png");
        BufferedImage image= ImageIO.read(file);
        QRCodeDecoder codeDecoder=new QRCodeDecoder();
        String result=new String(codeDecoder.decode(new MyQRCodeImage(image)),"gb2312");
        System.out.println(result);
    }
}
