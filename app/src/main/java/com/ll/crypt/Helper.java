package com.ll.crypt;

/**
 * Created by Liz on 6/5/16.
 */
public class Helper
{

    //Returns a permutation of length 8 of a given input of length 8
    public int [] ip(int [] input)
    {
        int [] ip = {2,6,3,1,4,8,5,7};
        int [] output = new int[input.length];
        for(int i=0; i<input.length; i++)
        {
            output[i]=input[ip[i]-1];
        }
        return output;
    }

    //Returns a permutation of length 10 of a given input of length 10
    public int [] p10(int [] key)
    {
        int [] p10 ={3,5,2,7,4,10,1,9,8,6};
        int [] output = new int[key.length];
        for(int i=0; i<key.length; i++)
        {
            output[i]=key[p10[i]-1];
        }
        return output;
    }

    //Shifts an input to the left by 1
    public int [] shift(int [] key)
    {
        int shiftKey[] = new int [key.length];
        int temp = key[0];
        int j=1;
        for(int i=0;i<key.length-1;i++)
        {
            shiftKey[i]=key[j];
            j++;
        }
        shiftKey[key.length-1]=temp;

        return shiftKey;
    }

    //Returns a permutation of length 8 of a given input of length 10
    public int [] p8(int [] input)
    {
        int [] p8={6,3,7,4,8,5,10,9};
        int [] output = new int[p8.length];
        for(int i=0; i<p8.length;i++)
        {
            output[i]=input[p8[i]-1];
        }
        return output;
    }

    //Implements the exclusive or function
    public int [] xor(int [] a, int [] b)
    {
        int [] c=new int[a.length];
        for(int i=0; i<c.length;i++)
        {
            if(a[i]==b[i])
            {
                c[i]=0;
            }
            else
            {
                c[i]=1;
            }
        }
        return c;
    }

    //Returns an inverse permutation of an input
    public int [] ipInv(int [] input)
    {
        int [] ipinv={4,1,3,5,7,2,8,6};
        int [] output = new int[ipinv.length];
        for(int i=0; i<ipinv.length;i++)
        {
            output[i]=input[ipinv[i]-1];
        }
        return output;
    }

    //Expands an input of length 4 to an output of length 8
    public int [] ep(int [] input)
    {
        int ep[] ={4,1,2,3,2,3,4,1};
        int[] output=new int[ep.length];
        for(int i=0; i<ep.length;i++)
        {
            output[i]=input[ep[i]-1];
        }
        return output;
    }

    //Implements the s-boxes
    public int [] sbox(int [] input, int [] key)
    {
        int p4 []={2,4,3,1};
        int perm [] = new int [8];
        int top [] = new int [4];
        int bottom [] = new int [4];
        int [] output = new int [4];
        int tempTop []= new int[2];
        int tempBot [] = new int [2];
        int [] outputTemp = new int [4];
        int rowval =0;
        int temp1=0;
        int temp2=0;

        //finds the permuation of the input and the key
        perm=this.xor(input, key);
        //stores the first four values of the permutation
        for(int i=0; i<4;i++)
        {
            top[i]=perm[i];
        }
        //stores the last four values of the permutation
        int k=0;
        for(int i=4; i<8;i++)
        {
            bottom[k]=perm[i];
            k++;
        }

        //implements the s-boxes for the first four digits of the permutation
        rowval=this.row(top);//gets the value of the row

        int [] s1row0={1,0,3,2};
        int [] s1row1={3,2,1,0};
        int [] s1row2={0,2,1,3};
        int [] s1row3={3,1,3,2};
        //checks to see which row to check, gets the column number and converts the
        //number at that location to a binary number
        for(int i=0; i<top.length;i++)
        {
            if(rowval==0)
            {
                temp1=this.col(top);
                temp2=s1row0[temp1];
                tempTop=toBin(temp2);

            }
            else if(rowval==1)
            {
                temp1=this.col(top);
                temp2=s1row1[temp1];
                tempTop=toBin(temp2);
            }
            else if(rowval==2)
            {
                temp1=this.col(top);
                temp2=s1row2[temp1];
                tempTop=toBin(temp2);
            }
            else if(rowval==3)
            {
                temp1=this.col(top);
                temp2=s1row3[temp1];
                tempTop=toBin(temp2);
            }

        }

        //implements the s-boxes for the last four digits of the permutation

        int [] s2row0={0,1,2,3};
        int [] s2row1={2,0,1,3};
        int [] s2row2={3,0,1,0};
        int [] s2row3={2,1,0,3};
        rowval=this.row(bottom);

        //checks to see which row to check, gets the column number and converts the
        //number at that location to a binary number
        for(int i=0; i<bottom.length;i++)
        {
            if(rowval==0)
            {
                temp1=this.col(bottom);
                temp2=s2row0[temp1];
                tempBot=toBin(temp2);

            }
            else if(rowval==1)
            {
                temp1=this.col(bottom);
                temp2=s2row1[temp1];
                tempBot=toBin(temp2);

            }
            else if(rowval==2)
            {
                temp1=this.col(bottom);
                temp2=s2row2[temp1];
                tempBot=toBin(temp2);
            }
            else if(rowval==3)
            {
                temp1=this.col(bottom);
                temp2=s2row3[temp1];
                tempBot=toBin(temp2);
            }

        }
        //stores the returned two bits from the s-boxes in temporary arrays
        for(int i=0; i<2;i++)
        {
            outputTemp[i]=tempTop[i];
        }
        int j=0;
        for(int i=2;i<4;i++)
        {
            outputTemp[i]=tempBot[j];
            j++;
        }
        //finds the p4 permutation of the temp array and stores them
        //in an array to be returned
        for(int i=0;i<p4.length;i++)
        {
            output[i]=outputTemp[p4[i]-1];
        }
        return output;
    }

    //Impplements and returns the fk aspect of s-des
    public int [] fk(int [] input, int [] key)
    {
        int outputF[]=new int [4];
        int output [] = new int [8];
        int [] l = new int[4];
        int [] r= new int [4];
        for(int i=0; i<4;i++)
        {
            l[i]=input[i];
        }

        int j=0;
        for(int i=4; i<8;i++)
        {
            r[j]=input[i];
            j++;
        }
        int[] rperm = new int [8];
        rperm=this.ep(r);
        int outputR [] = new int[4];
        outputR=this.sbox(rperm, key);
        outputF=this.xor(l, outputF);
        for(int i=0; i<4;i++)
        {
            output[i]=outputF[i];
        }
        int k=0;
        for(int i=4; i<8;i++)
        {
            output[i]=r[k];
            k++;
        }
        return output;
    }

    //Returns an array whose first 4 values have been switched with the last four values
    public int [] sw(int [] input)
    {
        int [] l = new int[4];
        int [] r= new int [4];
        int [] output= new int[8];
        for(int i=0; i<4;i++)
        {
            l[i]=input[i];
        }

        int j=0;
        for(int i=4; i<8;i++)
        {
            r[j]=input[i];
            j++;
        }
        for(int i=0; i<4;i++)
        {
            output[i]=r[i];
        }
        int y=0;
        for(int i=4;i<8;i++)
        {
            output[i]=l[y];
            y++;
        }
        return output;
    }
    //Returns an int by adding the first and last value in an array
    public int row(int [] k)
    {
        int row =0;
        int first = Integer.parseInt(String.valueOf(k[0]),2);
        int last = Integer.parseInt(String.valueOf(k[3]),2);
        row= first+last;
        return row;
    }
    //Returns an int by adding the second and third value in an array
    public int col(int [] A)
    {
        int i;
        int colval;

        String temp = String.valueOf(A[1]);
        for(i = 2; i < A.length-1; i++)
        {
            temp = temp + String.valueOf(A[i]);
        }
        colval= Integer.parseInt(temp, 2);
        return colval;
    }
    //Converts an integer to a binary number and stores it into an array
    public int[] toBin(int i)
    {
        int [] temp = new int [2];
        String k = Integer.toBinaryString(i);
        for(int j=0; j<k.length();j++)
        {
            temp[j]=Character.getNumericValue(k.charAt(j));
        }
        return temp;
    }


}