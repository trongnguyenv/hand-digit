package com.bpo.exec.digitrecognition;

import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.util.ModelSerializer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_imgproc.CV_THRESH_OTSU;
import static org.bytedeco.javacpp.opencv_imgproc.cvThreshold;
import org.bytedeco.javacv.Frame;


public class Application {
    private final static String IMAGEPATH = "Sample/sample1.jpg";
    private final static String[] DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static MultiLayerNetwork restored;

    public Application() {
        try {
            String pathtoexe = System.getProperty("user.dir");
            File net = new File(pathtoexe, "/data-train/cn-model.data");
            restored = ModelSerializer.restoreMultiLayerNetwork(net);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    public static BufferedImage IplImageToBufferedImage(IplImage src) {
//        OpenCVFrameConverter.ToIplImage grabberConverter = new OpenCVFrameConverter.ToIplImage();
//        Java2DFrameConverter paintConverter = new Java2DFrameConverter();
//        Frame frame = grabberConverter.convert(src);
//        return paintConverter.getBufferedImage(frame, 1);
//    }

//    public static void displayImage(Mat image) {
//        BufferedImage img = IplImageToBufferedImage(new IplImage(image));
//        JFrame frame = new JFrame();
//        frame.setTitle("Result");
//        frame.setSize(new Dimension(img.getWidth() + 10, img.getHeight() + 10));
//        frame.setLayout(new FlowLayout());
//        JLabel label = new JLabel();
//        label.setIcon(new ImageIcon(img));
//        frame.add(label);
//        frame.setResizable(false);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }

    public static void main(String[] args) throws IOException{
        Application app = new Application();
        /*Load image in grayscale mode*/
        IplImage image = cvLoadImage(IMAGEPATH, 0);

        /*Binarising Image*/
        IplImage binimg = cvCreateImage(cvGetSize(image), IPL_DEPTH_8U, 1);
        cvThreshold(image, binimg, 0, 255, CV_THRESH_OTSU);

        /*Invert image */

    }
}
