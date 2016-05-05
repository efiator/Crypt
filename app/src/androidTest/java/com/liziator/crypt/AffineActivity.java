package com.liziator.crypt;

/**
 * Created by Liz on 5/5/16.
 */
import android.view.View;
import android.content.Intent;

public class AffineActivity {
    public void decrypt(View view) {
        Intent intent = new Intent(this, AffineCipher.class);
    }
}
