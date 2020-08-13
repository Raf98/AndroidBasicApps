package com.example.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

public class MainActivity extends AppCompatActivity
{
    //private CalendarView calendarView;
    private MaterialCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);

        calendarView.state().edit()
                .setMinimumDate(CalendarDay.from(2018, 1, 1))
                .setMaximumDate(CalendarDay.from(2022, 1, 1))
                .commit();

        CharSequence[] monthNames = {"Janeiro", "Fevereiro", "Março", "Abril",
                                    "Maio", "Junho", "Julho", "Agosto",
                                    "Setembro", "Outubro", "Novembro", "Dezembro"};

        calendarView.setTitleMonths(monthNames);

        CharSequence[] dayOfWeekNames = {"Segunda", "Terça", "Quarta", "Quinta",
                                        "Sexta", "Sábado", "Domingo"};

        calendarView.setWeekDayLabels(dayOfWeekNames);

        calendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date)
            {
                String dateFormatted = date.getDay() + "/" + (date.getMonth()) + "/" + date.getYear();
                Toast.makeText(getApplicationContext(), dateFormatted, Toast.LENGTH_SHORT).show();
            }
        });

        /*
        calendarView.setOnDateChangedListener(new OnDateSelectedListener()
        {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected)
            {
                String dateFormatted = date.getDay() + "/" + (date.getMonth()) + "/" + date.getYear();
                Toast.makeText(getApplicationContext(), dateFormatted, Toast.LENGTH_SHORT).show();
            }
        });


         */
        /*calendarView = findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
            {
                String dateFormatted = dayOfMonth + "/" + (month+1) + "/" + year;
                Toast.makeText(getApplicationContext(), dateFormatted, Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
