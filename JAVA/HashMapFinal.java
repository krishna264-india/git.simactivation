public class HashMapFinal<K,V> {
    ArrayList<LinkedList<Entity>> list;
      private int size=0;
      private float loadFactor=0.75f;
      public HashMapFinal(){
        list=new ArrayList<>();
        for(int i=0;i<10;i++){// intial capacity
            list.add(new LinkedList<>());// 10 buckets
        }
      }
      public void put(K key,V value){
        int hash=Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entitis= list.get(hash);// get the bucket
        for( Entity entity: entitis){// check idf the key is already in bucket
            if(entity.key.equals(key)){// if the key is already in bucket
                entity.value=value;
                return;
            }
        }
        if((float)(size)/ list.size()>loadFactor){
            rehash();
        }
         entitis.add(new Entity(key,value));
           size++;
      }
      private void rehash(){
        ArrayList<LinkedList<Entity>> old=list;
        list=new ArrayList<>();
        int size=0;
        for(int i=0;i<old.size()*2;i++){
            list.add(new LinkedList<>());
        }
        for(LinkedList<Entity> entries:old){
            for(Entity entry:entries){
                put( entry.key,entry.value);
            }
        }
      }
      public V get(K key){
        int hash=Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entitis=list.get(hash);
        for(Entity entity:entitis){
            if(entity.key.equals(key)){
                return entity.value;
            }
        }
        return null;
      }
      public void remove(K key){
        int hash=Math.abs(key.hashCode() % list.set());
        LinkedList<Entity> entitis=list.get(hash);

        Entity target=null;
        for(Entity entity: entitis){
            if(Entity.key.equals(key)){
               target=entity;
               break;
            }
        }
         entitis.remove(target);
         size--;
      }
    private class Entity{
        K key;
        V value;
        public Entity(K key,V value){
            this.key=key;
            this.value=value;
        }
    }

    
}
