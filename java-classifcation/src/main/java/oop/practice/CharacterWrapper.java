/*This Class has the purpose to wrap the whole data set, and store each character in a list
 * It also contains methods for querying and classifying the data.
 */

package oop.practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CharacterWrapper {
    private List<Character> data;
    
    public void setData(List<Character> data) {
        this.data = data;
    }
    public List<Character> getData() {
        return data;
    }


    public List<Character> fetchById(int ID){
        List<Character> CharacterListBuffer = new ArrayList<>();
        for (Character c : data){
            if (c.getId() == ID){
                CharacterListBuffer.add(c);
                return CharacterListBuffer;
            }
        }
        return CharacterListBuffer;
    }
    // Fetch all Humanoids
    public List<Character> fetchByHumanoidCharacter(){
        List<Character> CharacterListBuffer = new ArrayList<>();
        for (Character c : data){
            if (c.isHumanoid() == null){
                continue;
            }
            if (c.isHumanoid()){
                CharacterListBuffer.add(c);
            }
        }
        return CharacterListBuffer;
    }
    // Fetch by Age
    public List<Character> fetchByAgeCharacter(int age){
        List<Character> CharacterListBuffer = new ArrayList<>();

        for (Character c : data){
            if (c.getAge() == -1){
                continue;
            }
            if (c.getAge() == age){
                CharacterListBuffer.add(c);
            }
        }
        return CharacterListBuffer;
    }
    public List<Character> fetchByEvenId(){
        List<Character> CharacterListBuffer = new ArrayList<>();

        for (Character c : data){
            if (c.getId() % 2 == 0){
                CharacterListBuffer.add(c);
            }
        }
        return CharacterListBuffer;
    }
    public List<Character> fetchByOddId(){
        List<Character> CharacterListBuffer = new ArrayList<>();

        for (Character c : data){
            if (c.getId() % 2 != 0){
                CharacterListBuffer.add(c);
            }
        }
        return CharacterListBuffer;
    }
    // This method tries to find at least one matching trait with the query
    public List<Character> fetchByTraits(String[] traits) {
        List<Character> characterListBuffer = new ArrayList<>();

        for (Character c : data) {
            if (c.getTraits() == null){
                continue;
            }
            // Check if any of the traits match
            for (String trait : traits) {
                if (Arrays.asList(c.getTraits()).contains(trait.toUpperCase())) {
                    characterListBuffer.add(c);
                    break;
                }
            }
        }
        return characterListBuffer;
    }
    // Case insensitive query
    public List<Character> fetchByPlanet(String planet) {
        List<Character> characterListBuffer = new ArrayList<>();

        for (Character c : data) {
            if (c.getPlanet() == null){
                continue;
            }
            if (c.getPlanet().toLowerCase().equals(planet.toLowerCase())){
                characterListBuffer.add(c);
            }
        }

        return characterListBuffer;
    }
    // Fetch by Wookie species (Star Wars Universe)
    public List<Character> fetchByWookie() {
        List<Character> characterListBuffer = new ArrayList<>();
        for (Character c : data) {
            if ( (c.isHumanoid()==null || !c.isHumanoid()) && ("Kashyyk".equalsIgnoreCase(c.getPlanet()) || c.getPlanet() == null) && c.getAge() >= 0 && c.getAge() <= 400 && 
                (c.getTraits() == null || Arrays.asList(c.getTraits()).contains("HAIRY") || Arrays.asList(c.getTraits()).contains("TALL"))) {
                characterListBuffer.add(c);
            }
        }
        return characterListBuffer;
    }

    // Fetch by Ewok species (Star Wars Universe)
    public List<Character> fetchByEwok() {
        List<Character> characterListBuffer = new ArrayList<>();
        for (Character c : data) {
            if ((c.isHumanoid()==null || !c.isHumanoid()) && ("Endor".equalsIgnoreCase(c.getPlanet())|| c.getPlanet() == null) && c.getAge() >= 0 && c.getAge() <= 60 && 
                (c.getTraits() == null || Arrays.asList(c.getTraits()).contains("SHORT") || Arrays.asList(c.getTraits()).contains("HAIRY"))) {
                characterListBuffer.add(c);
            }
        }
        return characterListBuffer;
    }

    // Fetch by Asgardian species (Marvel Universe)
    public List<Character> fetchByAsgardian() {
        List<Character> characterListBuffer = new ArrayList<>();
        for (Character c : data) {
            if ((c.isHumanoid()==null || c.isHumanoid()) && ("Asgard".equalsIgnoreCase(c.getPlanet())|| c.getPlanet() == null) && c.getAge() >= 0 && c.getAge() <= 5000 && 
                (c.getTraits() == null || Arrays.asList(c.getTraits()).contains("BLONDE") || Arrays.asList(c.getTraits()).contains("TALL"))) {
                characterListBuffer.add(c);
            }
        }
        return characterListBuffer;
    }

    // Fetch by Betelgeusian species (Hitchhiker's Guide Universe)
    public List<Character> fetchByBetelgeusian() {
        List<Character> characterListBuffer = new ArrayList<>();
        for (Character c : data) {
            if ((c.isHumanoid()==null || c.isHumanoid()) && ("Betelgeuse".equalsIgnoreCase(c.getPlanet())|| c.getPlanet() == null) && c.getAge() >= 0 && c.getAge() <= 100 &&
                (c.getTraits() == null || Arrays.asList(c.getTraits()).contains("EXTRA_ARMS") || Arrays.asList(c.getTraits()).contains("EXTRA_HEAD"))) {
                characterListBuffer.add(c);
            }
        }
        return characterListBuffer;
    }

    // Fetch by Vogon species (Hitchhiker's Guide Universe)
    public List<Character> fetchByVogon() {
        List<Character> characterListBuffer = new ArrayList<>();
        for (Character c : data) {
            if ((c.isHumanoid()==null || !c.isHumanoid()) && ("Vogsphere".equalsIgnoreCase(c.getPlanet())|| c.getPlanet() == null) && c.getAge() >= 0 && c.getAge() <= 200 && 
                (c.getTraits() == null || Arrays.asList(c.getTraits()).contains("GREEN") || Arrays.asList(c.getTraits()).contains("BULKY"))) {
                characterListBuffer.add(c);
            }
        }
        return characterListBuffer;
    }

    // Fetch by Elf species (Lord of the Rings Universe)
    public List<Character> fetchByElf() {
        List<Character> characterListBuffer = new ArrayList<>();
        for (Character c : data) {
            if ((c.isHumanoid()==null || c.isHumanoid()) && ("Earth".equalsIgnoreCase(c.getPlanet()) || c.getPlanet() == null) && (c.getTraits() == null || 
                Arrays.asList(c.getTraits()).contains("BLONDE") || Arrays.asList(c.getTraits()).contains("POINTY_EARS"))) {
                characterListBuffer.add(c);
            }
        }
        return characterListBuffer;
    }

    // Fetch by Dwarf species (Lord of the Rings Universe)
    public List<Character> fetchByDwarf() {
        List<Character> characterListBuffer = new ArrayList<>();
        for (Character c : data) {
            if ((c.isHumanoid()==null || c.isHumanoid()) && ("Earth".equalsIgnoreCase(c.getPlanet())|| c.getPlanet() == null) && c.getAge() >= 0 && c.getAge() <= 200 && 
                (c.getTraits() == null || Arrays.asList(c.getTraits()).contains("SHORT") || Arrays.asList(c.getTraits()).contains("BULKY"))) {
                characterListBuffer.add(c);
            }
        }
        return characterListBuffer;
    }

}
