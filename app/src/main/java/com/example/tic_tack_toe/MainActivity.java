package com.example.tic_tack_toe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tic_tack_toe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final List<int[]> combinations = new ArrayList<>();
    private int[] boxpositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int playerturn = 1;
    private int totalselectedbox = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        combinations.add(new int[]{0, 1, 2});
        combinations.add(new int[]{3, 4, 5});
        combinations.add(new int[]{6, 7, 8});
        combinations.add(new int[]{0, 3, 6});
        combinations.add(new int[]{1, 4, 7});
        combinations.add(new int[]{2, 5, 8});
        combinations.add(new int[]{2, 4, 6});
        combinations.add(new int[]{0, 4, 8});

        String getplayeronename = getIntent().getStringExtra("playerone");
        String getplayertwoname = getIntent().getStringExtra("playertwo");

        binding.playeronename.setText(getplayeronename);
        binding.playertwoname.setText(getplayertwoname);

        binding.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(0)){
                    performAction((ImageView) view,0);
                }
            }
        });

        binding.img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(1)){
                    performAction((ImageView) view,1);
                }
            }
        });

        binding.img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(2)){
                    performAction((ImageView) view,2);
                }
            }
        });

        binding.img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(3)){
                    performAction((ImageView) view,3);
                }
            }
        });

        binding.img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(4)){
                    performAction((ImageView) view,4);
                }
            }
        });

        binding.img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(5)){
                    performAction((ImageView) view,5);
                }
            }
        });

        binding.img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(6)){
                    performAction((ImageView) view,6);
                }
            }
        });

        binding.img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(7)){
                    performAction((ImageView) view,7);
                }
            }
        });

        binding.img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(8)){
                    performAction((ImageView) view,8);
                }
            }
        });

    }

    private void performAction(ImageView imageView, int selectedboxposition) {
        boxpositions[selectedboxposition] = playerturn;

        if (playerturn == 1) {
            imageView.setImageResource(R.drawable.ximage);

            if(checkresult()){
                resultActivity resultActivity = new resultActivity(MainActivity.this,binding.playeronename.getText().toString() +" won the game",MainActivity.this);
                resultActivity.setCancelable(false);
                resultActivity.show();
            }else if(totalselectedbox == 9){
                resultActivity resultActivity = new resultActivity(MainActivity.this,"Koi Nu Na Thayu !",MainActivity.this);
                resultActivity.setCancelable(false);
                resultActivity.show();
            }else {
                chanegplayerturn(2);
                totalselectedbox++;
            }
        }else{
            imageView.setImageResource(R.drawable.oimage);

            if(checkresult()){
                resultActivity resultActivity = new resultActivity(MainActivity.this,binding.playertwoname.getText().toString() +" won the game",MainActivity.this);
                resultActivity.setCancelable(false);
                resultActivity.show();
            }else if(totalselectedbox == 9){
                resultActivity resultActivity = new resultActivity(MainActivity.this,"Koi Nu Na Thayu !",MainActivity.this);
                resultActivity.setCancelable(false);
                resultActivity.show();
            }else {
                chanegplayerturn(1);
                totalselectedbox++;
            }

        }
    }

    private void chanegplayerturn(int currentplayerturn) {
        playerturn = currentplayerturn;
        if (playerturn == 1) {
            binding.playeronelayout.setBackgroundResource(R.drawable.black_border);
            binding.playertwolayout.setBackgroundResource(R.drawable.white_box);
        } else {
            binding.playertwolayout.setBackgroundResource(R.drawable.black_border);
            binding.playeronelayout.setBackgroundResource(R.drawable.white_box);
        }
    }

    private boolean checkresult() {
        boolean response = false;
        for (int i = 0; i < combinations.size(); i++) {
            final int[] combination = combinations.get(i);

            if (boxpositions[combination[0]] == playerturn && boxpositions[combination[1]] ==playerturn &&
                    boxpositions[combination[2]] == playerturn) {
                response = true;

            }
        }
        return response;

    }

    private boolean isboxselectable(int boxposition){
        boolean response = false;
        if(boxpositions[boxposition] == 0){
            response = true;
        }
        return response;
    }

    public void resetgame(){
        boxpositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        totalselectedbox = 1;
        playerturn =1;

        binding.img1.setImageResource(R.drawable.white_box);
        binding.img2.setImageResource(R.drawable.white_box);
        binding.img3.setImageResource(R.drawable.white_box);
        binding.img4.setImageResource(R.drawable.white_box);
        binding.img5.setImageResource(R.drawable.white_box);
        binding.img6.setImageResource(R.drawable.white_box);
        binding.img7.setImageResource(R.drawable.white_box);
        binding.img8.setImageResource(R.drawable.white_box);
        binding.img9.setImageResource(R.drawable.white_box);
    }


}


























