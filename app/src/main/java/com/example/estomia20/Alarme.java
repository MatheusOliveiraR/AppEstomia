package com.example.estomia20;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import android.widget.TextView;

import com.example.estomia20.Pessoa.hora;
import com.example.estomia20.Pessoa.notifi;
import com.example.estomia20.banco.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Alarme extends JobService{
    int qnt=0;
    int dispa=0;
    TextView minuto;
    @Override
    public boolean onStartJob(JobParameters params) {
        NotificationManager nm = (NotificationManager) getBaseContext().
                getSystemService(getBaseContext().NOTIFICATION_SERVICE);
        Intent inten = new Intent(getBaseContext(), notificacao.class);
        inten.putExtra("mensagem", "Alarme disparado");
        int id = (int) (Math.random() * 1000);
        PendingIntent pi = PendingIntent.getActivity(getBaseContext(), id,
                inten, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification noti = new Notification.Builder(getBaseContext())
                .setContentTitle("Esta na hora!" )
                .setContentText("Beba Agua!")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pi).build();
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        Ringtone ringtone =RingtoneManager.getRingtone(this,uri);
        ringtone.play();
        //atualizando o banco
        salvarNoBanco();
        Log.i("Alarme","dispa " + dispa);
        //fim da atualização de banco

        NotificationManager notificationManager = (NotificationManager)
                getBaseContext().
                        getSystemService(getBaseContext().NOTIFICATION_SERVICE);
        noti.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(id, noti);
        dao bd = new dao(getApplicationContext());
        notifi notifi = bd.recuperarNotifi();
        int verifica = Integer.parseInt(notifi.getQant());
        if(verifica <8){
            agendar();
        }
        return false;
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

    public void salvarNoBanco(){
        dao dao = new dao(getApplicationContext());
        notifi notifi;
        notifi = dao.recuperarNotifi();
        qnt = Integer.parseInt(notifi.getQant());
        qnt=qnt+1;
        String qntS = String.valueOf(qnt);
        notifi.setQant(qntS);
        dao.updateNoti(notifi);
        hora horas =new hora();
        horas.setHoras(getHoras());
        dao.updateHoras(horas);
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }



    public String getHoras(){
        SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:MM");
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();
        String hora_atual = dateFormat_hora.format(data_atual);
        Log.i("HORAS::::::: ","HORASSSSSS:::::" + data_atual.getHours()+":"+data_atual.getMinutes());
        return data_atual.getHours()+":"+data_atual.getMinutes();
    }
}
