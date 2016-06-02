package com.ll.crypt;/*
*Author: Elizabeth Fiator 
*Version: April 11, 2016
*Description and Background: The purpose of this project is 
*to generate a possible set of keys for an encrypted text with
*a shift cipher and use those keys to decrypt the text.
*The keys are generated based on the characters with the highest
*frequencies in the encrypted text and matching these possibilities
*with the characters that have the highest frequencies in the plain 
*text alphabets.
* 
*Modifications:
*Version: April 16, 2016
*Modification: Modified to use the set of generated keys to decrypt
*the encrypted text.
*Version: April 28, 2016
*Version: April 29, 2016
*/
import java.util.*;
//import javax.swing.JOptionPane;

public class Shift
{


    /*This method uses decrypts and encrypted text using the numerical value
        * of the key that was used to decrypt it.
     */
    public String decrypt(String ctxt, int k)
    {
        char c;
        String ptxt = "";
        String [] splitStr = ctxt.split(" "); //splits the decrypted text
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

    public String encrypt(String ptxt, int k)
    {
        char c;
        String ctxt = "";
        String [] splitStr = ptxt.split(" "); //splits the decrypted text
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


    }

