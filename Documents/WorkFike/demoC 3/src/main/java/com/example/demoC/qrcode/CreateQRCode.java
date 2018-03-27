package com.example.demoC.qrcode;


import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 使用Qrcode方式生成二维码
 * Created by Gabriel on 18/3/27.
 **/
public class CreateQRCode {
    private static Integer width=67+12*(7-1);
    private static Integer height=67+12*(7-1);
    public static void main(String[] args) throws IOException {
        Qrcode x=new Qrcode();
        x.setQrcodeErrorCorrect('M');//纠错等级
        x.setQrcodeEncodeMode('B');//N代表数字，A代表a--Z,B代表其他字符
        x.setQrcodeVersion(7);//版本号
        String qrDate="你好黄小刀";

        BufferedImage bufferedImage=new BufferedImage(300,300,BufferedImage.TYPE_INT_RGB);
        //调用java的画图工具
        Graphics2D gs=bufferedImage.createGraphics();
        gs.setBackground(Color.WHITE);
        gs.setColor(Color.PINK);
        gs.clearRect(0,0,width,height);//清除画板内容

        int pixoff=2;//偏移量
        byte[] d=qrDate.getBytes("gb2312");
        //向画板里填充内容
        if(d.length>0&&d.length<120){
            boolean[][]s=x.calQrcode(d);//将填充内容转换为字节数
            for(int i=0;i<s.length;i++){
                for (int j = 0; j < s.length; j++) {
                    if(s[j][i]){
                        gs.fillRect(j*3+pixoff,i*3+pixoff,3,3);
                    }
                }
            }
        }
        System.out.println("111");

        gs.dispose();
        bufferedImage.flush();
        ImageIO.write(bufferedImage,"png",new File("/Users/ganguo/Desktop/QRCode.png"));

    }
}
