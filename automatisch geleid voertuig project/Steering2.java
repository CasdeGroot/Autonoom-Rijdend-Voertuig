import TI.*;

public class Steering2
{
    BoeBotServo servoLeft;
    BoeBotServo servoRight;

    private float increment = 0;
    private float targetSpeedLeft = 0;
    private float targetSpeedRight = 0;
    private float speedLeft;
    private float speedRight;

    public Steering2()
    {
        servoLeft = new BoeBotServo(15, false);
        servoRight = new BoeBotServo(14, true);

    }

    public void update(int deltaTime)
    {
        if (servoLeft.getSpeed() != targetSpeedLeft)
        {
            if (servoLeft.getSpeed() < targetSpeedLeft)
            {
                servoLeft.setSpeed(servoLeft.getSpeed()+increment);
                if (servoLeft.getSpeed() > targetSpeedLeft)
                    servoLeft.setSpeed(targetSpeedLeft);
            }
            else
            {
                servoLeft.setSpeed(servoLeft.getSpeed()-increment);
                if (servoLeft.getSpeed() < targetSpeedLeft)
                    servoLeft.setSpeed(targetSpeedLeft);
            }
        }

        if (servoRight.getSpeed() != targetSpeedRight)
        {
            if (servoRight.getSpeed() < targetSpeedRight)
            {
                servoRight.setSpeed(servoRight.getSpeed()+increment);
                if (servoRight.getSpeed() > targetSpeedRight)
                    servoRight.setSpeed(targetSpeedRight);
            }
            else
            {
                servoRight.setSpeed(servoRight.getSpeed()-increment);
                if (servoRight.getSpeed() < targetSpeedRight)
                    servoRight.setSpeed(targetSpeedRight);
            }
        }
        //System.out.println("Left " + targetSpeedLeft + ", " + servoLeft.getSpeed() + "\n" +
        //        "Right " + targetSpeedRight + ", " + servoRight.getSpeed() + "\n"); 
    }

    public void goToSpeedIncrement(float targetSpeed, float increment)
    {
        targetSpeedLeft = targetSpeed;
        targetSpeedRight = targetSpeed;
        this.increment = increment; 

        System.out.println("targetSpeed "+ targetSpeed+", targetSpeedLeft " + targetSpeedLeft + ", targetSpeedRight " + targetSpeedRight); 
    }

    public void getSpeed()
    {
        servoLeft.getSpeed();
        servoRight.getSpeed();
    }

    public void TurnDegrees(boolean direction)
    {   
        if(direction)
        {
            targetSpeedLeft = 0;
            targetSpeedRight = 100;
        }

        if(!direction)
        {
            targetSpeedLeft = 100;
            targetSpeedRight = 0;
        }
        
        servoLeft.setSpeed(targetSpeedLeft);
        servoRight.setSpeed(targetSpeedRight);
    }
    
    public void turnDegrees(int degrees)
    {
        System.out.println("This is not supported");
    }
}