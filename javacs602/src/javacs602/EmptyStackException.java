package javacs602;
// EmptyStackException class declaration.
public class EmptyStackException extends RuntimeException
{
   // no-argument constructor
   public EmptyStackException()
   {
      this("Stack is empty");
   } 

   // one-argument constructor
   public EmptyStackException(String exception)
   {
      super(exception);
   } 
} // end class EmptyStackException

