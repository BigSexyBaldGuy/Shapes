package mouseDraw;

import java.awt.*;
import javax.swing.*;

/**
 *  {@code mouseDraw}
 *  @version 2022101601
 *  @author David Simmons
 */


public class mouseDraw
{
    public static void main(String arg[])
    {
        EventQueue.invokeLater(() -> {
                CanvasFrame     frame;

                frame = new CanvasFrame();

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("MTC CPT-237 Fall 2022 mouseDraw");
                frame.setVisible(true);
            });
    }
}