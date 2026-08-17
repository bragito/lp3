//Números primos: Escribe un programa que incluya 
// una función para verificar si un númeroesprimo y otra función para imprimir todos 
// los números primos entre 1 y un número dado n.

//Java
import java.util.Scanner;
public class E1 {
    public static int sumar(int[] array){
        int suma=0;
        for (int i:array){
            suma+=i;
        }
        return suma;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int [] num={15,13,10,-12};
        System.out.print(sumar(num));
        sc.close();
    }
}
//*C++
// #include <iostream>
// using namespace std;
//  int sumar(int[] array,tam){
//      int suma=0;
//      for (int i=0; i<tam;i++){
//          suma+=array[i];
//      }
//    return suma;
//}
// int main(){
//int num[] = {1,3,5,6,1,-8};
//tamaño=sizeof(num)/sizeof(num[0]); //para verificar el tamaño del array
// cout<<sumar(num,tamaño)
//retunr 0;}*/



//* En python
//  def suma(array):
//      retunr(sum)*
// numeros=[1,2,5,3,7]
// print(suma(numeros))/