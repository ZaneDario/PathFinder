import java.util.ArrayList;

public class Algorithm {

    Resources r;
    int[][] map;
    ArrayList<Path> paths = new ArrayList<>();

    public static void main(String[] args) {
        new Algorithm().run();
    }

    void run()
    {
        r = new Resources();
        map = new Map().map;
        paths.add(new Path(new ArrayList<>(), "0,0"));
        ManagePaths();
    }


    void ManagePaths()
    {
        for (int i = 0; i < paths.size(); i++) {

            String output = "0,0";
            Path p = paths.get(i);
            while(output != null)
            {
                output = Walk(p);
                p.path.add(output);
                System.out.println("The output was: " + output);
                p.ways.clear();
            }
            System.out.println("--------------------------");
        }

        /*for (int i = 0; i < paths.size(); i++) {
            System.out.println("????");
            if((paths.get(i).path.get(paths.get(i).path.size()-1).equals("5,5")))
            {
                for (int j = 0; j < paths.get(i).path.size(); j++) {
                    System.out.print(paths.get(i).path.get(j) + " ");
                }
            }
        }*/
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
                        && yNew >= 0 && yNew < map.length)
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
                        System.out.println("Possible: " + c);
                        w.add(c);
                    }

                }

            }
        }
        System.out.println("....................");
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
