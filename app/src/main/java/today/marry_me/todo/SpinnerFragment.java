package today.marry_me.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SpinnerFragment extends Fragment {

    private TextView textView;
    private Spinner spinner;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.spinner_fragment, container, false);
        textView = (TextView) view.findViewById(R.id.text);
        textView.setText("您选择的城市是Shanghai");
        spinner = (Spinner) view.findViewById(R.id.spinner);

        list = new ArrayList<String>();
        list.add("Shanghai");
        list.add("Beijing");
        list.add("Guangzhou");
        list.add("Shenzhen");
        // 2. 新建ArrayAdapter
        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, list);

        // 3. adapter设置一个下拉菜单样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cityName = adapter.getItem(position);
                // String cityName = list.get(position);
                textView.setText("您选择的城市是" + cityName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

}
