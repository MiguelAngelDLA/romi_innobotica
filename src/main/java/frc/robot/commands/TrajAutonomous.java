package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.trajectories.FirstCuadrant;

public class TrajAutonomous extends SequentialCommandGroup{

    FirstCuadrant firstCuadrant = new FirstCuadrant();
    public TrajAutonomous(Drivetrain drivetrain){

        var ResetOdometry = new InstantCommand(() -> drivetrain.resetOdometry(firstCuadrant.firstMove().getInitialPose()));

        addCommands(
            ResetOdometry,
            drivetrain.createCommandForTrajectory(firstCuadrant.firstMove(), true),
            drivetrain.createCommandForTrajectory(firstCuadrant.secondMove(), true),
            drivetrain.createCommandForTrajectory(firstCuadrant.thirdMove(), true),
            drivetrain.createCommandForTrajectory(firstCuadrant.fourthMove(), true),
            drivetrain.createCommandForTrajectory(firstCuadrant.fithMove(), true)
        );
    }
    
}
