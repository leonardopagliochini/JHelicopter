package View.Sounds;

import View.Sound;

public class RecordSound {

    private static final Sound sound = new Sound();

    public static void play()
    {
        sound.setFile("/Resources/Sounds/record.wav");
        sound.play();
    }
}
