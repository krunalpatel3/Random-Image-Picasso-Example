package krunal.com.example.picassoapp;

import java.util.Random;

class Utility {

     static String getWebUrl(){

        String WebUrl = "https://picsum.photos/300/300?image=";

        // minimum value.
        int min = 1;

        // create random object
        Random randomno = new Random();

        // get random number from 1 to 1000.
        int getResult = min + randomno.nextInt(1000);

        return WebUrl + String.valueOf(getResult);

    }

}
