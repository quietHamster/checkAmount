public class TestApp {
  public static void main(String[] args){
    long startTime = System.currentTimeMillis();
    
    Check aCheck = new Check();
    aCheck.setAmount(3908.88);
    System.out.println(aCheck.getAmountInWords(aCheck.getAmount()));
    
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println(elapsedTime);
  }
}
