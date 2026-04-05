import java.util.*;
public class MapusingHash {
    private Entity[] entitis;
    
    public MapusingHash(){
        entitis = new Entity[100];
    }
     public void put(String  key,String value){
        int hash= Math.abs(key.hashCode() % entitis.length);
         entitis(hash)= new Entity(key,value);
     }

     public String get(String key){
        int hash= Math.abs(key.hashCode() % entitis.length);
        if( entitis(hash)!=null && entitis(hash).key.equals(key)){
            return entitis(hash).value;
        }
        return null;
     }
     public void remove(String key){
        int hash= Math.abs(key.hashCode() % entitis.length);
        if( entitis(hash)!=null && entitis(hash).key.equals(key)){
            entitis(hash)=null;
        }
     }

     private class Entity{
        String key;
        String value;
        public Entity(String key,String value){
            this.key=key;
            this.value=value;
        }
     }

}
