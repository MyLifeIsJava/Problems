package techgig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Problem Statement : https://drive.google.com/open?id=1bj7eETck82Aryw5ypXBtP23IFm8WU3ft
 * 
 * Status : Some test cases are failing
 * 
 * @author kiran
 *
 */
public class Bring_Back_Power_Supply {

    public static void main(String[] args) throws Exception{
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            String elevationsStr = scanner.nextLine();
            String fuelStr = scanner.nextLine();
            String []tokens = elevationsStr.split(",");
            double []elevations = new double[tokens.length];
            for(int i=0; i < tokens.length; i++)
                elevations[i] = Double.parseDouble(tokens[i]);
            double []fuels = new double[4];
            tokens = fuelStr.split("#");
            for(String token : tokens) {
                int index = token.indexOf(":");
                String fuel = token.substring(0, index);
                String quantityStr = token.substring(index+1);
                double quantity = Double.parseDouble(quantityStr);
                if(fuel.equalsIgnoreCase("PETROL")) {
                    fuels[0] = quantity;
                }else if(fuel.equalsIgnoreCase("DIESEL")) {
                    fuels[1] = quantity;
                }else if(fuel.equalsIgnoreCase("KEROSENE")) {
                    fuels[2] = quantity;
                }else if(fuel.equalsIgnoreCase("WATER")) {
                    fuels[3] = quantity;
                }
            }
            int[][] retVal = fillFuel(elevations, fuels);
            for(int i=0; i < retVal.length; i++) {
                if(i > 0)
                    System.out.print(",");
                
                System.out.print("[");
                if(retVal[i] != null && retVal[i].length > 0) {
                    for(int k=0; k < retVal[i].length; k++) {
                        if(k > 0)
                            System.out.print(",");
                        System.out.print(retVal[i][k]);
                    }
                }
                System.out.print("]");
            }
        }finally {
            if(scanner != null)
                scanner.close();
        }
    }

    public static int[][] fillFuel(double []elevations, double []fuels){
        int[][] retVal = new int[4][];
        if(elevations == null || elevations.length < 3)
            return retVal;

//      For each elevation find the left wall and right wall elevations : O(n)
        double []leftWalls = new double[elevations.length];
        double []rightWalls = new double[elevations.length];
        double tallestWall = 0;
        for(int i=0; i < elevations.length; i++) {
            if(elevations[i] > tallestWall) {
                tallestWall = elevations[i];
            }
            leftWalls[i] = tallestWall;
        }
        tallestWall = 0;
        for(int i=elevations.length - 1; i >= 0; i--) {
            if(elevations[i] > tallestWall) {
                tallestWall = elevations[i];
            }
            rightWalls[i] = tallestWall;
        }
//        Now find the congruent space
        int spaceSize = 0;
        int spaceBeginIndex = -1;
        int spaceEndIndex = -1;
        List<CongruentSpace> spaces = new ArrayList<CongruentSpace>();
        for(int i=0; i < elevations.length; i++) {
            double leftWall = leftWalls[i];
            double rightWall = rightWalls[i];
            double space = 0;
            if(leftWall > 0 && rightWall > 0) {
                space = Math.min(rightWall, leftWall) -  elevations[i];
                if(space < 0)
                    space = 0;
            }
            if(space > 0) {
                if(spaceBeginIndex == -1) {
                    spaceBeginIndex = i;
                }
                spaceSize += space;
                spaceEndIndex = i;
            }else {
                if(spaceSize > 0) {
                    spaces.add(new CongruentSpace(spaceSize, spaceBeginIndex, spaceEndIndex));
                }
                spaceSize = 0;
                spaceBeginIndex = -1;
            }
        }
//        System.out.println("spaces="+spaces);
////        Handle last congruent space
//        if(spaceSize > 0) {
//            spaces.add(new CongruentSpace(spaceSize, spaceBeginIndex, spaceEndIndex));
//        }
//        System.out.println();
//        System.out.println(Arrays.toString(elevations));
//        System.out.println(Arrays.toString(leftWalls));
//        System.out.println(Arrays.toString(rightWalls));
//        System.out.println(spaces);
//        Construct a binary search tree for the congruent spaces
        if(!spaces.isEmpty()) {
//            TODO: We can use some good data structure instead of a sorted array
            Collections.sort(spaces, new Comparator<CongruentSpace>() {
                @Override
                public int compare(CongruentSpace o1, CongruentSpace o2) {
                    if(o1.size < o2.size)
                        return 1;
                    else if(o1.size > o2.size)
                        return -1;
                    return 0;
                }
            });
            
            for(int i=0; i < fuels.length; i++) {
                double fuel = fuels[i];
                if(fuel == 0)
                    continue;
//                System.out.println("Fuel="+i);
                List<Integer> res = new ArrayList<Integer>();
                List<CongruentSpace> applicableSpaces = getLeastCongruentSpaces(spaces, fuel);
                if(applicableSpaces != null && !applicableSpaces.isEmpty()) {
//                   We can't reuse this to fill some other fuel, so remove it from the list
                    for(CongruentSpace space : applicableSpaces) {
//                        System.out.println("\tspace="+space);
                        for(int k = space.beginIndex ; k <= space.endIndex; k++)
                            res.add(k);
                    }
                    spaces.removeAll(applicableSpaces); 
                }
                if(!res.isEmpty()) {
                    Collections.sort(res);
                    retVal[i] = new int[res.size()];
                    for(int k = 0; k < res.size(); k++) {
                        retVal[i][k] = res.get(k);
                    }
                }
            }
        }
        
        return retVal;
    }
    private static List<CongruentSpace> getLeastCongruentSpaces(List<CongruentSpace> spaces, double searchValue) {
//        System.out.println("Inside getLeastCongruentSpaces, searchValue="+searchValue+", spaces="+spaces);
        if(spaces == null || spaces.isEmpty())
            return null;
        if(spaces.size() == 1)
            return spaces;
        
        List<CongruentSpace> retList = new ArrayList<CongruentSpace>();
        CongruentSpace prevVal = null;
        int index = -1;
        for(CongruentSpace space : spaces) {
            index ++;
            if(space.size <= searchValue) {
                retList.add(space);
                return retList;
            }
            else if(space.size < searchValue){
                break;
            }
            prevVal = space;
        }
//        We didn't get congruent space with exact required size
//        Hence get minimum congruent spaces
//        System.out.println("searchValue="+searchValue+", prevVal="+prevVal+", index="+index);
        Map<Double, List<CongruentSpace>> spaceOptions = getPowerSet(spaces, index, searchValue);
//        System.out.println("spaceOptions="+spaceOptions);
        if(spaceOptions.isEmpty()) {
//            No combination of spaces with size >= searchValue
            if(prevVal != null) {
//                The previous space had sufficient size, so return it
                retList.add(prevVal);
                return retList;
            }else {
//                No single space with more size
//                All spaces are needed to fill this fuel
                return spaces;
            }
        }else {
//            Some combination of spaces can be used to fill this fuel
            if(prevVal == null) {
//                No single space with more size
//                Then return the combination with minimal size
                return spaceOptions.values().iterator().next();
            }
            else {
                Double combinationSize = spaceOptions.keySet().iterator().next();
                if(combinationSize > prevVal.size) {
                    retList.add(prevVal);
                    return retList;
                }else {
                    return spaceOptions.values().iterator().next();
                }
            }
        }
    }
   
    private static Map<Double, List<CongruentSpace>> getPowerSet(List<CongruentSpace> spaces, int beginIndex, double searchValue) {
        Map<Double, List<CongruentSpace>> retMap = new TreeMap<Double, List<CongruentSpace>>();
        int size = spaces.size() - beginIndex;
        
        for(long l=0; l < (1<<size); l++) {
            List<CongruentSpace> list = new ArrayList<CongruentSpace>();
            double sum = 0;
            for(int i=0; i < size; i++) {
                if((l & (1<<i)) > 0) {
                    CongruentSpace space = spaces.get(i + beginIndex);
                    sum += space.size;
                    list.add(space);
                }
            }
            if(!list.isEmpty() && searchValue <= sum)
                retMap.put(sum, list);
        }
        return retMap;
    }
    private static class CongruentSpace{
        double size;
        int beginIndex;
        int endIndex;
        public CongruentSpace(double size, int beginIndex, int endIndex) {
            this.size = size;
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
        }
        public String toString() {
            return "["+beginIndex+","+endIndex+":"+size+"]";
        }
    }
}
