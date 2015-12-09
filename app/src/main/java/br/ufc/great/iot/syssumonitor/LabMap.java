package br.ufc.great.iot.syssumonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class LabMap extends AppCompatActivity {

    private ImageView iv_user_sas;
    private ImageView iv_user_sde;
    private ImageView iv_user_lith;
    private ImageView iv_user_litl;

    private DataReader mDataReader;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_map);

        iv_user_sas = (ImageView) findViewById(R.id.iv_oldman_sas);
        iv_user_sde = (ImageView) findViewById(R.id.iv_oldman_sde);
        iv_user_lith = (ImageView) findViewById(R.id.iv_oldman_lith);
        iv_user_litl = (ImageView) findViewById(R.id.iv_oldman_litl);

        View.OnClickListener listener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(count < 2){
                    Toast.makeText(LabMap.this, "Sem informações adicionais", Toast.LENGTH_SHORT).show();
                    count++;
                    return;
                }
                if(v.getVisibility() == View.VISIBLE) {
                    int activity = new Random().nextInt(8) + 1;
                    String actv = String.valueOf(activity);
                    Toast.makeText(LabMap.this, "User A: " + actv, Toast.LENGTH_SHORT).show();
                    if(activity == 8){
                        Toast.makeText(LabMap.this, "Queda detectada!!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };

        iv_user_sas.setOnClickListener(listener);
        iv_user_sde.setOnClickListener(listener);
        iv_user_lith.setOnClickListener(listener);
        iv_user_litl.setOnClickListener(listener);

        mDataReader = new DataReader(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                mDataReader.startDetection();
            }
        }).start();

    }

    public void updateUI(final int sensorCode){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                iv_user_sas.setVisibility(View.INVISIBLE);
                iv_user_sde.setVisibility(View.INVISIBLE);
                iv_user_lith.setVisibility(View.INVISIBLE);
                iv_user_litl.setVisibility(View.INVISIBLE);

                if(sensorCode == 1){
                    iv_user_lith.setVisibility(View.VISIBLE);
                }
                else if(sensorCode == 2){
                    iv_user_litl.setVisibility(View.VISIBLE);
                }
                else if(sensorCode == 4){
                    iv_user_sas.setVisibility(View.VISIBLE);
                }
                else if(sensorCode == 5){
                    iv_user_sde.setVisibility(View.VISIBLE);
                }
                else{
                    // no one
                }
            }
        });


    }
}
