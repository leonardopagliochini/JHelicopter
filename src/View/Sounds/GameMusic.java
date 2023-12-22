package View.Sounds;

import View.Sound;

public class GameMusic {

    private static final Sound sound = new Sound();

    public static void play()
    {
        sound.setFile("/Resources/Sounds/Music/game.wav");
        sound.loop();
    }

    public static void stop()
    {
        sound.stop();
    }
}
