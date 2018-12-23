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

public class Tab3Fragment extends Fragment {
    private static final String TAG = "Tab3Fragment";
    private Button Tab3Button;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_fragment, container, false);
        Tab3Button = (Button) view.findViewById(R.id.tab3button);
        Tab3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Button 3 clicked", Toast.LENGTH_SHORT).show();
            }
        });




        return  view;
    }
}
