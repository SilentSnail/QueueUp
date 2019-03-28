package com.queue.utils;

//import com.queue.utils.verify.GifEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 验证码获取工具类
 * Created by liusong on 2018/10/8.s
 */
public class VerifyCodeUtil {

    private static final char[] CODE_SEQUENCE = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final short WIDTH = 120;
    private static final short HEIGHT = 40;
    private static final short CODE_COUNT = 5;
    private static final Random random = new Random();
//    private static String savePath = "/Volumes/TEST_HD/Temp/imgTmp/";

    public static BufferedImage getImage(char[] code){
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);//创建图片
        Graphics grap = image.getGraphics();//获取图片的绘制器
        grap.setColor(Color.WHITE);//设置画笔颜色
        grap.fillRect(0, 0, WIDTH, HEIGHT);//绘制矩形

        //绘制内容
        grap.setColor(Color.GRAY);//重新设置画笔颜色
        int address = 20;
        for (int i = 0; i < code.length; i++) {
            grap.drawChars(code, i, 1, address, 20);//绘制内容
            address+=20;
        }

        //绘制干扰线
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(WIDTH - 1);
            int y = random.nextInt(HEIGHT - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            grap.drawLine(x, y, x + xl + 20, y + yl + 10);
        }

        float yawpRate = 0.05f;// 噪声率
        int area = (int) (yawpRate * WIDTH * HEIGHT);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            image.setRGB(x, y, 255);
        }
        grap.dispose();//释放资源
        return image;
    }

    /**
     * 获取验证码字符
     * @return
     */
    public static char[] getCode(){
        char[] codes = new char[CODE_COUNT];
        for (int i = 0; i < CODE_COUNT; i++) {
            codes[i] = CODE_SEQUENCE[random.nextInt(CODE_SEQUENCE.length)];
        }
        return codes;
    }

//    public static String getImageCode(OutputStream os) throws IOException {
//        char[] codes = getCode();
//        ImageIO.write(getImage(codes), "png", os);
//        os.flush();
//        return new StringBuffer().append(codes).toString();
//    }

    public static String getVerifyCode(OutputStream osm) throws IOException {
        char[] codes = getCode();
        ImageIO.write(getImage(codes), "png", osm);
        return new StringBuffer().append(codes).toString();
    }

//    public static void main(String[] args) {
//        try {
//            String saveName = SecurityEncryptUtils.getUUID()+ ".png";
//            File file = new File(savePath+saveName);
//            FileOutputStream os = new FileOutputStream(file);
//            String code = VerifyCodeUtil.getImageCode(os);
//            System.out.println(code);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
