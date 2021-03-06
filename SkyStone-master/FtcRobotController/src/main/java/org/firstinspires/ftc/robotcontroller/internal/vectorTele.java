package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "vectorTele", group = "9191")
public class vectorTele extends OpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor linearLift;
    private DcMotor intakeLeft;
    private DcMotor intakeRight;
    private CRServo gripperLeft;
    private CRServo gripperRight;
    private CRServo gripperChange;
    private CRServo counterServo;
    private Servo foundationOne;
    private Servo foundationTwo;
    private CRServo capStone;

    //private CRServo pushBlock;*/
    @Override
    //TODO: Intake on GP1; Fix foundation servos; Slow down rotator
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
        linearLift = hardwareMap.dcMotor.get("LL");
        intakeLeft = hardwareMap.dcMotor.get("IL");
        intakeRight = hardwareMap.dcMotor.get("IR");
        gripperLeft = hardwareMap.crservo.get("GF");
        gripperRight = hardwareMap.crservo.get("GB");
        gripperChange = hardwareMap.crservo.get("GC");
        counterServo = hardwareMap.crservo.get("CL");
        foundationOne = hardwareMap.servo.get("F1");
        foundationTwo = hardwareMap.servo.get("F2");
        //pushBlock = hardwareMap.crservo.get("PB");
        capStone = hardwareMap.crservo.get("CS");


    }

    @Override

    public void loop() {
      /*
        double mag = Math.abs(gamepad1.left_stick_x) + Math.abs(gamepad1.left_stick_y) + Math.abs(gamepad1.right_stick_x);
        double throtle = (1 + gamepad1.left_trigger - gamepad1.right_trigger);
        final double v1 = (gamepad1.left_stick_x/3 - gamepad1.left_stick_y/3 + gamepad1.right_stick_x/3) * mag ;
        final double v2 = (-gamepad1.left_stick_x/3 - gamepad1.left_stick_y/3 - gamepad1.right_stick_x/3) * mag;
        final double v3 = (-gamepad1.left_stick_x/3  - gamepad1.left_stick_y/3 + gamepad1.right_stick_x/3) * mag;
        final double v4 = (gamepad1.left_stick_x/3 - gamepad1.left_stick_y/3 - gamepad1.right_stick_x/3) * mag;

/*
        double mag = Math.abs(gamepad1.left_stick_x) + Math.abs(gamepad1.left_stick_y) + Math.abs(gamepad1.right_stick_x);
        double throtle = (1 - gamepad1.left_trigger);
        final double v1 = (gamepad1.left_stick_x - gamepad1.left_stick_y + gamepad1.right_stick_x) / mag ;
        final double v2 = (-gamepad1.left_stick_x - gamepad1.left_stick_y - gamepad1.right_stick_x) / mag;
        final double v3 = (-gamepad1.left_stick_x  - gamepad1.left_stick_y + gamepad1.right_stick_x) / mag;
        final double v4 = (gamepad1.left_stick_x - gamepad1.left_stick_y - gamepad1.right_stick_x) / mag;
*/


        double throtle = (1 + gamepad1.left_trigger - gamepad1.right_trigger);
        final double v1 = (gamepad1.left_stick_x - gamepad1.left_stick_y) / 1.69 + gamepad1.right_stick_x;
        final double v2 = (-gamepad1.left_stick_x - gamepad1.left_stick_y) / 1.69 - gamepad1.right_stick_x;
        final double v3 = (-gamepad1.left_stick_x - gamepad1.left_stick_y) / 1.69 + gamepad1.right_stick_x;
        final double v4 = (gamepad1.left_stick_x - gamepad1.left_stick_y) / 1.69 - gamepad1.right_stick_x;
        frontLeft.setPower(v1 * throtle);
        frontRight.setPower(-v2 * throtle);
        backLeft.setPower(v3 * throtle);
        backRight.setPower(-v4 * throtle);
        intakeRight.setPower(gamepad2.right_stick_y * 2);
        intakeLeft.setPower(-gamepad2.right_stick_y * 2);


        linearLift.setPower(gamepad2.right_trigger);
        counterServo.setPower(gamepad2.right_trigger * -.2);
        counterServo.setPower(gamepad2.left_trigger);
        linearLift.setPower(gamepad2.left_trigger * -.14);


        if (gamepad2.a) {
            gripperLeft.setPower(1);
            gripperRight.setPower(-1);
        } else if (gamepad2.y) {
            gripperRight.setPower(1);
            gripperLeft.setPower(-1);
        } else {
            gripperLeft.setPower(0);
            gripperRight.setPower(0);
        }
        if (gamepad2.x) {
            gripperChange.setPower(.65);
        } else if (gamepad2.b) {
            gripperChange.setPower(-.65);
        } else {
            gripperChange.setPower(0);

        }
        if (gamepad1.y) {
            foundationOne.setPosition(foundationOne.getPosition() - .01);
            foundationTwo.setPosition(foundationTwo.getPosition() + .01);
        } else if (gamepad1.a) {
            foundationOne.setPosition(foundationOne.getPosition() + .02);
            foundationTwo.setPosition(foundationTwo.getPosition() - .02);
        } if (gamepad1.left_bumper) {
                capStone.setPower(1);
            } else if (gamepad1.right_bumper) {
                capStone.setPower(-1);
            } else {
                capStone.setPower(0);

        }
    }
}
