# Crypt
Elizabeth Fiator
Spring 2016
Cryptography Project

CRYPT: A Simple App For Three Different Ciphers for Encryption and Decryption
	The purpose of this app is to help a user encrypt or decrypt texts using either a shift cipher, an affine cipher or s-des. 

Shift Cipher: For encryption or decryption to successfully work, a user must enter the text to be encrypted/decrypted and the numerical key to be used. The text is encrypted by shifting the plaintext to the right n number of times assuming n is the key. An encrypted text can be decrypted by shifting the text to the left n number of times to recover the plaintext. 

Affine Cipher: This cipher uses two numerical values for a and b to encrypt or decrypt text. For successful encryption/decryption, the value for a cannot be a factor of 26. That means it cannot be 0, 26 or 13. The value for b can be anything from 1-25.   An Affine Cipher uses the equation c=ap-b(mod 26)
 to encrypt a plaintext, where c is the encrypted text and p is the plaintext. The function used in decrypting is p=((inverse of a (mod 26)*(c-b))(mod 26).

S-DES: S-DES is a much simpler version of DES. This crypto-system requires a binary string of length 8 as the input text and a binary string of length 10 as the key to be used. The text and key are used in multiple calculations of permutations that eventually generate the cipher-text or the plaintext. 

