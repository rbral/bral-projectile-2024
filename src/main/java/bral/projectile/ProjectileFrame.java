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
    public ProjectileFrame()
    {
        setSize(400, 600);
        setTitle("Projectile Calculate");
        setDefaultCloseOperation(EXIT_ON_CLOSE); // means you exit the app when you close. need this or else program wx stop

        setLayout(new GridLayout(8, 2));
        // JLabels:
        JLabel velocityLabel = new JLabel("Velocity");
        JLabel angleLabel = new JLabel("Angle");
        JLabel secondsLabel = new JLabel("Seconds");
        JLabel xLabel = new JLabel("x");
        JLabel xResultLabel = new JLabel("_");

        JLabel yLabel = new JLabel("y");
        JLabel yResultLabel = new JLabel("_");
        JLabel blankLabel = new JLabel();

        JLabel peakYLabel = new JLabel("Peak Y");
        JLabel peakYResultLabel = new JLabel("_");
        JLabel interceptXLabel = new JLabel("Intercept X");
        JLabel interceptXResultLabel = new JLabel("_");

        // JFields:
        JTextField velocityField = new JTextField();
        JTextField secondsField = new JTextField();

        // JSlider:
        JSlider angleSlider = new JSlider(0, 90, 0);
        angleSlider.setMajorTickSpacing(15);
        angleSlider.setMinorTickSpacing(1);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);

        //JButton:
        JButton calculateButton = new JButton("Calculate");

        //add:
        add(velocityLabel);
        add(velocityField);
        add(angleLabel);
        add(angleSlider);
        add(secondsLabel);
        add(secondsField);
        add(xLabel);
        add(xResultLabel);
        add(yLabel);
        add(yResultLabel);
        add(peakYLabel);
        add(peakYResultLabel);
        add(interceptXLabel);
        add(interceptXResultLabel);
        add(blankLabel);
        add(calculateButton);

        // calling methods to recalculate and display automatically:
        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                recalculateAndDisplay(angleSlider, velocityField, secondsField, xResultLabel, yResultLabel, peakYResultLabel, interceptXResultLabel);
            }
        });

        secondsField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                recalculateAndDisplay(angleSlider, velocityField, secondsField, xResultLabel, yResultLabel, peakYResultLabel, interceptXResultLabel);
            }
        });
        angleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                recalculateAndDisplay(angleSlider, velocityField, secondsField, xResultLabel, yResultLabel, peakYResultLabel, interceptXResultLabel);
            }
        });

        // a listener that does something when the button is clicked
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create a new projectile
                Projectile projectile = new Projectile(
                        angleSlider.getValue(),
                        Double.parseDouble(velocityField.getText())
                );
                projectile.setSeconds(
                        Double.parseDouble(secondsField.getText())
                );
                // display info
                xResultLabel.setText(Double.toString(projectile.getX()));
                yResultLabel.setText(Double.toString(projectile.getY()));
                peakYResultLabel.setText(Double.toString(projectile.getPeakY()));
                interceptXResultLabel.setText(Double.toString(projectile.getInterceptX()));

            }
        });

    }

    private void recalculateAndDisplay(
            JSlider angleSlider, JTextField velocityField, JTextField secondsField,
            JLabel xResultLabel, JLabel yResultLabel, JLabel peakYResultLabel, JLabel interceptXResultLabel
            )
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
            xResultLabel.setText(Double.toString(projectile.getX()));
            yResultLabel.setText(Double.toString(projectile.getY()));
            peakYResultLabel.setText(Double.toString(projectile.getPeakY()));
            interceptXResultLabel.setText(Double.toString(projectile.getInterceptX()));
        }
        catch (NumberFormatException e)
        {
            e.getMessage();
        }

    }


}
