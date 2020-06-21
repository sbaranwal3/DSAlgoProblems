import java.util.*;
import java.util.logging.Logger;

class TestCopy {
    static Test123 a;
    public static void main(String[] args){

//        List<Location> locations = new java.util.ArrayList<>();
//        locations.add(new Location("5-2", "STORE"));
//        locations.add(new Location("2193-2", "STORE"));
//        locations.add(new Location("2200-2", "STORE"));

//        System.out.println(a);
//        String x,y;
//        x = "abc";
//        y = "abc";
//        System.out.println(x==y);
//        x = x+"abc";
//        y = y+"abc";
//        System.out.println(x==y);

//        for (Student student : students){
//            System.out.println(student.name);
//            System.out.println(student.age);
//        }
//        Collections.sort(locations, Comparator.comparing(Location::getLocationId).thenComparing(Location::getLocationType));
//        for (Location location : locations){
//            System.out.println(location.getLocationId());
////            System.out.println(student.age);
//        }

        String locationIdStr = "3236,1139,2840,3237,1264,1885,1147,1866,3230,3259,2451,1401,1150,1344,2844,2811,2212,1148,3243,2380,1849,2850,1887,3312,3249,3321";
        String[] locations= getLocationIdsWithStoreCountLimit(locationIdStr);
        System.out.println(Arrays.toString(locations));
    }

    public static String[] getLocationIdsWithStoreCountLimit(String locationIdsStr) {
        List<String> locations = new LinkedList<>(Arrays.asList(locationIdsStr.split(",", 20 + 1)));
        if (locations.size() > 20) {
            locations.remove(20);
        }
        return locations.toArray(new String[0]);
    }
}


