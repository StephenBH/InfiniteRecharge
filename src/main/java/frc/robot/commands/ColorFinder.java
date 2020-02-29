package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;


public class ColorFinder extends CommandBase {
    
    private Elevator.WheelColor wheelColor;
    Elevator elevator;

    public ColorFinder(Elevator elevator) {
        this.elevator = elevator;
        addRequirements(elevator);
    }

    public void initialize(){
        switch (DriverStation.getInstance().getGameSpecificMessage()) {
            case "B":
            wheelColor = Elevator.WheelColor.BLUE;
            case "R":
            wheelColor = Elevator.WheelColor.RED;
            case "Y":
            wheelColor = Elevator.WheelColor.YELLOW;
            case "G":
            wheelColor = Elevator.WheelColor.GREEN;
        }
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return elevator.goToColor(wheelColor);
        }
    }