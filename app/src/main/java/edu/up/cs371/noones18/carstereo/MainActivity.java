package edu.up.cs371.noones18.carstereo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import static android.graphics.Color.LTGRAY;

public class MainActivity extends AppCompatActivity {
    private ToggleButton OnOffSwitch;
    private ToggleButton AMFMbutton;
    private SeekBar RadioBar;
    private SeekBar Volume;
    private Button Station1;
    private Button Station2;
    private Button Station3;
    private Button Station4;
    private Button Station5;
    private Button Station6;
    private TextView RadioProgress;
    public boolean AMFMstate;
    public double FMnumber;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnOffSwitch = (ToggleButton) findViewById(R.id.powerbutton);
        AMFMbutton = (ToggleButton) findViewById(R.id.AMFMbutton);
        RadioBar = (SeekBar) findViewById(R.id.RadioBar);
        Volume = (SeekBar) findViewById(R.id.Volume);
        RadioBar.setProgress(0);
        RadioBar.incrementProgressBy(10);
        RadioBar.setMax(1170);
        RadioProgress = (TextView)findViewById(R.id.RadioProgress);
        Station1 = (Button) findViewById(R.id.Station1);
        Station2 = (Button) findViewById(R.id.Station2);
        Station3 = (Button) findViewById(R.id.Station3);
        Station4 = (Button) findViewById(R.id.Station4);
        Station5 = (Button) findViewById(R.id.Station5);
        Station6 = (Button) findViewById(R.id.Station6);

        RadioBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if(AMFMbutton.isChecked()) //AM station
                {

                    RadioBar.setMax(1700-530);
                    RadioProgress.setText(""+(progress+530));
                }
                else
                {
                    //RadioBar.setProgress(881);
                    RadioBar.setMax(1079-881);
                     progress = (int)((double) progress/10);

                    RadioProgress.setText(""+(progress+88.1));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });


    }
    public void sendMessage(View v)
    {
        Button preSet = (Button) v;

        if(AMFMbutton.isChecked()) //AM station
        {
            int prenum = Integer.valueOf((String)preSet.getText());
            int progbar = 50*prenum+500;
            RadioBar.setProgress(550-530);
            RadioProgress.setText("550");

            ////
            if(Integer.valueOf((String)preSet.getText())==1)
            {
                RadioBar.setProgress(550-530);
                RadioProgress.setText("550");
            }
            else if(preSet.getText()=="2"){
                RadioBar.setProgress(600-530);
                RadioProgress.setText("600");
            }
            else if(preSet.getText()=="3"){
                RadioBar.setProgress(650-530);
                RadioProgress.setText("650");
            }
            else if(preSet.getText()=="4"){
                RadioBar.setProgress(700-530);
                RadioProgress.setText("700");
            }
            else if(preSet.getText()=="5"){
                RadioBar.setProgress(750-530);
                RadioProgress.setText("750");

            }else if(preSet.getText()=="6"){
                RadioBar.setProgress(800-530);
                RadioProgress.setText("800");
            }

         }
         else{

        }
    }
    public boolean OnOff(View v)
    {
        if(!OnOffSwitch.isChecked())
        {
            int offColor = Color.rgb(49,63,159);


            Station1.setBackgroundColor(offColor);
            Station2.setBackgroundColor(offColor);
            Station3.setBackgroundColor(offColor);
            Station4.setBackgroundColor(offColor);
            Station5.setBackgroundColor(offColor);
            Station6.setBackgroundColor(offColor);
            AMFMbutton.setBackgroundColor(offColor);
            RadioBar.setBackgroundColor(offColor);
            Volume.setBackgroundColor(offColor);
            RadioBar.setBackgroundColor(offColor);
            return true;
        }

        int offColor = Color.rgb(49,63,159);
        Station1.setBackgroundColor(LTGRAY);
        Station2.setBackgroundColor(LTGRAY);
        Station3.setBackgroundColor(LTGRAY);
        Station4.setBackgroundColor(LTGRAY);
        Station5.setBackgroundColor(LTGRAY);
        Station6.setBackgroundColor(LTGRAY);
        AMFMbutton.setBackgroundColor(LTGRAY);
        RadioBar.setBackgroundColor(LTGRAY);
        Volume.setBackgroundColor(LTGRAY);
        RadioBar.setBackgroundColor(LTGRAY);
     return false;
    }




}
