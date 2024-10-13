/*This Class has the purpose to wrap the whole data set, and store each character in a list
 * It also contains methods for querying and classifying the data.
 */

package oop.practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class DataWrapper {
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
}
