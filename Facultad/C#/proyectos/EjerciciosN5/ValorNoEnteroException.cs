namespace EjercicioN5
{
    public class ValorNoEnteroException : Exception
    {
        public ValorNoEnteroException()
            : base("El vector contiene valores que no son enteros.")
        {
        }
    }
}