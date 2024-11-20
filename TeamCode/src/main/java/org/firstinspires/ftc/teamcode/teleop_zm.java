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
        DcMotor arm = hardwareMap.get(DcMotor.class, "arm");
        DcMotor pivot_1 = hardwareMap.get(DcMotor.class, "pivot1");
        DcMotor pivot_2 = hardwareMap.get(DcMotor.class, "pivot2");

        //bl.setDirection(DcMotorSimple.Direction.REVERSE);
        //br.setDirection(DcMotorSimple.Direction.REVERSE);

        //positions for arm
        int p1 = 0;
        int p2 = -700;
        int p3 = -1400;
        int p4 = -2100;
        int pivotp1 = 0;
        int pivotp2 = -60;
        int pivotp3 = -120;
        //double close = 0;
        //double open = 1;

        waitForStart();
        while (opModeIsActive()) {
            //getting joystick values for motor speed
            double y = gamepad1.left_stick_y;
            double x = -gamepad1.right_stick_x;
            //setting motor speeds w/ joystick values
            bl.setPower(y + x);
            br.setPower(y - x);

            //resetting encoder back to 0
            arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            pivot_1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            pivot_2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            arm.setTargetPosition(0);
            pivot_1.setTargetPosition(0);
            pivot_2.setTargetPosition(0);

            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            pivot_1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            pivot_2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            //setting arm to different positions according to the press of a button
            if (gamepad1.a) {
                arm.setTargetPosition(p1);
                arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                arm.setPower(1);
            } else if (gamepad1.b) {
                arm.setTargetPosition(p2);
                arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                arm.setPower(1);
            } else if (gamepad1.x) {
                arm.setTargetPosition(p3);
                arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                arm.setPower(1);
            } else if (gamepad1.y) {
                arm.setTargetPosition(p4);
                arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                arm.setPower(1);
            } else {
                arm.setPower(0);
            }
            //arm pivot
            if (gamepad1.dpad_down) {
                pivot_1.setTargetPosition(pivotp1);
                pivot_1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                pivot_1.setPower(1);
                pivot_2.setTargetPosition(pivotp1);
                pivot_2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                pivot_2.setPower(1);
            } else if (gamepad1.dpad_right) {
                pivot_1.setTargetPosition(pivotp2);
                pivot_1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                pivot_1.setPower(1);
                pivot_2.setTargetPosition(pivotp2);
                pivot_2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                pivot_2.setPower(1);
            } else if (gamepad1.dpad_up) {
                pivot_1.setTargetPosition(pivotp3);
                pivot_1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                pivot_1.setPower(1);
                pivot_2.setTargetPosition(pivotp3);
                pivot_2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                pivot_2.setPower(1);
            } else {
                pivot_1.setPower(0);
                pivot_2.setPower(0);
            }
    }
}
}