public class Caesar {
    public  String decrypt (int offset, String input)
    {
        String result ="";
        for ( int i = 0; i < input.length(); i++)
        {
            int tal = input.charAt(i);
            char letter = (char)(tal-offset);
            result +=letter;
        }
        return result;
    }
    public String encrypt (int offset, String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            int tal = input.charAt(i);
            char letter = (char)(tal + offset);
            result +=letter;
        }
        return result;
    }

}

