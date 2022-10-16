package mouseDraw;

import java.awt.*;
import javax.swing.*;

/**
 *  {@code CanvasFrame}
 *  @version 2022101601
 *  @author David Simmons
 */

public class CanvasFrame extends JFrame
{
        public CanvasFrame()
        {
                add (new CanvasComponent());

                pack();

                setLocationRelativeTo(null);
        }
}
