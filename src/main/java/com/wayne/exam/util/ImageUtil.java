package com.wayne.exam.util;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	public static void main(String[] args) {
		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		try {
			Thumbnails.of(new File("D:\\Pictures\\shanheguren.png")).size(1920, 1080)
					.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "shield.jpg")), 0.25f)
					.outputQuality(0.8f).toFile("D:\\Pictures\\shanheguren2.png");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
