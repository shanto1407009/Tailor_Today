package today.tailor.tt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class Selection extends AppCompatActivity {

    private static final String TAG = "Selection";

    private RecyclerView IndividualParts;
    private IndividualViewAdapter IAdapter;
    public static ArrayList<ProductDetails>PartsId = new ArrayList<>();
    public static ArrayList<ProductDetails> temp0 = new ArrayList<>();
    public static ArrayList<ProductDetails> temp1 = new ArrayList<>();
    public static ArrayList<ProductDetails> temp2 = new ArrayList<>();
    public static ArrayList<ProductDetails> temp3 = new ArrayList<>();
    public static ArrayList<ProductDetails> temp4 = new ArrayList<>();
    public static ArrayList<ProductDetails> temp5 = new ArrayList<>();
    public static ArrayList<ProductDetails> temp6 = new ArrayList<>();
    public static ArrayList<ProductDetails> temp7 = new ArrayList<>();
    public static ArrayList<ProductDetails> temp8 = new ArrayList<>();
    public static ArrayList<ProductDetails> temp9 = new ArrayList<>();
    public static ArrayList<ProductDetails> temp10 = new ArrayList<>();
    public static ArrayList<ProductDetails> temp11 = new ArrayList<>();
    public static ArrayList<ProductDetails> temp12 = new ArrayList<>();
    public static ArrayList<ProductDetails> temp13 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_selection);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.widthPixels;

        getWindow().setLayout((int)(width*.9), (int)(height*1));


        init();
    }


    public void init()
    {
        IndividualParts = (RecyclerView) findViewById(R.id.individual_parts);

        IAdapter = new IndividualViewAdapter(this, getData());
        IndividualParts.setAdapter(IAdapter);
        IndividualParts.setLayoutManager(new LinearLayoutManager(this));
        IndividualParts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }



    public List<Individual> getData()
    {
        List<Individual> individuals = new ArrayList<>();



        if(ButtonViewAdapter.x == 0)
        {
            individuals.clear();
            for(int i = 0; i< temp0.size(); i++)
            {
                individuals.add(new Individual("ID: " + temp0.get(i).ID, temp0.get(i).Availability, "Price: " + temp0.get(i).Price, "Back_Shoulder"));
            }
        }

        if(ButtonViewAdapter.x == 1)
        {
            individuals.clear();
            for(int i = 0; i< temp1.size(); i++)
            {
                individuals.add(new Individual("ID: " + temp1.get(i).ID, temp1.get(i).Availability, "Price: " + temp1.get(i).Price, "Sleeve_Left"));
            }
        }

        if(ButtonViewAdapter.x == 2)
        {
            individuals.clear();
            for(int i = 0; i< temp2.size(); i++)
            {
                individuals.add(new Individual("ID: " + temp2.get(i).ID, temp2.get(i).Availability, "Price: " + temp2.get(i).Price, "Sleeve_Right"));
            }
        }

        if(ButtonViewAdapter.x == 3)
        {
            individuals.clear();
            for(int i = 0; i< temp3.size(); i++)
            {
                individuals.add(new Individual("ID: " + temp3.get(i).ID, temp3.get(i).Availability, "Price: " + temp3.get(i).Price, "Body_Front_Left"));
            }
        }

        if(ButtonViewAdapter.x == 4)
        {
            individuals.clear();
            for(int i = 0; i< temp4.size(); i++)
            {
                individuals.add(new Individual("ID: " + temp4.get(i).ID, temp4.get(i).Availability, "Price: " + temp4.get(i).Price, "Body_Front_Right"));
            }
        }

        if(ButtonViewAdapter.x == 5)
        {
            individuals.clear();
            for(int i = 0; i< temp5.size(); i++)
            {
                individuals.add(new Individual("ID: " + temp5.get(i).ID, temp5.get(i).Availability, "Price: " + temp5.get(i).Price, "Collar"));
            }
        }

        if(ButtonViewAdapter.x == 6)
        {
            individuals.clear();
            for(int i = 0; i< temp6.size(); i++)
            {
                individuals.add(new Individual("ID: " + temp6.get(i).ID, temp6.get(i).Availability, "Price: " + temp6.get(i).Price, "Pocket_Left"));
            }
        }

        if(ButtonViewAdapter.x == 7)
        {
            individuals.clear();
            for(int i = 0; i< temp7.size(); i++)
            {
                individuals.add(new Individual("ID: " + temp7.get(i).ID, temp7.get(i).Availability, "Price: " + temp7.get(i).Price, "Pocket_Left_Hood"));
            }
        }

        if(ButtonViewAdapter.x == 8)
        {
            individuals.clear();
            for(int i = 0; i< temp8.size(); i++)
            {
                individuals.add(new Individual("ID: " + temp8.get(i).ID, temp8.get(i).Availability, "Price: " + temp8.get(i).Price, "Pocket_Right"));
            }
        }

        if(ButtonViewAdapter.x == 9)
        {
            individuals.clear();
            for(int i = 0; i< temp9.size(); i++)
            {
                individuals.add(new Individual("ID: " + temp9.get(i).ID, temp9.get(i).Availability, "Price: " + temp9.get(i).Price, "Pocket_Right_Hood"));
            }
        }

        if(ButtonViewAdapter.x == 10)
        {
            individuals.clear();
            for(int i = 0; i< temp10.size(); i++)
            {
                individuals.add(new Individual("ID: " + temp10.get(i).ID, temp10.get(i).Availability, "Price: " + temp10.get(i).Price, "Placket"));
            }
        }

        if(ButtonViewAdapter.x == 11)
        {
            individuals.clear();
            for(int i = 0; i< temp11.size(); i++)
            {
                individuals.add(new Individual("ID: " + temp11.get(i).ID, temp11.get(i).Availability, "Price: " + temp11.get(i).Price, "Buttons"));
            }
        }

        if(ButtonViewAdapter.x == 12)
        {
            individuals.clear();
            for(int i = 0; i< temp12.size(); i++)
            {
                individuals.add(new Individual("ID: " + temp12.get(i).ID, temp12.get(i).Availability, "Price: " + temp12.get(i).Price, "Cuff_Left"));
            }
        }

        if(ButtonViewAdapter.x == 13)
        {
            individuals.clear();
            for(int i = 0; i< temp13.size(); i++)
            {
                individuals.add(new Individual("ID: " + temp13.get(i).ID, temp13.get(i).Availability, "Price: " + temp13.get(i).Price, "Cuff_Right"));
            }
        }

        return individuals;
    }


}
