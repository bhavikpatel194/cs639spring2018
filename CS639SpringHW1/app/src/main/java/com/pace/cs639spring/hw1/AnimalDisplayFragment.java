package com.pace.cs639spring.hw1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kachi on 1/31/18.
 */

public class AnimalDisplayFragment extends Fragment{
    TextView dogText, birdText, catText;
    ImageView bird, cat, dog;
    ImageButton greenButton, lightBlueButton, darkBlueButton, blackButton, pinkButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.animal_display, container, false);

        bird = view.findViewById(R.id.bird);                //getting the views by id's
        cat = view.findViewById(R.id.cat);
        dog = view.findViewById(R.id.dog);


        greenButton = view.findViewById(R.id.greenButton);
        lightBlueButton = view.findViewById(R.id.lightBlueButton);
        darkBlueButton = view.findViewById(R.id.darkBlueButton);
        pinkButton = view.findViewById(R.id.pinkButton);
        blackButton = view.findViewById(R.id.blackButton);

        birdText = view.findViewById(R.id.birdText);
        catText = view.findViewById(R.id.catText);
        dogText = view.findViewById(R.id.dogText);

        bird.setOnClickListener(new View.OnClickListener() {            //calling onClickListener on bird
            private boolean stateChanged1 = true;
            @Override
            public void onClick(View v) {
                if (stateChanged1) {                                    //on click make text visible and allow colour change
                    String birdDesc = "This is a Bird";
                    birdText.setText(birdDesc);
                    birdText.setVisibility(view.VISIBLE);
                    stateChanged1 = false;
                    changeColor();
                }
                else {
                    birdText.setVisibility(view.INVISIBLE);             //on again click make text invisible and freeze the color picker to not allow the change
                    stateChanged1 = true;
                    noChange();
                }
            }
        });
        cat.setOnClickListener(new View.OnClickListener() {             //calling onClickListener on cat
            private boolean stateChanged2 = true;
            @Override
            public void onClick(View v) {
                if (stateChanged2) {
                    String catDesc = "This is a Cat";
                    catText.setText(catDesc);
                    catText.setVisibility(view.VISIBLE);
                    stateChanged2 = false;
                    changeColor();
                }
                else {
                    catText.setVisibility(view.INVISIBLE);
                    stateChanged2 = true;
                    noChange();
                }
            }
        });
        dog.setOnClickListener(new View.OnClickListener() {             //calling onClickListener on dog
            private boolean stateChanged3 = true;
            @Override
            public void onClick(View v) {
                if (stateChanged3) {
                    String dogDesc = "This is a Dog";
                    dogText.setText(dogDesc);
                    dogText.setVisibility(view.VISIBLE);
                    stateChanged3 = false;
                    changeColor();
                } else {
                    dogText.setVisibility(view.INVISIBLE);
                    stateChanged3 = true;
                    noChange();
                }
            }
        });
        return view;
    }
    public void changeColor(){              //function for color change when the ImageView is clicked

        greenButton.setEnabled(true);
        lightBlueButton.setEnabled(true);
        darkBlueButton.setEnabled(true);
        pinkButton.setEnabled(true);
        blackButton.setEnabled(true);

            greenButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bird.setColorFilter(getActivity().getResources().getColor(R.color.colorSecondary));
                    cat.setColorFilter(getActivity().getResources().getColor(R.color.colorSecondary));
                    dog.setColorFilter(getActivity().getResources().getColor(R.color.colorSecondary));
                }
            });
            lightBlueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bird.setColorFilter(getActivity().getResources().getColor(R.color.colorPrimary));
                    cat.setColorFilter(getActivity().getResources().getColor(R.color.colorPrimary));
                    dog.setColorFilter(getActivity().getResources().getColor(R.color.colorPrimary));
                }
            });
            pinkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bird.setColorFilter(getActivity().getResources().getColor(R.color.colorAccent));
                    cat.setColorFilter(getActivity().getResources().getColor(R.color.colorAccent));
                    dog.setColorFilter(getActivity().getResources().getColor(R.color.colorAccent));
                }
            });
            blackButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bird.setColorFilter(getActivity().getResources().getColor(R.color.colorSecondaryDark));
                    cat.setColorFilter(getActivity().getResources().getColor(R.color.colorSecondaryDark));
                    dog.setColorFilter(getActivity().getResources().getColor(R.color.colorSecondaryDark));
                }
            });
            darkBlueButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    bird.setColorFilter(getActivity().getResources().getColor(R.color.colorPrimaryDark));
                    cat.setColorFilter(getActivity().getResources().getColor(R.color.colorPrimaryDark));
                    dog.setColorFilter(getActivity().getResources().getColor(R.color.colorPrimaryDark));
                }
            });
    }
    public void noChange(){                                 //when image is not selected, no color change to be made
        greenButton.setEnabled(false);
        lightBlueButton.setEnabled(false);
        darkBlueButton.setEnabled(false);
        blackButton.setEnabled(false);
        pinkButton.setEnabled(false);
    }
}
