package james.peck.myrpg;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SaveLoadPlayer {

    Context context;
    Creature target;

    public SaveLoadPlayer(Creature target, Context context)
    {
        this.target = target;
        this.context = context;
    }

    public SaveLoadPlayer(Context context)
    {
        this.context = context;
    }

    public void playerSave()
    {
        File file = new File(context.getFilesDir(), "Player");
        try {
            FileOutputStream outputStream = context.openFileOutput("Player", Context.MODE_PRIVATE);

            ObjectOutputStream objectOutStream = new ObjectOutputStream(outputStream);
            objectOutStream.writeObject(target);
            objectOutStream.close();
        }catch (Exception e)
        {

        }

    }

    public Creature playerLoad()
    {
        try {
            FileInputStream inputStream = context.openFileInput("Player");
            ObjectInputStream objectInStream = new ObjectInputStream(inputStream);
           Creature player = (Creature)objectInStream.readObject();
            objectInStream.close();
            return player;

        }catch ( Exception e)
        {

        }
        return null;
    }
}

