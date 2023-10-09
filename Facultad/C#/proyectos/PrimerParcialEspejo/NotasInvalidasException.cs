using System.Runtime.Serialization;

namespace PrimerParcialEspejo
{
    [Serializable]
    internal class NotasInvalidasException : Exception
    {
        public NotasInvalidasException()
        {
        }

        public NotasInvalidasException(string? message) : base(message)
        {
        }

        public NotasInvalidasException(string? message, Exception? innerException) : base(message, innerException)
        {
        }

        protected NotasInvalidasException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}