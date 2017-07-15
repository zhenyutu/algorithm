package cn.tzy.app.coderInterviewGuide.chapter1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tuzhenyu on 17-7-15.
 * @author tuzhenyu
 */
public class CatDogQueue {
    private Queue<WapperPet> catQueue;
    private Queue<WapperPet> dogQueue;
    private int count = 0;

    public CatDogQueue(){
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
    }

    public void add(Pet pet){
        if ("cat".equals(pet.getType()))
            catQueue.add(new WapperPet(new Cat(),count++));
        else
            dogQueue.add(new WapperPet(new Dog(),count++));
    }

    public Pet pullAll(){
        if (!catQueue.isEmpty()&&!dogQueue.isEmpty()){
            if (catQueue.peek().getCount()<dogQueue.peek().getCount())
                return catQueue.poll().getPet();
            else
                return dogQueue.poll().getPet();
        }else if (catQueue.isEmpty() && !dogQueue.isEmpty()){
            return dogQueue.poll().getPet();
        }else
            return catQueue.poll().getPet();
    }

    public Pet pullCat(){
        return catQueue.poll().getPet();
    }

    public Pet pullDog(){
        return dogQueue.poll().getPet();
    }

    public boolean isEmpty(){
        return catQueue.isEmpty() && dogQueue.isEmpty();
    }

    public boolean isCatEmpty(){
        return catQueue.isEmpty();
    }

    public boolean isDogEmpty(){
        return dogQueue.isEmpty();
    }

    public static void main(String[] args) {
        CatDogQueue queue = new CatDogQueue();

        queue.add(new Cat());
        queue.add(new Dog());
        queue.add(new Cat());
        queue.add(new Dog());

        System.out.println(queue.pullAll().getType());
        System.out.println(queue.pullAll().getType());

    }
}

class WapperPet{
    private Pet pet;
    private int count;

    public WapperPet(Pet pet, int count){
        this.count = count;
        this.pet = pet;
    }

    public Pet getPet(){
        return this.pet;
    }

    public int getCount(){
        return this.count;
    }

    public String getType(){
        return pet.getType();
    }
}

class Pet{
    private String type;

    public Pet(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}

class Cat extends Pet{
    public Cat(){
        super("cat");
    }
}

class Dog extends Pet{
    public Dog(){
        super("dog");
    }
}
