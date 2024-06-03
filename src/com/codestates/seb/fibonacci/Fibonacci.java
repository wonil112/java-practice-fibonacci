package com.codestates.seb.fibonacci;
import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args){
    // 프로그램 시작을 알리는 안내문 출력 및 변수 선언
    System.out.println("[안내] 피보나치 수열 프로그램 시작.");
    Scanner scanner = new Scanner(System.in);
    int isValid = 0;
    int inputNumber = 0;

    // 숫자를 입력받는 부분. 잘못된 입력 검증.
    while (isValid == 0) {
      System.out.print("원하는 수열의 개수를 입력해 주세요 : ");
      String inputNumberString = scanner.nextLine();
      if(!isValidDigitString(inputNumberString) || inputNumberString.equals("") || inputNumberString.equals("0")) {
        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
      } else {
        inputNumber = Integer.parseInt(inputNumberString);
        isValid++;
      }
    }
    // 1번째, 2번째 수열 1로 선언
    int fibonacciNum1 = 1;
    int fibonacciNum2 = 1;
    // 배열로 선언. 배열 길이는 입력받은 값.
    int[] fibonacci = new int[inputNumber];
    // 반복문을 통한 피보나치 수열 점화식 작성. 1번값과 2번값은 기존 설정값 사용.
    for(int i = 0; i < fibonacci.length; i++) {
      if(i==0) {
        fibonacci[i] = fibonacciNum1;
      } else if (i == 1) {
        fibonacci[i] = fibonacciNum2;
      } else {
        fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
      }
    }

    // 결과 출력을 위한 안내 문구 출력
    System.out.println("[피보나치 수열 출력");
    for (int i = 0; i < fibonacci.length; i++) {
      System.out.println(fibonacci[i]);
    }
    System.out.println("[안내] 프로그램을 종료합니다.");
  }

  // 오류 검증을 위한 부분
  public static boolean isValidDigitString(String formula) {

    String digit = "1234567890";
    for (char c : formula.toCharArray()) {
      if (digit.indexOf(c) == -1) {
        return false;
      }
    }
    return true;
  }
}