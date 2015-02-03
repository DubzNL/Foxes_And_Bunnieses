import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
  
 public class junittestlimited extends Simulator
 {
 private static int depth = 80;
 private static int  width = 55;

 public double FOX_TEST_CREATION_PROBABILITY     = 0.00; 
 public double RABBIT_TEST_CREATION_PROBABILITY   = 0.08;
  
 @Override 
  public void populate() 
  {
   Simulator theSimulator = new Simulator();
   Random rand = Randomizer.getRandom();
   theSimulator.populate();
   field.clear();
         for(int row = 0; row < field.getDepth(); row++) 
         {
          for(int col = 0; col < field.getWidth(); col++) 
          {
                 if(rand.nextDouble() <= FOX_TEST_CREATION_PROBABILITY) 
                 {
                     Location location = new Location(row, col);
                     Fox fox = new Fox(true, field, location);
                     animals.add(fox);
                 }
                  else if(rand.nextDouble() <= RABBIT_TEST_CREATION_PROBABILITY) 
                  {
                   Location location = new Location(row, col);
                   Rabbit rabbit = new Rabbit(true, field, location);
                   animals.add(rabbit);
                  }
                 // else leave the location empty.
             }
         }
  }
 


 @Parameters
 private static void Simulator(int depth, int width)
 {
  if(width <= 0 || depth <= 0) 
  {
   System.out.println("The dimensions must be greater than zero.");
   System.out.println("Using default values.");
 
  }
 }

 @Test 
 public static void main(String[]args)
 {
  Simulator(depth, width);
 }
}