package org.firstinspires.ftc.teamcode;/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotor.RunMode;
import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */
public class RogueBot
{
  /* Public OpMode members. */
//    public DcMotor leftFrontMotor   = null;
//    public DcMotor leftBackMotor  = null;
//    public DcMotor rightFrontMotor     = null;
//    public DcMotor rightBackMotor    = null;
//    public DcMotor liftMotor   = null;
//    public Servo leftClampServo    = null;
//    public Servo rightClampServo   = null;
//    public Servo armServo = null;
//    public ColorSensor colorSensor;
  public DcMotor leftFrontMotor= null;
  public DcMotor leftBackMotor= null;
  public DcMotor rightBackMotor= null;
  public DcMotor rightFrontMotor= null;
  public CRServo hookServo_1 = null;
  public CRServo hookServo_2 = null;
  public Servo rotateServo = null;
  public Servo intakeServo = null;
  public DcMotor liftMotorRight = null;
  public DcMotor liftMotorLeft = null;


  BNO055IMU imu;

  /* local OpMode members. */
  HardwareMap hwMap =  null;
  private ElapsedTime period  = new ElapsedTime();

  /* Constructor */
  public RogueBot(){

  }

  /* Initialize standard Hardware interfaces */
  public void init(HardwareMap hardwareMap) {

    //Assigning variables
    // Drivebase motors
    leftFrontMotor = hardwareMap.dcMotor.get("frontLeft");
    leftBackMotor = hardwareMap.dcMotor.get("backLeft");
    rightBackMotor = hardwareMap.dcMotor.get("backRight");
    rightFrontMotor = hardwareMap.dcMotor.get("frontRight");

    // Lift motors
    liftMotorRight = hardwareMap.dcMotor.get("liftMotorRight");
    liftMotorLeft = hardwareMap.dcMotor.get("liftMotorLeft");

    // Foundation servos
    hookServo_1 = hardwareMap.crservo.get("hookServo1");
    hookServo_2 = hardwareMap.crservo.get("hookServo2");

    // Intake servos
    rotateServo = hardwareMap.servo.get("rotateServo");
    intakeServo = hardwareMap.servo.get("intakeServo");


      imu = hardwareMap.get(BNO055IMU.class, "imu");




    // Set up the parameters with which we will use our IMU. Note that integration
    // algorithm here just reports accelerations to the logcat log; it doesn't actually
    // provide positional information.
    BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
    parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
    parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
    parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
    parameters.loggingEnabled      = true;
    parameters.loggingTag          = "imu";
    parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();


    // Initialize sensor parameters
    imu.initialize(parameters);


    //Assigning directions of motors


    rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
    rightBackMotor.setDirection(DcMotor.Direction.REVERSE);


//    leftFrontMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    leftFrontMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    leftBackMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    rightFrontMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    rightBackMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    liftMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    liftMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);




  }
}