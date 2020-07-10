import java.util.ArrayList;

class Path {

    ArrayList<String> path;
    ArrayList<String> ways = new ArrayList<>();

    Path(ArrayList<String> p, String newTile)
    {
        path = new ArrayList<>(p);
        path.add(newTile);
    }

}
