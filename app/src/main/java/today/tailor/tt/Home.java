package today.tailor.tt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import static today.tailor.tt.Tab1Fragment.getData;

public class Home extends AppCompatActivity {

    private RecyclerView ProductList;
    private ViewAdapter adapter;
    private LinearLayout AddOwnDesign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_home);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.widthPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.8));

        init();

    }

    public void init()
    {
        ProductList = (RecyclerView) findViewById(R.id.product_list);
        AddOwnDesign = (LinearLayout) findViewById(R.id.addOwnDesign);


        AddOwnDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainTab.class);
                startActivity(intent);
            }
        });




        adapter = new ViewAdapter(this, getData());
        ProductList.setAdapter(adapter);
        ProductList.setLayoutManager(new LinearLayoutManager(this));
        ProductList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));



    }


    /*public static List<fullProduct> getData()
    {
        List<fullProduct> Products = new ArrayList<>();
        int[] sleevesL = {R.drawable.shirt1, R.drawable.shirt4, R.drawable.shirt7};
        int[] bodys = {R.drawable.shirt3, R.drawable.shirt6, R.drawable.shirt9};
        int[] sleevesR = {R.drawable.shirt2, R.drawable.shirt5, R.drawable.shirt8};
        String[] tittles = {"Model-1", "Model-2"};
        int x = 0;
        int i = 0;
        int j = 0;
        return Products;
    }*/
}
