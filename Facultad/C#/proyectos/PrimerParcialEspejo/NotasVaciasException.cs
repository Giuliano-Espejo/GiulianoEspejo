using System.Runtime.Serialization;

namespace PrimerParcialEspejo
{
    [Serializable]
    internal class NotasVaciasException : Exception
    {
        public NotasVaciasException()
        {
        }

        public NotasVaciasException(string? message) : base(message)
        {
        }

        public NotasVaciasException(string? message, Exception? innerException) : base(message, innerException)
        {
        }

        protected NotasVaciasException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}