package com.example.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int x_counter=0;
    String winner;
    private boolean contGame=true;
    Button b[];
    int abc=0;
    boolean btn4_isCicked=false;
    TextView tx;
    int o_counter=0;
    int a,bb,c;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        b = new Button[9];
        b[0] = findViewById(R.id.button);
        b[1] = findViewById(R.id.button2);
        b[2] = findViewById(R.id.button3);
        b[3] = findViewById(R.id.button4);
        b[4] = findViewById(R.id.button5);
        b[5] = findViewById(R.id.button6);
        b[6] = findViewById(R.id.button7);
        b[7] = findViewById(R.id.button8);
        b[8] = findViewById(R.id.button9);

        tx=((TextView)findViewById(R.id.text1));

    }
    @SuppressLint("UseCompatLoadingForDrawables")
    public void game(View v){
        ((Button)findViewById(R.id.button12)).setEnabled(false);
        if(v==findViewById(R.id.button10)){
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
        }
        if(v==findViewById(R.id.button11)){
            ((Button)findViewById(R.id.button10)).setEnabled(false);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colorfour));
        }
    }
    @SuppressLint("SetTextI18n")
    public void onXorO(View v){


        System.out.println("XorO");
        if(((Button)findViewById(R.id.button10)).isEnabled() && !(((Button)findViewById(R.id.button11)).isEnabled())
            && contGame
        ){
            ((Button)v).setText("X");
            ((Button)v).setTextColor(Color.parseColor("#47D51F"));
            System.out.println("X");
            ((Button)findViewById(R.id.button10)).setEnabled(false);
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorthree));
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(true);
            ((Button)v).setEnabled(false);
            x_counter++;
            if(x_counter>=3){
                gameCheck();}
        }
         if (((Button)findViewById(R.id.button11)).isEnabled() && !(((Button)findViewById(R.id.button10)).isEnabled())
                && contGame
        ){
//            ((Button)v).setText("O");
//            ((Button)v).setTextColor(Color.parseColor("#FF5722"));;
//
//            ((Button)findViewById(R.id.button10)).setEnabled(true);
//            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
//            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
//            ((Button)findViewById(R.id.button11)).setEnabled(false);
//            ((Button)v).setEnabled(false);
            computer();
            o_counter++;
            System.out.println("called");
            abc++;
             System.out.println("O fun: "+abc);
            if(o_counter>=3){
            gameCheck();}

        }
        if (!contGame) {
            System.out.println("game end!-1");
            for(int i=0;i<9;i++){
                if(b[i].isEnabled()){
                    b[i].setEnabled(false);
                }
            }
            System.out.println("game end!-2");
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            System.out.println("game end!-3");
            ((Button)findViewById(R.id.button10)).setEnabled(false);
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            System.out.println("game end!-4");
            tx.setText("Player "+winner+" is the Winner!!!");
            System.out.println("game end!-5");

            System.out.println("game end!-6");
            ((Button)findViewById(R.id.button12)).setEnabled(true);
            System.out.println("game end!-7");

        }



    }
    public void gameCheck(){
        System.out.println("n>3 entered");
        String sb=b[0].getText().toString();
        String sb1=b[1].getText().toString();
        String sb2=b[2].getText().toString();
        String sb3=b[3].getText().toString();
        String sb4=b[4].getText().toString();
        String sb5=b[5].getText().toString();
        String sb6=b[6].getText().toString();
        String sb7=b[7].getText().toString();
        String sb8=b[8].getText().toString();
        if(sb.equals(sb1) && sb.equals(sb2)&& !(sb.equals("X/O"))){
            b[1].setBackground(getDrawable(R.drawable.colorfive));
            b[0].setBackground(getDrawable(R.drawable.colorfive));
            b[2].setBackground(getDrawable(R.drawable.colorfive));
            winner=b[1].getText().toString();System.out.println("n>3");
            contGame=false;
        }
        else if (sb3.equals(sb4)&& sb3.equals(sb5) && !(sb3.equals("X/O"))) {
            b[3].setBackground(getDrawable(R.drawable.colorfive));
            b[4].setBackground(getDrawable(R.drawable.colorfive));
            b[5].setBackground(getDrawable(R.drawable.colorfive));
            winner=b[3].getText().toString();System.out.println("n>3");
            contGame=false;
        }
        else if (sb6.equals(sb7) && sb6.equals(sb8) && !(sb6.equals("X/O"))) {
            b[6].setBackground(getDrawable(R.drawable.colorfive));
            b[7].setBackground(getDrawable(R.drawable.colorfive));
            b[8].setBackground(getDrawable(R.drawable.colorfive));
            winner=b[6].getText().toString();System.out.println("n>3");
            System.out.println("o win!");
            contGame=false;
        }
        else if (sb.equals(sb3) && sb.equals(sb6) && !(sb.equals("X/O"))) {

            b[0].setBackground(getDrawable(R.drawable.colorfive));
            b[3].setBackground(getDrawable(R.drawable.colorfive));
            b[6].setBackground(getDrawable(R.drawable.colorfive));
            winner=b[3].getText().toString();System.out.println("n>3");
            contGame=false;
        }
        else if (sb1.equals(sb4) &&sb1.equals(sb7)&& !(sb1.equals("X/O"))) {

            b[1].setBackground(getDrawable(R.drawable.colorfive));
            b[4].setBackground(getDrawable(R.drawable.colorfive));
            b[7].setBackground(getDrawable(R.drawable.colorfive));
            winner=b[4].getText().toString();
            contGame=false;
        }
        else if (sb2.equals(sb5) && sb2.equals(sb8) && !(sb2.equals("X/O"))) {

            b[2].setBackground(getDrawable(R.drawable.colorfive));
            b[5].setBackground(getDrawable(R.drawable.colorfive));
            b[8].setBackground(getDrawable(R.drawable.colorfive));
            winner=b[2].getText().toString();System.out.println("n>3");
            contGame=false;
        }
        else if (sb.equals(sb4) && sb.equals(sb8) && !(sb.equals("X/O"))) {

            b[0].setBackground(getDrawable(R.drawable.colorfive));
            b[4].setBackground(getDrawable(R.drawable.colorfive));
            b[8].setBackground(getDrawable(R.drawable.colorfive));
            winner=b[0].getText().toString();System.out.println("n>3");
            contGame=false;
        }
        else if (sb2.equals(sb4)  && sb2.equals(sb6) && !(sb2.equals("X/O"))) {

            b[2].setBackground(getDrawable(R.drawable.colorfive));
            b[4].setBackground(getDrawable(R.drawable.colorfive));
            b[6].setBackground(getDrawable(R.drawable.colorfive));
            winner=b[6].getText().toString();System.out.println("n>3");
            contGame=false;
        }
        if (contGame && (o_counter+x_counter==9)) {
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button10)).setEnabled(false);
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            tx.setText("It is Draw!!!");
            ((Button)findViewById(R.id.button12)).setEnabled(true);

        }


    }

    public void Restart(View v){
        System.out.println("restart-1");
        o_counter=0;
        x_counter=0;
        contGame=true;
        for(int i=0;i<9;i++){

                b[i].setEnabled(true);
                b[i].setText("X/O");
                b[i].setBackground(getDrawable(R.drawable.custom_button));
                b[i].setTextColor(Color.parseColor("#808080"));

        }
        System.out.println("restart-1");
        ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
        ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorthree));
        System.out.println("restart-1");
        ((Button)findViewById(R.id.button10)).setEnabled(true);
        ((Button)findViewById(R.id.button11)).setEnabled(true);
        tx.setText("");

    }
    public void computer(){
        System.out.println("answered");
        String sb=b[0].getText().toString();
        String sb1=b[1].getText().toString();
        String sb2=b[2].getText().toString();
        String sb3=b[3].getText().toString();
        String sb4=b[4].getText().toString();
        String sb5=b[5].getText().toString();
        String sb6=b[6].getText().toString();
        String sb7=b[7].getText().toString();
        String sb8=b[8].getText().toString();
        if((sb.equals(sb1)) && !(sb.equals("X/O")) && b[2].isEnabled()){
            b[2].setText("O");
            b[2].setTextColor(Color.parseColor("#FF5722"));;

            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[2].setEnabled(false);
        }
        else if (sb.equals(sb2) && !(sb.equals("X/O"))&& b[1].isEnabled())
         {
             b[1].setText("O");
             b[1].setTextColor(Color.parseColor("#FF5722"));
             ((Button)findViewById(R.id.button10)).setEnabled(true);
             ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
             ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
             ((Button)findViewById(R.id.button11)).setEnabled(false);
             b[1].setEnabled(false);
        }
        else if (sb1.equals(sb2)&& !(sb1.equals("X/O")) && b[0].isEnabled()) {
            b[0].setText("O");
            b[0].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[0].setEnabled(false);
        }
        else if (sb.equals(sb3) && !(sb.equals("X/O"))&& b[6].isEnabled()) {

            b[6].setText("O");
            b[6].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[6].setEnabled(false);
        }
        else if (sb.equals(sb6) && !(sb.equals("X/O")) && b[3].isEnabled()) {
            b[3].setText("O");
            b[3].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[3].setEnabled(false);
        }
        else if (sb3.equals(sb6)&& !(sb3.equals("X/O")) && b[0].isEnabled()) {
            b[0].setText("O");
            b[0].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[0].setEnabled(false);
        }
        else if (sb3.equals(sb4)&& !(sb3.equals("X/O")) && b[5].isEnabled()) {

            b[5].setText("O");
            b[5].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[5].setEnabled(false);
        }
        else if (sb3.equals(sb5)&& !(sb3.equals("X/O"))&&  b[4].isEnabled() ) {

            b[4].setText("O");
            b[4].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[4].setEnabled(false);
        }
        else if (sb4.equals(sb5) && !(sb4.equals("X/O"))&& b[3].isEnabled()) {

            b[3].setText("O");
            b[3].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[3].setEnabled(false);
        }
        else if (sb1.equals(sb4) && !(sb1.equals("X/O")) && b[7].isEnabled()) {

            b[7].setText("O");
            b[7].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[7].setEnabled(false);
        }
        else if (sb1.equals(sb7) && !(sb1.equals("X/O")&& !sb7.equals("X/O"))&& b[4].isEnabled()
        ) {

            System.out.println("Cliked sb4");
            b[4].setText("O");
            b[4].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[4].setEnabled(false);
        }
        else if (sb4.equals(sb7) && !(sb4.equals("X/O"))&& b[1].isEnabled()) {

            b[1].setText("O");
            b[1].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[1].setEnabled(false);
        }
        else if (sb2.equals(sb5) && !(sb5.equals("X/O"))&& b[8].isEnabled()) {

            b[8].setText("O");
            b[8].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[8].setEnabled(false);
        }
        else if (sb2.equals(sb8) && !(sb8.equals("X/O")) && b[5].isEnabled()) {

            b[5].setText("O");
            b[5].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[5].setEnabled(false);
        }
        else if (sb5.equals(sb8) && !(sb5.equals("X/O"))&& b[2].isEnabled()) {

            b[2].setText("O");
            b[2].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[2].setEnabled(false);
        }
        else if (sb6.equals(sb7) && !(sb7.equals("X/O"))&& b[8].isEnabled()) {

            b[8].setText("O");
            b[8].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[8].setEnabled(false);
        }
        else if (sb6.equals(sb8) && !(sb8.equals("X/O"))&&  b[7].isEnabled()) {

            b[7].setText("O");
            b[7].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[7].setEnabled(false);
        }
        else if (sb7.equals(sb8) && !(sb8.equals("X/O"))&& b[6].isEnabled()) {

            b[6].setText("O");
            b[6].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[6].setEnabled(false);
        }
        else if (sb.equals(sb4) && !(sb4.equals("X/O"))&& b[8].isEnabled()) {

            b[8].setText("O");
            b[8].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[8].setEnabled(false);
        }
        else if (sb.equals(sb8) && !(sb8.equals("X/O"))&& b[4].isEnabled()) {

            b[4].setText("O");
            b[4].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[4].setEnabled(false);
        }
        else if (sb4.equals(sb8) && !(sb4.equals("X/O"))&& b[0].isEnabled()) {

            b[0].setText("O");
            b[0].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[0].setEnabled(false);
        }
        else if (sb2.equals(sb4) && !(sb2.equals("X/O"))&& b[6].isEnabled()) {

            b[6].setText("O");
            b[6].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[6].setEnabled(false);
        }
        else if (sb2.equals(sb6) && !(sb2.equals("X/O"))&& b[4].isEnabled() ) {

            b[4].setText("O");
            b[4].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[4].setEnabled(false);
        }
        else if (sb4.equals(sb6)&& !(sb4.equals("X/O"))&& b[2].isEnabled()) {

            b[2].setText("O");
            b[2].setTextColor(Color.parseColor("#FF5722"));
            ((Button)findViewById(R.id.button10)).setEnabled(true);
            ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
            ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
            ((Button)findViewById(R.id.button11)).setEnabled(false);
            b[2].setEnabled(false);
        }
        else {
            System.out.println("Else-PART");
            Random rand= new Random();
            for(int i=0;i<9;i++){
                int num=rand.nextInt(9);
                System.out.println("index-button:"+num);
                if(b[num].isEnabled()){
                    b[num].setText("O");
                    b[num].setTextColor(Color.parseColor("#FF5722"));
                    ((Button)findViewById(R.id.button10)).setEnabled(true);
                    ((Button)findViewById(R.id.button10)).setBackground(getDrawable(R.drawable.colortwo));
                    ((Button)findViewById(R.id.button11)).setBackground(getDrawable(R.drawable.colorfour));
                    ((Button)findViewById(R.id.button11)).setEnabled(false);
                    b[num].setEnabled(false);
                    break;
                }
            }
        }

        //o_counter++;
    }
}







