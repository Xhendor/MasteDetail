package curso.uabc.com.mastedetail.datos;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by xhendor on 5/4/15.
 */
public class MiAdaptador extends ArrayAdapter<Participante> {

    public MiAdaptador(Context context, int resource) {
        super(context, resource);
    }

    public MiAdaptador(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public MiAdaptador(Context context, int resource, Participante[] objects) {
        super(context, resource, objects);
    }

    public MiAdaptador(Context context, int resource, int textViewResourceId, Participante[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public MiAdaptador(Context context, int resource, List<Participante> objects) {
        super(context, resource, objects);
    }

    public MiAdaptador(Context context, int resource, int textViewResourceId, List<Participante> objects) {
        super(context, resource, textViewResourceId, objects);
    }


    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
