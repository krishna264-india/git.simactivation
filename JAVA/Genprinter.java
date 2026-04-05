public class Genprinter <T extends Cat> {
    private T thingsToPrint;

   public  Genprinter(T thingsToPrint){
    this.thingsToPrint=thingsToPrint;

    }

    public void something(){
        thingsToPrint.meow();
       // thingsToPrint.bark();
        System.out.println(thingsToPrint);
    }

    
}
