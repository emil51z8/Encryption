public class Viginiere {

    private String key;
    private int keySpot;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public Viginiere(String key) {
        this.key = key;
    }
    public Viginiere(){

    }
    public  String encrypt (String input)
    {
        String result = "";
        for (int i= 0; i < input.length(); i++)
        {
            if(keySpot >= key.length())
            {
                keySpot = 0;
            }
            int offset = key.charAt(keySpot);
            int tal = input.charAt(i);
            char letter = (char)(tal+offset);
            result +=letter;
            keySpot++;
        }
        keySpot =0;
        return result;
    }
    public String decrypt (String input)
    {
        int resetKey = 0;
        String result = "";
        for (int i= 0; i < input.length(); i++)
        {
            if(keySpot >= key.length())
            {
                keySpot = 0;
            }
            int offset = key.charAt(keySpot);
            int tal = input.charAt(i);
            char letter = (char)(tal-offset);
            result +=letter;
            keySpot++;
        }
        keySpot =0;
        return result;
    }

}