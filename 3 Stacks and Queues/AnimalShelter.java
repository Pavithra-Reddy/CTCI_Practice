import java.util.*;
class AnimalShelter extends Queue{
  private static class  Animal{
    private String name;
    private String type;
    private int arrivalTime;

    Animal(String name, String type){
      this.name = name;
      this.type = type;
      this.arrivalTime = arrTime++;
    }

    public String getName(){
      return this.name;
    }
    public int getArrivalTime(){
      return this.arrivalTime;
    }
  }

  private static Queue<Animal> dogQueue = new Queue<Animal>();
  private static Queue<Animal> catQueue= new Queue<Animal>();
  private static int arrTime = 0;

  public static void main(String args[]){
      Scanner sc = new Scanner(System.in);

      System.out.println("Menu\n1. Enqueue\n2. dequeueAny\n3. dequeueCat\n4. dequeueDog\n5. End");
      while(true){
        try{
          System.out.println("Enter option : ");
          int op = sc.nextInt();
          switch(op){
            case 1: System.out.print("Enter name and type(dog or cat) respectively: ");
                    String name = sc.next();
                    String type = sc.next();
                    System.out.println(name);
                    System.out.println(type);
                    enqueue(name, type);
                    break;
            case 2: System.out.println(dequeueAny() + " removed.");
                    break;
            case 3: System.out.println(dequeueCat() + " removed.");
                    break;
            case 4: System.out.println(dequeueDog() + " removed.");
                    break;
            case 5: return;
            default: break;
          }
        }
        catch(Exception e){
          System.out.println("Queue is empty");
        }
      }
  }

  private static void enqueue(String name, String type){
    Animal a = new Animal(name, type);
    if("dog".equalsIgnoreCase(type)){
      dogQueue.push(a);
    }
    else if("cat".equalsIgnoreCase(type)){
      catQueue.push(a);
    }
    else{
      System.out.println("Not a valid type");
    }
  }

  private static String dequeueAny() throws EmptyQueueException{
    if(catQueue.isEmpty()){
      return dequeueDog();
    }
    if(dogQueue.isEmpty()){
      return dequeueCat();
    }
    Animal cat = catQueue.peek();
    Animal dog = dogQueue.peek();
    if(cat.getArrivalTime() < dog.getArrivalTime()){
      return dequeueCat();
    }
    else{
      return dequeueDog();
    }
  }

  private static String dequeueCat() throws EmptyQueueException{
    Animal a = catQueue.pop();
    return a.getName();
  }

  private static String dequeueDog() throws EmptyQueueException{
    Animal a = dogQueue.pop();
    return a.getName();
  }
}
