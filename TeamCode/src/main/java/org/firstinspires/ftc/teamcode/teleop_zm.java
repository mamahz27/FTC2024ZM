package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class teleop_zm extends LinearOpMode{

    @Override
    public void runOpMode() {
        DcMotor bl = hardwareMap.get(DcMotor.class, "bl");
        DcMotor br = hardwareMap.get(DcMotor.class, "br");

        //bl.setDirection(DcMotorSimple.Direction.REVERSE);
        //br.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()) {
            //getting joystick values for motor speed
            //left y value
            double ly = gamepad1.left_stick_y;
            //right x value
            double rx = gamepad1.right_stick_x;

            //setting motor speeds w/ joystick values
            bl.setPower(ly + rx);
            br.setPower(ly - rx);

        }
    }
}