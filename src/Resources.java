public class Resources {

    String SetText(int x, int y)
    {
        return (x+","+y);
    }

    int[] GetValue(String text)
    {
       String[] t = text.split(",");
       int[] v = new int[2];
       v[0] = Integer.parseInt(t[0]);
       v[1] = Integer.parseInt(t[1]);

        return v;
    }
}
