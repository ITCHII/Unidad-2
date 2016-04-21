package raul.randroid_b;

/**
 * Created by Raúl Terrazas on 17/04/2016.
 */
public class Img {
    private String nombre;
    private int idDrawable;
    public Img(String nombre,int idDrawable) {
        this.idDrawable = idDrawable;
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public int getIdDrawable() {
        return idDrawable;
    }
    public int getId() {
        return nombre.hashCode();
    }
    public static Img[] ITEMS = {
            new Img("boy",R.mipmap.ic_boy),
            new Img("launcher",R.mipmap.ic_launcher),
            new Img("star",R.mipmap.ic_star),
            new Img("batery",R.mipmap.ic_batery),
            new Img("airplane",R.mipmap.ic_airplane)
    };
    public static Img getItem(int id) {
        for (Img item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
