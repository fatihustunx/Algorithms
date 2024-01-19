class Main {
  static double fonk(double x) {
    return ((Math.exp(-x)) - Math.sin(((Math.PI)/2)*x));
  }
  static boolean ortala(float a, float b) {
    if(fonk(a) * fonk(b) < 0) {
      return true;
    }
    else {
    return false;
    }  
  }

  static void ortabul(float a1, float a2){
    double e = 0.001;
    float xy = (a1 + a2) / 2 ;
    if(ortala(a1, xy)){
      float result = Math.abs(a1-xy);
      if(result > e){
        ortabul(a1, xy);
      }
      else{
        System.out.println(xy);
      }
    }
    if(ortala(xy, a2)){
      float result = Math.abs(xy - a2);
    if(result > e){
       ortabul(xy, a2);
    
  }
      else{
        System.out.println(xy);
      }
    }
}
  
  
  
  public static void main(String[] args) {
    ortabul(0,1);
  }
}