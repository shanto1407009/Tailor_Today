package today.tailor.tt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Shanto on 1/29/2018.
 */

public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";
    private Button Tab2Button;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);
        Tab2Button = (Button) view.findViewById(R.id.tab2button);
        Tab2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Button 2 clicked", Toast.LENGTH_SHORT).show();
            }
        });




        return  view;
    }
}
