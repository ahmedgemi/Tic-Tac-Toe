package com.example.ago1.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class Game extends AppCompatActivity {


    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;

    TextView t1;

    int turn =1;  // 1= X , 0= O
    int total_move =0;

    int game_type ; // 1= players & computer  ,,, 2= two players

    Player p1 = new Player();
    Player p2 = new Player();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        b1= (Button ) findViewById(R.id.b1);
        b2= (Button ) findViewById(R.id.b2);
        b3= (Button ) findViewById(R.id.b3);
        b4= (Button ) findViewById(R.id.b4);
        b5= (Button ) findViewById(R.id.b5);
        b6= (Button ) findViewById(R.id.b6);
        b7= (Button ) findViewById(R.id.b7);
        b8= (Button ) findViewById(R.id.b8);
        b9= (Button ) findViewById(R.id.b9);

        t1= (TextView)  findViewById(R.id.textView2 );


       // Bundle b= getIntent().getExtras();
       // game_type = b.getInt("type");


    }

    private int check_win(){

        ArrayList<Integer> list ;

        for (int i =0 ; i<2;i++){

            if (i==0)
                list = p1.move;
            else
                list = p2.move;

            if (list.contains(1) && list.contains(2) && list.contains(3)) return i;

            else  if (list.contains(1) && list.contains(2) && list.contains(3)) return i;

            else  if (list.contains(4) && list.contains(5) && list.contains(6)) return i;

            else  if (list.contains(7) && list.contains(8) && list.contains(9)) return i;

            else  if (list.contains(1) && list.contains(4) && list.contains(7)) return i;

            else  if (list.contains(2) && list.contains(5) && list.contains(8)) return i;

            else  if (list.contains(3) && list.contains(6) && list.contains(9)) return i;

            else  if (list.contains(1) && list.contains(5) && list.contains(9)) return i;

            else  if (list.contains(3) && list.contains(5) && list.contains(7)) return i;
        }

        return -1;
    }

    private void save_move(int pos){

        if (turn == 0){

            p1.move.add(pos);

        }
        else{ // turn =1

            p2.move.add(pos);

        }

    }

private  void toggle(){

    if (turn == 0) {
        turn = 1;
        t1.setText("Turn: Player X");
    }
    else {
        turn = 0;
        t1.setText("Turn: Player O");
    }

}

    private void update( int pos){

        total_move ++;

        save_move(pos);

       int r= check_win();

        Intent i = new Intent (Game.this,Win.class);

        if (r !=-1){

            i.putExtra("winner",r);
            startActivity(i);
            finish();
        }

        else if (total_move >=9){

            i.putExtra("winner",-1);
            startActivity(i);
            finish();
        }



        if(game_type==1){

        }
        else { // two players


        }

        toggle();
    }

    private int get_turn(){

     int icon ;

        if (turn == 0){
            icon = R.drawable.o;

        }
        else{ // turn =1

            icon = R.drawable.x;

        }

        return icon;
    }

    public void click_b1(View v){

        int icon = get_turn();

        b1.setBackgroundResource(icon);
        b1.setEnabled(false);

        update(1);

    }

    public void click_b2(View v){
        int icon = get_turn();

        b2.setBackgroundResource(icon);
        b2.setEnabled(false);

        update(2);

    }

    public void click_b3(View v){

        int icon = get_turn();

        b3.setBackgroundResource(icon);
        b3.setEnabled(false);

        update(3);
    }

    public void click_b4(View v){

        int icon = get_turn();

        b4.setBackgroundResource(icon);
        b4.setEnabled(false);

        update(4);
    }

    public void click_b5(View v){

        int icon = get_turn();

        b5.setBackgroundResource(icon);
        b5.setEnabled(false);

        update(5);
    }

    public void click_b6(View v){

        int icon = get_turn();

        b6.setBackgroundResource(icon);
        b6.setEnabled(false);

        update(6);
    }

    public void click_b7(View v){

        int icon = get_turn();

        b7.setBackgroundResource(icon);
        b7.setEnabled(false);

        update(7);
    }
    public void click_b8(View v){

        int icon = get_turn();

        b8.setBackgroundResource(icon);
        b8.setEnabled(false);

        update(8);
    }

    public void click_b9(View v){

        int icon = get_turn();

        b9.setBackgroundResource(icon);
        b9.setEnabled(false);

        update(9);
    }


}
