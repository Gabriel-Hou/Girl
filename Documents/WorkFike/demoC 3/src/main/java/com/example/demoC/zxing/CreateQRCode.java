package com.example.demoC.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * 用zxing生成二维码
 * Created by Gabriel on 18/3/27.
 **/
public class CreateQRCode {
    private static Integer width=300;
    private static Integer height=300;
    private static String format="png";
    private static String content="么么哒";

    public static void main(String[] args){
        //定义二维码的参数
        HashMap hints=new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");//编码格式
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//纠错等级，
        hints.put(EncodeHintType.MARGIN,2);//边距
//                                                                 内容，     格式
        try {
            BitMatrix bitMatrix= new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);

            Path file=new File("/Users/ganguo/Desktop/img.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix,format,file);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("找不到路径");
        }


    }


    
}
