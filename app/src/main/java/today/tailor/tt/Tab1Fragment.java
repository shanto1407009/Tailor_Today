package today.tailor.tt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaopiz.kprogresshud.KProgressHUD;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import static today.tailor.tt.SplashScreen.SERVER_ADDRESS;

/**
 * Created by Shanto on 1/29/2018.
 */

public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private RecyclerView ProductList;
    private ViewAdapter adapter;
    private static int i = 0;

    public static ArrayList<Bitmap> ProductImage = new ArrayList<>();

    //public static int[] LayerFull = {R.drawable.x1, R.drawable.x2, R.drawable.x3};
    public static int[] Layer0 = {R.drawable.a0, R.drawable.b0, R.drawable.c0};
    public static String[] PartID0 = {"0000", "0001", "0002"};
    public static int[] Layer1 = {R.drawable.a1, R.drawable.b1, R.drawable.c1};
    public static String[] PartID1 = {"0000", "0001", "0002"};
    public static int[] Layer2 = {R.drawable.a2, R.drawable.b2, R.drawable.c2};
    public static String[] PartID2 = {"0000", "0001", "0002"};
    public static int[] Layer3 = {R.drawable.a3, R.drawable.b3, R.drawable.c3};
    public static String[] PartID3 = {"0000", "0001", "0002"};
    public static int[] Layer4 = {R.drawable.a4, R.drawable.b4, R.drawable.c4};
    public static String[] PartID4 = {"0000", "0001", "0002"};
    public static int[] Layer5 = {R.drawable.a5, R.drawable.b5, R.drawable.c5};
    public static String[] PartID5 = {"0000", "0001", "0002"};
    public static int[] Layer6 = {R.drawable.a6, R.drawable.b6, R.drawable.c6};
    public static String[] PartID6 = {"0000", "0001", "0002"};
    public static int[] Layer7 = {R.drawable.a7, R.drawable.b7, R.drawable.c7};
    public static String[] PartID7 = {"0000", "0001", "0002"};
    public static int[] Layer8 = {R.drawable.a8, R.drawable.b8, R.drawable.c8};
    public static String[] PartID8 = {"0000", "0001", "0002"};
    public static int[] Layer9 = {R.drawable.a9, R.drawable.b9, R.drawable.c9};
    public static String[] PartID9 = {"0000", "0001", "0002"};
    public static int[] Layer10 = {R.drawable.a10, R.drawable.b10, R.drawable.c10};
    public static String[] PartID10 = {"0000", "0001", "0002"};
    public static int[] Layer11 = {R.drawable.a11, R.drawable.b11, R.drawable.c11};
    public static String[] PartID11 = {"0000", "0001", "0002"};
    public static int[] Layer12 = {R.drawable.a12, R.drawable.b12, R.drawable.c12};
    public static String[] PartID12 = {"0000", "0001", "0002"};
    public static int[] Layer13 = {R.drawable.a13, R.drawable.b13, R.drawable.c13};
    public static String[] PartID13 = {"0000", "0001", "0002"};
    public static int[] Favourites = {R.drawable.love, R.drawable.love2};
    public static String[] Prices = {"599"};
    public static String[] tittles = {"Model-1", "Model-2"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);


        ProductList = (RecyclerView) view.findViewById(R.id.product_list);
        init();

        return  view;
    }


    public void init()
    {

        final KProgressHUD hud = KProgressHUD.create(getActivity())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Loading...")
                .setDetailsLabel("Please Wait...")
                .setCancellable(false)
                .setAnimationSpeed(3)
                .setDimAmount(0.7f)
                .show();

        for(i = 0; i < SplashScreen.ProductID.size(); i++)
        {
            new DownloadImage(SplashScreen.ProductID.get(i).ID);
        }

        hud.dismiss();






        adapter = new ViewAdapter(getActivity(), getData());
        ProductList.setAdapter(adapter);
        ProductList.setLayoutManager(new LinearLayoutManager(getActivity()));
        ProductList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));



    }


    public static List<fullProduct> getData()
    {
        List<fullProduct> Products = new ArrayList<>();
        int x = 0;
        int j = 0;
        for(i = 0; i < SplashScreen.ProductID.size(); i++)
        {

            fullProduct current = new fullProduct();
            x++;
            current.L0 = i;
            current.Love = Favourites[1];
            current.Tittle = "Model-"+x;
            current.Price = SplashScreen.ProductID.get(i).Price;
            current.ID = SplashScreen.ProductID.get(i).ID;
            new DownloadImage(current.ID);
            Products.add(current);
        }
        fullProduct current = new fullProduct();
        current.L0= R.drawable.plus;
        current.Tittle = "My own design";
        Products.add(current);
        return Products;
    }




    private static class DownloadImage extends AsyncTask<Void, Void, Bitmap>
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
                ProductImage.set(i, bitmap);
                //Toast.makeText(getBaseContext(), "Downloaded Successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
