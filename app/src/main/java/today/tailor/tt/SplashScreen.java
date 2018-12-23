package today.tailor.tt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SplashScreen extends AppCompatActivity {

    public static final String SERVER_ADDRESS = "https://tailortodaycf.000webhostapp.com/";

    private ImageView Logo;
    private TextView Text1, Text2, Text3, Loading;
    public static ArrayList<ProductDetails> ProductID = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ProductID.clear();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        init();
    }


    public void init()
    {

        Logo = (ImageView) findViewById(R.id.startLogo);
        Text1 = (TextView) findViewById(R.id.text1);
        Text2 = (TextView) findViewById(R.id.text2);
        Text3 = (TextView) findViewById(R.id.text3);
        Loading = (TextView) findViewById(R.id.loading);


        //Logo.setTranslationX(1000);
        Text1.setTranslationX(1000);
        Text2.setTranslationX(1000);
        Text3.setTranslationX(1000);
        Loading.setTranslationX(1000);



        LoadData();

        /*for(int i = 0; i < ProductID.size(); i++)
        {
            Toast.makeText(getApplicationContext(), "Calling", Toast.LENGTH_SHORT).show();
            new DownloadImage(ProductID.get(i).toString()).execute();
        }*/




        Thread myThread = new Thread() {
            @Override
            public void run() {
                try {
                    Logo.animate().translationX(0);
                    sleep(1000);
                    Loading.setTranslationX(0);
                    sleep(200);
                    Text1.animate().translationX(0);
                    sleep(200);
                    Text1.animate().translationY(200);
                    sleep(300);
                    Text2.animate().translationX(0);
                    sleep(200);
                    Text2.animate().translationY(200);
                    sleep(300);
                    Text3.animate().translationX(0);
                    sleep(200);
                    Text3.animate().translationY(200);
                    sleep(4000);
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };


        myThread.start();

    }









    //getting data from backend
    //storing them for further use...................:)







    public void LoadData()
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
                            for(int i = 0; i < jsonArray.length(); i++)
                            {
                                ProductDetails productDetails = new ProductDetails();
                                JSONObject jObj = jsonArray.getJSONObject(i);
                                //Toast.makeText(getApplicationContext(), jObj.getString("ID"), Toast.LENGTH_SHORT).show();
                                productDetails.ID = jObj.getString("ID");
                                productDetails.Availability = jObj.getString("Availability");
                                productDetails.Price = jObj.getString("Price");
                                ProductID.add(productDetails);
                                //new DownloadImage(jObj.getString("ID").toString()).execute();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            //Toast.makeText(Upload.this,"message", Toast.LENGTH_SHORT).show();
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
                params.put("Table", "Full_Product");
                return params;
            }
        };


        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);

    }



    //Loading the image Bitmap here
    //Going to set them in the recyclerView of the next page
    //attemp to make the app little fast :D

    /*private class DownloadImage extends AsyncTask<Void, Void, Bitmap>
    {
        String name;
        private DownloadImage(String name)
        {
            this.name = name;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            String url = SERVER_ADDRESS + "Full_Product" + "/" + name + ".JPG";
            //Toast.makeText(getBaseContext(), url, Toast.LENGTH_SHORT).show();
            try
            {
                URLConnection connection = new URL(url).openConnection();
                connection.setConnectTimeout(1000*30);
                connection.setReadTimeout(1000*30);
                return BitmapFactory.decodeStream((InputStream) connection.getContent(), null, null);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(bitmap != null)
            {
                //ImageToload.setImgeBitmap(bitmap);
                Toast.makeText(getBaseContext(), "Downloaded Successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }*/

   /* private HttpParams getHttpRequestParams()
    {
        HttpParams httpRequestParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpRequestParams, 1000 * 30);
        HttpConnectionParams.setSoTimeout(httpRequestParams, 1000*30);
        return httpRequestParams;
    }*/
}
