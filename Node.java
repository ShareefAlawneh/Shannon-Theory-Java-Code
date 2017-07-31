/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shannon.theory;

/**
 *
 * @author Admin
 */
    public  class Node {
    
    String sym;
    float pro;
    String code;
   
    
    
    public Node(){
    sym = "";
    pro = 0;
    code = "";
    }
 
   public void  setSym(String ch) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    this.sym = ch;
     
    }
   public void setPro(float p){
       this.pro = p;
   }
   
   public float getPro(){
       
       return this.pro;
   }

   public String getSym(){
       
       return this.sym;
   }
   
   public void setCode(String s){
       
       this.code +=s;
   }
    public String getCode(){
        
        return this.code;
    }
   
}