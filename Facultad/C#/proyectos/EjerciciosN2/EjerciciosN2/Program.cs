using System;
using System.ComponentModel;
using System.Diagnostics.Metrics;
using System.Reflection.Metadata.Ecma335;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace EjerciciosN2 
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //ejercicio1();
            //ejercicio8();
            //ejercicio9();
            ejercicio10();
        }
        public static void ejercicio10()
        {
            int[] numeros = entrada();
            Console.WriteLine("Array inicial");
            mostrarArray(numeros);
            int[] newNumeros = eliminar(numeros);
            Console.WriteLine("Array final");
            mostrarArray(newNumeros);
        }

        public static int[] eliminar(int[] numeros)
        {
            int[] newNumeros = new int[numeros.Length - 1];
            int posicion = 0, numero = 0;
            string num = "";
            do
            {
                try
                {
                    Console.WriteLine("Ingrese la posicion, numero maximo {0} ", newNumeros.Length);
                    posicion = int.Parse(Console.ReadLine());
                }
                catch (Exception e)
                {
                    Console.WriteLine("Error al ingresar el numero");
                }
            } while (posicion < 0 || posicion > newNumeros.Length);

            bool eliminado = false;
            for (int i = 0; i < newNumeros.Length; i++)
            {
                if (i == posicion)
                {
                    eliminado = true;
                }
                else if (eliminado)
                {
                    newNumeros[i-1] = numeros[i];
                }
                else
                {
                    newNumeros[i] = numeros[i];
                }

            }

            return newNumeros;
        }
        public static void ejercicio9()
        {
            int[] numeros = entrada();
            Console.WriteLine("Array inicial");
            mostrarArray(numeros);
            int[] newNumeros = insertar(numeros);
            Console.WriteLine("Array final");
            mostrarArray(newNumeros);
        }

        public static void mostrarArray(int[] n)
        {
            for(int i = 0; i < n.Length; i++)
            {
                Console.Write(n[i] + "     ");
            }
            Console.WriteLine();
        }
        public static int[] insertar(int[] numeros)
        {
            int[] newNumeros = new int[numeros.Length + 1];
            int posicion = 0 , numero = 0;
            string num = "";
            do
            {
                try
                {
                    Console.WriteLine("Ingrese la posicion, numero maximo {0} ", newNumeros.Length-1);
                    posicion = int.Parse(Console.ReadLine());
                }catch(Exception e)
                {
                    Console.WriteLine("Error al ingresar el numero");
                }
            } while ( posicion < 0 || posicion > newNumeros.Length-1);

            do
            {
                try
                {
                    Console.WriteLine("Ingrese el numero a insertar");
                    num = Console.ReadLine();
                    numero = int.Parse(num);
                }
                catch (Exception e)
                {
                    Console.WriteLine("Error al ingresar el numero");
                }
            } while (num.Equals(numero));

            bool aniadido = false;
            for(int i = 0; i < newNumeros.Length; i++)
            {
                if (i == posicion)
                {
                    newNumeros[i] = numero;
                    aniadido = true;
                }
                else if (aniadido)
                {
                    newNumeros[i] = numeros[i - 1];
                }
                else
                {
                    newNumeros[i] = numeros[i];
                }

            }

            return newNumeros;
        }
        public static void ejercicio8()
        {
            int[] numeros = entrada();
            int mayor = numeros[0];
            int menor = numeros[0];
            for (int i = 0; i <= numeros.Length - 1; i++)
            {
                if (numeros[i] > mayor) mayor = numeros[i];
                if (numeros[i] < menor) menor = numeros[i];
            }

            Console.WriteLine("El MAYOR ES: " + mayor);
            Console.WriteLine("El MENOR ES: " + menor);


        }
        
        public static int[] entrada()
        {
            int c = 0;
            int ingreso2 = 0;
           do
        {
            Console.WriteLine("Ingrese la cantidad de números positivos que desea ingresar:");
        } while (!int.TryParse(Console.ReadLine(), out c) || c <= 0);
            int[] numeros = new int[c];
            int ingreso = 0;
            for(int i = 0; i < c; i++)
            {
                try
                {
                    Console.WriteLine("Ingrese el numero para la posicion {0} ", i);
                    ingreso = int.Parse(Console.ReadLine());
                    numeros[i] = ingreso;
                }catch(Exception e)
                {
                    Console.WriteLine("Error al ingresar el numero");
                    i--;
                }
            }
            return numeros;
        }
    
        public static void ejercicio1()
        {
            //GENERAR N NÚMEROS PRIMOS
            int numero = 0, cantidad = 0;
            Console.WriteLine("Ingrese la cantidad de numeros que desea ingresar");
            cantidad = Int32.Parse(Console.ReadLine());
            int[] primos = generarPrimo(cantidad);
            for (int i = 0; i < primos.Length; i++)
            {
                Console.Write(primos[i] + "     ");
            }
        }
        public static int[] generarPrimo(int c) {
            var primos = new int[c];
            int i = 1, posicion = 0;
            do
            {
                if (esPrimo(i)){
                    primos[posicion] = i;
                    posicion++;
                }
                i++;
            } while (primos[c-1] == 0);
            return primos;
        }
        public  static bool esPrimo(int n)
        {
            bool esPrimo = true;
            if (n == 1)
            {
                esPrimo = true;
            }
            else
            {
                for (int i = 2; i < n; i++)
                {
                    if (n % i == 0)
                    {
                        esPrimo = false;
                    }
                }
            }
            return esPrimo;
        }
    }
}