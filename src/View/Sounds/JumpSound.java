package View.Sounds;

import View.Sound;

public class JumpSound {

    private static final Sound sound = new Sound();

    public static void play()
    {
        sound.setFile("/Resources/Sounds/jump.wav");
        sound.play();
    }

}
