package today.marry_me.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GridViewFragment extends Fragment {

    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private int[] icon = {R.drawable.address_book, R.drawable.calendar, R.drawable.camera, R.drawable.clock,
            R.drawable.games_control, R.drawable.messenger, R.drawable.ringtone, R.drawable.settings,
            R.drawable.speech_balloon, R.drawable.weather, R.drawable.world, R.drawable.youtube
    };
    private String[] iconName = {
            "通讯录", "日历", "相机", "时间", "游戏中心", "消息", "铃声", "设置", "会话", "天气", "世界", "优酷"
    };
    private SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_view_fragment, container, false);

        gridView = (GridView) view.findViewById(R.id.gridView);
        // 1. prepare data source
        // 2. new SimpleAdapter
        // 3. load Adapter
        // 4. Init listener
        dataList = new ArrayList<>();
        adapter = new SimpleAdapter(this.getActivity(), getData(),
                R.layout.grid_item,
                new String[]{"image", "text"},
                new int[]{R.id.image, R.id.text});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "我是" + iconName[position], Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private List<Map<String, Object>> getData() {
        for (int i = 0; i < icon.length; i++)
        {
            Map<String, Object> map = new HashMap<>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            dataList.add(map);
        }
        return dataList;
    }


}
