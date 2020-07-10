import java.util.ArrayList;

public class Algorithm {

    Resources r;
    int[][] map;
    ArrayList<Path> paths = new ArrayList<>();
    String source = "0,0";
    String destiny = "0,6";

    public static void main(String[] args) {
        new Algorithm().run();
    }

    void run()
    {
        r = new Resources();
        map = new Map().map;
        paths.add(new Path(new ArrayList<>(), source));
        ManagePaths();
    }


    void ManagePaths()
    {
        for (int i = 0; i < paths.size(); i++) {

            String output = source;
            Path p = paths.get(i);
            while(output != null && !(output.equals(destiny)))
            {
                output = Walk(p);
                p.path.add(output);
                System.out.println("The chosen one is: " + output);
                System.out.println(".............. Finish checking of this four possible directions.");
                p.ways.clear();
            }
            System.out.println("--------------------------------- Finish checking this path.");
        }

        for (int i = 0; i < paths.size(); i++) {

            Path p = paths.get(i);
            int index = p.path.size()-1;
            String lastTile = p.path.get(index);

            if(lastTile != null && lastTile.equals(destiny))
            {
                for (int j = 0; j < paths.get(i).path.size(); j++) {
                    System.out.print(paths.get(i).path.get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    String Walk(Path p)
    {
        int x = r.GetValue(p.path.get(p.path.size()-1))[0];
        int y = r.GetValue(p.path.get(p.path.size()-1))[1];
        ArrayList<String> w = p.ways;

        for (int i = 0; i < 4; i++)
        {
            int xNew = 0; int yNew = 0;
            if(i == 0){ xNew=x+1; yNew=y;}
            if(i == 1){ xNew=x-1; yNew=y;}
            if(i == 2){ xNew=x; yNew=y+1;}
            if(i == 3){ xNew=x; yNew=y-1;}

            System.out.println(xNew+","+yNew);

            if(xNew >= 0 && xNew < map.length
                        && yNew >= 0 && yNew < map[0].length)
            {
                if(map[xNew][yNew] == 0)
                {
                    String c = r.SetText(xNew, yNew);
                    boolean contained = false;

                    for (String t: p.path)
                    {
                        if(t.equals(c))
                        {
                            contained = true;
                            break;
                        }

                    }

                    if(!contained)
                    {
                        System.out.println("Is a valid direction: " + c);
                        w.add(c);
                    }

                }

            }
        }

        if(w.size() > 1)
        {
            for(int i = 1; i < w.size(); i++)
            {
                paths.add(new Path(p.path, w.get(i)));
            }
            return w.get(0);
        }
        else if(w.size() == 1)
            return w.get(0);
        else
            return null;
    }
}
