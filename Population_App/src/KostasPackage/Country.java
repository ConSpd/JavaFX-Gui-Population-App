package KostasPackage;

import java.util.Comparator;
import java.util.HashMap;

public class Country {

    private HashMap<Integer, Integer> DataBase;
    private int Population;
    private int Index;
    private String Variant;
    private String Name;
    private int Notes;
    private int Code;
    private int ParentCode;
    private int lastYear;
    private String Type = "Country/Area";

    public Country() {
        DataBase = new HashMap<>();
    }
    public void setIndex(int Index) {
        this.Index = Index;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setVariant(String Variant) {
        this.Variant = Variant;
    }
    public void setNotes(int Notes) {
        this.Notes = Notes;
    }
    public void setCode(int Code) {
        this.Code = Code;
    }
    public void setParentCode(int ParentCode) {
        this.ParentCode = ParentCode;
    }
    public void setPopulation(int Population) {
        this.Population = Population;
    }
    public void setLastYear(int lastYear){
        this.lastYear = lastYear;
    }    
    public int getIndex() {
        return Index;
    }
    public String getVariant() {
        return Variant;
    }
    public String getName() {
        return Name;
    }
    public int getNotes() {
        return Notes;
    }
    public int getCode() {
        return Code;
    }
    public String getType() {
        return Type;
    }
    public int getParentCode() {
        return ParentCode;
    }
    public int getPopulation() {
        return Population;
    }
    public int getLastYear(){
        return lastYear;
    }
    public int getDBPopulation(int spot) {
        return DataBase.get(spot);
    }
    public int getDBSize(){
        return DataBase.size();
    }
    public void addToDatabase(int Year, int Population) {
        DataBase.put(Year, Population);
    }
}

