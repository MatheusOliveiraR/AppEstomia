package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estomia20.Pessoa.hora;
import com.example.estomia20.Pessoa.notifi;
import com.example.estomia20.banco.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class notificacao extends AppCompatActivity {
    private Button btnLigar;
    private ProgressBar barrinha;
    private ImageButton voltar;
    private TextView next;
    private TextView quantoT;
    private TextView qntPorce;
    private TextView minuto;
    private Button cancelar;
    private TextView tomadas;
    private TextView qntNoti;
    private TextView resetar;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacao);
        final dao dao = new dao(getApplicationContext());
        barrinha = findViewById(R.id.barrinha);
        notifi notifi;
        notifi = dao.recuperarNotifi();
        barrinha.setProgress(Integer.parseInt(notifi.getQant()));
        tomadas = findViewById(R.id.tomadas);
        tomadas.setText(notifi.getQant() + " Copos");
        qntNoti = findViewById(R.id.qntNoti);
        qntNoti.setText(notifi.getQant()+" notificações");


        next = findViewById(R.id.nextNoti);
        int faltam = 8- Integer.parseInt(notifi.getQant());
        if(faltam>0) {
            next.setText(String.valueOf(faltam));
        }else{
            next.setText("0");
        }

        quantoT = findViewById(R.id.quantoTomou);
        quantoT.setText(notifi.getQant()+"/8");


        qntPorce = findViewById(R.id.qntPorce);
        qntPorce.setText(gerarInt()+"%");

        minuto = findViewById(R.id.nextMinute);
        minuto.setText("0");
        hora hora = dao.recuperarHoras();
        if(hora.getHoras()!=null) {
            String horasbanco[] = hora.getHoras().split(":");
            String horasagora[] = getHoras().split(":");
            int horasresultante = ((Integer.parseInt(horasbanco[0])+2) - Integer.parseInt(horasagora[0]))   ;
            int minutosresultates = Integer.parseInt(horasagora[1])-Integer.parseInt(horasbanco[1]);
            int novominuto = 0;
            if (horasresultante != 0) {
                int temp = horasresultante * 60;
                novominuto = minutosresultates + temp;
            } else {
                novominuto = minutosresultates;
            }
            minuto.setText(String.valueOf(novominuto));
        }else{
            minuto.setText("0");
        }
        resetar = findViewById(R.id.resetar);
        resetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.removerHoras();
                notifi notifi = new notifi();
                notifi.setdispa("01");
                notifi.setQant("0");
                dao.updateNoti(notifi);
                quantoT.setText("0/8");
                next.setText("8");
                qntNoti.setText("Nenhuma notificação disparada");
                tomadas.setText("0 copos");
                qntPorce.setText("0%");
                barrinha.setProgress(0);

                JobScheduler js = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
                js.cancelAll();
                Toast toast = Toast.makeText(getApplicationContext(),"Alarme Resetado!" , Toast.LENGTH_SHORT);
                dao dao = new dao(getApplicationContext());
                dao.removerHoras();
                minuto.setText("0");
                toast.show();

                SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:MM");
                Date data = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(data);
                Date data_atual = cal.getTime();
                String hora_atual = dateFormat_hora.format(data_atual);
                Log.i("HORAS::::::: ","HORASSSSSS:::::" + data_atual.getHours()+":"+data_atual.getMinutes());
                dao db =new dao(getApplicationContext());
                hora hora;
                db.salvarHora(data_atual.getHours()+":"+data_atual.getMinutes());
                ComponentName serviceName = new ComponentName(getBaseContext(),
                        Alarme.class);
                JobInfo jobInfo = new JobInfo.Builder(0, serviceName)
                        .setMinimumLatency(7200000)
                        .setRequiresCharging(false)
                        .build();
                JobScheduler scheduler = (JobScheduler) getBaseContext()
                        .getSystemService(Context.JOB_SCHEDULER_SERVICE);
                int result = scheduler.schedule(jobInfo);
                if (result == JobScheduler.RESULT_SUCCESS)
                    Log.d("MainActivity", "Serviço agendado!");
                Context context = getApplicationContext();
                CharSequence text = "Serviço Agendado!";
                int duration = Toast.LENGTH_SHORT;



            }
        });
        btnLigar = findViewById(R.id.btnLigar);
        btnLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:MM");
                Date data = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(data);
                Date data_atual = cal.getTime();
                String hora_atual = dateFormat_hora.format(data_atual);
                Log.i("HORAS::::::: ","HORASSSSSS:::::" + data_atual.getHours()+":"+data_atual.getMinutes());
                dao db =new dao(getApplicationContext());
                hora hora;
                db.salvarHora(data_atual.getHours()+":"+data_atual.getMinutes());
                ComponentName serviceName = new ComponentName(getBaseContext(),
                        Alarme.class);
                JobInfo jobInfo = new JobInfo.Builder(0, serviceName)
                        .setMinimumLatency(7200000)
                        .setRequiresCharging(false)
                        .build();
                JobScheduler scheduler = (JobScheduler) getBaseContext()
                        .getSystemService(Context.JOB_SCHEDULER_SERVICE);
                int result = scheduler.schedule(jobInfo);
                if (result == JobScheduler.RESULT_SUCCESS)
                    Log.d("MainActivity", "Serviço agendado!");
                Context context = getApplicationContext();
                CharSequence text = "Serviço Agendado!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        cancelar = findViewById(R.id.cancelar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JobScheduler js = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
                js.cancelAll();
                Toast toast = Toast.makeText(getApplicationContext(),"Alarme cancelado!" , Toast.LENGTH_SHORT);
                dao dao = new dao(getApplicationContext());
                dao.removerHoras();
                minuto.setText("0");
                toast.show();
                Log.e("Notificação!!! ", "PASSEI AQUI:::::::::::::::");
            }
        });





        voltar = findViewById(R.id.voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public float gerarInt(){
        notifi notifi= new notifi();
        dao dao = new dao(getApplicationContext());
        notifi =dao.recuperarNotifi();
            float por = Float.parseFloat(notifi.getQant()) / 8;
            float porcem = por * 100;
            return porcem;    
    }

    public String getHorasresultante(){
        dao db = new dao(getApplicationContext());
        hora hora= db.recuperarHoras();
        String horasbanco[] = hora.getHoras().split(":");
        String horasagora[] = getHoras().split(":");
        int horasresultante = ((Integer.parseInt(horasbanco[0])+2) - Integer.parseInt(horasagora[0]))   ;
        int minutosresultates = Integer.parseInt(horasagora[1])-Integer.parseInt(horasbanco[1]);
        int novominuto=0;
        if(horasresultante!=0){
            int temp=horasresultante*60;
            novominuto = minutosresultates+temp;
        }else{
            novominuto = minutosresultates;
        }
        return String.valueOf(novominuto);

    }

    public void agendar(){
        ComponentName serviceName = new ComponentName(getBaseContext(),
                Alarme.class);
        JobInfo jobInfo = new JobInfo.Builder(0, serviceName)
                .setMinimumLatency(7200000)
                .setRequiresCharging(false)
                .build();
        JobScheduler scheduler = (JobScheduler) getBaseContext()
                .getSystemService(Context.JOB_SCHEDULER_SERVICE);
        int result = scheduler.schedule(jobInfo);
        if (result == JobScheduler.RESULT_SUCCESS)
            Log.d("MainActivity", "Serviço agendado!");
    }

    public String getHoras(){
        SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:MM");
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();
        String hora_atual = dateFormat_hora.format(data_atual);
        Log.i("HORAS::::::: ","HORASSSSSS:::::" + data_atual.getHours()+":"+data_atual.getMinutes());
        dao db =new dao(getApplicationContext());
        hora hora;
        db.salvarHora(data_atual.getHours()+":"+data_atual.getMinutes());
        return data_atual.getHours()+":"+data_atual.getMinutes();
    }

}
