package today.tailor.tt;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Collections;
import java.util.List;

/**
 * Created by Shanto on 2/3/2018.
 */

public class ButtonViewAdapter extends RecyclerView.Adapter<ButtonViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    public static int x = -1;


    List<PartsList> Btn = Collections.emptyList();

    public ButtonViewAdapter(Context context, List<PartsList> btn)
    {
        inflater=LayoutInflater.from(context);
        this.Btn = btn;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.button_list, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final PartsList current = Btn.get(position);
        holder.ListButton.setText(current.ButtonName);
        holder.ListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current.ButtonName.equals("Back Shoulder"))
                {
                    x = 0;
                }
                else if(current.ButtonName.equals("Sleeve Left"))
                {
                    x = 1;
                }
                else if(current.ButtonName.equals("Sleeve Right"))
                {
                    x = 2;
                }
                else if(current.ButtonName.equals("Body Front Left"))
                {
                    x = 3;
                }
                else if(current.ButtonName.equals("Body Front Right"))
                {
                    x = 4;
                }else if(current.ButtonName.equals("Collar"))
                {
                    x = 5;
                }
                else if(current.ButtonName.equals("Pocket Left"))
                {
                    x = 6;
                }
                else if(current.ButtonName.equals("Pocket Left Hood"))
                {
                    x = 7;
                }
                else if(current.ButtonName.equals("Pocket Right"))
                {
                    x = 8;
                }
                else if(current.ButtonName.equals("Pocket Right Hood"))
                {
                    x = 9;
                }
                else if(current.ButtonName.equals("Placket"))
                {
                    x = 10;
                }
                else if(current.ButtonName.equals("Buttons"))
                {
                    x = 11;
                }
                else if(current.ButtonName.equals("Cuff Left"))
                {
                    x = 12;
                }
                else if(current.ButtonName.equals("Cuff Right"))
                {
                    x = 13;
                }



                Intent intent = new Intent(v.getContext(), Selection.class);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Btn.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        Button ListButton;

        private final Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            ListButton = (Button) itemView.findViewById(R.id.list_button);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
