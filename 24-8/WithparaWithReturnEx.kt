//with para with return type
fun add(a:Int,b:Int) :Int
{
    return  a+b
}

//with para without return type
fun add2(a:Int,b:Int)
{
    var c=a+b
    println(c)
}
//with return type without parameter
fun add3():Int
{
    var a=5
    var b=6

    var c=a+b

    return c
}
//without return type without para
fun add4()
{
    var a=5
    var b=6

    var c=a+b

    println(c)
}

fun main()
{
            println(add(5,6))
            add2(5,6)
            println(add3())
            add4()

}