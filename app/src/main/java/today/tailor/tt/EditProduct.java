package today.tailor.tt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static today.tailor.tt.Selection.PartsId;
import static today.tailor.tt.SplashScreen.SERVER_ADDRESS;

public class EditProduct extends AppCompatActivity {


    private static final String TAG = "EditProduct";

    private RecyclerView ButtonList;
    private ButtonViewAdapter bAdapter;


    private ImageView C0;
    public ImageView C1;
    public ImageView C2;
    public ImageView C3;
    public ImageView C4;
    public ImageView C5;
    public ImageView C6;
    public ImageView C7;
    public ImageView C8;
    public ImageView C9;
    public ImageView C10;
    public ImageView C11;
    public ImageView C12;
    public ImageView C13;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_edit_product);
        init();
    }


    public void init()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.textlogo);

        ButtonList = (RecyclerView) findViewById(R.id.Button_list);



        //setting adapter for button of parts of shirt
        //getting data of the list and setting the adapter here

        bAdapter = new ButtonViewAdapter(this, getData());
        ButtonList.setAdapter(bAdapter);
        ButtonList.setLayoutManager(new LinearLayoutManager(this));
        ButtonList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));



        C0 = (ImageView) findViewById(R.id.r0);
        C1 = (ImageView) findViewById(R.id.r1);
        C2 = (ImageView) findViewById(R.id.r2);
        C3 = (ImageView) findViewById(R.id.r3);
        C4 = (ImageView) findViewById(R.id.r4);
        C5 = (ImageView) findViewById(R.id.r5);
        C6 = (ImageView) findViewById(R.id.r6);
        C7 = (ImageView) findViewById(R.id.r7);
        C8 = (ImageView) findViewById(R.id.r8);
        C9 = (ImageView) findViewById(R.id.r9);
        C10 = (ImageView) findViewById(R.id.r10);
        C11 = (ImageView) findViewById(R.id.r11);
        C12 = (ImageView) findViewById(R.id.r12);
        C13 = (ImageView) findViewById(R.id.r13);




        Selection.temp0.clear();
        Selection.temp0 = LoadData("Back_Shoulder");

        Selection.temp1.clear();
        Selection.temp1 = LoadData("Sleeve_Left");

        Selection.temp2.clear();
        Selection.temp2 = LoadData("Sleeve_Right");

        Selection.temp3.clear();
        Selection.temp3 = LoadData("Body_Front_Left");

        Selection.temp4.clear();
        Selection.temp4 = LoadData("Body_Front_Right");

        Selection.temp5.clear();
        Selection.temp5 = LoadData("Collar");

        Selection.temp6.clear();
        Selection.temp6 = LoadData("Pocket_Left");

        Selection.temp7.clear();
        Selection.temp7 = LoadData("Pocket_Left_Hood");

        Selection.temp8.clear();
        Selection.temp8 = LoadData("Pocket_Right");

        Selection.temp9.clear();
        Selection.temp9 = LoadData("Pocket_Right_Hood");

        Selection.temp10.clear();
        Selection.temp10 = LoadData("Placket");

        Selection.temp11.clear();
        Selection.temp11 = LoadData("Buttons");

        Selection.temp12.clear();
        Selection.temp12 = LoadData("Cuff_Left");

        Selection.temp13.clear();
        Selection.temp13 = LoadData("Cuff_Right");



        String ProductItemId = ViewAdapter.itemID;
        List<String>PartsId = new ArrayList<>();


        for(int i = 0; i < ProductItemId.length(); i++)
        {
            String temp = "";
            temp += ProductItemId.charAt(i);
            temp += ProductItemId.charAt(i+1);
            temp += ProductItemId.charAt(i+2);
            temp += ProductItemId.charAt(i+3);
            PartsId.add(temp);
            i += 3;
            temp = "";
        }

        //Toast.makeText(getBaseContext(), PartsId.get(0), Toast.LENGTH_SHORT).show();
        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Back_Shoulder/" + PartsId.get(0) + ".JPG").into(C0);
        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Sleeve_Left/" + PartsId.get(1) + ".JPG").into(C1);
        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Sleeve_Right/" + PartsId.get(2) + ".JPG").into(C2);
        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Body_Front_Left/" + PartsId.get(3) + ".JPG").into(C3);
        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Body_Front_Right/" + PartsId.get(4) + ".JPG").into(C4);
        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Collar/" + PartsId.get(5) + ".JPG").into(C5);
        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Pocket_Left/" + PartsId.get(6) + ".JPG").into(C6);
        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Pocket_Left_Hood/" + PartsId.get(7) + ".JPG").into(C7);
        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Pocket_Right/" + PartsId.get(8) + ".JPG").into(C8);
        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Pocket_Right_Hood/" + PartsId.get(9) + ".JPG").into(C9);
        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Placket/" + PartsId.get(10) + ".JPG").into(C10);
        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Buttons/" + PartsId.get(11) + ".JPG").into(C11);
        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Cuff_Left/" + PartsId.get(12) + ".JPG").into(C12);
        Picasso.with(getApplicationContext()).load(SERVER_ADDRESS + "Cuff_Right/" + PartsId.get(13) + ".JPG").into(C13);


        /*C0.setImageResource(Tab1Fragment.Layer0[Integer.parseInt(PartsId.get(0))]);
        C1.setImageResource(Tab1Fragment.Layer1[Integer.parseInt(PartsId.get(1))]);
        C2.setImageResource(Tab1Fragment.Layer2[Integer.parseInt(PartsId.get(2))]);
        C3.setImageResource(Tab1Fragment.Layer3[Integer.parseInt(PartsId.get(3))]);
        C4.setImageResource(Tab1Fragment.Layer4[Integer.parseInt(PartsId.get(4))]);
        C5.setImageResource(Tab1Fragment.Layer5[Integer.parseInt(PartsId.get(5))]);
        C6.setImageResource(Tab1Fragment.Layer6[Integer.parseInt(PartsId.get(6))]);
        C7.setImageResource(Tab1Fragment.Layer7[Integer.parseInt(PartsId.get(7))]);
        C8.setImageResource(Tab1Fragment.Layer8[Integer.parseInt(PartsId.get(8))]);
        C9.setImageResource(Tab1Fragment.Layer9[Integer.parseInt(PartsId.get(9))]);
        C10.setImageResource(Tab1Fragment.Layer10[Integer.parseInt(PartsId.get(10))]);
        C11.setImageResource(Tab1Fragment.Layer11[Integer.parseInt(PartsId.get(11))]);
        C12.setImageResource(Tab1Fragment.Layer12[Integer.parseInt(PartsId.get(12))]);
        C13.setImageResource(Tab1Fragment.Layer13[Integer.parseInt(PartsId.get(13))]);*/

    }





    public static List<PartsList> getData()
    {
        List<PartsList> PartsButton = new ArrayList<>();

        PartsButton.add(new PartsList("Back Shoulder"));
        PartsButton.add(new PartsList("Sleeve Left"));
        PartsButton.add(new PartsList("Sleeve Right"));
        PartsButton.add(new PartsList("Body Front Left"));
        PartsButton.add(new PartsList("Body Front Right"));
        PartsButton.add(new PartsList("Collar"));
        PartsButton.add(new PartsList("Pocket Left"));
        PartsButton.add(new PartsList("Pocket Left Hood"));
        PartsButton.add(new PartsList("Pocket Right"));
        PartsButton.add(new PartsList("Pocket Right Hood"));
        PartsButton.add(new PartsList("Placket"));
        PartsButton.add(new PartsList("Buttons"));
        PartsButton.add(new PartsList("Cuff Left"));
        PartsButton.add(new PartsList("Cuff Right"));


        return PartsButton;
    }



    public ArrayList<ProductDetails> LoadData(final String TableName)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_LOAD_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(SplashScreen.this, response, Toast.LENGTH_SHORT).show();
                        try {
                            //JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = new JSONArray(response);
                            PartsId.clear();
                            for(int i = 0; i < jsonArray.length(); i++)
                            {
                                ProductDetails productDetails = new ProductDetails();
                                JSONObject jObj = jsonArray.getJSONObject(i);
                                productDetails.ID = jObj.getString("ID");
                                productDetails.Availability = jObj.getString("Availability");
                                productDetails.Price = jObj.getString("Price");
                                PartsId.add(productDetails); //storing the informations about individual parts...............
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Table", TableName);
                return params;
            }
        };


        RequestHandler.getInstance(EditProduct.this).addToRequestQueue(stringRequest);

        return PartsId;

    }
}
