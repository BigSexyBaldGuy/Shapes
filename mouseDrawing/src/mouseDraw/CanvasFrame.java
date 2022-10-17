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
                // Add our CanvasComponent as a child will to the
                // contentPane provided by JFrame
                add (new CanvasComponent());

                // Causes this Window to be sized to fit the preferred
                // size and layouts of its subcomponents. The resulting
                // width and height of the window are automatically
                // enlarged if either of dimensions is less than the
                // minimum size as specified by the previous call to
                // the setMinimumSize method.
                pack();

                setLocationRelativeTo(null);
        }
}
