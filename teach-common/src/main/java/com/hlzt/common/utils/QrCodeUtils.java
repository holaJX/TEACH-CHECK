package com.hlzt.common.utils;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.*;

/**
 * 二维码工具
 *
 * @author hlzt-slx
 */
public class QrCodeUtils {
    /**
     * 获取BASE64的二维码
     *
     * @param string
     * @return
     */
    public static String getBase64(String string) {
        QrConfig config = new QrConfig(300, 300);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 设置前景色，既二维码颜色（青色）
        config.setForeColor(Color.BLACK);
        // 设置背景色（灰色）
        config.setBackColor(Color.WHITE);
        // 高纠错级别
        config.setErrorCorrection(ErrorCorrectionLevel.H);
        // 生成二维码到文件，也可以到流
        return QrCodeUtil.generateAsBase64(string, config, "jpg");
    }
}
