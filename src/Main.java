import Controller.TimeController;
import Controller.UIController;
import View.MainFrame;

public class Main {
    public static void main(String[] args) {
        TimeController timeController = new TimeController();
        timeController.start();
        UIController.start();
    }
}
