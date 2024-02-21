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

    public ProjectileFrame()
    {
        setSize(400, 600);
        setTitle("Projectile Calculate");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8, 2));

        JLabel velocityLabel = new JLabel("Velocity");
        add(velocityLabel);

        velocityField = new JTextField();
        add(velocityField);

        JLabel angleLabel = new JLabel("Angle");
        add(angleLabel);

        angleSlider = new JSlider(0, 90, 0);
        angleSlider.setMajorTickSpacing(15);
        angleSlider.setMinorTickSpacing(1);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);
        add(angleSlider);

        JLabel secondsLabel = new JLabel("Seconds");
        add(secondsLabel);

        secondsField = new JTextField();
        add(secondsField);

        JLabel labelX = new JLabel("x");
        add(labelX);

        resultLabelX = new JLabel("_");
        add(resultLabelX);

        JLabel labelY = new JLabel("y");
        add(labelY);

        resultLabelY = new JLabel("_");
        add(resultLabelY);

        JLabel labelPeakY = new JLabel("Peak Y");
        add(labelPeakY);

        resultLabelPeakY = new JLabel("_");
        add(resultLabelPeakY);

        JLabel labelInterceptX = new JLabel("Intercept X");
        add(labelInterceptX);

        resultLabelInterceptX = new JLabel("_");
        add(resultLabelInterceptX);

        JLabel blankLabel = new JLabel();
        add(blankLabel);

        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);

        // calling methods to recalculate and display automatically:
        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                recalculateAndDisplay();
            }
        });

        secondsField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                recalculateAndDisplay();
            }
        });
        angleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                recalculateAndDisplay();
            }
        });

        // a listener that does something when the button is clicked
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recalculateAndDisplay();
            }
        });

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
            // display info
            resultLabelX.setText(Double.toString(projectile.getX()));
            resultLabelY.setText(Double.toString(projectile.getY()));
            resultLabelPeakY.setText(Double.toString(projectile.getPeakY()));
            resultLabelInterceptX.setText(Double.toString(projectile.getInterceptX()));
        } catch (NumberFormatException e)
        {
            System.out.println("Did not fill in all fields.");
        }

    }


}
