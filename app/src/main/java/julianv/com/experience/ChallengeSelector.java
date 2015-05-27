package julianv.com.experience;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import adapters.ImageAdapter;

/**
 * @author JulianV
 * @link https://github.com/julivillaquiran
 */

public class ChallengeSelector extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_selector);

        GridView gridview = (GridView) findViewById(R.id.challengeSelectorGrid);// crear el
        // gridview a partir del elemento del xml gridview

        gridview.setAdapter(new ImageAdapter(this));// con setAdapter se llena
        // el gridview con datos. en
        // este caso un nuevo objeto de la clase ImageAdapter,
        // que está definida en otro archivo
        // para que detecte la pulsación se le añade un listener de itemClick
        // que recibe un OniTemClickListener creado con new

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // dentro de este listener difinimos la función que se ejecuta al
            // hacer click en un item
            // el metodo pertenece a AdapterView, es decir, es
            // AdapterView.OnItemClickListener
            // dentro de este, tenemos el método onItemClick, que es el que se
            // invoca al pulsar un item del AdapterView
            // esa función recibe el objeto padre, que es un adapterview en el
            // que se ha pulasdo, una vista, que es el elemento sobre el que se
            // ha pulsado,
            // una posicion, que es la posicion del elemento dentro del adapter,
            // y un id, que es el id de fila del item que se ha pulsado
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // Toast para mostrar un mensaje. Escribe el nombre de tu clase
                // si no la llamaste MainActivity.
                // Al hacer click, esta mensaje muestra la posición
                Intent intent = new Intent(ChallengeSelector.this, ChallengeDescription.class);
                Bundle b = new Bundle();
                b.putInt("ChallengeSelected", position); //Your id
                intent.putExtra("ChallengeSelected", position); //Put your id to your next Intent

                startActivity(intent);
                //finish();

                /*Toast.makeText(ChallengeSelector.this, "" + position, Toast.LENGTH_SHORT)
                        .show();*/

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_challenge_selector, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
