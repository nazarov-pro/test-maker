/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */
package az.shahin.other;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class ImageOptions {

    private ImageOptions() {

    }

    public static void copyFile(File sourceFile, String path)
            throws IOException {
        File destFile = new File("img/" +  (path.endsWith(".jpg") ? (path) : (path + ".jpg")));
        if (!sourceFile.exists()) {
            return;
        }
        if (!destFile.exists()) {
            destFile.createNewFile();
            FileChannel source = null;
            FileChannel destination = null;
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            if (destination != null && source != null) {
                destination.transferFrom(source, 0, source.size());
            }
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }

    }

    public static BufferedImage setResalution(int width, int height, String path) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bi.createGraphics();
        //System.out.println(path+"\n"+"img/"+(path.endsWith(".jpg") ? path :( path+".jpg")));
        Image img = null;
        File newfile = new File("img/" + (path.endsWith(".jpg") ? (path) : (path + ".jpg")));
        try {
            //  System.out.println(newfile.toURL());
            img = ImageIO.read(newfile.toURL());
        } catch (IOException ex) {
            Logger.getLogger(ImageOptions.class.getName()).log(Level.SEVERE, null, ex);
        }

        g.drawImage(img, 0, 0, width, height, null);

        g.dispose();

        return bi;
    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        String byShahin = "img/" + (destinationFile.endsWith(".jpg") ? destinationFile : destinationFile + ".jpg");
        //System.out.println(imageUrl + "\n" + byShahin);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(byShahin);
        byte[] b = new byte[2048];
        int length;
        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }
        is.close();
        os.close();
        File file = new File(byShahin);
        file.deleteOnExit();
    }

}
