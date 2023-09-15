using System;

namespace Saludos // Note: actual namespace depends on the project name.
{
    internal class Saludar
    {
        static void Main(string[] args)
        {
            try
            {
                Console.WriteLine("Escriba el primer entero");
                string temp = Console.ReadLine();
                int i = Int32.Parse(temp);
                Console.WriteLine("Escriba el segundo entero");
                temp = Console.ReadLine();
                int j = Int32.Parse(temp);
                int k = i / j;
                Console.WriteLine("El resultado de dividir {0} por {1} es {2}", i, j, k);
            }
            catch (Exception e)
            {
                Console.WriteLine("Excepción lanzada: {0}", e);
            }
        }
    }
}
