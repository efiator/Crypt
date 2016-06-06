package com.ll.crypt;

/**
 * Created by Liz on 6/5/16.
 */
public class Sdes
{
    Helper help = new Helper();
    public int [] toInt(String txt)
    {
        int [] input = new int[txt.length()];
        for(int i=0; i<txt.length();i++)
        {
            input[i]=Character.getNumericValue(txt.charAt(i));
        }
        return input;
    }
    //Encrypts the input from the user by going through the proper
    //s-des rounds and calling the right helper methods.
    public int [] encrypt(String txt, String keystring)
    {
        int[] input = this.toInt(txt);
        int[] key = this.toInt(keystring);
        int [] p10=help.p10(key);
        int [] key1 = help.shift(p10);
        int [] p81= help.p8(key1);
        int [] ip=help.ip(input);
        int [] fk=help.fk(ip, p81);
        int [] sw=help.sw(fk);
        int [] key2=help.shift(key1);
        int [] p82=help.p8(key2);
        int [] fk2=help.fk(sw,key2);
        int [] output = help.ipInv(fk2);
        return output;


    }
    //Decrypts the input from the user by going through the proper
    //s-des rounds and calling the right helper methods.

    public int [] decrypt(String txt, String keystring)
    {
        int[] input = this.toInt(txt);
        int[] key = this.toInt(keystring);
        int [] p10=help.p10(key);
        int [] key1 = help.shift(p10);
        int [] key2=help.shift(key1);

        int [] p81= help.p8(key2);
        int [] ip=help.ip(input);

        int [] fk=help.fk(ip, p81);
        int [] sw=help.sw(fk);
        int [] p82=help.p8(key1);
        int [] fk2=help.fk(sw,p82);
        int [] output = help.ipInv(fk2);
        return output;


    }
}