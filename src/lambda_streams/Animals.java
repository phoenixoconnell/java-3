package lambda_streams;

import java.util.*;
import java.util.stream.Collectors;

class Animals {

    //This class will be using streams.
    static List<String> animals = Arrays.asList("peacoCK","rabbit","chiwawa","OranguTAN","vipeR","cobra","paNDa","bUffalo","DeeR","maLLard");

    public static void main(String[] args) {
        System.out.println("original animals : " + animals);
        //clean up the animals array by using the capsFirst() method. follow instructions in the method definition.
        List<String> cleaned = capsFirst(animals, false);
        System.out.println(cleaned);
        //do not modify these addAnimal() method invocations
        addAnimal("rEIndeeR");
        addAnimal("Platypus");
        addAnimal("frOg");
        addAnimal("lEOpArD");
        //---------------------------------------
        capsFirst(animals,true);
        System.out.println(animals);
        List<String> lowered = lowerFirst(animals,false);
        System.out.println(lowered);
    }

    static List<String> capsFirst(List<String> animaList, boolean mutate) {
        //clean up the animals list so that the first letter is capitalized, and all the other letters are lowercased. Use a stream to accomplish this task.  Also, the 2nd parameter of this function is a boolean.  use this boolean 'flag' to determine whether or not to 'mutate' the original animals array stored as a static class field.  if the flag is set to 'true', mutate the animals and return the animals out of the function.  if it is false, create a copy of the animals, perform your stream operations on the copy, and return the copy of animals out of the function, WITHOUT modifying the original animals array.
        if(!mutate) {
            List<String> temp;
            temp = animaList.stream().map(a -> {
                String[] chars = a.toLowerCase().split("");
                chars[0] = chars[0].toUpperCase();
                return String.join("", chars);
            }).collect(Collectors.toList());
            return temp;
        } else {
            animals = animaList.stream().map(a -> {
                String[] chars = a.toLowerCase().split("");
                chars[0] = chars[0].toUpperCase();
                return String.join("", chars);
            }).collect(Collectors.toList());
            System.out.println(animals);
            return animals;
        }
    }

    static String addAnimal(String animal) {
        //add an animal to the animal list.
        ArrayList<String> temp = new ArrayList<>(animals);
        temp.add(animal);
        animals = (List<String>) temp;
        return animal;
    };

    static List<String> lowerFirst(List<String> animaList, boolean mutate) {
        //lowercase the first letter, and uppercase the rest of the letters, using streams.  Also, depending on the value of the boolean flag 'mutate', mutate the original animals list, or perform your stream operations on a 'copy' of the animals list.  return the list out of hte function in both cases.
        if(!mutate) {
            List<String> temp;
            temp = animaList.stream().map(a -> {
                String[] chars = a.toUpperCase().split("");
                chars[0] = chars[0].toLowerCase();
                return String.join("", chars);
            }).collect(Collectors.toList());
            return temp;
        } else {
            animals = animaList.stream().map(a -> {
                String[] chars = a.toUpperCase().split("");
                chars[0] = chars[0].toLowerCase();
                return String.join("", chars);
            }).collect(Collectors.toList());
            return animals;
        }
    }

    static List<String> flipAnimals(boolean mutate) {
        //reverse the order of the animals in the animal list.  If the booleaen parameter is true, reverse the static animals array list by mutating the array.  if the mutate boolean is false, flip a 'copy' of the animals list, then return that list of flipped animals, WITHOUT mutating the static animals array. return the flipped list in both cases.
        if(!mutate) {
            List<String> temp = new ArrayList<String>();
            temp = animals.stream().collect(Collectors.toList());
            Collections.reverse(temp);
            return temp;
        } else {
            Collections.reverse(animals);
            return animals;
        }
    }

    static List<String> sortAnimals(boolean mutate) {
        //sort the animals in alphabetical order.  If the booleaen parameter is true, mutating the animals list.  if the mutate boolean is false, sort a 'copy' of the animals list, then return that list of sorted animals, WITHOUT mutating the static animals array. return the sorted list in both cases.
        if(!mutate) {
            List<String> temp = new ArrayList<>();
            temp = animals.stream().sorted().collect(Collectors.toList());
            return temp;
        } else {
            List<String> temp = new ArrayList<>();
            temp = animals.stream().sorted().collect(Collectors.toList());
            animals = temp;
            return animals;
        }
    }
}