package com.ll.crypt;

/*
 Author: Elizabeth Fiator
 Version: April 10, 2016
 Modifications:
 Version: April 16, 2016
 Modified to take an input string from the user
 Description and Background: The purpose of this class is to encrypt and decrypt a
 text using an Affine Cipher. An Affine Cipher uses the equation c=ap-b(mod 26)
 to encrypt a plaintext. a takes a numerical value that is not a factor or multiple of
 26. c is the numerical value of the ciphered text while p is the numerical value
 of the plaintext.
 The function used in decrypting is p=((inverse of a (mod 26)*(c-b))(mod 26)
*/
public class AffineCipher
{

    //Encrypts the string and takes an input of plain text
    public static String encrypt(int a, int b, String ptxt)
    {
        //The encrypted or ciphered text will be stored in this string
        String ctxt = "";
        //Finds the numerical equivalence of a character using the inverse equation.
        for(int i=0;i<ptxt.length();i++)
        {
            ctxt = ctxt+(char) ((((a*ptxt.charAt(i))+b)%26)+65);
        }
        return ctxt;//returns the encrypted text
    }

    /*
    This method decrypts an encrypted text.
    It finds the inverse mod of a and uses it to
    find the correct numerical value of the plaintext
    The parameter is the ciphered text
    */
    public static String decrypt(int a, int b, String ctxt)
    {
        String ptxt = "";
        int inv_a =0;
        int x =0;
        //finds the inverse mod of a
        if(a !=0 && a!=13 && a!=26 && b!=0 && b!=26)
        {
            for (int i = 0; i < 26; i++) {
                x = (a * i) % 26;
                if (x == 1) {
                    inv_a = i;
                    System.out.println("the inverse of a is " + i);
                }
            }
            //Uses the inverse of a to compute the correct numerical equivalence
            //of the plaintext
            for (int i = 0; i < ctxt.length(); i++) {
                ptxt = ptxt + (char) (((inv_a * ((ctxt.charAt(i) - b)) % 26)) + 65);
            }
        }
        return ptxt;//returns the decrypted text
    }

}