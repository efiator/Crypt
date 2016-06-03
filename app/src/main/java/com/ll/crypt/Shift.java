package com.ll.crypt;/*
*Author: Elizabeth Fiator 
*Version: April 11, 2016
*Description and Background: This class has methods that are used for
* a shift cipher encryption and decryption.
*Modifications:
*Version: April 16, 2016
*Version: April 28, 2016
*Version: April 29, 2016
*/


public class Shift
{

    /*
     *This method encrypts plaintext using a key
     */
    public static String encrypt(String ptxt, int k)
    {
        char c;
        String ctxt = "";
        String [] splitStr = ptxt.split(" "); //splits the plaintext text
        for(int j=0; j<splitStr.length;j++)
        {
            String string = splitStr[j];
            ctxt=ctxt+" ";  //properly spaces out the text
            for(int i=0; i<string.length(); i++)
            {
                c=string.charAt(i);
                if(Character.isLetter(c))

                {
                    ctxt = ctxt+(char) (((string.charAt(i)+k)%26)+65);
                }
            }
        }
        return ctxt;
    }
    /*This method uses decrypts and encrypted text using the numerical value
        * of the key that was used to decrypt it.
     */
    public static String decrypt(String ctxt, int k)
    {
        char c;
        String ptxt = "";
        String [] splitStr = ctxt.split(" "); //splits the encrypted text
        for(int j=0; j<splitStr.length;j++)
        {
            String string = splitStr[j];
            ptxt=ptxt+" ";  //properly spaces out the text
            for(int i=0; i<string.length(); i++)
            {
                c=string.charAt(i);
                if(Character.isLetter(c))

                {
                    ptxt = ptxt+(char) (((string.charAt(i)-k)%26)+65);
                }
            }
        }
        return ptxt;
    }

    }

