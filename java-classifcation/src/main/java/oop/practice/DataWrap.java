/*This Class has the purpose to wrap the whole data set, and store each character in a list */

package oop.practice;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class DataWrap {
    @JsonProperty("data")
    List<Character> data;
    
    public void setData(List<Character> data) {
        this.data = data;
    }
    public List<Character> getData() {
        return data;
    }
}
