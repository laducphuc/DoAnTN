package common;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageResize {
	private static final int IMG_WIDTH = 890;
	private static final int IMG_HEIGHT = 323;
    public static void resizeImage(String path){
    BufferedImage originalImage,resizedImage;
    int type=0;
	try {
		originalImage = ImageIO.read(new File(path));
		type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();
		System.out.println("doi thanh cong");
		ImageIO.write(resizedImage, "jpg", new File(path));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("doi that bai");
	}
	
    }

}
