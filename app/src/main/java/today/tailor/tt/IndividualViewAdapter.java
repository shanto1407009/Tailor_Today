package today.tailor.tt;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import static today.tailor.tt.SplashScreen.SERVER_ADDRESS;

/**
 * Created by Shanto on 2/4/2018.
 */

public class IndividualViewAdapter extends RecyclerView.Adapter<IndividualViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;


    List<Individual> IndividualPart = Collections.emptyList();

    public IndividualViewAdapter(Context context, List<Individual> indi)
    {
        inflater=LayoutInflater.from(context);
        this.IndividualPart = indi;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.sinlge_parts, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        context = parent.getContext();

        return holder;
    }

    @Override
    public void onBindViewHolder(IndividualViewAdapter.MyViewHolder holder, int position) {
        final Individual current = IndividualPart.get(position);
        holder.Id.setText(current.ID);
        holder.Price.setText(current.Price);
        char[] realID = new char[4];
        realID[0] = current.ID.charAt(4);
        realID[1] = current.ID.charAt(5);
        realID[2] = current.ID.charAt(6);
        realID[3] = current.ID.charAt(7);
        Picasso.with(context).load(SERVER_ADDRESS + current.Folder + "/" + String.valueOf(realID) + ".JPG").into(holder.IP);
        holder.IP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonViewAdapter.x == 0)
                {
                    //EditProduct.C0.setImageResource(current.Ipart);
                    char[] temp = ViewAdapter.itemID.toCharArray();
                    temp[0] = current.ID.charAt(4);   //starts with 4 because the id is like "ID: 0000"
                    temp[1] = current.ID.charAt(5);
                    temp[2] = current.ID.charAt(6);
                    temp[3] = current.ID.charAt(7);
                    ViewAdapter.itemID = String.valueOf(temp);
                    //Toast.makeText(v.getContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), EditProduct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    v.getContext().startActivity(intent);
                }

                if(ButtonViewAdapter.x == 1)
                {
                    //EditProduct.C0.setImageResource(current.Ipart);
                    char[] temp = ViewAdapter.itemID.toCharArray();
                    temp[4] = current.ID.charAt(4);
                    temp[5] = current.ID.charAt(5);
                    temp[6] = current.ID.charAt(6);
                    temp[7] = current.ID.charAt(7);
                    ViewAdapter.itemID = String.valueOf(temp);
                    //Toast.makeText(v.getContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), EditProduct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    v.getContext().startActivity(intent);
                }
                if(ButtonViewAdapter.x == 2)
                {
                    //EditProduct.C0.setImageResource(current.Ipart);
                    char[] temp = ViewAdapter.itemID.toCharArray();
                    temp[8] = current.ID.charAt(4);
                    temp[9] = current.ID.charAt(5);
                    temp[10] = current.ID.charAt(6);
                    temp[11] = current.ID.charAt(7);
                    ViewAdapter.itemID = String.valueOf(temp);
                    //Toast.makeText(v.getContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), EditProduct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    v.getContext().startActivity(intent);
                }
                if(ButtonViewAdapter.x == 3)
                {
                    //EditProduct.C0.setImageResource(current.Ipart);
                    char[] temp = ViewAdapter.itemID.toCharArray();
                    temp[12] = current.ID.charAt(4);
                    temp[13] = current.ID.charAt(5);
                    temp[14] = current.ID.charAt(6);
                    temp[15] = current.ID.charAt(7);
                    ViewAdapter.itemID = String.valueOf(temp);
                    //Toast.makeText(v.getContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), EditProduct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    v.getContext().startActivity(intent);
                }
                if(ButtonViewAdapter.x == 4)
                {
                    //EditProduct.C0.setImageResource(current.Ipart);
                    char[] temp = ViewAdapter.itemID.toCharArray();
                    temp[16] = current.ID.charAt(4);
                    temp[17] = current.ID.charAt(5);
                    temp[18] = current.ID.charAt(6);
                    temp[19] = current.ID.charAt(7);
                    ViewAdapter.itemID = String.valueOf(temp);
                    //Toast.makeText(v.getContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), EditProduct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    v.getContext().startActivity(intent);
                }
                if(ButtonViewAdapter.x ==5)
                {
                    //EditProduct.C0.setImageResource(current.Ipart);
                    char[] temp = ViewAdapter.itemID.toCharArray();
                    temp[20] = current.ID.charAt(4);
                    temp[21] = current.ID.charAt(5);
                    temp[22] = current.ID.charAt(6);
                    temp[23] = current.ID.charAt(7);
                    ViewAdapter.itemID = String.valueOf(temp);
                    //Toast.makeText(v.getContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), EditProduct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    v.getContext().startActivity(intent);
                }
                if(ButtonViewAdapter.x == 6)
                {
                    //EditProduct.C0.setImageResource(current.Ipart);
                    char[] temp = ViewAdapter.itemID.toCharArray();
                    temp[24] = current.ID.charAt(4);
                    temp[25] = current.ID.charAt(5);
                    temp[26] = current.ID.charAt(6);
                    temp[27] = current.ID.charAt(7);
                    ViewAdapter.itemID = String.valueOf(temp);
                    //Toast.makeText(v.getContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), EditProduct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    v.getContext().startActivity(intent);
                }
                if(ButtonViewAdapter.x == 7)
                {
                    //EditProduct.C0.setImageResource(current.Ipart);
                    char[] temp = ViewAdapter.itemID.toCharArray();
                    temp[28] = current.ID.charAt(4);
                    temp[29] = current.ID.charAt(5);
                    temp[30] = current.ID.charAt(6);
                    temp[31] = current.ID.charAt(7);
                    ViewAdapter.itemID = String.valueOf(temp);
                    //Toast.makeText(v.getContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), EditProduct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    v.getContext().startActivity(intent);
                }
                if(ButtonViewAdapter.x == 8)
                {
                    //EditProduct.C0.setImageResource(current.Ipart);
                    char[] temp = ViewAdapter.itemID.toCharArray();
                    temp[32] = current.ID.charAt(4);
                    temp[33] = current.ID.charAt(5);
                    temp[34] = current.ID.charAt(6);
                    temp[35] = current.ID.charAt(7);
                    ViewAdapter.itemID = String.valueOf(temp);
                    //Toast.makeText(v.getContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), EditProduct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    v.getContext().startActivity(intent);
                }
                if(ButtonViewAdapter.x == 9)
                {
                    //EditProduct.C0.setImageResource(current.Ipart);
                    char[] temp = ViewAdapter.itemID.toCharArray();
                    temp[36] = current.ID.charAt(4);
                    temp[37] = current.ID.charAt(5);
                    temp[38] = current.ID.charAt(6);
                    temp[39] = current.ID.charAt(7);
                    ViewAdapter.itemID = String.valueOf(temp);
                    //Toast.makeText(v.getContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), EditProduct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    v.getContext().startActivity(intent);
                }
                if(ButtonViewAdapter.x == 10)
                {
                    //EditProduct.C0.setImageResource(current.Ipart);
                    char[] temp = ViewAdapter.itemID.toCharArray();
                    temp[40] = current.ID.charAt(4);
                    temp[41] = current.ID.charAt(5);
                    temp[42] = current.ID.charAt(6);
                    temp[43] = current.ID.charAt(7);
                    ViewAdapter.itemID = String.valueOf(temp);
                    //Toast.makeText(v.getContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), EditProduct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    v.getContext().startActivity(intent);
                }
                if(ButtonViewAdapter.x == 11)
                {
                    //EditProduct.C0.setImageResource(current.Ipart);
                    char[] temp = ViewAdapter.itemID.toCharArray();
                    temp[44] = current.ID.charAt(4);
                    temp[45] = current.ID.charAt(5);
                    temp[46] = current.ID.charAt(6);
                    temp[47] = current.ID.charAt(7);
                    ViewAdapter.itemID = String.valueOf(temp);
                    //Toast.makeText(v.getContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), EditProduct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    v.getContext().startActivity(intent);
                }
                if(ButtonViewAdapter.x == 12)
                {
                    //EditProduct.C0.setImageResource(current.Ipart);
                    char[] temp = ViewAdapter.itemID.toCharArray();
                    temp[48] = current.ID.charAt(4);
                    temp[49] = current.ID.charAt(5);
                    temp[50] = current.ID.charAt(6);
                    temp[51] = current.ID.charAt(7);
                    ViewAdapter.itemID = String.valueOf(temp);
                    //Toast.makeText(v.getContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), EditProduct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    v.getContext().startActivity(intent);
                }
                if(ButtonViewAdapter.x == 13)
                {
                    //EditProduct.C0.setImageResource(current.Ipart);
                    char[] temp = ViewAdapter.itemID.toCharArray();
                    temp[52] = current.ID.charAt(4);
                    temp[53] = current.ID.charAt(5);
                    temp[54] = current.ID.charAt(6);
                    temp[55] = current.ID.charAt(7);
                    ViewAdapter.itemID = String.valueOf(temp);
                    //Toast.makeText(v.getContext(), ViewAdapter.itemID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), EditProduct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    v.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return IndividualPart.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        ImageView IP;
        TextView Id;
        TextView Price;

        private final Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            Price = (TextView) itemView.findViewById(R.id.partPrice);
            IP = (ImageView) itemView.findViewById(R.id.s0);
            Id = (TextView) itemView.findViewById(R.id.part_id);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
