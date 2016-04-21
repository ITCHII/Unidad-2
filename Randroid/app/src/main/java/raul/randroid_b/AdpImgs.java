package raul.randroid_b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Raúl Terrazas on 17/04/2016.
 */
public class AdpImgs extends BaseAdapter {
    private Context context;

    public AdpImgs(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Img.ITEMS.length;
    }

    @Override
    public Img getItem(int position) {
        return Img.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_itm, parent, false);
        }
        ImageView imagen = (ImageView) view.findViewById(R.id.imagen);
        TextView nombre = (TextView) view.findViewById(R.id.Nombre);
        final Img item = getItem(position);
        imagen.setImageResource(item.getIdDrawable());
        nombre.setText(item.getNombre());
        return view;
    }
}
