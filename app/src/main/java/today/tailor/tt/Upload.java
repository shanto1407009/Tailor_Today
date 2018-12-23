package today.tailor.tt;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kaopiz.kprogresshud.KProgressHUD;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Upload extends AppCompatActivity {

    private static int RESULT_LOAD_IMAGE = 1;
    private static final String SERVER_ADDRESS = "https://tailortodaycf.000webhostapp.com/";
    private Button UploadButton;
    private Button ChooseImage;
    private EditText UploadImageName;
    private EditText UploadImagePrice;
    private EditText NoOfParts;
    private ImageView ImageToUpload;
    private Button loadButton;
    private EditText loadImageName;
    private ImageView ImageToload;
    private Spinner ItemType;
    private String PartType = "";
    private ProgressDialog progressDialog;
    private String RealID = "";

    private String[] ItemTypeList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);



        UploadButton = (Button) findViewById(R.id.uploadButton);
        ChooseImage =(Button) findViewById(R.id.chooseButton);
        UploadImageName = (EditText) findViewById(R.id.uploadImageName);
        UploadImagePrice = (EditText) findViewById(R.id.uploadImagePrice);
        ImageToUpload = (ImageView) findViewById(R.id.imageToUpload);
        ItemType = (Spinner) findViewById(R.id.itemType);
        NoOfParts = (EditText) findViewById(R.id.noOfParts);

        progressDialog = new ProgressDialog(this);

        loadButton = (Button) findViewById(R.id.loadButton);
        loadImageName = (EditText) findViewById(R.id.loadImageName);
        ImageToload = (ImageView) findViewById(R.id.imageToload);


        UploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RealID = "";

                int num = Integer.parseInt(NoOfParts.getText().toString().trim());
                for(int i = 0; i < num; i++)
                {
                    RealID += UploadImageName.getText().toString().trim();
                }


                if(RealID.length() < 4) {
                    Toast.makeText(getBaseContext(), "ID is incorrect or no OF Parts", Toast.LENGTH_SHORT).show();
                }
                else {
                    Bitmap image = ((BitmapDrawable) ImageToUpload.getDrawable()).getBitmap();
                    InsertFullProduct();
                    new UploadImage(image, RealID, PartType).execute();
                }
            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadImage(loadImageName.getText().toString()).execute();
            }
        });



        ChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
            }
        });


        this.ItemTypeList = new String[]
                {
                        "Full_Product", "Back_Shoulder", "Sleeve_Left", "Sleeve_Right", "Body_Front_Left", "Body_Front_Right", "Collar", "Pocket_Left", "Pocket_Left_Hood", "Pocket_Right", "Pocket_Right_Hood", "Placket", "Buttons", "Cuff_Left", "Cuff_Right"
                };
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ItemTypeList);
        ItemType.setAdapter(adapter1);
        ItemType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(QuestionBasic.this, parent.getItemAtPosition(position)+" selected", Toast.LENGTH_SHORT).show();
                //QuestionBasic.Scattagory = parent.getItemAtPosition(position).toString();
                PartType = parent.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(), PartType, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }

    private void InsertFullProduct()
    {
        final String ID = RealID;
        final String Price = UploadImagePrice.getText().toString();
        final String Availability = "1";


        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_INSERT_FULL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(Upload.this, response, Toast.LENGTH_SHORT).show();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(Upload.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            //Toast.makeText(Upload.this,"message", Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Table", PartType);
                params.put("ID", ID);
                params.put("Availability", Availability);
                params.put("Price", Price);
                return params;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null)
        {
            Uri selectedImage = data.getData();
            ImageToUpload.setImageURI(selectedImage);
        }
    }

    private class UploadImage extends AsyncTask<Void, Void, Void> {

        final KProgressHUD hud = KProgressHUD.create(Upload.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Uploading...")
                .setDetailsLabel("Please Wait...")
                .setCancellable(false)
                .setAnimationSpeed(3)
                .setDimAmount(0.7f)
                .show();

        Bitmap image;
        String name;
        String folder;

        public UploadImage(Bitmap image, String name, String folder)
        {
            this.image = image;
            this.name = name;
            this.folder = folder;
        }

        @Override
        protected Void doInBackground(Void... params) {
            for(int i = 0; i < 1; i++) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if(i == 0) {
                    image.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                }
                else
                {
                    image.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
                }
                String encodeImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);

                ArrayList<NameValuePair> dataToSend = new ArrayList<>();
                dataToSend.add(new BasicNameValuePair("image", encodeImage));
                if(i == 0) {
                    dataToSend.add(new BasicNameValuePair("name", name));
                }
                else
                {
                    dataToSend.add(new BasicNameValuePair("name", name+"-1"));
                }
                dataToSend.add(new BasicNameValuePair("folder", folder));

                HttpParams httpRequestParams = getHttpRequestParams();
                HttpClient client = new DefaultHttpClient(httpRequestParams);
                HttpPost post = new HttpPost(SERVER_ADDRESS + "SavePicture.php");

                try {
                    post.setEntity(new UrlEncodedFormEntity(dataToSend));
                    client.execute(post);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //progressDialog.cancel();


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            hud.dismiss();
            Toast.makeText(getBaseContext(), "Upload Successful", Toast.LENGTH_SHORT).show();
        }
    }


    private class DownloadImage extends AsyncTask<Void, Void, Bitmap>
    {
        String name;
        private DownloadImage(String name)
        {
            this.name = name;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            String url = SERVER_ADDRESS + PartType + "/" + name + ".PNG";
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
                ImageToload.setImageBitmap(bitmap);
                Toast.makeText(getBaseContext(), "Downloaded Successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private HttpParams getHttpRequestParams()
    {
        HttpParams httpRequestParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpRequestParams, 1000 * 30);
        HttpConnectionParams.setSoTimeout(httpRequestParams, 1000*30);
        return httpRequestParams;
    }
}
