using System.ComponentModel.Design;
using System.Text.RegularExpressions;
using System;
using System.Diagnostics.CodeAnalysis;

namespace Vectores
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //ejercicio1();
            //ejercicio3();
            //ejercicio4();
            //ejercicio5();
            //ejercicio6();
            //ejercicio7();
            //ejercicio8();
            //ejercicio9();
            //ejercicio10();
        }

        public static void ejercicio10()
        {
            double[] a = crearVector();
            double[] b = new double[a.Length];
            llenarVector(a);
            llenarVector(b);
            Console.WriteLine("El vector promedio es: ");
            mostrarVector(promedioVectores(a, b));
        }

        public static double[] promedioVectores(double[] a, double[] b)
        {
            double[] resultado = new double[a.Length];
            for(int i = 0; i < a.Length; i++)
            {
                resultado[i] = (a[i] + b[i]) / 2;
            }
            return resultado;
        }

        public static void ejercicio9()
        {
            double[] a = crearVector();
            double[] b = new double[a.Length];
            Console.WriteLine("Carge vector 1");
            llenarVector(a);
            Console.WriteLine("Carge vector 2");
            llenarVector(b);
            double[] resultado = proyeccionVectoria(a, b);
            Console.WriteLine("El resultado de la proyeccion es:");
            mostrarVector(resultado);
        }

        public static double[] proyeccionVectoria(double[] a, double[] b)
        {
            double[] resultado = new double[a.Length];
            double productoEscalar = productoPunto(a, b);
            double magintudB = pitagoras(b);
            double escalar = productoEscalar / (magintudB * magintudB);
            for (int i = 0; i < a.Length; i++)
            {
                resultado[i] = escalar * b[i];
            }
            return resultado;
        }

        public static void ejercicio8()
        {
            double[] a = crearVector();
            double[] b = new double[a.Length];
            Console.WriteLine("Carge vector 1");
            llenarVector(a);
            Console.WriteLine("Carge vector 2");
            llenarVector(b);
            double resultado = productoPunto(a, b);
            if (resultado == 0) {
                Console.WriteLine("Son ortogonales");
            } else {
                Console.WriteLine("No son ortogonales");
            }
        }

        public static void ejercicio7()
        {
            double[] a = new double[3];
            double[] b = new double[3];
            Console.WriteLine("Carge vector 1");
            llenarVector(a);
            Console.WriteLine("Carge vector 2");
            llenarVector(b);
            double resultado = calcularAngulo(a, b);
            Console.WriteLine("El resultado es {0} grados", resultado);
        }

        public static double calcularAngulo(double[] a, double[] b)
        {
            double productoEscalar = productoPunto(a, b);
            double magnitudA = pitagoras(a);
            double magnitudB = pitagoras(b);
            double resultado = Math.Acos(productoEscalar/(magnitudA * magnitudB));
            resultado = resultado * 57.296;
            return resultado;
        }
       
        public static void ejercicio6()
        {
            ejercicio2();
        }

        public static double productoPunto(double[] a, double[] b)
        {
            double resultado =  0;
            
            for(int i = 0; i < a.Length; i++){
                resultado += a[i] * b[i];
            }

            return resultado;
        }

        public static void ejercicio5()
        {
            double[] a = crearVector();
            llenarVector(a);
            Console.WriteLine("Arreglo normalizado");
            normalizarVector(a);
            mostrarVector(a);
        }
        
        public static void normalizarVector(double[] a)
        {
            double magnitud = pitagoras(a);
            for(int i = 0; i < a.Length; i++)
            {
                a[i] = a[i] / magnitud;
            }
        }

        public static double[] crearVector()
        {
            int size = 0;
            do
            {
                try
                {
                    Console.Write("ingrese el tamanio -> ");
                    size = int.Parse(Console.ReadLine());
                }
                catch (Exception e)
                {
                    Console.WriteLine("Error al cargar tamanio");
                }
            } while (size <=0);

            double[] a = new double[size];
            return a;
        }

        public static void ejercicio4()
        {
            int size = 0;
            do
            {
                try
                {
                    Console.Write("ingrese el tamanio -> ");
                    size = int.Parse(Console.ReadLine());
                }catch(Exception e)
                {
                    Console.WriteLine("Error al cargar tamanio");
                }
            } while (size < 2);
            double[] a = new double[size];
            llenarVector(a);
            double resultado = pitagoras(a);
            Console.WriteLine("Pitagoras -> {0}",resultado);
        }

        public static double pitagoras(double[] a)
        {
            double resultado = 0;
            for(int i = 0; i < a.Length; i++)
            { 
                resultado += (a[i] * a[i]);
            }
            resultado = Math.Sqrt(resultado);
            return resultado;
        }

        public static void ejercicio3()
        {
            //Producto cruz
            double[] a = new double[3];
            double[] b = new double[3];
            Console.WriteLine("Carge el vector 1");
            llenarVector(a);
            Console.WriteLine("Carge el vector 2");
            llenarVector(b);
            double[] resultado = new double[3];
            productoCruz(a, b, resultado);
            Console.WriteLine("Resultado : ");
            mostrarVector(resultado);
        }

        public static void llenarVector(double[] a)
        {
            for(int i = 0; i < a.Length; i++)
            {
                try
                {
                    Console.WriteLine("Ingrese valor para la posicio {0}", i);
                    a[i] = double.Parse(Console.ReadLine());
                }catch(Exception e)
                {
                    Console.WriteLine("Errro al cargar valor");
                    i--;
                }
            }
        }
    
        public static void mostrarVector(double[] a)
        {
            Console.Write("[ ");
            for (int i = 0; i < a.Length; i++)
            {
                Console.Write(a[i] + " ");
            }
            Console.WriteLine("]");
        }
    
        public static void productoCruz(double[] a, double[] b, double[] c)
        {
            //(x,y,z)
            //Cx
            c[0] = a[1] * b[2] - a[2] * b[1];
            //Cy
            c[1] = a[2] * b[0] - a[0] * b[2];
            //Cz
            c[2] = a[0] * b[1] - a[1] * b[0];
        }

        public static void ejercicio2()
        {
            double[] a = crearVector();
            double[] b = new double[a.Length];
            Console.WriteLine("Carge vector 1");
            llenarVector(a);
            Console.WriteLine("Carge vector 2");
            llenarVector(b);
            Console.WriteLine("Producto Punto");
            double resultado = productoPunto(a, b);
            Console.WriteLine("El producto punto es -> {0}", resultado);
        }

        public static void ejercicio1()
        {
            double[] a = crearVector();
            double[] b = new double[a.Length];
            llenarVector(a);
            llenarVector(b);
            double[] resultado = sumaVectores(a, b);
            Console.WriteLine("La suma es: ");
            mostrarVector(resultado);
        }

        public static double[] sumaVectores(double[] a, double[] b)
        {
            double[] resultado = new double[a.Length];
            for (int i = 0; i < a.Length; i++)
            {
                resultado[i] = a[i] + b[i];
            }
            return resultado;
        }
    }
}