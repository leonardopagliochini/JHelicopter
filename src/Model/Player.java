package Model;

import Utils.FileUtils;

public class Player {
    public String username;
    public int score;

    public void setScore(int score) {
        this.score = score;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void InsertPlayer(){
        Integer[] point = new Integer[5];
        for (int i = 0 ; i < 5; i++)
        {
            point[i] = Integer.parseInt(FileUtils.readSequences("Resources/punteggi.csv")[i][1]);
        }
        for (int i = 0 ; i < 5; i++)
            if (point[i] == 0)
            {
                insertAt(i);
                break;
            }
        int min = point[0];
        int minIndex = 0;
        for (int i = 1 ; i < 5 ; i++)
        {
            if (point[i] < min)
            {
                min = point[i];
                minIndex = i;
            }

        }
        if (this.score > min)
        {
            insertAt(minIndex);
        }

    }

    public void insertAt(int index)
    {
        String s = new String("");
        for (int i = 0 ; i < index ; i++)
        {
            s += FileUtils.readSequences("Resources/punteggi.csv")[i][0] + ";" +
                    FileUtils.readSequences("Resources/punteggi.csv")[i][1] + "\n";
        }
        s += username + ";" + score + "\n";
        for (int i = index+1; i < 5 ; i++)
        {
            s += FileUtils.readSequences("Resources/punteggi.csv")[i][0] + ";" +
                    FileUtils.readSequences("Resources/punteggi.csv")[i][1] + "\n";
        }
        FileUtils.writeFile("Resources/punteggi.csv",s);
    }
}
