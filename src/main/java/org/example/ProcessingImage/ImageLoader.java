package org.example.ProcessingImage;

import lombok.AllArgsConstructor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
    int angle;
    public ImageLoader(int angle){
        this.angle = angle;
    }
    BufferedImage newImage;

    public void transform() {


        try {

            File file = new File("C://Users//marzenusia//IdeaProjects//Matrix//src//main//java//org//example//image//Zdjęcie WhatsApp 2023-10-19 o 12.25.31_e8f3c3cd.jpg"); // Zamień na ścieżkę do swojego obrazu
            BufferedImage image = ImageIO.read(file);

            int width = image.getWidth();
            int height = image.getHeight();

            newImage = setSide(width, height, image);
            newImage = rotation(image, height, width);


            File outputFile = new File("C://Users//marzenusia//IdeaProjects//Matrix//src//main//java//org//example//image//result3.png");
            ImageIO.write(newImage, "png", outputFile);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }


    BufferedImage setSide(int width, int height, BufferedImage image) {
        if (width != height) {
            if (angle == 90 || angle == 270) {
                newImage = new BufferedImage(height, width, image.getType());

            } else if (angle == 180) {
                newImage = new BufferedImage(width, height, image.getType());
            } else {
                throw new RuntimeException("angle must be one with this: 90,180,270");
            }
        } else {
            newImage = new BufferedImage(width, height, image.getType());
        }
        return newImage;

    }

    BufferedImage rotation(BufferedImage image, int height, int width) {

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                switch (angle) {
                    case (90) -> newImage.setRGB(y, width - 1 - x, pixel);
                    case (180) -> newImage.setRGB(width - 1 - x, height - 1 - y, pixel);
                    case (270) -> newImage.setRGB(height - 1 - y, x, pixel);
                }
            }
        }
        return newImage;
    }
}
