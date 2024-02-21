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
    private JLabel xResultLabel;
    private JLabel yResultLabel;
    private JLabel peakYResultLabel;
    private JLabel interceptXResultLabel;
    public ProjectileFrame()
    {
        setSize(400, 600);
        setTitle("Projectile Calculate");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8, 2));

        // JLabels:
        JLabel angleLabel = new JLabel("Angle");
        JLabel secondsLabel = new JLabel("Seconds");
        JLabel xLabel = new JLabel("x");
        xResultLabel = new JLabel("_");

        JLabel yLabel = new JLabel("y");
        yResultLabel = new JLabel("_");
        JLabel blankLabel = new JLabel();

        JLabel peakYLabel = new JLabel("Peak Y");
        peakYResultLabel = new JLabel("_");
        JLabel interceptXLabel = new JLabel("Intercept X");
        interceptXResultLabel = new JLabel("_");

        // JFields:
        velocityField = new JTextField();


        // JSlider:
        angleSlider = new JSlider(0, 90, 0);
        angleSlider.setMajorTickSpacing(15);
        angleSlider.setMinorTickSpacing(1);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);


        //add:
        JLabel velocityLabel = new JLabel("Velocity");
        add(velocityLabel);
        add(velocityField);
        add(angleLabel);
        add(angleSlider);
        add(secondsLabel);
        secondsField = new JTextField();
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
        //JButton:
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
