package com.queue.utils;

//import com.queue.utils.verify.GifEncoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.geom.AffineTransform;
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

    /**
     * 生成验证码图片
     * @param code 验证码内容
     * @return 验证码图片对象
     */
    private static BufferedImage getImage(char[] code){
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);//创建图片
        Graphics grap = image.getGraphics();//获取图片的绘制器
        grap.setColor(Color.WHITE);//设置画笔颜色
        grap.fillRect(0, 0, WIDTH, HEIGHT);//绘制矩形

        //绘制内容
        grap.setColor(Color.GRAY);//重新设置画笔颜色
        int address = 20;
        Font font = new Font(null, Font.PLAIN, 20);
        AffineTransform atf;
        for (int i = 0; i < code.length; i++) {
            atf = new AffineTransform();
            atf.rotate(Math.toRadians(45), 0, 0);
            font.deriveFont(atf);
            grap.setFont(font);
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
     * 获取指定长度的随机字符
     * @param length
     * @return
     */
    public static char[] getCode(int length){
        char[] codes = new char[length];
        for (int i = 0; i < length; i++) {
            codes[i] = CODE_SEQUENCE[random.nextInt(CODE_SEQUENCE.length)];
        }
        return codes;
    }

    /**
     * 向流中写入图片数据
     * @param osm
     * @return 验证码明文
     * @throws IOException
     */
    public static String getVerifyCode(OutputStream osm) throws IOException {
        return getVerifyCode(osm, CODE_COUNT);
    }

    public static String getVerifyCode(OutputStream osm, int length) throws IOException {
        char[] codes = getCode(length);
        ImageIO.write(getImage(codes), "jpg", osm);
        return new StringBuffer().append(codes).toString();
    }

    /**
     * 向客户端发送验证码
     * @param response
     * @return 验证码明文
     * @throws IOException
     */
    public static String getVerifyCode(HttpServletResponse response) throws IOException {
        return getVerifyCode(response, CODE_COUNT);
    }

    public static String getVerifyCode(HttpServletResponse response, int lengt) throws IOException {
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        return getVerifyCode(response.getOutputStream(), lengt);
    }

}
