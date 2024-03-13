package bral.projectile;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ProjectileFrame extends JFrame
{
    private JTextField velocityField;

    private JTextField secondsField;

    private JSlider angleSlider;

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

        west.setLayout(new GridLayout(8, 2));

        JLabel velocityLabel = new JLabel("Velocity");
        west.add(velocityLabel);

        velocityField = new JTextField();
        west.add(velocityField);

        JLabel angleLabel = new JLabel("Angle");
        west.add(angleLabel);

        angleSlider = new JSlider(0, 90, 0);
        angleSlider.setMajorTickSpacing(15);
        angleSlider.setMinorTickSpacing(1);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);
        west.add(angleSlider);

        JLabel secondsLabel = new JLabel("Seconds");
        west.add(secondsLabel);

        secondsField = new JTextField();
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

        JLabel blankLabel = new JLabel();
        west.add(blankLabel);

        JButton calculateButton = new JButton("Calculate");
        west.add(calculateButton);

        // calling methods to recalculate and display automatically:
        velocityField.getDocument().addDocumentListener((SimpleDocumentListener) e -> recalculateAndDisplay());

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
                    Double.parseDouble(velocityField.getText())
            );
            projectile.setSeconds(
                    Double.parseDouble(secondsField.getText())
            );

            // set the projectile info to the graph
            graph.setProjectile(projectile);

            // display info
            resultLabelX.setText(Double.toString(projectile.getX()));
            resultLabelY.setText(Double.toString(projectile.getY()));
            resultLabelPeakY.setText(Double.toString(projectile.getPeakY()));
            resultLabelInterceptX.setText(Double.toString(projectile.getInterceptX()));
        } catch (NumberFormatException e)
        {
            e.printStackTrace();
        }

    }


}
