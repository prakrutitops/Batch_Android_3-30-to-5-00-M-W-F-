class OverloadinEx
{
    fun add(a:Int,b:Int):Int
    {
        return  a+b
    }

    fun add(a:Int,b:Int,c:Int):Int
    {
        return  a*b*c
    }
}

fun main()
{
    var o1 =OverloadinEx()
    println(o1.add(10,20))
    println(o1.add(10,20,30))


}