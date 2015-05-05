package curso.uabc.com.mastedetail.datos;

import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhendor on 5/4/15.
 */
public class Participantes {

    public static List<Participante> ITEMS = new ArrayList<Participante>();
    public static Map<String, Participante> ITEM_MAP = new HashMap<String, Participante>();
public static MiAdaptador adapter;

static{

    Participante participante=new Participante();
    participante.setApellidoMaterno("Canales");
    participante.setApellidoPaterno("Sosa");
    participante.setNombres("Leafar Odnesor");
    participante.setaQueTeDedicas("Programador de Aplicaciones Moviles y degustador de tacos de pastor");
    participante.id=""+Participantes.ITEMS.size();
    Participantes.addItem(participante);
}
    public static void addItem(Participante item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static void removeItem(Participante item){
        ITEMS.remove(item);

        ITEM_MAP.remove(item.id);
        adapter.notifyDataSetChanged();

    }

    public static void removeItem(int indexItem){
        ITEMS.remove(""+indexItem);

        ITEM_MAP.remove(indexItem);
        adapter.notifyDataSetChanged();


    }

    public static void setItem(Participante newItem,int index){
        ITEMS.set(index,newItem);
        ITEM_MAP.put("" + index, newItem);
        adapter.notifyDataSetChanged();


    }


    public static void setAdapter( MiAdaptador adapter) {
        Participantes.adapter= adapter;
        adapter.notifyDataSetChanged();

    }
}
