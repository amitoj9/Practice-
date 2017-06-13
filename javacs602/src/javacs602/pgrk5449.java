package javacs602;

//SINGH AMITOJ cs610 5449 prp
/*
 * @author amitoj singh
 * page rank algorithm
 * 
*/
import static java.lang.Math.abs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class pgrk5449 {

       static int iter;
       static int initVal;
       static String filename;
       static int n;      // number of vertices in the graph
       static int m;      // number of edges in the graph
       static int[][] adjMat;  // adjacency matrix 
       static final double d = 0.85;
       static final double errorrate = 0.00001;//Error rate defined as 10^-5
       static double[] dsa;
       static int[] outGoingLinks; // Outgoing links 

   
  
    
    public static void main(String[] args) throws Exception
    {
        if(args.length != 3) {
            throw new Exception("Wrong number of parameters");
        }
//        command line arguments
//        Initializing values of iteration, initial value and file name.
     	iter=(int)Integer.parseInt( args[0]);
    	initVal=(int)Integer.parseInt( args[1]);
    	filename=args[2];
//    	 checking condition for initial value.
      if( !(initVal== -2 || initVal == -1 ||initVal == 0 ||initVal == 1) ) {
          System.out.println("Wrong Initial Value");
          return;
      }
// Calling initailizeValues method to initialize the initial values.
        initalizeValues();
// Calling Page rank algorithm
        pgrkAlgo();
    }
// Checking for intersection
   public static boolean intersection(double[] src, double[] target)
    {
        for(int i = 0; i < n; i++)
        {
          if ( abs(src[i] - target[i]) > errorrate )
            return false;
        }
        return true;
    }
//  Page rank alog for N grater than 10
  public static void pgrnkAlgoForNGreaterThan10(boolean flag,double[] arr)
  {

      iter = 0;
      for(int i =0; i < n; i++) {
        dsa[i] = 1.0/n;
      }
      int i = 0;
    do {
         if(flag == true)
         {
            flag = false;
         }
         else
         {
           for(int l = 0; l < n; l++) {
             dsa[l] = arr[l];
           }
         }
         for(int l = 0; l < n; l++) {
           arr[l] = 0.0;
         }

         for(int j = 0; j < n; j++) {
           for(int k = 0; k < n; k++)
           {
              if(adjMat[k][j] == 1) {
                  arr[j] += dsa[k]/outGoingLinks[k];
              }
           }
         }

         //outGoingLinksompute and print page rank of all pages
         for(int l = 0; l < n; l++) {
           arr[l] = d*arr[l] + (1-d)/n;
         }
         i++;
       } while (intersection(dsa, arr) != true);

       // print page ranks at the stopping iteration 
       System.out.println("Iter: " + i);
       for(int l = 0 ; l < n; l++) {
           System.out.printf("P[" + l + "] = %.6f\n",Math.round(arr[l]*1000000.0)/1000000.0);
       }
       return;
  
  }
//  Page rank algorithm starts.
  public static void pgrkAlgo() {
        double[] arr = new double[n];
        boolean flag = true;
        // If the graph has N greater than 10, then the values for iterations, initialvalue revert to 0 and -1 respectively.
        if(n > 10) {
        	pgrnkAlgoForNGreaterThan10(flag,arr);
        }
        //Base Case
        System.out.print("Base    : 0");
        for(int j = 0; j < n; j++) {
            System.out.printf(" :P[" + j + "]=%.6f",Math.round(dsa[j]*1000000.0)/1000000.0);
        }

        if (iter != 0) {
          for(int i = 0; i < iter; i++)
          {
              for(int l = 0; l < n; l++) {
                arr[l] = 0.0;
              }
            
              for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++)
                {
                    if(adjMat[k][j] == 1) {
                        arr[j] += dsa[k]/outGoingLinks[k];
                    } 
                }
              }

              //Compute and print pagerank of all pages
              System.out.println();
              System.out.print("Iter    : " + (i+1));
              for(int l = 0; l < n; l++) {
                arr[l] = d*arr[l] + (1-d)/n;
                System.out.printf(" :P[" + l + "]=%.6f",Math.round(arr[l]*1000000.0)/1000000.0);
              }
            
              for(int l = 0; l < n; l++) {
                dsa[l] = arr[l]; 
              } 
          }
          System.out.println();
        }
        else 
        { //number of iterations is 0, try convergence
          int i = 0;
          do {
               if(flag == true)
               {
                  flag = false;
               }
               else
               {
                 for(int l = 0; l < n; l++) {
                   dsa[l] = arr[l];
                 }
               }
               for(int l = 0; l < n; l++) {
                 arr[l] = 0.0;
               }

               for(int j = 0; j < n; j++) {
                 for(int k = 0; k < n; k++)
                 {
                    if(adjMat[k][j] == 1) {
                        arr[j] += dsa[k]/outGoingLinks[k];
                    }
                 }
               }

               //outGoingLinksompute and print pagerank of all pages
               System.out.println(); 
               System.out.print("Iter    : " + (i+1));
               for(int l = 0; l < n; l++) {
                 arr[l] = d*arr[l] + (1-d)/n;
                 System.out.printf(" :P[" + l + "]=%.6f",Math.round(arr[l]*1000000.0)/1000000.0);
               }
               i++;  
             } while (intersection(dsa, arr) != true);  
        System.out.println(); 
        }
    }
  public static void initalizeValues()   
  {
      
      int p = 0;
      int q = 0;
      try {        
          Scanner scanner = new Scanner(new File(filename));
          n = scanner.nextInt();
          m = scanner.nextInt();
          
          //Adjacency matrix representation of graph
          adjMat = new int[n][n];
          for(int i = 0; i < n; i++)
           for(int j = 0; j < n; j++)
             adjMat[i][j] = 0;
          
          while(scanner.hasNextInt())
          {
              p = scanner.nextInt();
              q = scanner.nextInt();
              adjMat[p][q] = 1;
          }
          

          //outGoingLinks[i] --> number of outgoing links of page 'Ti'
          outGoingLinks = new int[n];
          for(int i = 0; i < n; i++) {
              outGoingLinks[i] = 0;
              for(int j = 0; j < n; j++) {
                  outGoingLinks[i] += adjMat[i][j];
              }
          }

          dsa = new double[n];
          if(initVal==0) {
            for(int i = 0; i < n; i++) {
              dsa[i] = 0;
            }
          }
          else if(initVal==1)
          {
          for(int i = 0; i < n; i++) {
              dsa[i] = 1;
            }
          }
          else if(initVal==-1)
          {
            for(int i =0; i < n; i++) {
              dsa[i] = 1.0/n;
            }
          }
          else if (initVal==-2)
          {
          	for(int i =0; i < n; i++) {
              dsa[i] = 1.0/Math.sqrt(n);
          	}
           
          }
      }
      catch(FileNotFoundException fnfe)
      {
      }
  }
}
