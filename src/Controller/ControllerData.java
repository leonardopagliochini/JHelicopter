package Controller;

import View.Scores;

public class ControllerData {

    private static boolean isRunning = false;
    private static int score = 0;
    private static boolean coinIntersect = false;
    private static double cointime = 8;
    private static int highScore = 0;
    private static boolean endingGame = false;
    private static int explosionMstimer = 0;
    private static int coinMstimer = 0;
    private static boolean exceedColumn = false;
    private static boolean beamCollision = false;
    private static String coinPath = "/Resources/GameObjectIcons/coin/coin0.png";

    private static boolean paused = false;

    private static int xSpeed = 5;
    private static int ySpeed = 4;
    private static int xSpeedRecovery = 5;
    private static int ySpeedRecovery = 4;



    public static void incrementScore()
    {
        score++;
    }


    /*GET AND SET METHODS*/

    public static void setIsRunning(boolean b)
    {
        isRunning = b;
    }

    public static boolean isIsRunning()
    {
        return isRunning;
    }

    public static boolean isCoinIntersect() {
        return coinIntersect;
    }

    public static int getScore() {
        return score;
    }

    public static double getCointime() {
        return cointime;
    }

    public static void setCointime(double cointime) {
        ControllerData.cointime = cointime;
    }

    public static void setCoinIntersect(boolean coinIntersect) {
        ControllerData.coinIntersect = coinIntersect;
    }

    public static int getHighScore() {
        return highScore;
    }

    public static void setHighScore() {
        highScore = Scores.max();
    }

    public static void setScore(int score) {
        ControllerData.score = score;
    }

    public static void setEndingGame(boolean endingGame) {
        ControllerData.endingGame = endingGame;
    }

    public static boolean isEndingGame() {
        return endingGame;
    }

    public static void setExplosionMstimer(int value) {
        explosionMstimer = value;
    }

    public static int getExplosionMstimer() {
        return explosionMstimer;
    }

    public static void incrementExplosionMstimer() {
        explosionMstimer++;
    }

    public static void setHighScore(int highScore) {
        ControllerData.highScore = highScore;
    }

    public static void setExceedColumn(boolean exceedColumn) {
        ControllerData.exceedColumn = exceedColumn;
    }

    public static boolean isExceedColumn() {
        return exceedColumn;
    }

    public static void setxSpeed(int xSpeed) {
        ControllerData.xSpeed = xSpeed;
    }

    public static int getxSpeed() {
        return xSpeed;
    }

    public static void setySpeed(int ySpeed) {
        ControllerData.ySpeed = ySpeed;
    }

    public static int getySpeed() {
        return ySpeed;
    }

    public static void setPaused(boolean paused) {
        ControllerData.paused = paused;
    }

    public static boolean isPaused() {
        return paused;
    }

    public static void setxSpeedRecovery(int xSpeedRecovery) {
        ControllerData.xSpeedRecovery = xSpeedRecovery;
    }

    public static int getxSpeedRecovery() {
        return xSpeedRecovery;
    }

    public static void setySpeedRecovery(int ySpeedRecovery) {
        ControllerData.ySpeedRecovery = ySpeedRecovery;
    }

    public static int getySpeedRecovery() {
        return ySpeedRecovery;
    }

    public static void setBeamCollision(boolean beamCollision) {
        ControllerData.beamCollision = beamCollision;
    }

    public static boolean isBeamCollision() {
        return beamCollision;
    }

    public static void setCoinPath(String coinPath) {
        ControllerData.coinPath = coinPath;
    }

    public static String getCoinPath() {
        return coinPath;
    }

    public static void setCoinMstimer(int value) {
        coinMstimer = value;
    }

    public static int getCoinMstimer() {
        return coinMstimer;
    }

    public static void incrementCoinMstimer() {
        coinMstimer++;
    }
}
