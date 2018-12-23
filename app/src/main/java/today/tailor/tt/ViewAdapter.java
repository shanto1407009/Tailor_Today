package today.tailor.tt;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import static today.tailor.tt.SplashScreen.SERVER_ADDRESS;

/**
 * Created by Shanto on 1/26/2018.
 */

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder> {


    private LayoutInflater inflater;
    public static String itemID;
    private Context context;


    List<fullProduct> Products = Collections.emptyList();

    public ViewAdapter(Context context, List<fullProduct> Products)
    {
        inflater=LayoutInflater.from(context);
        this.Products = Products;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        context = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final fullProduct current = Products.get(position);
        if(current.Tittle.equals("My own design"))
        {
            holder.A0.setImageResource(R.drawable.plus);
        }
        else {
            Picasso.with(context).load(SERVER_ADDRESS + "Full_Product/" + current.ID + ".JPG").into(holder.A0);
        }
        /*holder.A1.setImageResource(current.L1);
        holder.A2.setImageResource(current.L2);
        holder.A3.setImageResource(current.L3);
        holder.A4.setImageResource(current.L4);
        holder.A5.setImageResource(current.L5);
        holder.A6.setImageResource(current.L6);
        holder.A7.setImageResource(current.L7);
        holder.A8.setImageResource(current.L8);
        holder.A9.setImageResource(current.L9);
        holder.A10.setImageResource(current.L10);
        holder.A11.setImageResource(current.L11);
        holder.A12.setImageResource(current.L12);
        holder.A13.setImageResource(current.L13);*/
        holder.LV.setImageResource(current.Love);
        holder.ProductTittle.setText(current.Tittle);
        holder.ProductPrice.setText("Price: " + current.Price);


        holder.LV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(current.Love == R.drawable.love2)
                {
                    current.Love = (R.drawable.love);
                    holder.LV.setImageResource(current.Love);
                    Toast.makeText(v.getContext(), "Added to favourite", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    current.Love = (R.drawable.love2);
                    holder.LV.setImageResource(current.Love);
                    Toast.makeText(v.getContext(), "Removed from favourite", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.LL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current.Tittle == "My own design")
                {
                    Toast.makeText(v.getContext(), current.Tittle, Toast.LENGTH_SHORT).show();
                }
                else {
                    itemID = current.ID;
                    //Toast.makeText(v.getContext(), current.ID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), DisplayProduct.class);
                    v.getContext().startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return Products.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView ProductTittle;
        TextView ProductPrice;
        ImageView A0;
        ImageView A1;
        ImageView A2;
        ImageView A3;
        ImageView A4;
        ImageView A5;
        ImageView A6;
        ImageView A7;
        ImageView A8;
        ImageView A9;
        ImageView A10;
        ImageView A11;
        ImageView A12;
        ImageView A13;
        ImageView LV;
        LinearLayout LL;

        private final Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            ProductTittle = (TextView) itemView.findViewById(R.id.product_tittle);
            ProductPrice = (TextView) itemView.findViewById(R.id.product_price);
            A0 = (ImageView) itemView.findViewById(R.id.p0);
            A1 = (ImageView) itemView.findViewById(R.id.p1);
            A2 = (ImageView) itemView.findViewById(R.id.p2);
            A3 = (ImageView) itemView.findViewById(R.id.p3);
            A4 = (ImageView) itemView.findViewById(R.id.p4);
            A5 = (ImageView) itemView.findViewById(R.id.p5);
            A6 = (ImageView) itemView.findViewById(R.id.p6);
            A7 = (ImageView) itemView.findViewById(R.id.p7);
            A8 = (ImageView) itemView.findViewById(R.id.p8);
            A9 = (ImageView) itemView.findViewById(R.id.p9);
            A10 = (ImageView) itemView.findViewById(R.id.p10);
            A11 = (ImageView) itemView.findViewById(R.id.p11);
            A12 = (ImageView) itemView.findViewById(R.id.p12);
            A13 = (ImageView) itemView.findViewById(R.id.p13);
            LV = (ImageView) itemView.findViewById(R.id.love);
            LL = (LinearLayout) itemView.findViewById(R.id.item_layout);

        }

        @Override
        public void onClick(View v) {

        }
    }

    /*public Bitmap getImage(String name)
    {
        String url = SERVER_ADDRESS + "Full_Product" + "/" + name + ".JPG";
        //Toast.makeText(getBaseContext(), url, Toast.LENGTH_SHORT).show();
        try
        {
            URLConnection connection = new URL(url).openConnection();
            connection.setConnectTimeout(1000*30);
            connection.setReadTimeout(1000*30);
            return BitmapFactory.decodeStream(connection.getInputStream());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }*/


}
