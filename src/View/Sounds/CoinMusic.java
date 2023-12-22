package View.Sounds;

import View.Sound;

public class CoinMusic {

    private static final Sound sound = new Sound();

    public static void play()
    {
        sound.setFile("/Resources/Sounds/Music/super.wav");
        sound.play();
    }

    public static void stop()
    {
        sound.stop();
    }
}

