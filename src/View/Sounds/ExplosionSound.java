package View.Sounds;

import View.Sound;

public class ExplosionSound {

    private static final Sound sound = new Sound();

    public static void play()
    {
        sound.setFile("/Resources/Sounds/explosion.wav");
        sound.play();
    }
}
