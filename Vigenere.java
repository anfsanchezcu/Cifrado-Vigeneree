import java.util.Scanner;

public class Vigenere {
  public static void main(String [] args){
    Scanner sc  = new Scanner(System.in);
    
    String text;
    String keyword;
    int t;

    int option = 1;
    boolean cipher = true;
    while(option!=-1){
      System.out.println("Seleccione la opcion que desea relizar:");
      System.out.println("1.cifrar");
      System.out.println("2.descifrar");
      option= sc.nextInt(); 

      if(option == -1)continue;

      cipher = option == 1 ? true : false;
      System.out.println("Ingrerse el texto:");  sc.nextLine();text = sc.nextLine();
      System.out.println("Ingrese el keyword:");keyword = sc.nextLine();
      System.out.println("ingrese el parametro t:"); t = sc.nextInt();

      System.out.println();
      System.out.println("----------------------------------");
      System.out.println(Cipher(text, keyword,5, cipher));
      System.out.println("---------------------------------- \n");

    }

  }

  public static String Cipher(String plainText, String keyword, int T, boolean cipher){
    plainText = checkText(plainText);
    int m = keyword.length();
    String result = "";
    for (int i = 0; i < plainText.length(); i++) {
      result += sumaAscci( plainText.charAt(i), keyword.charAt(i%m), cipher);
      if((i+1)%T == 0 && i!= 0)result += " ";
    }
    return result;
  }

  public static int toAscci(char a){
    return a+0;
  }

  public static char sumaAscci(char a, char b, boolean cipher){
    int tp  =toAscci(a) - 97;
    int kw  =toAscci(b) - 97;
    kw = cipher ? kw :-kw;

    int t = (kw + tp) % 26;
    if(t<0) t+= 26;
    return (char)(t + 97);
  }


  public static String checkText(String text){
    return  text.toLowerCase().replaceAll("[/ ]", "");
  }
}
