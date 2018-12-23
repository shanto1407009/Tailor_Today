package today.tailor.tt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import static today.tailor.tt.SplashScreen.SERVER_ADDRESS;
import static today.tailor.tt.ViewAdapter.itemID;

public class DisplayProduct extends AppCompatActivity {

    public static List<fullProduct> allProducts = Collections.emptyList();

    private ImageView B0;
    private ImageView B1;
    private ImageView B2;
    private ImageView B3;
    private ImageView B4;
    private ImageView B5;
    private ImageView B6;
    private ImageView B7;
    private ImageView B8;
    private ImageView B9;
    private ImageView B10;
    private ImageView B11;
    private ImageView B12;
    private ImageView B13;

    private Button EditOrder;
    private Button OrderDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Toast.makeText(getBaseContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();

        setContentView(R.layout.activity_display_product);

        init();

    }

    public void init()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.textlogo);


        B0 = (ImageView) findViewById(R.id.q0);
        B1 = (ImageView) findViewById(R.id.q1);
        B2 = (ImageView) findViewById(R.id.q2);
        B3 = (ImageView) findViewById(R.id.q3);
        B4 = (ImageView) findViewById(R.id.q4);
        B5 = (ImageView) findViewById(R.id.q5);
        B6 = (ImageView) findViewById(R.id.q6);
        B7 = (ImageView) findViewById(R.id.q7);
        B8 = (ImageView) findViewById(R.id.q8);
        B9 = (ImageView) findViewById(R.id.q9);
        B10 = (ImageView) findViewById(R.id.q10);
        B11 = (ImageView) findViewById(R.id.q11);
        B12 = (ImageView) findViewById(R.id.q12);
        B13 = (ImageView) findViewById(R.id.q13);

        EditOrder = (Button) findViewById(R.id.edit_order);
        OrderDisplay = (Button) findViewById(R.id.order_display);


        EditOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //action on clicking edit & order button
                //going to the next activity to edit
                Intent intent = new Intent(getBaseContext(), EditProduct.class);
                startActivity(intent);
            }
        });

        /*allProducts = Tab1Fragment.getData();
        fullProduct selectedProduct;

        for(int i = 0; i < allProducts.size(); i++)
        {
            if(allProducts.get(i).ID.equals(ViewAdapter.itemID))
            {
                selectedProduct = allProducts.get(i);
                //Toast.makeText(getBaseContext(), selectedProduct.Tittle, Toast.LENGTH_SHORT).show();
                B0.setImageResource(selectedProduct.L0);
                /*B1.setImageResource(selectedProduct.L1);
                B2.setImageResource(selectedProduct.L2);
                B3.setImageResource(selectedProduct.L3);
                B4.setImageResource(selectedProduct.L4);
                B5.setImageResource(selectedProduct.L5);
                B6.setImageResource(selectedProduct.L6);
                B7.setImageResource(selectedProduct.L7);
                B8.setImageResource(selectedProduct.L8);
                B9.setImageResource(selectedProduct.L9);
                B10.setImageResource(selectedProduct.L10);
                B11.setImageResource(selectedProduct.L11);
                B12.setImageResource(selectedProduct.L12);
                B13.setImageResource(selectedProduct.L13);
                //break;
            }
        }*/

        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Full_Product/" + itemID + ".JPG").into(B0);


    }
}
