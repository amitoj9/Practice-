package javacs602;


import static java.lang.Math.abs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//SINGH AMITOJ cs610 5449 prp
/*
 * @author amitoj singh
 * hits algo
 * 
*/
public class hits5449 {

       static int iter;
//       Static variable for iteration of hits algorithm
       static  int initVal;
//       Initializing the initial value for 0th iteration 
       static String filename;
//      File name of graph that is provided.
       static int n;     
//        number of vertices in the graph
       static int m;     
//		 number of edges in the graph
       static  int[][] adjMat;  
// 		adjacency matrix 
       static double[] hu;
       static double[] au;
       static final double errorrate = 0.00001; 

   

    public static void main(String[] args)
    {
        
        try{
//        	 Throw exception if the number of parameters are not equal.
        	 if(args.length != 3) {
                 throw new Exception("Wrong number of parameters");
             }
//        	  command line arguments
//            Initializing values of iteration, initial value and file name.
        	iter=(int)Integer.parseInt( args[0]);
        	initVal=(int)Integer.parseInt( args[1]);
        	filename=args[2];
//          Checking initial value if it is -2, -1, 0 or 1
            if( !(initVal== -2 || initVal == -1 ||initVal == 0 ||initVal == 1) ) {
            	 System.out.println("Wrong Initial Value");
                 return;
             }
//            Calling initailizeValues method to initialize the initial values of hub and authority.
            initalizeValues();
            
            hitsAlgo();
        }
        catch(Exception e)
        {
        	System.out.println("exception occured in"+e);
        }
        //command line arguments
        
        
    }

 // Checking for intersection
    static boolean  intersection(double[] p, double[] q)
    {
       for(int i = 0 ; i < n; i++) {
           if ( abs(p[i] - q[i]) > errorrate ) 
             return false;
       }
       return true;
       
       
    } 
//  Hits alog for N grater than 10
    public static void hitsAlfgoForNGreaterThan10(double[] hub,double []aut,double aut_sum_square,double aut_scale_factor,double hub_scale_factor,double hub_sum_square,double[] hprev,double[] aprev)
    {

        iter = 0;
        for(int i =0; i < n; i++) {
        	hub[i] = 1.0/n;
            aut[i] = 1.0/n;
            hprev[i] = hub[i];
            aprev[i] = aut[i];
        }
        
      int i = 0;
      do {  
           for(int r = 0; r < n; r++) {
               aprev[r] = aut[r];
               hprev[r] = hub[r];
           }

            //Authority step starts
            for(int p = 0; p < n; p++) {
                aut[p] = 0.0;
            }
        
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(adjMat[k][j] == 1) {
                        aut[j] += hub[k]; 
                    }
                }
            }//Authority step ends

            //Hub step starts
            for(int p = 0; p < n; p++) {
            	hub[p] = 0.0;
            }

            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(adjMat[j][k] == 1) {
                    	hub[j] += aut[k]; 
                    }
                }
            }//Hub step ends

            //Scaling Authority starts
            aut_scale_factor = 0.0;
            aut_sum_square = 0.0;
            for(int l = 0; l < n; l++) {
                aut_sum_square += aut[l]*aut[l];    
            }
            aut_scale_factor = Math.sqrt(aut_sum_square); 
            for(int l = 0; l < n; l++) {
                aut[l] = aut[l]/aut_scale_factor;
            }//Scaling Authority ends  

            //Scaling Hub starts
            hub_scale_factor = 0.0;
            hub_sum_square = 0.0;
            for(int l = 0; l < n; l++) {
                hub_sum_square += hub[l]*hub[l];    
            }
            hub_scale_factor = Math.sqrt(hub_sum_square); 
            for(int l = 0; l < n; l++) {
            	hub[l] = hub[l]/hub_scale_factor;
            }// Scaling Hub ends
            i++; // incr the iteration counter
      } while( false == intersection(aut, aprev) || false == intersection(hub, hprev));
      System.out.println("Iter:    " + i);
      for(int l = 0; l < n; l++) {
          System.out.printf(" A/H[%d]=%.6f/%.6f\n",l,Math.round(aut[l]*1000000.0)/1000000.0,Math.round(hub[l]*1000000.0)/1000000.0); 
      }
      return;
    
    }
    public  static void hitsAlgo()
    {
        double[] hub = new double[n];
        double[] aut = new double[n];
        double aut_scale_factor = 0.0;
        double aut_sum_square = 0.0;
        double hub_scale_factor = 0.0;
        double hub_sum_square = 0.0; 
        double[] aprev = new double[n]; //last iterations values of a, used for convergence
        double[] hprev = new double[n]; //last iterations values of h, used for convergence

        //If the graph has N greater than 10, then the values for iterations, initial value revert to 0 and -1 respectively
        if(n > 10) {
        	hitsAlfgoForNGreaterThan10(hub,aut,aut_sum_square,aut_scale_factor,hub_scale_factor,hub_sum_square,hprev,aprev);
        }

        //Initialization
        for(int i = 0; i < n; i++)
        {
        	hub[i] = hu[i];
            aut[i] = au[i];
            hprev[i] = hub[i];
            aprev[i] = aut[i]; 
        }
        
        //Base Case
        System.out.print("Base:    0 :");
        for(int i = 0; i < n; i++) {
          System.out.printf(" A/H[%d]=%.6f/%.6f",i,Math.round(au[i]*1000000.0)/1000000.0,Math.round(hu[i]*1000000.0)/1000000.0); 
        }
        
        if (iter != 0) { 
            for(int i = 0; i < iter; i++) { //iteration starts
            
                //Authority step starts
                for(int p = 0; p < n; p++) {
                    aut[p] = 0.0;
                }
            
                for(int j = 0; j < n; j++) {
                    for(int k = 0; k < n; k++) {
                        if(adjMat[k][j] == 1) {
                            aut[j] += hub[k]; 
                        }
                    }
                }//Authority step ends

                //Hub step starts
                for(int p = 0; p < n; p++) {
                	hub[p] = 0.0;
                }

                for(int j = 0; j < n; j++) {
                    for(int k = 0; k < n; k++) {
                        if(adjMat[j][k] == 1) {
                            hub[j] += aut[k]; 
                        }
                    }
                }//Hub step ends

                //Scaling Authority starts
                aut_scale_factor = 0.0;
                aut_sum_square = 0.0;
                for(int l = 0; l < n; l++) {
                    aut_sum_square += aut[l]*aut[l];    
                }
                aut_scale_factor = Math.sqrt(aut_sum_square); 
                for(int l = 0; l < n; l++) {
                    aut[l] = aut[l]/aut_scale_factor;
                }//Scaling Authority ends  
 
                //Scaling Hub starts
                hub_scale_factor = 0.0;
                hub_sum_square = 0.0;
                for(int l = 0; l < n; l++) {
                    hub_sum_square += hub[l]*hub[l];    
                }
                hub_scale_factor = Math.sqrt(hub_sum_square); 
                for(int l = 0; l < n; l++) {
                    hub[l] = hub[l]/hub_scale_factor;
                }// Scaling Hub ends
            
                System.out.println();
                System.out.print("Iter:    " + (i+1) + " :");
                for(int l = 0; l < n; l++) {
                    System.out.printf(" A/H[%d]=%.6f/%.6f",l,Math.round(aut[l]*1000000.0)/1000000.0,Math.round(hub[l]*1000000.0)/1000000.0); 
                }
   
            }//iteration ends
        } // if iter != 0 ends
        else
        {
          int i = 0;
          do {  
                for(int r = 0; r < n; r++) {
                    aprev[r] = aut[r];
                    hprev[r] = hub[r];
                }

                //Authority step starts
                for(int p = 0; p < n; p++) {
                    aut[p] = 0.0;
                }
            
                for(int j = 0; j < n; j++) {
                    for(int k = 0; k < n; k++) {
                        if(adjMat[k][j] == 1) {
                            aut[j] += hub[k]; 
                        }
                    }
                }//Authority step ends

                //Hub step starts
                for(int p = 0; p < n; p++) {
                    hub[p] = 0.0;
                }

                for(int j = 0; j < n; j++) {
                    for(int k = 0; k < n; k++) {
                        if(adjMat[j][k] == 1) {
                            hub[j] += aut[k]; 
                        }
                    }
                }//Hub step ends

                //Scaling Authority starts
                aut_scale_factor = 0.0;
                aut_sum_square = 0.0;
                for(int l = 0; l < n; l++) {
                    aut_sum_square += aut[l]*aut[l];    
                }
                aut_scale_factor = Math.sqrt(aut_sum_square); 
                for(int l = 0; l < n; l++) {
                    aut[l] = aut[l]/aut_scale_factor;
                }//Scaling Authority ends  
 
                //Scaling Hub starts
                hub_scale_factor = 0.0;
                hub_sum_square = 0.0;
                for(int s = 0; s < n; s++) {
                    hub_sum_square += hub[s]*hub[s];    
                }
                hub_scale_factor = Math.sqrt(hub_sum_square); 
                for(int s = 0; s < n; s++) {
                    hub[s] = hub[s]/hub_scale_factor;
                }// Scaling Hub ends
                i++; // incr the iteration counter
                System.out.println();
                System.out.print("Iter:    " + i + " :");
                for(int l = 0; l < n; l++) {
                    System.out.printf(" A/H[%d]=%.6f/%.6f",l,Math.round(aut[l]*1000000.0)/1000000.0,Math.round(hub[l]*1000000.0)/1000000.0); 
                }
          } while( false == intersection(aut, aprev) || false == intersection(hub, hprev));
        }
        System.out.println();
    }
//    Initializing values and reading data from file
    public static void initalizeValues()   
    {
        try {        
            Scanner scanner = new Scanner(new File(filename));
            n = scanner.nextInt();
            m = scanner.nextInt();
              //Adjacency matrix representation of graph
//            Initializing zero values for adjacency matrix
            adjMat = new int[n][n];
            for(int i = 0; i < n; i++)
             for(int j = 0; j < n; j++)
               adjMat[i][j] = 0;

            while(scanner.hasNextInt())
            {
                adjMat[scanner.nextInt()][scanner.nextInt()] = 1; 
            }
            
           

            hu = new double[n];
            au = new double[n];
            if(initVal==0)
            {
            	  for(int i = 0; i < n; i++) {
                      hu[i] = 0;
                      au[i] = 0;
                    }
            }
            else if (initVal==1)
            {
            	 for(int i = 0; i < n; i++) {
                     hu[i] = 1;
                     au[i] = 1;
                   }
            }
            else if (initVal==-1)
            {
            	 for(int i =0; i < n; i++) {
                     hu[i] = 1.0/n;
                     au[i] = 1.0/n;
                   }
            }
            else if (initVal==-2)
            {
            	for(int i =0; i < n; i++) {
                    hu[i] = 1.0/Math.sqrt(n);
                    au[i] = 1.0/Math.sqrt(n);
                  }
            }
          

        }
        catch(FileNotFoundException fnfe)
        {
        }
    }
}