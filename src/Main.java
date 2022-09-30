import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        String[] firstLine = num.split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int s = Integer.parseInt(firstLine[2]);
        int max = (Math.max(n,m));

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            String[] splitLine = in.nextLine().split(" ");
            String a = splitLine[0];
            String b = splitLine[1];
            if (!a.equals("-")) {
                first.add(Integer.parseInt(a));
            }
            if (!b.equals("-")) {
               second.add(Integer.parseInt(b));
            }
        }
        in.close();

        first.removeIf(element -> element>s);
        second.removeIf(element -> element>s);



        int res = find(first,second,s);
        System.out.println(res);
    }

    public static int find(ArrayList<Integer> first,ArrayList<Integer> second,int s) {
        int sizeFirst=first.size();
        int sizeSecond=second.size();
        if (sizeFirst+sizeSecond==0) return 0;
        int a,b;
        if (sizeFirst==0){
            a = 0;
        }
        else a = first.get(sizeFirst-1);
        if (sizeSecond==0){
            b = 0;
        }
        else b = second.get(sizeSecond-1);


        while (a+b>s){
            if (a==0 && b == 0){
                break;
            }
            double valueA = (double) a / sizeFirst;
            double valueB = (double) b / sizeSecond;
            if (valueA > valueB) {
                first.remove(sizeFirst - 1);
            } else {
                second.remove(sizeSecond - 1);
            }
            sizeFirst=first.size();
            sizeSecond=second.size();
            if (sizeFirst==0){
                a = 0;
            }
            else a = first.get(sizeFirst-1);
            if (sizeSecond==0){
                b = 0;
            }
            else b = second.get(sizeSecond-1);
        }
        return sizeFirst+sizeSecond;
    }
}


