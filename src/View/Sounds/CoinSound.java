package View.Sounds;

import View.Sound;

public class CoinSound {

    private static final Sound sound = new Sound();

    public static void play()
    {
        sound.setFile("/Resources/Sounds/coin.wav");
        sound.play();
    }

}

