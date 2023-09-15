namespace EjercicioN5
{
    internal class Program
    {
        static void Main(string[] args)
        {

            //ejercicio1();
            //ejercicio2();
            //ejercicio3();
            //ejercicio4();
            ejercicio5();
        }

        public static void ejercicio5()
        {
            //Escribe un método llamado ProductoEscalar que tome dos vectores de enteros y calcula su producto escalar.
            //Asegúrese de manejar correctamente los vectores de diferentes longitudes y lanza una excepción si son de
            //diferente tamaño.
            int[] a = { 1, 2, 3, 4 };
            int[] b = { 1, 2, 3 };

            int? resutado = productoEscalar(a, b);

            Console.WriteLine("El resultado del producto escalar del vector a y b es: {0}", resutado);

            int[] c = { 1, 2, 3, 4 };
            int[] d = { 1, 2, 3, 4 };

            int? resutado2 = productoEscalar(c, d);

            Console.WriteLine("El resultado del producto escalar del vector c y d es: {0}", resutado2);

        }

        public static int? productoEscalar(int[] a, int[] b)
        {
            try
            {
                if(a.Length != b.Length)
                {
                    throw new ArgumentException("Los vectores son de diferente tamanio");
                }
                int resultado = 0;

                for (int i = 0; i < a.Length; i++)
                {
                    resultado += a[i] * b[i];
                }

                return resultado;
            }catch(ArgumentException e)
            {
                Console.WriteLine("Error " + e);
                return null;
            }
        }

        public static void ejercicio4()
        {
            //Escribe un método llamado CrearMatrizIdentidad que tome un entero n
            //como parámetro y devuelva una matriz identidad de tamaño nxn.
            //Si n es menor o igual a 0, lanza una excepción ArgumentException.
            Console.WriteLine("Ingrese el numero N para crear la matriz identidad");
            int n = int.Parse(Console.ReadLine());

            int[,] matriz = crearMatrizIdentidad(n);

            Console.WriteLine("Matriz identidad");

            if(matriz != null)
            {
                mostrarMatriz(matriz);
            }
        }

        public static int[,] crearMatrizIdentidad(int n)
        {
            try { 
                if(n <= 0)
                {
                    throw new ArgumentException("N no puede ser menor igual a 0");
                }

                int[,] result = new int[n, n];

                for(int i = 0; i < n; i++)
                {
                    for(int j = 0; j < n; j++)
                    {
                        result[i, j] = (i == j) ? 1 : 0; 
                    }
                }

                return result;
            } catch(ArgumentException e)
            {
                Console.WriteLine("Error " + e);
                return null;
            }

        }

        public static void ejercicio3()
        {
            /*Ejercicio 3: Ordenar Vector con Excepciones Personalizadas
            Escribe un método llamado OrdenarVector que tome un vector de enteros como parámetro y lo ordene en orden ascendente. Si el vector contiene 
            valores no enteros, lanza una excepción de llamada personalizada ValorNoEnteroException.
            */

            double[] b = { 1, 2, 22, 3, 5 };

            int[] bInt = ordenarVector(b);

            mostrarVector(bInt);

            Console.WriteLine("\n");

            double[] a = { 1, 2, 22, 3, 6, 7, 1, 2, 2.2, 5.4, 5, 5, 8, 10, 2, 5 };

            int[] aInt = ordenarVector(a);

            mostrarVector(aInt);
        }

        public static int[] ordenarVector(double[] a)
        {
            try
            {
                foreach(double num in a)
                {
                    if (num != (int)num)
                    {
                        throw new ValorNoEnteroException();
                    }
                }

                int[] result = new int[a.Length];

                for (int i = 0; i < a.Length; i++)
                {
                    result[i] = (int)a[i];
                }

                Array.Sort(result);

                return result;
            }
            catch (Exception e)
            {
                Console.WriteLine("Error : " + e);
                return null;
            }
        }

        public static void ejercicio2()
        {
            /*Ejercicio 2: Multiplicación de matrices
            Escribe un método llamado MultiplicarMatrices que tome dos matrices como parámetros y devuelva una nueva matriz que sea el resultado de 
            multiplicar las dos matrices. Asegúrese de manejar adecuadamente las dimensiones de las matrices y lanza una excepción si no se pueden 
            multiplicar.
            */
            int[,] a = {
                { 5, 3, -4, -2 },
                { 8, -1, 0, -3 }
            };

            int[,] b = {
                { 1, 4, 0},
                { -5, 3, 7},
                { 0, -9, 5},
                { 5, 1, 4}
            };

            int[,] resultado = sumaMatriz(a, b);

            if (resultado != null) mostrarMatriz(resultado);

            Console.WriteLine( );

            int[,] c = {
                { 5, 3, -4, -2 },
                { 8, -1, 0, -3 },
                { 8, -1, 0, -3 }
            };

            int[,] d = {
                { 1, 4, 0},
                { -5, 3, 7}
            };

            int[,] resultado1 = sumaMatriz(c, d);

            if (resultado1 != null) mostrarMatriz(resultado1);

        }
        
        public static int[,] sumaMatriz(int[,] a, int[,] b)
        {

            try
            {
                if (a.GetLength(1) != b.GetLength(0))
                {
                    throw new ArgumentException("Las matrices no se pueden multiplicar");
                }

                int[,] resultado = new int[a.GetLength(0), b.GetLength(1)];

                for (int i = 0; i < a.GetLength(0); i++)
                {
                    for (int j = 0; j < b.GetLength(1); j++)
                    {
                        int sumatoria = 0;
                        for (int k = 0; k < a.GetLength(1); k++)
                        {
                            sumatoria += a[i, k] * b[k, j];
                        }
                        resultado[i, j] = sumatoria;
                    }
                }
                return resultado;
            }catch(ArgumentException e)
            {
                Console.WriteLine("Error: " + e);
                return null;
            }
        }

        public static void mostrarMatriz(int[,] a)
        {
            for(int i = 0; i<a.GetLength(0); i++)
            {
                for(int j = 0; j < a.GetLength(1); j++)
                {
                    Console.Write(" " + a[i,j] +" ");
                }
                Console.WriteLine();
            }

        }
       
        public static void ejercicio1()
        {
            /*Ejercicio 1: Suma de Vectores
            Escribe un método llamado SumarVectores que tome dos vectores de enteros como parámetros y devuelva un
            nuevo vector que sea la suma de los dos vectores. Si los vectores tienen longitudes diferentes, lanza una 
            excepción ArgumentException para indicar que los vectores deben ser del mismo tamaño.
            */
            //ENTRADA
            int[] a = { 1, 2, 3};
            int[] b = { 1, 2, 3, 4 };
            
            //PROCESO
            int[] resultado = sumaVectores(a, b);

            //SALIDA
            if (resultado != null)
            {
                mostrarVector(resultado);
            }
            Console.WriteLine();

            //ENTRADA
            int[] c = { 1, 2, 3, 4};
            int[] d = { 1, 2, 3, 4 };

            //PROCESO
            int[] resultado1 = sumaVectores(c, d);

            //SALIDA
            if (resultado1 != null)
            {
                mostrarVector(resultado1);
            }

        }

        public static int[] sumaVectores(int[] a, int[] b) 
        {

            try
            {
                //VALIDACION
                if (a.Length != b.Length)
                {
                    throw new ArgumentException("Los vectores deben ser del mismo tamaño");
                }

                int[] c = new int[a.Length];
            
                for(int i = 0; i < a.Length; i++)
                {
                    c[i] = a[i] + b[i];
                }
                    return c;
                }
            catch (ArgumentException e)
            {
                Console.WriteLine("Error " + e);
                return null;
            }

        }

        public static void mostrarVector(int[] a)
        {
            foreach(int num in a)
            {
                Console.Write(num + " ");
            }
        }
    }
}