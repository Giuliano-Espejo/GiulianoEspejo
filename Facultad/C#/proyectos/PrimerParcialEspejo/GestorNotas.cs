namespace PrimerParcialEspejo
{
    internal class GestorNotas
    {
        static void Main(string[] args)
        {
            //PUNTO 1
            double[,] notas = creaMatriz();
            cargaNotas(notas);
            Console.WriteLine("Notas: ");
            mostrarNotas(notas);
            double? promedio = CalcularPromedioClase(notas);
            Console.WriteLine("El promedio de notas de la clase es de {0}", promedio);
            //-------------------------


            //PUNTO 2
            double? mejor = ObtenerMejorNota(notas);
            Console.WriteLine("La mejor notas es: {0}", mejor);
            //-------------------------

            //PUNTO 3
            int valorMin = IngresaValorMinimo();
            int? cantAprobados = ContarAprobados(notas, valorMin);
            Console.WriteLine("La cantidad de alumnos aprovado es de {0}", cantAprobados);
            //-------------------------

            //PUNTO 4
            /*
             * {1, 2, 3} {Pedro} notas de Pedro del examen 1, examen 2, examen 3
             * {2, 3, 4} {Juan} notas de Juan del examen 1, examen 2, examen 3
            */
            String[] alumnos = CargaAlumnos(notas);
            GenerarInforme(notas, alumnos);
            //-------------------------
        }

        public static void GenerarInforme(double[,] notas, String[] alumnos)
        {
            try
            {
                if(notas == null || alumnos == null)
                {
                    throw new ArgumentException("La matriz notas o la matriz alumnos estan vacias");
                }
                for (int i = 0; i < notas.GetLength(0); i++)
                {
                    string nombreEstudiante = alumnos[i];
                    Console.Write(nombreEstudiante + ": ");

                    for (int j = 0; j < notas.GetLength(1); j++)
                    {
                        double nota = notas[i, j];
                        Console.Write("Nota {0}: {1}", (j + 1), nota);
                        if (j < notas.GetLength(1) - 1)
                        {
                            Console.Write(", ");
                        }
                    }

                    Console.WriteLine();
                }
            }catch(Exception e)
            {
                Console.WriteLine("Error: " + e);
            }
        }

        public static void MostrarAlumnos(String[] alumnos)
        {
            for(int i = 0; i < alumnos.Length; i++)
            {
                Console.WriteLine(alumnos[i] + " ");
            }
        }
        
        public static String[] CargaAlumnos(double[,] notas)
        {
            try
            {
                String[] alumnos = new String[notas.GetLength(1)];
                for (int i = 0; i < alumnos.Length; i++)
                {
                    Console.WriteLine("Ingrese el nombre del Alumno {0}", i);
                    alumnos[i] = Console.ReadLine();
                }
                return alumnos;
            }catch(Exception e)
            {
                Console.WriteLine("Error al cargar los alumnos");
                return CargaAlumnos(notas);
            }
        }

        public static int? ContarAprobados(double[,] notas, int valor)
        {
            try
            {
                if(notas == null || notas.Length == 0)
                {
                    throw new NotasVaciasException("La matriz esta vacia");
                }
                int cantAprovados = 0;
                for (int i = 0; i < notas.GetLength(0); i++)
                {
                    for (int j = 0; j < notas.GetLength(1); j++)
                    {
                        if (notas[i,j] >= valor)
                        {
                            cantAprovados++;
                        }
                    }
                }
                return cantAprovados;
            }
            catch (NotasVaciasException e)
            {
                Console.WriteLine("Error");
                return null;
            }
        }

        public static int IngresaValorMinimo()
        {
            try
            {
                Console.WriteLine("Ingrese el valor de la nota minima para aprobar");
                int valor = int.Parse(Console.ReadLine());
                if(valor > 0 && valor<= 10)
                {
                    return valor;
                }
                else
                {
                    Console.WriteLine("La nota debe estar entre 1 y 10");
                    return IngresaValorMinimo();
                }
                
            }catch(Exception e)
            {
                Console.WriteLine("Error para cargar el valor, intentelo nuevamente");
                return IngresaValorMinimo();
            }
        }

        public static double? ObtenerMejorNota(double[,] notas)
        {
            try
            {
                if (notas == null || notas.Length == 0)
                {
                    throw new NotasVaciasException("La matriz de notas está vacía.");
                }

                double mejorNota = double.MinValue;

                for (int i = 0; i < notas.GetLength(0); i++)
                {
                    for (int j = 0; j < notas.GetLength(1); j++)
                    {
                        double nota = notas[i, j];
                        if (nota > mejorNota)
                        {
                            mejorNota = nota;
                        }
                    }
                }

                return mejorNota;
            }catch(NotasVaciasException e)
            {
                Console.WriteLine(e);
                return null;
            }
        }
   
        public static double? CalcularPromedioClase(double[,] notas)
        {
            try
            {
                if (notas == null || notas.Length == 0)
                {
                    throw new NotasInvalidasException("La matriz de notas está vacía.");
                }

                double sumaTotal = 0;
                int contadorNotas = 0;

                for (int i = 0; i < notas.GetLength(0); i++)
                {
                    for (int j = 0; j < notas.GetLength(1); j++)
                    {
                        double nota = notas[i, j];
                        if (nota < 0)
                        {
                            throw new NotasInvalidasException("La matriz de notas contiene valores negativos.");
                        }

                        sumaTotal += nota;
                        contadorNotas++;
                    }
                }

                if (contadorNotas == 0)
                {
                    throw new NotasInvalidasException("La matriz de notas no contiene notas válidas.");
                }

                double promedio = sumaTotal / contadorNotas;
                return promedio;
            }catch(NotasVaciasException e)
            {
                Console.WriteLine(e);
                return null;
            }
        }

        public static void mostrarNotas(double[,] notas)
        {
            for (int i = 0; i < notas.GetLength(0); i++)
            {
                for (int j = 0; j < notas.GetLength(1); j++)
                {
                    Console.Write(" " + notas[i, j] + " ");
                }
                Console.WriteLine();
            }
        }

        public static void cargaNotas(double[,] notas)
        {
            try
            {
                for(int i = 0; i < notas.GetLength(0); i++)
                {
                    for(int j = 0; j < notas.GetLength(1); j++)
                    {
                        Console.WriteLine("Ingrese valor para la posicion {0} {1}", i,j);
                        double valor = double.Parse(Console.ReadLine());
                        if (valor > 0 && valor <= 10)
                        {
                            notas[i, j] = valor;
                        }
                        else
                        {
                            Console.WriteLine("El valor de las notas debe estar entre 0 y 10");
                            j--;
                        }
                    }
                }
            }catch(Exception e)
            {
                Console.WriteLine("Error, vuelva a cargar la matriz");
                cargaNotas(notas);
            }
        }

        public static double[,] creaMatriz()
        {
            int filas, columnas;
            try
            {
                Console.WriteLine("Ingrese la cantidad de filas de la matriz:");
                if (int.TryParse(Console.ReadLine(), out filas) && filas > 0)
                {
                    Console.WriteLine("Ingrese la cantidad de columnas de la matriz:");
                    if (int.TryParse(Console.ReadLine(), out columnas) && columnas > 0)
                    {
                        double[,] matriz = new double[filas, columnas];
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
            }
            catch (Exception e)
            {
                Console.WriteLine("Error " + e);
                return creaMatriz();
            }
        }
    }

}