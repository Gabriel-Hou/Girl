package com.example.demoC.qrcode;

import jp.sourceforge.qrcode.data.QRCodeImage;

import java.awt.image.BufferedImage;

/**
 * 实现QRCodeImage接口，在解析二维码时会调用这个方法
 * Created by Gabriel on 18/3/27.
 **/
public class MyQRCodeImage implements QRCodeImage{

    BufferedImage bufferedImage;

    public MyQRCodeImage(BufferedImage bufferedImage){
        this.bufferedImage= bufferedImage;

    }

    @Override
    public int getWidth() {
        return bufferedImage.getWidth();
    }

    @Override
    public int getHeight() {
        return bufferedImage.getHeight();
    }

    @Override
    public int getPixel(int i, int i1) {
        System.out.println("111");
        return bufferedImage.getRGB(i,i1);
    }
}
