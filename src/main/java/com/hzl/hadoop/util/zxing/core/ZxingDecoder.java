package com.hzl.hadoop.util.zxing.core;

/**
 * <p>Title: Nepxion Zxing</p>
 * <p>Description: Nepxion Zxing QR Code</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.hzl.hadoop.util.zxing.exception.ZxingException;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ZxingDecoder {
    private static final Logger LOG = LoggerFactory.getLogger(ZxingDecoder.class);

    public Result decodeByFile(File file, String encoding) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            LOG.error("Decode file=[{}] error", file.getPath(), e);
            throw new ZxingException("Decode file=[" + file.getPath() + "] error", e);
        }

        try {
            return decode(image, encoding);
        } catch (NotFoundException e) {
            LOG.error("Decode file=[{}] error", file.getPath(), e);
            throw new ZxingException("Decode file=[" + file.getPath() + "] error", e);
        }
    }

    public Result decodeByInputStream(InputStream inputStream, String encoding) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(inputStream);
        } catch (IOException e) {
            LOG.error("Decode stream error", e);
            throw new ZxingException("Decode stream error", e);
        }

        try {
            return decode(image, encoding);
        } catch (NotFoundException e) {
            LOG.error("Decode stream error", e);
            throw new ZxingException("Decode stream error", e);
        }
    }

    public Result decodeByURL(URL url, String encoding) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            LOG.error("Decode url error", e);
            throw new ZxingException("Decode url error", e);
        }

        try {
            return decode(image, encoding);
        } catch (NotFoundException e) {
            LOG.error("Decode url error", e);
            throw new ZxingException("Decode url error", e);
        }
    }

    public Result decodeByBytes(byte[] bytes, String encoding) throws IOException {
        try(ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes)){
            return decodeByInputStream(inputStream, encoding);
        }
    }

    private Result decode(BufferedImage image, String encoding) throws NotFoundException {
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        Binarizer binarizer = new HybridBinarizer(source);
        BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

        Map<DecodeHintType, Object> hints = createHints(encoding);

        MultiFormatReader reader = new MultiFormatReader();

        return reader.decode(binaryBitmap, hints);
    }

    public static Map<DecodeHintType, Object> createHints(String encoding) {
        Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
        hints.put(DecodeHintType.CHARACTER_SET, encoding); // 设置编码

        return hints;
    }
}