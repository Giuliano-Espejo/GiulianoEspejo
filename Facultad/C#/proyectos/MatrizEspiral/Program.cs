

namespace MatrizEspiral
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int[,] matriz = creaMatriz();
            matrizEspiral(matriz);
            mostrarMatriz(matriz);
        }

        public static void mostrarMatriz(int[,] a)
        {
            for (int i = 0; i < a.GetLength(0); i++)
            {
                for (int j = 0; j < a.GetLength(1); j++)
                {
                    Console.Write(a[i, j] + " ");
                }
                Console.WriteLine(); 
            }
        }

        public static int  ingresoDato()
        {
            try
            {
                int valor;
                Console.WriteLine("Ingrese el valor: ");
                if (int.TryParse(Console.ReadLine(), out valor))
                {
                    return valor;
                }
                else
                {
                    return ingresoDato();
                }
            }catch(Exception e)
            {
                return ingresoDato();
            }
        }

        public static void  matrizEspiral(int[,] matriz)
        {
            int filas = matriz.GetLength(0);
            int columnas = matriz.GetLength(1);
            
            int filaInicio = 0;
            int filaFin = filas - 1;
            int columnaInicio = 0;
            int columnaFin = columnas - 1;

            while (filaInicio <= filaFin && columnaInicio <= columnaFin)
            {
                
                for (int j = columnaInicio; j <= columnaFin; j++)
                {
                    Console.WriteLine("Ingrese el valor para la fila {0} columna {1}: ", filaInicio, j);
                    matriz[filaInicio, j] = ingresoDato();
                }
                filaInicio++;

                // Llenar la columna derecha
                for (int i = filaInicio; i <= filaFin; i++)
                {
                    Console.WriteLine("Ingrese el valor para la fila {0} columna {1}: ", i, columnaFin);
                    matriz[i, columnaFin] = ingresoDato();
                }
                columnaFin--;

                // Llenar la fila inferior si es necesario
                if (filaInicio <= filaFin)
                {
                    for (int j = columnaFin; j >= columnaInicio; j--)
                    {
                        Console.WriteLine("Ingrese el valor para la fila {0} columna {1}: ", filaFin, j);
                        matriz[filaFin, j] = ingresoDato();
                    }
                    filaFin--;
                }

                // Llenar la columna izquierda si es necesario
                if (columnaInicio <= columnaFin)
                {
                    for (int i = filaFin; i >= filaInicio; i--)
                    {
                        Console.WriteLine("Ingrese el valor para la fila {0} columna {1}: ", i, columnaInicio);
                        matriz[i, columnaInicio] = ingresoDato();
                    }
                    columnaInicio++;
                }
            }
        }

        public static int[,] creaMatriz()
        {
            int filas, columnas;
            Console.Clear();
            try
            {
                Console.WriteLine("Ingrese la cantidad de filas de la matriz:");
                if (int.TryParse(Console.ReadLine(), out filas) && filas > 0)
                {
                    Console.WriteLine("Ingrese la cantidad de columnas de la matriz:");
                    if (int.TryParse(Console.ReadLine(), out columnas) && columnas > 0)
                    {
                        int[,] matriz = new int[filas, columnas];
                        return matriz;
                    }
                    else
                    {
                        Console.WriteLine("La cantidad de columnas debe ser un número entero positivo.");
                        return creaMatriz();
                    }
                }
                else
                {
                    Console.WriteLine("La cantidad de filas debe ser un número entero positivo.");
                    return creaMatriz();
                }
            }catch(Exception e)
            {
                Console.WriteLine("Error " + e);
                return creaMatriz();
            }
        }
    }
}