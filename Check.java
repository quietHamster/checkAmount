import java.text.SimpleDateFormat;
import java.util.Date;

public class Check {
  private double _amount;
  private String[] ones = {"","one","two","three","four","five","six","seven","eight","nine"};
  private String[] teens = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
  private String[] tens = {"","","twenty","thirdty","forty","fifty","sixty","seventy","eighty","ninety"};
	
  public Check(){
    this._amount = 0.00;
  }
  
  public void setAmount(double amount){
    this._amount = amount;
  }
  
  public String getAmountInWords(double amount){
  String amountStr = Double.toString(amount);
  String str = "";
  int dollar = Integer.parseInt(amountStr.substring(0, amountStr.indexOf('.')));
  int cent = Integer.parseInt(amountStr.substring(amountStr.indexOf('.')+1));

  // assume the minimum amount is $1.00
  // assume the maximum amount is $99,999.99
  if(dollar<10){
    str = str.concat(ones[dollar%10]+" ");
  } else if(dollar<20){
    str = str.concat(teens[dollar%10]+" ");
  } else if(dollar<100){
    str = str.concat(tens[dollar/10]);
    if(dollar%10!=0) {
      str = str.concat("-"+ones[dollar%10]);
    }
    str = str.concat(" ");
  } else if(dollar<1000){
    String tmp = Integer.toString(dollar);
    int hundred = Integer.parseInt(Character.toString(tmp.charAt(0)));
    int ten = Integer.parseInt(Character.toString(tmp.charAt(1)));
    int one = Integer.parseInt(Character.toString(tmp.charAt(2)));
    str = str.concat(ones[hundred]+" hundred ");
    if(ten!=0){
      if(ten==1){
        str = str.concat(teens[one]);
      }else{
        str = str.concat(tens[ten]);
        if(one!=0){
          str = str.concat("-"+ones[one]);
        }
      }
    }else{
      // remove extra space at the end of the string
      if(one==0){
        str = str.substring(0, str.length()-1);
      }
      str = str.concat(ones[one]);
    }
    str = str.concat(" ");	
  }else if(dollar<100000){
    String tmp = Integer.toString(dollar);
    int thousand = 0;
    if(tmp.length()==4){
      thousand = Integer.parseInt(Character.toString(tmp.charAt(0)));
    }else if(tmp.length()==5){
      thousand = Integer.parseInt(Character.toString(tmp.charAt(0))+Character.toString(tmp.charAt(1)));
    }
    int hundred = Integer.parseInt(Character.toString(tmp.charAt(tmp.length()-3)));
    int ten = Integer.parseInt(Character.toString(tmp.charAt(tmp.length()-2)));
    int one = Integer.parseInt(Character.toString(tmp.charAt(tmp.length()-1)));
    if(thousand<10){
      str = str.concat(ones[thousand]+" thousand ");
    }else if(thousand<20){
      str = str.concat(teens[thousand%10]+" thousand ");
    }else{
      if(thousand%10!=0){
        str = str.concat(tens[thousand/10]+"-"+ones[thousand%10]);
      }else{
        str = str.concat(tens[thousand/10]);
      }
      str = str.concat(" thousand ");
    }

    if(hundred!=0){
      str = str.concat(ones[hundred]+" hundred ");
    }
    if(ten!=0){
      if(ten==1){
        str = str.concat(teens[one]);
      }else{
        str = str.concat(tens[ten]);
        if(one!=0){
          str = str.concat("-"+ones[one]);
        }
      }
    } else {
      // remove extra space at the end of the string
      if(one==0){
        str = str.substring(0, str.length()-1);
      }
      str = str.concat(ones[one]);
    }
    str = str.concat(" ");
  }	
  str = str.concat("& "+Integer.toString(cent)+"/100");
  return str;
}
}
