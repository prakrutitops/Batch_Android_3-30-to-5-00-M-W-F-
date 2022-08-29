import java.lang.ArithmeticException

class ThrowEx
{
    fun data(age:Int)
    {
            if(age>18)
            {
              println("Eligible to vote")
            }
            else
            {
                throw  ArithmeticException("Age is not valid")
            }

    }
}

fun main()
{
    var t1 =ThrowEx()
    t1.data(17)
}