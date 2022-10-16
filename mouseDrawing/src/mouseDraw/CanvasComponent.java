package mouseDraw;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 *  {@code CanvasComponent} is the class that extends Expression to
 *  store a name, hashcode and value for the instance.
 *  @version 2022101601
 *  @author David Simmons
 */

public class CanvasComponent extends JComponent {
    private static final int defaultWidth = 10240;
    private static final int defaultHeight = 7680;

    private int                 whatToDraw;
    private RectangularShape    shape;
    private JPopupMenu          popupMenu;

    private class mouseHandler extends MouseAdapter
    {
        Point startingPoint;

        // Every time mouse is clicked
        public void mousePressed(MouseEvent event)
        {
            if (event.isPopupTrigger() == true) {
                popupMenu.show(event.getComponent(),
                        event.getX(), event.getY());
                return;
            }
                startingPoint = event.getPoint();
            }

            public void mouseDragged(MouseEvent event)
            {
                Point currentPoint;

                currentPoint = event.getPoint();

                if (shape == null) {
                    if (whatToDraw == 0) {
                        shape = new Rectangle2D.Double();
                    } else if (whatToDraw == 1) {
                        shape = new Ellipse2D.Double();
                    }
                }

                shape.setFrameFromCenter(startingPoint,
                        currentPoint);

                repaint();
            }

            public void mouseReleased(MouseEvent event)
            {
                shape = null;
            }
        }

        public CanvasComponent()
        {
            mouseHandler            mouseHandler;
            ButtonGroup             buttonGroup;
            JRadioButtonMenuItem    thisButton;

            mouseHandler = new mouseHandler();
            addMouseListener(mouseHandler);
            addMouseMotionListener(mouseHandler);

            popupMenu = new JPopupMenu();
            buttonGroup = new ButtonGroup();
            thisButton = new JRadioButtonMenuItem("Rectangle", true);
            thisButton.addActionListener(event -> whatToDraw = 0);
            buttonGroup.add(thisButton);
            popupMenu.add(thisButton);

            thisButton = new JRadioButtonMenuItem("Ellipse", false);
            thisButton.addActionListener(event -> whatToDraw = 1);
            buttonGroup.add(thisButton);
            popupMenu.add(thisButton);

            setComponentPopupMenu(popupMenu);
        }

        public Dimension getPreferredSize()
        {
            int width;
            int height;
            Toolkit toolkit;
            Dimension screenSize;

            toolkit = Toolkit.getDefaultToolkit();
            screenSize = toolkit.getScreenSize();

            width = defaultWidth;
            if (width > screenSize.width) {
                width = screenSize.width / 2;
            }

            height = defaultHeight;
            if (height > screenSize.height) {
                height = screenSize.height / 2;
            }

            return (new Dimension(width, height));
        }

        public void paintComponent(Graphics graphics)
        {
            Graphics2D graphics2D;

            graphics2D = (Graphics2D) graphics;

            if (shape != null)
            {
                graphics2D.draw(shape);
            }
        }
    }