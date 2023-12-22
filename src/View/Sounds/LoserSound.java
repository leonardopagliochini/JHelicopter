package View.Sounds;

import View.Sound;

public class LoserSound {

    private static final Sound sound = new Sound();

    public static void play()
    {
        sound.setFile("/Resources/Sounds/gameOver.wav");
        sound.play();
    }
}
