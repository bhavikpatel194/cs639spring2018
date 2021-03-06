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
    ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.animal_display, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void addImageClickListeners() {
        /**
         * Create an anonymous inner class that'll be used for our onClickListener.
         * See: https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
         * Also: https://stackoverflow.com/questions/355167/how-are-anonymous-inner-classes-used-in-java
         */
        View.OnClickListener imageListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //more information on ternary operator: https://www.sitepoint.com/java-ternary-operator/
                mSelectedImage = mSelectedImage == view ? null : (ImageView) view;
                int selectedImageId = mSelectedImage == null ? 0 : mSelectedImage.getId();
                //show the animal description if the animal's image id = selectedImageId. If not, hide it.
                mBirdDescription.setVisibility(selectedImageId == R.id.bird ? View.VISIBLE : View.INVISIBLE);
                mCatDescription.setVisibility(selectedImageId == R.id.cat ? View.VISIBLE : View.INVISIBLE);
                mDogDescription.setVisibility(selectedImageId == R.id.dog ? View.VISIBLE : View.INVISIBLE);
            }
        };

        //add above listener to animal images
        getView().findViewById(R.id.bird).setOnClickListener(imageListener);
        getView().findViewById(R.id.cat).setOnClickListener(imageListener);
        getView().findViewById(R.id.dog).setOnClickListener(imageListener);
    }

    private void addColorClickListeners() {
        /**
         * Create an anonymous inner class that'll be used for our onClickListener.
         * See: https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
         * Also: https://stackoverflow.com/questions/355167/how-are-anonymous-inner-classes-used-in-java
         */
        View.OnClickListener colorListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //if mSelectedImage == null, it means that no image is selected. Tell user to select an image
                if (mSelectedImage == null) {
                    Toast.makeText(getActivity(), R.string.please_select_an_animal_image_before_choosing_a_color,
                            Toast.LENGTH_LONG).show();
                    return;
                }
                //extract color from the view that we clicked on. Since the background of the view
                //was just a color value in XML, Android converts it to a ColorDrawable
                //cast the background to a ColorDrawable, extract the color from the Drawable, and
                //then assign that color to the animal
                int viewBackgroundColor = ((ColorDrawable)view.getBackground()).getColor();
                mSelectedImage.setColorFilter(viewBackgroundColor, PorterDuff.Mode.SRC_IN);
            }
        };

        //add above listener to views that'll be used for color picker
        getView().findViewById(R.id.red).setOnClickListener(colorListener);
        getView().findViewById(R.id.orange).setOnClickListener(colorListener);
        getView().findViewById(R.id.green).setOnClickListener(colorListener);
        getView().findViewById(R.id.blue).setOnClickListener(colorListener);
        getView().findViewById(R.id.yellow).setOnClickListener(colorListener);
}
