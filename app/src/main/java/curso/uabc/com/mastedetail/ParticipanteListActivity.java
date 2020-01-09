package curso.uabc.com.mastedetail;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import curso.uabc.com.mastedetail.datos.Participante;
import curso.uabc.com.mastedetail.datos.Participantes;


/**
 * An activity representing a list of Participantes. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ParticipanteDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link ParticipanteListFragment} and the item details
 * (if present) is a {@link ParticipanteDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link ParticipanteListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class ParticipanteListActivity extends AppCompatActivity
        implements ParticipanteListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private ParticipanteListFragment porco;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante_list);

        if (findViewById(R.id.participante_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
           porco=  ((ParticipanteListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.participante_list));
            porco.setActivateOnItemClick(true);




        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link ParticipanteListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ParticipanteDetailFragment.ARG_ITEM_ID, id);
            ParticipanteDetailFragment fragment = new ParticipanteDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.participante_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ParticipanteDetailActivity.class);
            detailIntent.putExtra(ParticipanteDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                agregarItems();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void agregarItems() {
        Participante participante=new Participante();
        participante.setApellidoMaterno("Salazar");
        participante.setApellidoPaterno("Quintanilla");
        participante.setNombres("Roger Adan");
        participante.setaQueTeDedicas("Programador de Aplicaciones Moviles y super-heroe por las noches");
        participante.id=""+Participantes.ITEMS.size();
        Participantes.addItem(participante);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Participantes.adapter.notifyDataSetChanged();

            }
        });

    }

}
