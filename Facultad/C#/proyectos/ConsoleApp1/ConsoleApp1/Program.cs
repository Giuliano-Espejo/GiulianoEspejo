using System;
					
public class Program
{
    public static void Main()
    {
        //calcular el factorial de un numero
        ulong numero = ingreso(); // entrada
        ulong resultado = factorial(numero); //proceso
        Console.WriteLine("El resultado del factorial de " + numero + " es de " + resultado); //salida
    }
	
    public static ulong factorial(ulong numero){
        ulong resultado = 0;
        if(numero == 1){
            return resultado = 1;
        }else{
            return resultado=numero*factorial(numero-1);
        }
    }
	
    public static ulong ingreso(){
        bool ingreso = false;
        ulong numero = 0;
        do{
            try{
                Console.Write("Ingres un numero -> ");
                numero = ulong.Parse(Console.ReadLine());
                if(numero > 0){
                    ingreso = true;
                }else{
                    Console.WriteLine("No se puede calcular factorial de un numero negativo");	
                }
            }catch(Exception e){
                Console.WriteLine("Hubo un error al ingresar el numero");
            }
        }while(!ingreso);
        return numero;
    }
	
}