package com.pace.cs639spring.hw2;

import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    int image[] = {R.drawable.bird, R.drawable.cat, R.drawable.dog, R.drawable.crocodile,
            R.drawable.elephant, R.drawable.fish, R.drawable.giraffe, R.drawable.lion,
            R.drawable.snake, R.drawable.monkey
    };
    String desc[] = {"This is a bird.",
            "This is a cat.", "This is a dog.",
            "This is a Crocodile", "This is an Elephant",
            "This is a fish", "This is a giraffe", "This is a Lion",
            "This is a Snake", "This is a Monkey"
    };
    TextView nTextAnimal;
    View v;
    ArrayList<HashMap<Integer,String>> hm;
    HashMap<Integer,String> m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nTextAnimal = findViewById(R.id.text_animal);
        getListContent();
        addColorClickListeners();
    }

    public void getListContent() {
        ListView listView = findViewById(R.id.list_animal);
        List<AnimalObjects> data = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            data.add(new AnimalObjects(image[i], desc[i]));
        }
        AnimalAdapter adapter = new AnimalAdapter(MainActivity.this, data);
        listView.setAdapter(adapter);
        listView.setItemsCanFocus(false);
        adapter.notifyDataSetChanged();


       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               v = (v == view ? null : view);
                int pos  = v == null? 0: position;
                AnimalObjects a = (AnimalObjects) parent.getItemAtPosition(position);
                nTextAnimal = view.findViewById(R.id.text_animal);
                Button b1 = view.findViewById(R.id.next_button);
                Button b2 = view.findViewById(R.id.delete_button);

                nTextAnimal.setVisibility(pos == position ? View.VISIBLE : View.INVISIBLE);
                b1.setVisibility(pos == position? View.VISIBLE : View.INVISIBLE);
                b2.setVisibility(pos == position ? View.VISIBLE : View.INVISIBLE);
            }
        });
    }

   private void addColorClickListeners() {//on click change the color
        View.OnClickListener colorListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (v == null) {
                    Toast.makeText(MainActivity.this, "Select Image", Toast.LENGTH_LONG).show();
                    return;
                }
                ImageView img = v.findViewById(R.id.image_animal);
                int viewBackgroundColor = ((ColorDrawable)view.getBackground()).getColor();
                img.setColorFilter(viewBackgroundColor, PorterDuff.Mode.SRC_IN);
            }
        };
        findViewById(R.id.red).setOnClickListener(colorListener);
        findViewById(R.id.blue).setOnClickListener(colorListener);
        findViewById(R.id.yellow).setOnClickListener(colorListener);
        findViewById(R.id.pink).setOnClickListener(colorListener);
        findViewById(R.id.cyan).setOnClickListener(colorListener);
    }

   public void OnAddition(View view) {//make toast if v is null and if not get the text
        if(v==null){
            Toast.makeText(MainActivity.this, "Select Animal", Toast.LENGTH_LONG).show();
            return;
        }
        EditText fact = findViewById(R.id.fact);
        String addFact = fact.getText().toString();
        m.put(v.getId(),addFact);
        hm.add(m);
        Toast.makeText(MainActivity.this, "Fact added", Toast.LENGTH_LONG).show();
    }

    public void addFact(View view){//on click add fact button add the fact
        if(v==null){
            Toast.makeText(MainActivity.this, "Select Animal", Toast.LENGTH_LONG).show();
            return;
        }
        int id = v.getId();
        if(m.containsKey(id)){
          nTextAnimal = v.findViewById(R.id.text_animal);
          nTextAnimal.setText(m.get(v.getId()));
        }
        else{
            Toast.makeText(getParent(), "No more Facts",Toast.LENGTH_LONG).show();
        }
    }

    public void deleteFact(View view){// on click delete button delete the fact
        if(v==null){
            Toast.makeText(MainActivity.this, "Select Animal", Toast.LENGTH_LONG).show();
            return;
        }
        int id = v.getId();
        if(m.containsKey(id)){
            m.remove(id);
            Toast.makeText(MainActivity.this, "Fact Deleted", Toast.LENGTH_LONG).show();
        }
    }

}