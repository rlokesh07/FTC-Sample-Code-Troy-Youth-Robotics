package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.MarkerCallback;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;

import java.util.Vector;

public class MeepMeepTesting {

    public static double MAX_VEL = 50;
    public static double MAX_ACCEL = 50;
    public static double MAX_ANG_VEL = Math.toRadians(200);
    public static double MAX_ANG_ACCEL = Math.toRadians(200);


    public static void main(String[] args) throws Exception {
        // TODO: If you experience poor performance, enable this flag
        // System.setProperty("sun.java2d.opengl", "true");

        // Declare a MeepMeep instance
        // With a field size of 800 pixels
        MeepMeep mm = new MeepMeep(750)
                // Set field image
                .setBackground(MeepMeep.Background.FIELD_FREIGHT_FRENZY)
                // Set theme
                .setTheme(new ColorSchemeRedDark())
                // Background opacity from 0-1
                .setBackgroundAlpha(1f)
                // Set constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(MAX_VEL, MAX_ACCEL, MAX_ANG_VEL, MAX_ANG_ACCEL, 9)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(12, -64, Math.toRadians(0)))
                                .strafeLeft(40)
                                .strafeRight(40)
                                .forward(34)
                                .lineToLinearHeading(new Pose2d(35,-65, Math.toRadians(0)))
                                .back(14)
                                .splineToSplineHeading(new Pose2d(-6, -42, Math.toRadians(300)), Math.toRadians(90))
                                .lineToSplineHeading(new Pose2d(12,-64, Math.toRadians(0)))
                                .forward(32)
                                .build()
                )
                .start();
    }
}