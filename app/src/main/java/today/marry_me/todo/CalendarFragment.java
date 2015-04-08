package today.marry_me.todo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class CalendarFragment extends Fragment {
    private TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;
    private TextView textView;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // layout布局文件转换为view对象
        // resource Fragment 需要加载的布局文件
        // root 加载layout的ViewGroup
        // attachToRoot: false, 不返回父viewGroup
        View view = inflater.inflate(R.layout.calendar_fragment, container, false);
        textView = (TextView) view.findViewById(R.id.text);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        textView.setText(year + "-" + month + "-" + day + "-" + hour + ":" + minute);

        datePickerDialog = new DatePickerDialog(this.getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                textView.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            }
        }, year, calendar.get(Calendar.MONTH), day);

        timePickerDialog = new TimePickerDialog(this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                textView.setText(hourOfDay + ":" + minute);
            }
        }, hour, minute, true);

        Button datePickerBtn = ((Button) view.findViewById(R.id.datePickerBtn));
        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
        view.findViewById(R.id.timePickerBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

        timePickerDialog.show();

        return view;
    }
}
