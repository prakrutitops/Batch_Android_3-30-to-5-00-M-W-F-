import java.lang.Integer.parseInt

fun main()
{
    var a = IntArray(5)
    var num=0
    for(i in 0..4)
    {
        println("Enter value")
        num= readLine()!!.toInt()
        a[i] = num

    }

    println("Array Element :")
    for(i in 0 .. 4)
    {
        print( " "+a[i])
    }



}