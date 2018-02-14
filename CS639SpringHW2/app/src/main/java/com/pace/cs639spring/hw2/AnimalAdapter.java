package com.pace.cs639spring.hw2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bhavi on 2/8/2018.
 */

public class AnimalAdapter extends BaseAdapter {
    Context mContext;
    List<AnimalObjects> mAnimalObjects;

    char[] i = {1,2,3,4,5};
    static class ViewHolder{
        ImageView mAnimalImage;
        TextView mAnimalText;
        Button mNextFact;
        Button mDeleteFact;

        ViewHolder(ImageView animalImage, TextView animalText, Button nextFact, Button deleteFact ){
            mAnimalImage = animalImage;
            mAnimalText = animalText;
            mNextFact = nextFact;
            mDeleteFact = deleteFact;
        }

    }

    AnimalAdapter(Context context, List<AnimalObjects> animalObjects){
        mContext = context;
        mAnimalObjects = animalObjects;
    }
    @Override
    public int getCount() {
        return mAnimalObjects.size();
    }

    @Override
    public Object getItem(int position) {
        return mAnimalObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = View.inflate(mContext,R.layout.list_view,null);
            ViewHolder viewHolder = new ViewHolder((ImageView) convertView.findViewById(R.id.image_animal),(TextView) convertView.findViewById(R.id.text_animal),(Button) convertView.findViewById(R.id.next_button),(Button) convertView.findViewById(R.id.delete_button));
            convertView.setTag(viewHolder);
        }
        AnimalObjects objects = (AnimalObjects) getItem(position);
        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.mAnimalImage.setImageResource(objects.mColor);//create an array to get all the Drawables. Also an array to add the facts.
        viewHolder.mAnimalText.setText(objects.mdescription);
        return convertView;
    }
}
