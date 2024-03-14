package bral.projectile;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class ProjectileFrame extends JFrame
{
//    private JTextField velocityField;

    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");

    private JSlider velocitySlider;

    private JLabel resultLabelVelocity;

    private JTextField secondsField;

    private JSlider angleSlider;

    private JLabel resultLabelAngle;

    private JLabel resultLabelX;

    private JLabel resultLabelY;

    private JLabel resultLabelPeakY;

    private JLabel resultLabelInterceptX;

    private ProjectileGraph graph;

    public ProjectileFrame()
    {
        setSize(1000, 800);
        setTitle("Projectile Calculate");
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        // tells the JFrame to use this JPanel
        setContentPane(main);

        JPanel west = new JPanel();
        // put the panel I'm calling west in the WEST part of the screen:
        main.add(west, BorderLayout.WEST);

        west.setLayout(new GridLayout(10, 2));

        JLabel velocityLabel = new JLabel("Velocity");
        west.add(velocityLabel);

        velocitySlider = new JSlider(0, 100, 65);
        west.add(velocitySlider);

        JLabel blankLabel1 = new JLabel();
        west.add(blankLabel1);

        resultLabelVelocity = new JLabel("-");
        west.add(resultLabelVelocity);


        /*velocityField = new JTextField();
        west.add(velocityField);*/

        JLabel angleLabel = new JLabel("Angle");
        west.add(angleLabel);

        angleSlider = new JSlider(0, 90, 31);
        angleSlider.setMajorTickSpacing(15);
        angleSlider.setMinorTickSpacing(1);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);
        west.add(angleSlider);

        JLabel blankLabel2 = new JLabel();
        west.add(blankLabel2);

        resultLabelAngle = new JLabel("-");
        west.add(resultLabelAngle);

        JLabel secondsLabel = new JLabel("Seconds");
        west.add(secondsLabel);

        secondsField = new JTextField("2.7");
        west.add(secondsField);

        JLabel labelX = new JLabel("x");
        west.add(labelX);

        resultLabelX = new JLabel("_");
        west.add(resultLabelX);

        JLabel labelY = new JLabel("y");
        west.add(labelY);

        resultLabelY = new JLabel("_");
        west.add(resultLabelY);

        JLabel labelPeakY = new JLabel("Peak Y");
        west.add(labelPeakY);

        resultLabelPeakY = new JLabel("_");
        west.add(resultLabelPeakY);

        JLabel labelInterceptX = new JLabel("Intercept X");
        west.add(labelInterceptX);

        resultLabelInterceptX = new JLabel("_");
        west.add(resultLabelInterceptX);

        JLabel blankLabel3 = new JLabel();
        west.add(blankLabel3);

        JButton calculateButton = new JButton("Calculate");
        west.add(calculateButton);

        // calling methods to recalculate and display automatically:
//        velocityField.getDocument().addDocumentListener((SimpleDocumentListener) e -> recalculateAndDisplay());
        velocitySlider.addChangeListener(e -> recalculateAndDisplay());

        secondsField.getDocument().addDocumentListener((SimpleDocumentListener) e -> recalculateAndDisplay());

        angleSlider.addChangeListener(e -> recalculateAndDisplay());

        // a listener that does something when the button is clicked
        calculateButton.addActionListener(e -> recalculateAndDisplay());

        // put graph in center
        graph = new ProjectileGraph();
        main.add(graph, BorderLayout.CENTER);

    }

    private void recalculateAndDisplay()
    {
        try
        {
            Projectile projectile = new Projectile(
                    angleSlider.getValue(),
                    velocitySlider.getValue()
//                    Double.parseDouble(velocityField.getText())
            );
            projectile.setSeconds(
                    Double.parseDouble(secondsField.getText())
            );

            // set the projectile info to the graph
            graph.setProjectile(projectile);

            // display info
            resultLabelVelocity.setText(String.valueOf(velocitySlider.getValue()));
            resultLabelAngle.setText(String.valueOf(angleSlider.getValue()));
            resultLabelX.setText(FORMAT.format(projectile.getX()));
            resultLabelY.setText(FORMAT.format(projectile.getY()));
            resultLabelPeakY.setText(FORMAT.format(projectile.getPeakY()));
            resultLabelInterceptX.setText(FORMAT.format(projectile.getInterceptX()));
        } catch (NumberFormatException e)
        {
            e.printStackTrace();
        }

    }


}
