import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ConvertNameToShortName {

    Map<String, String> w2p = new HashMap<>();
    Map<String, String> p2w = new HashMap<>();

    public List<String> nameConvert(String[] namesInput) {
        List<String> res = new ArrayList<>();
        if (namesInput == null || namesInput.length == 0){
            return res;
        }
        for (String name : namesInput){
            String shortName = replaceName(name);
            res.add(shortName);
        }
        return res;
    }

    public String replaceName(String name){
        String[] parts = name.split("\\s+");
        String shortName = parts[0];
        boolean canShorten = false;

        if (p2w.containsKey(shortName)){

            for (int i = 1; i < parts.length; i++){
                shortName += " " + String.valueOf(parts[i].charAt(0)) + ".";
                if (!p2w.containsKey(shortName)){
                    canShorten = true;
                    break;
                }
            }
        } else {
            canShorten = true;
        }
        if (!canShorten){
            shortName = name;
        }

        w2p.put(name, shortName);
        p2w.put(shortName, name);

        return shortName;
    }

    public static void main(String[] args) {
        String input[] = {
                "Alex Chow",
                "Brian Chesky",
                "Dan Fisher",
                "Dan Sugarman",
                "David Zuckerman",
                "Eric Bayshore",
                "Jack Dagger",
                "James Lawrence",
                "Jesse Watson",
                "Justin Misson",
                "Lenny Button",
                "Mike Linderman",
                "Morgan Armstrong",
                "Nathan Hillshore",
                "Peter West",

                "Matthew Tim",
                "Eric Statenfield",
                "Dan Sticher",
                "Alan Pepper",
                "Rosie Spring",

                "Taylor Pips",
                "Danny Gilbert",
                "Eric Becker",
                "Mike Dew",
                "Dan Butter",
                "Dan Bayer",
                "Mike Lomo",
                "Jack Donoghue",
                "Eric Singer",
                "Mike Laffen",

                "Nathan Spring",
                "Kyle Van Esser",
                "Mary-Kate Sandra",
                "Matthew O'Connor",
                "Matthew O'Connor Smith",
                "Kyle Hurla",

                "Alex",
                "Ted",

                "Alex Chow"};
        ConvertNameToShortName cts = new ConvertNameToShortName();
        List<String> res = cts.nameConvert(input);
        for (String str : res){
            System.out.println(str);
        }

    }
}