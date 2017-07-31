/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shannon.theory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 *
 * @author Admin
 */
public class ShannonTheory {
    
    

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        float sum1=0,sum2=0;
        float eff;
        
         int ratioNo;
         float x,total=0;
         String ch ="";
         Node temp = null;
         
         System.out.println("Enter how many ratio do you want");
         ratioNo = input.nextInt();
         
         Node [] ratio = new Node[ratioNo];
         
         for(int i=0;i<ratioNo;i++)
             ratio[i]=new Node();
         
          System.out.println("Enter the symbol and the value for each ratio");
         for(int i = 0 ; i<ratioNo ; i++){
             System.out.print("Symbol "+i+" -->");
             ch = input.next();
             System.out.print("Value "+i+" -->");
             x = input.nextFloat();
             ratio[i].setSym(ch);
             ratio[i].setPro(x);
             total +=x;
             System.out.println();
         }
     
         if(total != 1){
             System.out.println("Error: your ratios unequal to 1 !!");
             System.exit(0);
         }
         temp = new Node();
        for(int j = 1 ; j<=ratioNo-1 ; j++){
             for(int i = 0 ; i<ratioNo ; i++){
                 
                 if((ratio[j].getPro())<(ratio[i].getPro()))
        {
            
          temp.setSym(ratio[i].getSym());
          temp.setPro(ratio[i].getPro());
          ratio[i].setSym(ratio[j].getSym());
          ratio[i].setPro(ratio[j].getPro());
          ratio[j].setSym(temp.getSym());
          ratio[j].setPro(temp.getPro());
         
        }
             }
         }
         
         Shannon(0,ratioNo-1,ratio);
         
         System.out.println("\n\n\n\t----------- OUTPUT -----------");
         System.out.println("\tSymbol\tProbability\tCode");
         
         for(int i=0 ; i<ratio.length ; i++){
             
             sum1+=(ratio[i].getCode().length()*ratio[i].getPro());
             sum2+=(-1*ratio[i].getPro()*Log2((ratio[i].getPro())));
             System.out.printf("\n\t%s\t%3f\t%s",ratio[i].getSym(),ratio[i].getPro(),ratio[i].getCode());
                 
             
         }
         System.out.println();
         System.out.println("Average code word length = "+sum1);
         System.out.println("Entropy of source = "+sum2);
         eff = (sum2/sum1)*100;
         System.out.println("Effecincy = "+eff+"%");
        
      }
    
    private static float Log2(float x){
        float L1 = (float) Math.log(x);
        float L2 = (float) Math.log(2);
        return (L1/L2);
    }
    private static void  Shannon(int l, int h, Node []s){
        
        double pack1=0,pack2=0,diff1=0,diff2=0;
        int j;
        int k = 0;
        if((l+1)==h || l==h || l>h)
         {
               if(l==h || l>h)
                   return;
            s[h].setCode("0");
            //s[h].incTop();
            s[l].setCode("1");
            //s[l].incTop();
            return;
         }
        else
        {
         
            for(int i=l ; i<=h-1 ; i++){
                pack1+= s[i].getPro();
            }
             pack2+= s[h].getPro();
             diff1=pack1-pack2;
             
             if(diff1< 0)
                 diff1=diff1*-1;
             
             j = 2;
             
             while(j!=h-l+1){
                 
                 k=h-j;
                 pack1=pack2=0;
                 for(int i=l ; i<=k ; i++)
                  pack1=pack1+s[i].getPro();
                 for(int i=h ; i>k ; i--)
                  pack2=pack2+s[i].getPro();
                 diff2=pack1-pack2;
                 if(diff2< 0)
                   diff2=diff2*-1;
                 if(diff2>=diff1)
                   break;
                 diff1=diff2;
                 j++;
             }
             
             k++;
             for(int i=l ; i<=k ; i++){
               s[i].setCode("1");
              // s[i].incTop();
             }
             for(int i=k+1;i<=h;i++){
               s[i].setCode("0");
               //s[i].incTop();
             }
             
              Shannon(l,k,s);
             Shannon(k+1,h,s);
            
        }
        
        }
        
    }
    

