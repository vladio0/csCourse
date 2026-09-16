package com.shpp.p2p.cs.vbanada.assignment3;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
    Program - 5sec of fame

    In this program I made animation of atom core which consist of proton(p+)
    and neutron(n) and electrons (e-) around core
 */
public class Assignment3Part6 extends WindowProgram {
    //Application size constants
    private static final int APPLICATION_WIDTH = 500;
    private static final int APPLICATION_HEIGHT = 500;
    //Orbit diameter constant
    private static final double ORBIT_DIAMETER = 300;
    //Nucleon dimeter constant and core offset
    private static final double NUCLEON_DIAMETER = 60;
    private static final double CORE_OFFSET = 20;
    //Electron diameter constant
    private static final double ELECTRON_DIAMETER = 20;
    //Amount of circles electron can go
    private static final double REVOLUTIONS = 1;
    /*
        Making a variables to cut down a formula
        Than drawing a core and orbit of atom
        Creating two electrons and two labels "e-"
        Using currentTimeMillis for accurate time measurement
        Creating a cycle to setLocation and move electrons on orbit
     */
    @Override
    public void run() {
        double centerX = (double) getWidth() / 2;
        double centerY = (double) getHeight() / 2;
        double radius = ORBIT_DIAMETER / 2;
        double electronRadius = ELECTRON_DIAMETER / 2;

        drawCore(centerX, centerY);
        drawOrbit();

        GOval electronOne = createParticle(ELECTRON_DIAMETER, Color.YELLOW);
        GOval electronTwo = createParticle(ELECTRON_DIAMETER, Color.YELLOW);

        GLabel labelOne = createLabel("e-");
        GLabel labelTwo = createLabel("e-");

        long startTime = System.currentTimeMillis();
        while (true) {
            long elapsed = System.currentTimeMillis() - startTime;
            if (elapsed >= 5000) {
                break;
            }
            double progress = (double) elapsed / 5000;
            double angle = progress * REVOLUTIONS * 2 * Math.PI;
            moveElectron(centerX, centerY, radius, electronOne, labelOne, electronRadius, angle);
            moveElectron(centerX, centerY, radius, electronTwo, labelTwo, electronRadius, angle + Math.PI);
            pause(16);
        }
    }
    /*
        To move electron using a formula: center+radius*sin(or cos);
        Moving a label of electron as well
     */
    private void moveElectron(double centerX, double centerY, double radius,
                              GOval electron, GLabel label, double electronRadius, double angle) {
        double x = centerX + radius * Math.cos(angle);
        double y = centerY + radius * Math.sin(angle);

        electron.setLocation(x - electronRadius, y - electronRadius);

        label.setLocation(x - label.getWidth() / 2, y + label.getAscent() / 2);
    }
    /*
        Drawing orbit of core
     */
    private void drawOrbit() {
        GOval orbit = new GOval(
                (double) getWidth() / 2 - ORBIT_DIAMETER / 2,
                (double) getHeight() / 2 - ORBIT_DIAMETER / 2,
                ORBIT_DIAMETER,
                ORBIT_DIAMETER
        );
        add(orbit);
    }
    /*
        Creating a particle which means to create a GOval for electron, proton, neutron
     */
    private GOval createParticle(double size, Color color) {
        GOval particle = new GOval(
                size,
                size
        );
        particle.setFillColor(color);
        particle.setFilled(true);
        add(particle);
        return particle;
    }
    /*
        Creating GLabel for all labels in animation
     */
    private GLabel createLabel(String text) {
        GLabel label = new GLabel(text);
        label.setFont("SansSerif-Bold-12");
        label.setColor(Color.BLACK);
        add(label);
        return label;
    }
    /*
        Drawing core that consists of proton and neutron
        Using createParticle to create circles
        Setting location for both
        Creating label and setting location for label
     */
    private void drawCore(double centerX, double centerY) {
        double protonX = centerX - CORE_OFFSET;
        GOval proton = createParticle(NUCLEON_DIAMETER, Color.GREEN);
        proton.setLocation(protonX - NUCLEON_DIAMETER / 2, centerY - NUCLEON_DIAMETER / 2);

        GLabel protonLabel = createLabel("p+");
        protonLabel.setLocation(protonX - protonLabel.getWidth() / 2.0, centerY + protonLabel.getAscent() / 2.0);

        double neutronX = centerX + CORE_OFFSET;
        GOval neutron = createParticle(NUCLEON_DIAMETER, Color.GRAY);
        neutron.setLocation(neutronX - NUCLEON_DIAMETER / 2, centerY - NUCLEON_DIAMETER / 2);

        GLabel neutronLabel = createLabel("n");
        neutronLabel.setLocation(neutronX - neutronLabel.getWidth() / 2.0, centerY + neutronLabel.getAscent() / 2.0);
    }
}
