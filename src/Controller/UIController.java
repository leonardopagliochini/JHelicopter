package Controller;

import View.*;

import Model.*;
import View.Sounds.GameMusic;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class UIController {

    private static final MainFrame mainFrame = new MainFrame();
    public static Start start = new Start();
    public static Scores scores = new Scores();
    public static Skins skins = new Skins();
    public static Player player = new Player();
    public static GameOver gameOver;
    public static HelicopterPanel helicopterPanel = new HelicopterPanel();
    public static Pause pause = new Pause();

    public static void start(){
        setPanel(mainFrame, null, start);
        ControllerData.setScore(0);
    }

    public static void scores(){
        scores = new Scores();
        setPanel(mainFrame, start,scores);
        scores.repaint();
    }

    public static void pause()
    {
        setPanel(mainFrame, helicopterPanel, pause);
    }

    public static void resume()
    {
        setPanel(mainFrame, pause, helicopterPanel);
        mainFrame.setState(Frame.ICONIFIED);
        mainFrame.setState(Frame.NORMAL);
    }

    public static void backFromPause(){
        setPanel(mainFrame, pause, start);
        GameController.closeGameFromPause();
    }

    public static void skins(){
        setPanel(mainFrame, start, skins);
    }

    public static void backFromScores(){
        setPanel(mainFrame, scores,start);
    }

    public static void backFromSkins(){
        setPanel(mainFrame, skins,start);
    }

    public static void helicopter(){
        if (Objects.equals(UIController.start.usernameTextField.getText(), "") || Objects.equals(UIController.start.usernameTextField.getText(), "Username")
            ||(Objects.equals(UIController.start.usernameTextField.getText(), " ")))
        {
            JOptionPane.showMessageDialog(mainFrame, "Insert a username", "Error", 2);
        }
        /*System.out.println(UIController.start.usernameTextField.getText());*/
        else {
            setPanel(mainFrame, start, helicopterPanel);
            GameMusic.play();
            mainFrame.setState(Frame.ICONIFIED);
            mainFrame.setState(Frame.NORMAL);
        }
    }

    public static void gameOver(){
        gameOver = new GameOver();
        setPanel(mainFrame, helicopterPanel,gameOver);
    }

    public static void backFromGameOver(){
        setPanel(mainFrame, gameOver,start);
    }

    public static void playAgain(){
        GameMusic.play();
        setPanel(mainFrame, gameOver, helicopterPanel);
        mainFrame.setState(Frame.ICONIFIED);
        mainFrame.setState(Frame.NORMAL);
    }

    private static void setPanel(JFrame frame, JPanel from , JPanel to) {
        if (from != null)
        {
            frame.remove(from);
            frame.add(to);
            frame.validate();
            frame.repaint();
        }
        else
        {
            frame.add(to);
            frame.validate();
            frame.repaint();
        }
    }
}
